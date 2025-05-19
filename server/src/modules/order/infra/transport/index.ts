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

      res.status(200).json({
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

      res.status(200).json({
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
