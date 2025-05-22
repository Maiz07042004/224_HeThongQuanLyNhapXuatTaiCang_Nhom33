import { Request, Response } from "express";
import {
  GetCangDenQuery,
  GetQuocGiaQuery,
  ICangRepository,
  IQueryHandler,
} from "../../interface";
import { CangDen, QuocGia } from "../../model/cangDen";

export class CangHttpService {
  constructor(
    private readonly getCangDenQueryHandler: IQueryHandler<
      GetCangDenQuery,
      CangDen | null
    >,
    private readonly getQuocGiaQueryHandler: IQueryHandler<
      GetQuocGiaQuery,
      QuocGia | null
    >,
    private readonly repo: ICangRepository
  ) {}
  async getCangDenAPI(req: Request, res: Response) {
    const { id } = req.params;
    const cangDen = await this.getCangDenQueryHandler.execute({
      id: Number(id),
    });
    if (cangDen) {
      const quocGia = await this.getQuocGiaQueryHandler.execute({
        id: cangDen.IDQuocGia,
      });
      const newCangDen = {
        id: cangDen?.ID,
        ten: cangDen?.Ten,
        quocGia: quocGia?.Ten,
      };
      res.status(200).json({
        data: newCangDen,
      });
    }
    res.status(404).json({
      message: "Cang den not found",
    });
  }

  //RPC
  async getCangDenByIdsAPI(req: Request, res: Response) {
    const ids = req.query.ids as string;
    try {
      const cangDens = await this.repo.getCangDenByIds(
        ids.split(",").map((id) => Number(id))
      );
      const quocGiaIds = cangDens.map((cangDen) => cangDen.IDQuocGia);
      const quocGias = await this.repo.getQuocGiaByIds(quocGiaIds);
      const newCangDens = cangDens.map((cangDen) => {
        const quocGia = quocGias.find(
          (quocGia) => quocGia.ID === cangDen.IDQuocGia
        );
        return {
          ID: cangDen.ID,
          Ten: cangDen.Ten,
          QuocGia: quocGia?.Ten,
        };
      });
      res.status(200).json({
        data: newCangDens,
      });
    } catch (error) {
      res.status(404).json({
        message: "Cang den not found",
      });
    }
  }
}
