import { IDonHangRepository, IQueryHandler } from "../interface";
import { ThongKeSoLuongDonTheoHangTauRawDTO } from "../model/dto";

export class thongKeDonHangTheoHangTauQuery
  implements IQueryHandler<number, ThongKeSoLuongDonTheoHangTauRawDTO[]>
{
  constructor(private readonly repo: IDonHangRepository) {}
  async query(query: number): Promise<ThongKeSoLuongDonTheoHangTauRawDTO[]> {
    return await this.repo.thongKeDonHangTheoHangTau(query);
  }
}
