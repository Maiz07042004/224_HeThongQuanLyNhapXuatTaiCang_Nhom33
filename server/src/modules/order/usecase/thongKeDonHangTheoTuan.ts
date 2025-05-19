import {
  IDonHangRepository,
  IQueryHandler,
  ThongKeDonHangTheoTuanQuery,
} from "../interface";
import { ThongKeDonHangTheoTuanDTO } from "../model/dto";

export class thongKeDonHangTheoTuanQueryHandle
  implements
    IQueryHandler<ThongKeDonHangTheoTuanQuery, ThongKeDonHangTheoTuanDTO[]>
{
  constructor(private repo: IDonHangRepository) {}
  async query(
    query: ThongKeDonHangTheoTuanQuery
  ): Promise<{ tuan: number; nhap: number; xuat: number }[]> {
    const rawData = await this.repo.thongKeDonHangTheoTuan(
      query.thang,
      query.nam
    );

    const result: ThongKeDonHangTheoTuanDTO[] = [];

    for (let i = 1; i <= 4; i++) {
      const nhap =
        rawData.find((r) => r.tuan === i && r.kieuDon === "Nhập khẩu")?.count ||
        0;
      const xuat =
        rawData.find((r) => r.tuan === i && r.kieuDon === "Xuất khẩu")?.count ||
        0;

      result.push({ tuan: i, nhap, xuat });
    }

    return result;
  }
}
