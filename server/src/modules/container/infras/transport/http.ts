import { Request, Response } from "express";
import { IQueryHandler } from "../../interface";
import { ThongKeSoLuongContainerTheoTungKhoRawDTO } from "../../model/dto";

export class ContainerHttpService {
  constructor(
    private readonly thongKeSoLuongContainerTheoTungKhoUseCase: IQueryHandler<
      void,
      ThongKeSoLuongContainerTheoTungKhoRawDTO[]
    >
  ) {}
  async thongKeSoLuongContainerTheoTungKho(req: Request, res: Response) {
    const result = await this.thongKeSoLuongContainerTheoTungKhoUseCase.query();
    res.status(200).json({ data: result });
  }
}
