import { PrismaClient } from "@prisma/client";
import { PrismaDonHangRepository } from "./infra/repository/prisma";
import { thongKeDonHangTheoThangQueryHandle } from "./usecase/thongKeDonHangTheoThang";
import { thongKeDonHangTheoTuanQueryHandle } from "./usecase/thongKeDonHangTheoTuan";
import { DonHangHttpService } from "./infra/transport";
import { Router } from "express";
import { RPCDonHangCangRepo } from "./infra/repository/rpc/cang";
import { RPCDonHangLoaiHangRepository } from "./infra/repository/rpc/loaiHang";
import { RPPCDonHangSoChuyenTauRepo } from "./infra/repository/rpc/soChuyenTau";
import { RPCDonHangUserRepo } from "./infra/repository/rpc/user";
import { getListDonHangTheoThoiGian } from "./usecase/getDonHangTheoThoiGian";
import { thongKeDonHangTheoHangTauQuery } from "./usecase/thongKeDonHangTheoHangTau";
import { thongKeDonHangTheoCangDenQuery } from "./usecase/thongKeDonHangTheoCangDen";

export const setupDonHangModuleHexagonal = (prisma: PrismaClient) => {
  const repo = new PrismaDonHangRepository(prisma);
  const thongKeTheoThangQueryHandle = new thongKeDonHangTheoThangQueryHandle(
    repo
  );
  const thongKeTheoTuanQueryHandle = new thongKeDonHangTheoTuanQueryHandle(
    repo
  );
  const getListDonHangTheoThoiGianQueryHandler = new getListDonHangTheoThoiGian(
    repo
  );
  const thongKeTheoHangTauQueryHandle = new thongKeDonHangTheoHangTauQuery(
    repo
  );
  const thongKeTheoCangDenQueryHandle = new thongKeDonHangTheoCangDenQuery(
    repo
  );
  const cangRPCRepo = new RPCDonHangCangRepo("http://localhost:3000");
  const loaiHangRPCRepo = new RPCDonHangLoaiHangRepository(
    "http://localhost:3000"
  );
  const soChuyenTauRPCRepo = new RPPCDonHangSoChuyenTauRepo(
    "http://localhost:3000"
  );
  const userRPCRepo = new RPCDonHangUserRepo("http://localhost:3000");
  const httpService = new DonHangHttpService(
    thongKeTheoThangQueryHandle,
    thongKeTheoTuanQueryHandle,
    getListDonHangTheoThoiGianQueryHandler,
    thongKeTheoHangTauQueryHandle,
    thongKeTheoCangDenQueryHandle,
    cangRPCRepo,
    soChuyenTauRPCRepo,
    loaiHangRPCRepo,
    userRPCRepo
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
  router.get(
    "/donhang/list",
    httpService.getListDonHangTheoNamAPI.bind(httpService)
  );
  router.get(
    "/donhang/thongke-hangtau/:nam",
    httpService.thongKeDonHangTheoHangTauAPI.bind(httpService)
  );
  router.get(
    "/donhang/thongke-cangden/:nam",
    httpService.thongKeDonHangTheoCangDenAPI.bind(httpService)
  );
  return router;
};
