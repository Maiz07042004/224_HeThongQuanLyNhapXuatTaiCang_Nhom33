import { z } from "zod";

// Enum ví dụ cho trạng thái đơn hàng
export enum TrangThaiDonHang {
  ChoXacNhan = "ChoXacNhan",
  DangVanChuyen = "DangVanChuyen",
  HoanThanh = "HoanThanh",
  DaHuy = "DaHuy",
  // Thêm trạng thái khác nếu cần
}
export enum KieuDon {
  NhapKhau = "Nhập khẩu",
  XuatKhau = "Xuất khẩu",
}
export const CangDenSchema = z.object({});
export const DonHangSchema = z.object({
  ID: z.number().int().positive(), // ID INT PRIMARY KEY
  MaVanDon: z.string().min(1), // MaVanDon NVARCHAR(100)

  IDCangDen: z.number().int().positive(), // IDCangDen INT
  IDSoChuyenTau: z.number().int().positive(), // IDSoChuyenTau INT
  IDLoaiHang: z.number().int().positive(), // IDLoaiHang INT
  IDUser: z.number().int().positive(), // IDUser INT

  MaTrangThai: z.nativeEnum(TrangThaiDonHang), // MaTrangThai NVARCHAR(50)

  KieuDon: z.nativeEnum(KieuDon), // KieuDon NVARCHAR(50)
  LoaiDon: z.string().optional(), // LoaiDon NVARCHAR(50)
  SoToKhaiHaiQuan: z.string().optional(), // SoToKhaiHaiQuan NVARCHAR(100)
  CanNang: z.number().optional(), // CanNang FLOAT
  KichThuoc: z.string().optional(), // KichThuoc NVARCHAR(100)

  ThoiGianXuatHang: z.coerce.date().optional(), // ThoiGianXuatHang DATETIME
  ThoiGianTaoDon: z.coerce.date().optional(), // ThoiGianTaoDon DATETIME
  NgayNhapKho: z.coerce.date().optional(), // NgayNhapKho DATETIME

  NguoiNhan: z.string().optional(), // NguoiNhan NVARCHAR(100)
  createdAt: z.coerce.date().optional(), // Trường thêm nếu có
  updatedAt: z.coerce.date().optional(),
});

export type DonHang = z.infer<typeof DonHangSchema>;
