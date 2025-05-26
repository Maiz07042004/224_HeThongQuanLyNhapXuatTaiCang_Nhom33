import { PrismaClient } from "@prisma/client";
import { PrismaContainerRepository } from "./infras/repository/prisma";
import { ThongKeSoLuongContainerTheoTungKhoQuery } from "./usecase/thongKeContainerTheoKho";
import { ContainerHttpService } from "./infras/transport/http";
import { Router } from "express";

export const setupContainerModuleHexagonal = (prisma: PrismaClient) => {
  const repo = new PrismaContainerRepository(prisma);
  const thongKeSoLuongContainerTheoTungKho =
    new ThongKeSoLuongContainerTheoTungKhoQuery(repo);
  const http = new ContainerHttpService(thongKeSoLuongContainerTheoTungKho);

  const router = Router();

  router.get(
    "/container/thongke_soluongcontainer",
    http.thongKeSoLuongContainerTheoTungKho.bind(http)
  );

  return router;
};
