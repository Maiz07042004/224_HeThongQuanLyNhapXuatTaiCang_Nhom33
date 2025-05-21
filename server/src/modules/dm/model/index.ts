import { z } from "zod";

export const LoaiHangSchema = z.object({
  ID: z.number(),
  Ten: z.string(),
});
export type LoaiHang = z.infer<typeof LoaiHangSchema>;
