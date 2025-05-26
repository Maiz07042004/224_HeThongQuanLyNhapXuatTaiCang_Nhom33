import { IDonHangRepository, IQueryHandler } from "../interface";
import { ThongKeSoLuongDonTheoCangDenRawDTO } from "../model/dto";

export class thongKeDonHangTheoCangDenQuery
  implements IQueryHandler<number, ThongKeSoLuongDonTheoCangDenRawDTO[]>
{
  constructor(private readonly repo: IDonHangRepository) {}
  async query(query: number): Promise<ThongKeSoLuongDonTheoCangDenRawDTO[]> {
    return await this.repo.thongKeDonHangTheoCangDen(query);
  }
}
