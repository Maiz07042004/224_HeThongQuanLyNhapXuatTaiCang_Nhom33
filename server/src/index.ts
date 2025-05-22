import "module-alias/register";
import { PrismaClient } from "@prisma/client";
import express from "express";
import { setupDonHangModuleHexagonal } from "./modules/order";
import cors from "cors";
import { setupDanhMucChungHexagon } from "./modules/dm";
import { setupCangHexagon } from "./modules/cang";
import { setupTauHexagonal } from "./modules/tau";
import { setupUserServiceHexagonal } from "./modules/user";

const prisma = new PrismaClient();
const app = express();
const port = process.env.PORT || 3000;
app.use(cors());
app.use(express.json());

app.use("/v1", setupDonHangModuleHexagonal(prisma));
app.use("/v1", setupDanhMucChungHexagon(prisma));
app.use("/v1", setupCangHexagon(prisma));
app.use("/v1", setupTauHexagonal(prisma));
app.use("/v1", setupUserServiceHexagonal(prisma));
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
