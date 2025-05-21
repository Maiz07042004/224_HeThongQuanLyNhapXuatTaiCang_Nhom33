import { LoaiHang } from "../model/index";

export interface IDanhMucChungRepository {
  getLoaiHangById(id: number): Promise<LoaiHang | null>;
}

export interface GetLoaiHangQuery {
  id: number;
}
export interface ICommandHandler<Cmd, Result> {
  execute(cmd: Cmd): Promise<Result>;
}
export interface IQueryHandler<Query, Result> {
  execute(query: Query): Promise<Result>;
}
