import { PrismaClient } from "@prisma/client";
import { PrismaDanhMucChungRepository } from "./infras/repository/prisma";
import { GetLoaiHangById } from "./uescase/getLoaiHangById";
import { Router } from "express";
import { DanhMucChungHttpService } from "./infras/transport/http";

export const setupDanhMucChungHexagon = (prisma: PrismaClient) => {
  const repository = new PrismaDanhMucChungRepository(prisma);
  const getLoaiHangByIdQuery = new GetLoaiHangById(repository);
  const httpDanhMucChungService = new DanhMucChungHttpService(
    getLoaiHangByIdQuery
  );

  const router = Router();
  router.get(
    "/loai-hang/:id",
    httpDanhMucChungService.getLoaiHangByIdAPI.bind(httpDanhMucChungService)
  );
  return router;
};
