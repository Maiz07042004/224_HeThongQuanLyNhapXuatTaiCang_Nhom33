import { Request, Response } from "express";
import {
  IQueryHandler,
  ThongKeDonHangTheoThangQuery,
  ThongKeDonHangTheoTuanQuery,
} from "../../interface";
import {
  ThongKeDonHangTheoThangDTO,
  ThongKeDonHangTheoTuanDTO,
} from "../../model/dto";

export class DonHangHttpService {
  constructor(
    private readonly thongKeDonHangTheoThangQueryHandle: IQueryHandler<
      ThongKeDonHangTheoThangQuery,
      ThongKeDonHangTheoThangDTO[]
    >,
    private readonly thongKeDonHangTheoTuanQueryHandle: IQueryHandler<
      ThongKeDonHangTheoTuanQuery,
      ThongKeDonHangTheoTuanDTO[]
    >
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
}
