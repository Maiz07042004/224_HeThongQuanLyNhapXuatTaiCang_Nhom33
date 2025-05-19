import { PrismaClient } from "@prisma/client";
import { PrismaDonHangRepository } from "./infra/repository/prisma";
import { thongKeDonHangTheoThangQueryHandle } from "./usecase/thongKeDonHangTheoThang";
import { thongKeDonHangTheoTuanQueryHandle } from "./usecase/thongKeDonHangTheoTuan";
import { DonHangHttpService } from "./infra/transport";
import { Router } from "express";

export const setupDonHangModuleHexagonal = (prisma: PrismaClient) => {
  const repo = new PrismaDonHangRepository(prisma);
  const thongKeTheoThangQueryHandle = new thongKeDonHangTheoThangQueryHandle(
    repo
  );
  const thongKeTheoTuanQueryHandle = new thongKeDonHangTheoTuanQueryHandle(
    repo
  );
  const httpService = new DonHangHttpService(
    thongKeTheoThangQueryHandle,
    thongKeTheoTuanQueryHandle
  );

  const router = Router();
  router.get(
    "/donhang/thongke/:nam",
    httpService.thongKeDonHangTheoThangAPI.bind(httpService)
  );
  router.get(
    "/donhang/thongke/:nam/:thang",
    httpService.thongKeDonHangTheoTuanAPI.bind(httpService)
  );
  return router;
};
