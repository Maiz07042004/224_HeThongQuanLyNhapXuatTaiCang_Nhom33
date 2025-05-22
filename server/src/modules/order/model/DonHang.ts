import { z } from "zod";

// Enum ví dụ cho trạng thái đơn hàng
export enum TrangThaiDonHang {
  ChoXacNhan = "ChoXacNhan",
  DangVanChuyen = "DangVanChuyen",
  HoanThanh = "HoanThanh",
  DaHuy = "DaHuy",
  ChoXuat = "CHO_XUAT",
  DaXuat = "DA_XUAT",
  // Thêm trạng thái khác nếu cần
}
export enum KieuDon {
  NhapKhau = "Nhập khẩu",
  XuatKhau = "Xuất khẩu",
}

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

export const DonHang_CangDenSchema = z.object({
  ID: z.number().int().positive(), // ID INT PRIMARY KEY
  Ten: z.string().min(1), // Ten NVARCHAR(100)
  QuocGia: z.string().min(1),
});
export type DonHang_CangDen = z.infer<typeof DonHang_CangDenSchema>;

export const DonHang_SoChuyenTauSchema = z.object({
  ID: z.number().int().positive(), // ID INT PRIMARY KEY
  MaChuyenTau: z.string().min(1), // MaSoChuyen NVARCHAR(100)
  ThoiGian: z.date(),
  TenTau: z.string().min(1), // TenTau NVARCHAR(100)
  HangTau: z.string().min(1), // HangTau NVARCHAR(100)
});
export type DonHang_SoChuyenTau = z.infer<typeof DonHang_SoChuyenTauSchema>;

export const DonHang_LoaiHangSchema = z.object({
  ID: z.number().int().positive(), // ID INT PRIMARY KEY
  Ten: z.string().min(1), // Ten NVARCHAR(100)
});
export type DonHang_LoaiHang = z.infer<typeof DonHang_LoaiHangSchema>;

export const DonHang_UserSchema = z.object({
  ID: z.number().int().positive(), // ID INT PRIMARY KEY
  Ten: z.string().min(1), // Ten NVARCHAR(100)
});
export type DonHang_User = z.infer<typeof DonHang_UserSchema>;
