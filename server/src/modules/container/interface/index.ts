import { ThongKeSoLuongContainerTheoTungKhoRawDTO } from "../model/dto";

export interface IContainerRepository {
  thongKeSoLuongContainerTheoTungKho(): Promise<
    ThongKeSoLuongContainerTheoTungKhoRawDTO[]
  >;
}
export interface ICommandHandler<Cmd, Result> {
  execute(cmd: Cmd): Promise<Result>;
}
export interface IQueryHandler<Query, Result> {
  query(query: Query): Promise<Result>;
}
