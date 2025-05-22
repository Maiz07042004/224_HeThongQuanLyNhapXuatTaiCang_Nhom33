import { z } from "zod";

export const CangDenSchema = z.object({
  ID: z.number(),
  Ten: z.string(),
  IDQuocGia: z.number(),
});
export type CangDen = z.infer<typeof CangDenSchema>;

export const QuocGiaSchema = z.object({
  ID: z.number(),
  Ten: z.string(),
});
export type QuocGia = z.infer<typeof QuocGiaSchema>;
