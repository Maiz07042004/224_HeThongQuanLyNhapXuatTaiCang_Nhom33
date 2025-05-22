import { z } from "zod";

export const SoChuyenTauSchema = z.object({
  ID: z.number(),
  MaChuyenTau: z.string(),
  IDTau: z.number(),
  ThoiGian: z.date(),
});
export type SoChuyenTau = z.infer<typeof SoChuyenTauSchema>;

export const TauSchema = z.object({
  ID: z.number(),
  Ten: z.string(),
  IDHangTau: z.number(),
});
export type Tau = z.infer<typeof TauSchema>;

export const HangTauSchema = z.object({
  ID: z.number(),
  Ten: z.string(),
});
export type HangTau = z.infer<typeof HangTauSchema>;
