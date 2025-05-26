import { IContainerRepository, IQueryHandler } from "../interface";
import { ThongKeSoLuongContainerTheoTungKhoRawDTO } from "../model/dto";

export class ThongKeSoLuongContainerTheoTungKhoQuery
  implements IQueryHandler<void, ThongKeSoLuongContainerTheoTungKhoRawDTO[]>
{
  constructor(private readonly repo: IContainerRepository) {}
  async query(): Promise<{ kho: string; soLuong: number }[]> {
    return await this.repo.thongKeSoLuongContainerTheoTungKho();
  }
}
