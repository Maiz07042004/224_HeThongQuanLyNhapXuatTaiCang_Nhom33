import {
  IDonHangRepository,
  IQueryHandler,
  ThongKeDonHangTheoThangQuery,
} from "../interface";
import { ThongKeDonHangTheoThangDTO } from "../model/dto";

export class thongKeDonHangTheoThangQueryHandle
  implements
    IQueryHandler<ThongKeDonHangTheoThangQuery, ThongKeDonHangTheoThangDTO[]>
{
  constructor(private repo: IDonHangRepository) {}
  async query(
    query: ThongKeDonHangTheoThangQuery
  ): Promise<{ thang: number; nhap: number; xuat: number }[]> {
    const rawData = await this.repo.thongKeDonHangTheoThang(query.nam);

    const result: ThongKeDonHangTheoThangDTO[] = [];

    for (let i = 1; i <= 12; i++) {
      const nhap =
        rawData.find((r) => r.thang === i && r.kieuDon === "Nhập khẩu")
          ?.count || 0;
      const xuat =
        rawData.find((r) => r.thang === i && r.kieuDon === "Xuất khẩu")
          ?.count || 0;

      result.push({ thang: i, nhap, xuat });
    }

    return result;
  }
}
