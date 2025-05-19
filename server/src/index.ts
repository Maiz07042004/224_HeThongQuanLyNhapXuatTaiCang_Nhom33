import { PrismaClient } from "@prisma/client";
import express, { NextFunction, Request, Response } from "express";
const prisma = new PrismaClient();
const app = express();
const port = process.env.PORT || 3000;
app.use(express.json());

app.get("/", async (req: Request, res: Response) => {
  const donHangs = await prisma.donHang.findMany();
  res.json({ data: donHangs });
});
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
