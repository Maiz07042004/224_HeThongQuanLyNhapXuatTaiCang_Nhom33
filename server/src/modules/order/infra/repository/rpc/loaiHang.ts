import { ILoaiHangQueryRepository } from "@/modules/order/interface";
import { DonHang_LoaiHang } from "@/modules/order/model/DonHang";
import axios from "axios";

export class RPCDonHangLoaiHangRepository implements ILoaiHangQueryRepository {
  constructor(private readonly baseUrl: string) {}
  async getListLoaiHangByIds(ids: number[]): Promise<DonHang_LoaiHang[]> {
    try {
      const { data, status } = await axios.get(
        `${this.baseUrl}/v1/rpc/loai-hang-by-ids?ids=${ids.join(",")}`
      );
      if (data && status === 200) {
        const listLoaiHang = data.data as DonHang_LoaiHang[];
        return listLoaiHang;
      }
      return [];
    } catch (error) {
      throw error;
    }
  }
}
