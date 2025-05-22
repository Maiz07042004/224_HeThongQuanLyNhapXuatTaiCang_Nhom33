import { CangDen, QuocGia } from "../model/cangDen";

export interface ICangRepository {
  getCangDen(id: number): Promise<CangDen | null>;
  getQuocGia(id: number): Promise<QuocGia | null>;
  getQuocGiaByIds(ids: number[]): Promise<QuocGia[]>;
  getCangDenByIds(ids: number[]): Promise<CangDen[]>;
}

export interface ICommandHandler<Cmd, Result> {
  execute(cmd: Cmd): Promise<Result>;
}
export interface IQueryHandler<Query, Result> {
  execute(query: Query): Promise<Result>;
}

export interface GetCangDenQuery {
  id: number;
}
export interface GetQuocGiaQuery {
  id: number;
}
