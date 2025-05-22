import { ITauRepository } from "@/modules/tau/interface";
import { HangTau, SoChuyenTau, Tau } from "@/modules/tau/model";
import { PrismaClient } from "@prisma/client";

export class PrismaTauRepository implements ITauRepository {
  constructor(private prisma: PrismaClient) {}
  async getSoChuyenTauByIds(ids: number[]): Promise<SoChuyenTau[]> {
    const soChuyenTaus = await this.prisma.soChuyenTau.findMany({
      where: {
        ID: {
          in: ids,
        },
      },
    });
    return soChuyenTaus.map((soChuyenTau) => {
      return {
        ID: soChuyenTau.ID,
        MaChuyenTau: soChuyenTau.MaChuyenTau,
        IDTau: soChuyenTau.IDTau,
        ThoiGian: soChuyenTau.ThoiGian,
      } as SoChuyenTau;
    });
  }
  async getTauByIds(ids: number[]): Promise<Tau[]> {
    const taus = await this.prisma.tau.findMany({
      where: {
        ID: {
          in: ids,
        },
      },
    });
    return taus.map((tau) => {
      return {
        ID: tau.ID,
        Ten: tau.Ten,
        IDHangTau: tau.IDHangTau,
      } as Tau;
    });
  }
  async getHangTauByIds(ids: number[]): Promise<HangTau[]> {
    const hangTaus = await this.prisma.hangTau.findMany({
      where: {
        ID: {
          in: ids,
        },
      },
    });
    return hangTaus.map((hangTau) => {
      return {
        ID: hangTau.ID,
        Ten: hangTau.Ten,
      } as HangTau;
    });
  }
}
