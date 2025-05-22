import {
  GetListDonHangTheoThoiGianQuery,
  IDonHangRepository,
  IQueryHandler,
} from "../interface";
import { DonHang } from "../model/DonHang";

export class getListDonHangTheoThoiGian
  implements IQueryHandler<GetListDonHangTheoThoiGianQuery, DonHang[]>
{
  constructor(private readonly repo: IDonHangRepository) {}
  async query(query: GetListDonHangTheoThoiGianQuery): Promise<DonHang[]> {
    const result = await this.repo.getListDonHang(query.cond, query.page);
    return result.map((donHang) => {
      return donHang as DonHang;
    });
  }
}
