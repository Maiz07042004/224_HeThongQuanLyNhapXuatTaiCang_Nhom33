import { ISoChuyenTauQueryRepository } from "@/modules/order/interface";
import { DonHang_SoChuyenTau } from "@/modules/order/model/DonHang";
import axios from "axios";

export class RPPCDonHangSoChuyenTauRepo implements ISoChuyenTauQueryRepository {
  constructor(private readonly baseUrl: string) {}
  async getListSoChuyenTauByIds(ids: number[]): Promise<DonHang_SoChuyenTau[]> {
    try {
      const { data, status } = await axios.get(
        `${this.baseUrl}/v1/rpc/getSoChuyenTauByIds?ids=${ids.join(",")}`
      );
      if (data && status === 200) {
        const result: DonHang_SoChuyenTau[] =
          data.data as DonHang_SoChuyenTau[];
        return result;
      } else {
        return [];
      }
    } catch (error) {
      throw error;
    }
  }
}
