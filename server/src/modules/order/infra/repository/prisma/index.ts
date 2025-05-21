import { IDonHangRepository } from "@modules/order/interface";
import { DonHang, DonHangSchema } from "@modules/order/model/DonHang";
import {
  DonHangCondDTO,
  ThongKeDonHangTheoThangRawDTO,
  ThongKeDonHangTheoTuanRawDTO,
} from "@modules/order/model/dto";
import { PagingDTO } from "@share/models/paging";
import { PrismaClient } from "@prisma/client";

export class PrismaDonHangRepository implements IDonHangRepository {
  constructor(private prisma: PrismaClient) {}
  async thongKeDonHangTheoThang(
    nam: number
  ): Promise<ThongKeDonHangTheoThangRawDTO[]> {
    const raws: ThongKeDonHangTheoThangRawDTO[] = await this.prisma.$queryRaw`
  SELECT 
    DATEPART(month, ThoiGianTaoDon) as thang,
    KieuDon as kieuDon,
    COUNT(*) as count
  FROM DonHang
  WHERE 
    ThoiGianTaoDon >= ${new Date(`${nam}-01-01`)}
    AND ThoiGianTaoDon <= ${new Date(`${nam}-12-31`)}
  GROUP BY 
    DATEPART(month, ThoiGianTaoDon),
    KieuDon
`;
    return raws;
  }

  async thongKeDonHangTheoTuan(
    thang: number,
    nam: number
  ): Promise<ThongKeDonHangTheoTuanRawDTO[]> {
    const raws: ThongKeDonHangTheoTuanRawDTO[] = await this.prisma.$queryRaw`
    SELECT 
      -- Tính tuần trong tháng: ((ngày trong tháng - 1) / 7) + 1
      ((DAY(ThoiGianTaoDon) - 1) / 7) + 1 as tuan,
      KieuDon as kieuDon,
      COUNT(*) as "count"
    FROM DonHang
    WHERE 
      ThoiGianTaoDon >= ${new Date(`${nam}-${thang}-01`)}
      AND ThoiGianTaoDon < DATEADD(month, 1, ${new Date(`${nam}-${thang}-01`)})
    GROUP BY 
      ((DAY(ThoiGianTaoDon) - 1) / 7) + 1,
      KieuDon
    ORDER BY 
      tuan, kieuDon
  `;
    console.log(raws);
    return raws;
  }
  async getListDonHang(
    cond: DonHangCondDTO,
    page: PagingDTO
  ): Promise<DonHang[]> {
    // Xây dựng điều kiện where
    const whereCondition: any = {};

    // Xử lý điều kiện theo tháng/năm
    if (cond.thang && cond.nam) {
      const startDate = new Date(cond.nam, cond.thang - 1, 1);
      const endDate = new Date(cond.nam, cond.thang, 0); // Ngày cuối cùng của tháng

      whereCondition.ThoiGianTaoDon = {
        gte: startDate,
        lte: endDate,
      };
    } else if (cond.nam) {
      const startDate = new Date(cond.nam, 0, 1); // 01/01 của năm
      const endDate = new Date(cond.nam, 11, 31); // 31/12 của năm

      whereCondition.ThoiGianTaoDon = {
        gte: startDate,
        lte: endDate,
      };
    }

    // Thêm phân trang
    const skip = (page.page - 1) * page.limit;
    const take = page.limit;

    return this.prisma.donHang
      .findMany({
        where: whereCondition,
        skip,
        take,
        orderBy: {
          ThoiGianTaoDon: "desc", // Sắp xếp mới nhất trước
        },
        // Có thể include thêm các quan hệ nếu cần
      })
      .then((donHangs: any) =>
        donHangs.map((donHang: any) => DonHangSchema.parse(donHang))
      );
  }
}
