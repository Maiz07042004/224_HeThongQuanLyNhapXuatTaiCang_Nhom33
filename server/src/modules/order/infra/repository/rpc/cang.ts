import { ICangQueryRepository } from "@/modules/order/interface";
import { DonHang_CangDen } from "@/modules/order/model/DonHang";
import axios from "axios";

export class RPCDonHangCangRepo implements ICangQueryRepository {
  constructor(private readonly baseUrl: string) {}
  async getListCangDenByIds(ids: number[]): Promise<DonHang_CangDen[]> {
    try {
      const { data, status } = await axios.get(
        `${this.baseUrl}/v1/rpc/cang-den-by-ids?ids=${ids.join(",")}`
      );
      if (data && status === 200) {
        const listCangDen = data.data as DonHang_CangDen[];
        return listCangDen;
      }
      return [];
    } catch (error) {
      throw error;
    }
  }
}
