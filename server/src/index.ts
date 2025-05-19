import "module-alias/register";
import { PrismaClient } from "@prisma/client";
import express from "express";
import { setupDonHangModuleHexagonal } from "./modules/order";
const prisma = new PrismaClient();
const app = express();
const port = process.env.PORT || 3000;
app.use(express.json());

app.use("/v1", setupDonHangModuleHexagonal(prisma));
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
