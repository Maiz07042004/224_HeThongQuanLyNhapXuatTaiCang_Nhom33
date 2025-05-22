import { ICangRepository } from "@/modules/cang/interface";
import { CangDen, QuocGia } from "@/modules/cang/model/cangDen";
import { PrismaClient } from "@prisma/client";

export class PrismaCangRepository implements ICangRepository {
  constructor(private prisma: PrismaClient) {}
  async getCangDen(id: number): Promise<CangDen | null> {
    const cangDen = await this.prisma.cangDen.findFirst({
      where: {
        ID: id,
      },
    });
    if (!cangDen) {
      return null;
    }
    return {
      ID: cangDen.ID,
      Ten: cangDen.Ten,
      IDQuocGia: cangDen.IDQuocGia,
    } as CangDen;
  }
  async getQuocGia(id: number): Promise<QuocGia | null> {
    const quocGia = await this.prisma.quocGia.findFirst({
      where: {
        ID: id,
      },
    });
    if (!quocGia) {
      return null;
    }
    return quocGia as QuocGia;
  }
  // RPC
  async getQuocGiaByIds(ids: number[]): Promise<QuocGia[]> {
    const quocGiaList = await this.prisma.quocGia.findMany({
      where: {
        ID: {
          in: ids,
        },
      },
    });
    const result: QuocGia[] = quocGiaList.map((q) => q as QuocGia);
    return result;
  }
  async getCangDenByIds(ids: number[]): Promise<CangDen[]> {
    const cangDenList = await this.prisma.cangDen.findMany({
      where: {
        ID: {
          in: ids,
        },
      },
    });
    const result: CangDen[] = cangDenList.map((c) => c as CangDen);
    return result;
  }
}
