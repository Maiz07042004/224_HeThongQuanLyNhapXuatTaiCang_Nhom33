import { PagingDTO } from "@/share/models/paging";
import { DonHang } from "../model/DonHang";
import {
  DonHangCondDTO,
  ThongKeDonHangTheoThangRawDTO,
  ThongKeDonHangTheoTuanRawDTO,
} from "../model/dto";

export interface IDonHangRepository {
  thongKeDonHangTheoThang(
    nam: number
  ): Promise<ThongKeDonHangTheoThangRawDTO[]>;
  thongKeDonHangTheoTuan(
    thang: number,
    nam: number
  ): Promise<ThongKeDonHangTheoTuanRawDTO[]>;
  getListDonHang(cond: DonHangCondDTO, page: PagingDTO): Promise<DonHang[]>;
}

export interface ThongKeDonHangTheoThangQuery {
  nam: number;
}
export interface ThongKeDonHangTheoTuanQuery {
  thang: number;
  nam: number;
}

export interface ICommandHandler<Cmd, Result> {
  execute(cmd: Cmd): Promise<Result>;
}
export interface IQueryHandler<Query, Result> {
  query(query: Query): Promise<Result>;
}
