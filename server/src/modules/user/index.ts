import { PrismaClient } from "@prisma/client";
import { PrismaUserRepository } from "./infras/repository/prisma";
import { Login } from "./usecase/login";
import { UserHttpService } from "./infras/transport";
import { Router } from "express";

export const setupUserServiceHexagonal = (prisma: PrismaClient) => {
  const repoUser = new PrismaUserRepository(prisma);
  const loginQueryHandler = new Login(repoUser);
  const http = new UserHttpService(loginQueryHandler, repoUser);

  const router = Router();
  router.post("/auth/login", http.loginUserAPI.bind(http));

  // RPC
  router.get("/rpc/get-list-user-by-ids", http.getListUserByIdsAPI.bind(http));

  return router;
};
