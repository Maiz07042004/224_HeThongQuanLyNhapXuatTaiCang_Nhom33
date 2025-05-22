import { HangTau, SoChuyenTau, Tau } from "../model";

export interface ITauRepository {
  getSoChuyenTauByIds(ids: number[]): Promise<SoChuyenTau[]>;
  getTauByIds(ids: number[]): Promise<Tau[]>;
  getHangTauByIds(ids: number[]): Promise<HangTau[]>;
}

export interface IQueryHandler<Query, Result> {
  execute(query: Query): Promise<Result>;
}
export interface ICommandHandler<Cmd, Result> {
  execute(cmd: Cmd): Promise<Result>;
}
