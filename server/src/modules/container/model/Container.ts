import { z } from "zod";
const KhoSchema = z.object({
  ID: z.number().positive(),
  Ten: z.string().min(1).max(100),
  LoaiKho: z.string().min(1).max(50),
});

type Kho = z.infer<typeof KhoSchema>;

const KhuSchema = z.object({
  ID: z.number().positive(),
  Ten: z.string().min(1).max(100),
  IDKho: z.number().positive(),
});

const ContainerSchema = z.object({
  ID: z.number().positive(),
  SoHieu: z.string().min(1).max(100),
  Loai: z.string().min(1).max(50),
});

const ContainerDonHangSchema = z.object({
  IDContainer: z.number().positive(),
  IDDonHang: z.number().positive(),
  IDKhu: z.number().positive(),
});

type Khu = z.infer<typeof KhuSchema>;
type Container = z.infer<typeof ContainerSchema>;
type ContainerDonHang = z.infer<typeof ContainerDonHangSchema>;
