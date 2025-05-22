import { GetCangDenQuery, ICangRepository, IQueryHandler } from "../interface";
import { CangDen } from "../model/cangDen";

export class GetCangDenQueryHandler
  implements IQueryHandler<GetCangDenQuery, CangDen | null>
{
  constructor(private repo: ICangRepository) {}
  async execute(query: GetCangDenQuery): Promise<CangDen | null> {
    return await this.repo.getCangDen(query.id);
  }
}
