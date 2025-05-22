import { PrismaClient } from "@prisma/client";
import { PrismaCangRepository } from "./infras/repository/prisma";
import { GetCangDenQueryHandler } from "./usecase/getCangDen";
import { GetQuocGiaQueryHandle } from "./usecase/getQuocGia";
import { CangHttpService } from "./infras/transport/http";
import { Router } from "express";

export const setupCangHexagon = (prisma: PrismaClient) => {
  const cangRepo = new PrismaCangRepository(prisma);
  const getCangDenQuery = new GetCangDenQueryHandler(cangRepo);
  const getQuocGiaQuery = new GetQuocGiaQueryHandle(cangRepo);
  const cangHttp = new CangHttpService(
    getCangDenQuery,
    getQuocGiaQuery,
    cangRepo
  );

  const router = Router();
  router.get("/cang/:id", cangHttp.getCangDenAPI.bind(cangHttp));

  //RPC
  router.get(
    "/rpc/cang-den-by-ids",
    cangHttp.getCangDenByIdsAPI.bind(cangHttp)
  );

  return router;
};
