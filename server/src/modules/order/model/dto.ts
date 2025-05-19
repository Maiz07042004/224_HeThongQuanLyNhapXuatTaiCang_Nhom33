import { z } from "zod";

export const ThongKeDonHangTheoThangDTOSchema = z.object({
  thang: z.number().int().positive(),
  nhap: z.number().int().positive(),
  xuat: z.number().int().positive(),
});
export type ThongKeDonHangTheoThangDTO = z.infer<
  typeof ThongKeDonHangTheoThangDTOSchema
>;
export const ThongKeDonHangTheoThangRawDTOSchema = z.object({
  thang: z.number().int().positive(),
  kieuDon: z.string(),
  count: z.number().int().positive(),
});
export type ThongKeDonHangTheoThangRawDTO = z.infer<
  typeof ThongKeDonHangTheoThangRawDTOSchema
>;

export const ThongKeDonHangTheoTuanDTOSchema = z.object({
  tuan: z.number().int().positive(),
  nhap: z.number().int().positive(),
  xuat: z.number().int().positive(),
});
export type ThongKeDonHangTheoTuanDTO = z.infer<
  typeof ThongKeDonHangTheoTuanDTOSchema
>;
export const ThongKeDonHangTheoTuanRawDTOSchema = z.object({
  tuan: z.number().int().positive(),
  kieuDon: z.string(),
  count: z.number().int().positive(),
});
export type ThongKeDonHangTheoTuanRawDTO = z.infer<
  typeof ThongKeDonHangTheoTuanRawDTOSchema
>;

export type DonHangCondDTO = {
  thang?: number;
  nam?: number;
};
