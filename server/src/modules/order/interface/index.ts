import { PagingDTO } from "@/share/models/paging";
import {
  DonHang,
  DonHang_CangDen,
  DonHang_LoaiHang,
  DonHang_SoChuyenTau,
  DonHang_User,
} from "../model/DonHang";
import {
  DonHangCondDTO,
  ThongKeDonHangTheoThangRawDTO,
  ThongKeDonHangTheoTuanRawDTO,
  ThongKeSoLuongDonTheoCangDenRawDTO,
  ThongKeSoLuongDonTheoHangTauRawDTO,
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
  thongKeDonHangTheoHangTau(
    nam: number
  ): Promise<ThongKeSoLuongDonTheoHangTauRawDTO[]>;
  thongKeDonHangTheoCangDen(
    nam: number
  ): Promise<ThongKeSoLuongDonTheoCangDenRawDTO[]>;
}

export interface ICangQueryRepository {
  getListCangDenByIds(ids: number[]): Promise<DonHang_CangDen[]>;
}
export interface IUserQueryRepository {
  getListUserByIds(ids: number[]): Promise<DonHang_User[]>;
}
export interface ILoaiHangQueryRepository {
  getListLoaiHangByIds(ids: number[]): Promise<DonHang_LoaiHang[]>;
}
export interface ISoChuyenTauQueryRepository {
  getListSoChuyenTauByIds(ids: number[]): Promise<DonHang_SoChuyenTau[]>;
}

export interface ThongKeDonHangTheoThangQuery {
  nam: number;
}
export interface ThongKeDonHangTheoTuanQuery {
  thang: number;
  nam: number;
}

export interface GetListDonHangTheoThoiGianQuery {
  cond: DonHangCondDTO;
  page: PagingDTO;
}

export interface ICommandHandler<Cmd, Result> {
  execute(cmd: Cmd): Promise<Result>;
}
export interface IQueryHandler<Query, Result> {
  query(query: Query): Promise<Result>;
}
