import { Request, Response } from "express";
import {
  GetListDonHangTheoThoiGianQuery,
  ICangQueryRepository,
  ILoaiHangQueryRepository,
  IQueryHandler,
  ISoChuyenTauQueryRepository,
  IUserQueryRepository,
  ThongKeDonHangTheoThangQuery,
  ThongKeDonHangTheoTuanQuery,
} from "../../interface";
import {
  ThongKeDonHangTheoThangDTO,
  ThongKeDonHangTheoTuanDTO,
  ThongKeSoLuongDonTheoCangDenRawDTO,
  ThongKeSoLuongDonTheoHangTauRawDTO,
} from "../../model/dto";
import {
  DonHang,
  DonHang_CangDenSchema,
  DonHang_LoaiHangSchema,
  DonHang_SoChuyenTauSchema,
  DonHang_UserSchema,
} from "../../model/DonHang";

export class DonHangHttpService {
  constructor(
    private readonly thongKeDonHangTheoThangQueryHandle: IQueryHandler<
      ThongKeDonHangTheoThangQuery,
      ThongKeDonHangTheoThangDTO[]
    >,
    private readonly thongKeDonHangTheoTuanQueryHandle: IQueryHandler<
      ThongKeDonHangTheoTuanQuery,
      ThongKeDonHangTheoTuanDTO[]
    >,
    private readonly getListDonHangTheoThoiGian: IQueryHandler<
      GetListDonHangTheoThoiGianQuery,
      DonHang[]
    >,
    private readonly thongKeDonHangTheoHangTauQueryHandle: IQueryHandler<
      number,
      ThongKeSoLuongDonTheoHangTauRawDTO[]
    >,
    private readonly thongKeDonHangTheoCangDenQueryHandle: IQueryHandler<
      number,
      ThongKeSoLuongDonTheoCangDenRawDTO[]
    >,
    private readonly RPCCangRepo: ICangQueryRepository,
    private readonly RPCSoChuyenTauRepo: ISoChuyenTauQueryRepository,
    private readonly RPCLoaiHangRepo: ILoaiHangQueryRepository,
    private readonly RPCUserRepo: IUserQueryRepository
  ) {}

  async thongKeDonHangTheoThangAPI(req: Request, res: Response) {
    const nam: number = Number(req.params.nam);

    try {
      const result = await this.thongKeDonHangTheoThangQueryHandle.query({
        nam,
      });

      const totalNhap = result.reduce((acc, cur) => acc + cur.nhap, 0);
      const totalXuat = result.reduce((acc, cur) => acc + cur.xuat, 0);
      res.status(200).json({
        totalNhap,
        totalXuat,
        data: result,
      });
    } catch (error) {
      res.status(400).json({
        status: "fail",
        message: (error as Error).message,
      });
    }
  }
  async thongKeDonHangTheoTuanAPI(req: Request, res: Response) {
    const thang: number = Number(req.params.thang);
    const nam: number = Number(req.params.nam);

    try {
      const result = await this.thongKeDonHangTheoTuanQueryHandle.query({
        thang,
        nam,
      });
      const totalNhap = result.reduce((acc, cur) => acc + cur.nhap, 0);
      const totalXuat = result.reduce((acc, cur) => acc + cur.xuat, 0);
      res.status(200).json({
        totalNhap,
        totalXuat,
        data: result,
      });
    } catch (error) {
      res.status(400).json({
        status: "fail",
        message: (error as Error).message,
      });
    }
  }
  async getListDonHangTheoNamAPI(req: Request, res: Response) {
    const result: DonHang[] = [];
    const page = Number(req.query.page);
    const limit = Number(req.query.limit);
    if (req.query.nam && !req.query.thang) {
      const nam: number = Number(req.query.nam);
      try {
        const donHangList = await this.getListDonHangTheoThoiGian.query({
          cond: { nam },
          page: { page: 1, limit: 10 },
        });
        result.push(...donHangList);
      } catch (error) {
        res.status(400).json({
          status: "fail",
          message: (error as Error).message,
        });
      }
    } else {
      const nam: number = Number(req.query.nam);
      const thang: number = Number(req.query.thang);
      try {
        const donHangList = await this.getListDonHangTheoThoiGian.query({
          cond: { nam, thang },
          page: { page: 1, limit: 10 },
        });
        result.push(...donHangList);
      } catch (error) {
        res.status(400).json({
          status: "fail",
          message: (error as Error).message,
        });
      }
    }
    const cangIds = [...new Set(result.map((d) => d.IDCangDen))];
    const loaiHangIds = [...new Set(result.map((d) => d.IDLoaiHang))];
    const userIds = [...new Set(result.map((d) => d.IDUser))];
    const soChuyenTauIds = [...new Set(result.map((d) => d.IDSoChuyenTau))];
    const [cangs, loais, users, taus] = await Promise.all([
      this.RPCCangRepo.getListCangDenByIds(cangIds),
      this.RPCLoaiHangRepo.getListLoaiHangByIds(loaiHangIds),
      this.RPCUserRepo.getListUserByIds(userIds),
      this.RPCSoChuyenTauRepo.getListSoChuyenTauByIds(soChuyenTauIds),
    ]);
    taus;

    const userMap = new Map(
      users.map((u) => [u.ID, DonHang_UserSchema.parse(u)])
    );
    const tauMap = new Map(
      taus.map((t) => [
        t.ID,
        DonHang_SoChuyenTauSchema.parse({
          ...t,
          ThoiGian: new Date(t.ThoiGian),
        }),
      ])
    );
    const cangMap = new Map(
      cangs.map((c) => [c.ID, DonHang_CangDenSchema.parse(c)])
    );
    const loaiMap = new Map(
      loais.map((l) => [l.ID, DonHang_LoaiHangSchema.parse(l)])
    );

    // B5: Gộp thông tin vào đơn hàng
    const donHangsFull = result.map((d) => ({
      ...d,
      user: userMap.get(d.IDUser),
      soChuyenTau: tauMap.get(d.IDSoChuyenTau),
      cangDen: cangMap.get(d.IDCangDen),
      loaiHang: loaiMap.get(d.IDLoaiHang),
    }));
    res.status(200).json({
      status: "success",
      data: donHangsFull,
    });
  }
  async thongKeDonHangTheoHangTauAPI(req: Request, res: Response) {
    const nam: number = Number(req.params.nam);
    const result = await this.thongKeDonHangTheoHangTauQueryHandle.query(nam);
    res.status(200).json({
      data: result,
    });
  }
  async thongKeDonHangTheoCangDenAPI(req: Request, res: Response) {
    const nam: number = Number(req.params.nam);
    const result = await this.thongKeDonHangTheoCangDenQueryHandle.query(nam);
    res.status(200).json({
      data: result,
    });
  }
}
