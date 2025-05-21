import { LoaiHang } from "../model/index";
import {
  GetLoaiHangQuery,
  IDanhMucChungRepository,
  IQueryHandler,
} from "../interface";

export class GetLoaiHangById
  implements IQueryHandler<GetLoaiHangQuery, LoaiHang | null>
{
  constructor(private readonly repo: IDanhMucChungRepository) {}
  async execute(query: GetLoaiHangQuery): Promise<LoaiHang | null> {
    return await this.repo.getLoaiHangById(query.id);
  }
}
