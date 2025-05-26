import { z } from "zod";

export const ThongKeSoLuongContainerTheoTungKhoRawDTOSchema = z.object({
  kho: z.string(),
  soLuong: z.number().int().positive(),
});
export type ThongKeSoLuongContainerTheoTungKhoRawDTO = z.infer<
  typeof ThongKeSoLuongContainerTheoTungKhoRawDTOSchema
>;
