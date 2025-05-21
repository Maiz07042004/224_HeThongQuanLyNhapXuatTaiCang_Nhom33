import { IDanhMucChungRepository } from "@/modules/dm/interface";
import { PrismaClient } from "@prisma/client";
import { LoaiHang } from "@modules/dm/model";

export class PrismaDanhMucChungRepository implements IDanhMucChungRepository {
  constructor(private prisma: PrismaClient) {}
  async getLoaiHangById(id: number): Promise<LoaiHang | null> {
    const loaiHang = await this.prisma.loaiHang.findFirst({
      where: { ID: id },
    });
    const result: { ID: number; Ten: string } | null = loaiHang
      ? { ID: loaiHang.ID, Ten: loaiHang.Ten as string }
      : null;
    if (!loaiHang) return null;
    return result;
  }
}
