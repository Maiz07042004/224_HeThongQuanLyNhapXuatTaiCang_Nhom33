import { IDonHangRepository } from "@modules/order/interface";
import { DonHang, DonHangSchema } from "@modules/order/model/DonHang";
import {
  DonHangCondDTO,
  ThongKeDonHangTheoThangRawDTO,
  ThongKeDonHangTheoTuanRawDTO,
  ThongKeSoLuongDonTheoCangDenRawDTO,
  ThongKeSoLuongDonTheoHangTauRawDTO,
} from "@modules/order/model/dto";
import { PagingDTO } from "@share/models/paging";
import { PrismaClient } from "@prisma/client";

export class PrismaDonHangRepository implements IDonHangRepository {
  constructor(private prisma: PrismaClient) {}
  async thongKeDonHangTheoCangDen(
    nam: number
  ): Promise<ThongKeSoLuongDonTheoCangDenRawDTO[]> {
    return await this.prisma.$queryRaw<ThongKeSoLuongDonTheoCangDenRawDTO[]>`
    SELECT 
      CD.Ten AS CangDen,
      COUNT(DH.ID) AS SoLuongDon
    FROM 
      DonHang DH
    JOIN 
      CangDen CD ON DH.IDCangDen = CD.ID
    WHERE 
      YEAR(DH.ThoiGianTaoDon) = ${nam}
    GROUP BY 
      CD.Ten
    ORDER BY 
      SoLuongDon DESC
  `;
  }
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
    const startDate = new Date(`${nam}-${thang}-01`);
    const endDate = new Date(startDate);
    endDate.setMonth(startDate.getMonth() + 1);

    const raws: ThongKeDonHangTheoTuanRawDTO[] = await this.prisma.$queryRaw`
  SELECT 
    CAST(((DAY(ThoiGianTaoDon) - 1) / 7) + 1 AS INT) AS tuan,
    KieuDon as kieuDon,
    COUNT(*) as "count"
  FROM DonHang
  WHERE 
    ThoiGianTaoDon >= ${startDate}
    AND ThoiGianTaoDon < ${endDate}
  GROUP BY 
    CAST(((DAY(ThoiGianTaoDon) - 1) / 7) + 1 AS INT),
    KieuDon
  ORDER BY 
    tuan, kieuDon;
`;

    return raws;
  }
  async thongKeDonHangTheoHangTau(
    nam: number
  ): Promise<ThongKeSoLuongDonTheoHangTauRawDTO[]> {
    return await this.prisma.$queryRaw<ThongKeSoLuongDonTheoHangTauRawDTO[]>`
    SELECT 
      HT.Ten AS hangTau,
      COUNT(DH.ID) AS soLuongDon
    FROM 
      DonHang DH
    JOIN 
      SoChuyenTau SCT ON DH.IDSoChuyenTau = SCT.ID
    JOIN 
      Tau T ON SCT.IDTau = T.ID
    JOIN 
      HangTau HT ON T.IDHangTau = HT.ID
    WHERE
      YEAR(DH.ThoiGianTaoDon) = ${nam}
    GROUP BY 
      HT.Ten
    ORDER BY 
      soLuongDon DESC;
  `;
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

    // // Thêm phân trang
    // const skip = (page.page - 1) * page.limit;
    // const take = page.limit;

    return this.prisma.donHang
      .findMany({
        where: whereCondition,
        // skip,
        // take,
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
