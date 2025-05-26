import { z } from "zod";
import { GioiTinh } from ".";

export const UserLoginSchema = z.object({
  Email: z.string(),
  MatKhau: z.string(),
});
export type UserLoginDto = z.infer<typeof UserLoginSchema>;
export const UserLoginResponseSchema = z.object({
  Error: z.string().optional(),
  Ten: z.string().max(100),
  ChucVu: z.string().max(100),
  NgaySinh: z.date(),
  GioiTinh: z.nativeEnum(GioiTinh),
  SDT: z.string().max(20),
  Email: z.string().email().max(100),
  DiaChi: z.string().max(200),
});
export type UserLoginResponseDto = z.infer<typeof UserLoginResponseSchema>;
