import { GetQuocGiaQuery, ICangRepository, IQueryHandler } from "../interface";
import { QuocGia } from "../model/cangDen";

export class GetQuocGiaQueryHandle
  implements IQueryHandler<GetQuocGiaQuery, QuocGia | null>
{
  constructor(private repo: ICangRepository) {}
  async execute(query: GetQuocGiaQuery): Promise<QuocGia | null> {
    const quocGia = await this.repo.getQuocGia(query.id);
    return quocGia;
  }
}
