import { z } from "zod";
export enum GioiTinh {
  Nam = "Nam",
  Nu = "Nữ",
  Khac = "Khác",
}
export enum TrangThai {
  HoatDong = "Hoạt động",
  Khoa = "Khoá",
}
export const UserAccountSchema = z.object({
  ID: z.number().positive(),
  Ten: z.string().max(100),
  IDChucVu: z.number().positive(),
  MatKhau: z.string().max(100),
  NgaySinh: z.date(),
  GioiTinh: z.nativeEnum(GioiTinh),
  Cccd: z.string().max(20),
  Sdt: z.string().max(20),
  Email: z.string().email().max(100),
  DiaChi: z.string().max(200),
  TrangThai: z.nativeEnum(TrangThai),
});

export type UserAccount = z.infer<typeof UserAccountSchema>;
