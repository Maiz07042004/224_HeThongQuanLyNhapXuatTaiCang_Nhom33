import e, { Request, Response } from "express";
import {
  GetLoaiHangQuery,
  IDanhMucChungRepository,
  IQueryHandler,
} from "../../interface";
import { LoaiHang } from "../../model";

export class DanhMucChungHttpService {
  constructor(
    private readonly getLoaiHangByIdQueryHandler: IQueryHandler<
      GetLoaiHangQuery,
      LoaiHang | null
    >,
    private readonly repository: IDanhMucChungRepository
  ) {}

  async getLoaiHangByIdAPI(req: Request, res: Response) {
    try {
      const id = req.params.id;
      const loaiHang = await this.getLoaiHangByIdQueryHandler.execute({
        id: Number(id),
      });
      res.status(200).json({ data: loaiHang });
    } catch (error) {
      res.status(500).json({ message: (error as Error).message });
    }
  }
  async getLoaiHangByIdsAPI(req: Request, res: Response) {
    try {
      const ids = req.query.ids as string;
      const loaiHangs = await this.repository.getLoaiHangByIds(
        ids.split(",").map((id) => Number(id))
      );
      res.status(200).json({ data: loaiHangs });
    } catch (error) {
      res.status(500).json({ message: (error as Error).message });
    }
  }
}
