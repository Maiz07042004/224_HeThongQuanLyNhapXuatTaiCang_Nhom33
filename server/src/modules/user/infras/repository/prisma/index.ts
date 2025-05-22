import { IUserRepository } from "@/modules/user/interface";
import { GioiTinh, TrangThai, UserAccount } from "@/modules/user/model";
import { UserLoginDto } from "@/modules/user/model/dto";
import { PrismaClient } from "@prisma/client";

export class PrismaUserRepository implements IUserRepository {
  constructor(private prisma: PrismaClient) {}
  async login(data: UserLoginDto): Promise<string> {
    const user = await this.prisma.userAccount.findFirst({
      where: {
        Email: data.Email,
      },
    });
    if (!user) {
      throw new Error("Không tìm thấy tài khoản với email mày");
    }
    if (user.MatKhau !== data.MatKhau) {
      throw new Error("Mật khẩu sai");
    }
    return "success";
  }
  async getListUserByIds(ids: number[]): Promise<UserAccount[]> {
    const users = await this.prisma.userAccount.findMany({
      where: {
        ID: {
          in: ids,
        },
      },
    });
    const result: UserAccount[] = users.map((user) => ({
      Email: user.Email || "",
      MatKhau: user.MatKhau || "",
      ID: user.ID,
      Ten: user.Ten || "",
      IDChucVu: user.IDChucVu || 0,
      NgaySinh: user.NgaySinh || new Date(),
      GioiTinh: (user.GioiTinh as GioiTinh) || "Nam",
      DiaChi: user.DiaChi || "",
      TrangThai: (user.TrangThai as TrangThai) || "Hoạt động",
      Cccd: user.CCCD || "",
      Sdt: user.SDT || "",
    }));
    return result;
  }
}
