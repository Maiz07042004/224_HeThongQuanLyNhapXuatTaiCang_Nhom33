import { PrismaClient } from "@prisma/client";
import { PrismaTauRepository } from "./infras/repository/prisma";
import { TauHttpService } from "./infras/transport/http";
import { Router } from "express";

export const setupTauHexagonal = (prisma: PrismaClient) => {
  const tauRepository = new PrismaTauRepository(prisma);
  const tauHttp = new TauHttpService(tauRepository);

  const router = Router();
  router.get(
    "/rpc/getSoChuyenTauByIds",
    tauHttp.getSoChuyenTauByIds.bind(tauHttp)
  );
  return router;
};
