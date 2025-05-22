import { IUserQueryRepository } from "@/modules/order/interface";
import { DonHang_User } from "@/modules/order/model/DonHang";
import axios from "axios";

export class RPCDonHangUserRepo implements IUserQueryRepository {
  constructor(private readonly baseUrl: string) {}
  async getListUserByIds(ids: number[]): Promise<DonHang_User[]> {
    try {
      const { data, status } = await axios.get(
        `${this.baseUrl}/v1/rpc/get-list-user-by-ids?ids=${ids.join(",")}`
      );
      if (status === 200 && data) {
        const result = data.data as DonHang_User[];
        return result;
      } else {
        return [];
      }
    } catch (error) {
      throw error as Error;
    }
  }
}
