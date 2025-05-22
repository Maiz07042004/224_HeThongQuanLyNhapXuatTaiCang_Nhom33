import { Request, Response } from "express";
import { ITauRepository } from "../../interface";

export class TauHttpService {
  constructor(private readonly repo: ITauRepository) {}
  async getSoChuyenTauByIds(req: Request, res: Response) {
    const ids = req.params.ids;
    const soChuyenTaus = await this.repo.getSoChuyenTauByIds(
      ids.split(",").map(Number)
    );
    const taus = await this.repo.getTauByIds(
      soChuyenTaus.map((soChuyenTau) => soChuyenTau.ID)
    );
    const hangTaus = await this.repo.getHangTauByIds(
      taus.map((tau) => tau.IDHangTau)
    );
    res.status(200).json({
      data: soChuyenTaus.map((soChuyenTau) => {
        const tau = taus.find((tau) => tau.ID === soChuyenTau.IDTau);
        return {
          ID: soChuyenTau.ID,
          MaChuyenTau: soChuyenTau.MaChuyenTau,
          ThoiGian: soChuyenTau.ThoiGian,
          TenTau: taus.find((tau) => tau.ID === soChuyenTau.IDTau)?.Ten,
          HangTau: hangTaus.find((hangTau) => hangTau.ID === tau?.IDHangTau)
            ?.Ten,
        };
      }),
    });
  }
}
