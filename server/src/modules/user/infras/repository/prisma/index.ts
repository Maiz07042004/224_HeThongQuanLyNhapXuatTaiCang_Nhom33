import { IUserRepository } from "@/modules/user/interface";
import { GioiTinh, TrangThai, UserAccount } from "@/modules/user/model";
import { UserLoginDto, UserLoginResponseDto } from "@/modules/user/model/dto";
import { PrismaClient } from "@prisma/client";

export class PrismaUserRepository implements IUserRepository {
  constructor(private prisma: PrismaClient) {}
  async login(data: UserLoginDto): Promise<UserLoginResponseDto> {
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
    const chucVu = await this.prisma.chucVu.findFirst({
      where: {
        ID: user.IDChucVu || undefined,
      },
    });

    return {
      Email: user.Email || "",
      ChucVu: chucVu?.Ten || "",
      DiaChi: user.DiaChi || "",
      GioiTinh: (user.GioiTinh as GioiTinh) || "Nam",
      NgaySinh: user.NgaySinh || new Date(),
      SDT: user.SDT || "",
      Ten: user.Ten || "",
    };
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
      SDT: user.SDT || "",
    }));
    return result;
  }
}
