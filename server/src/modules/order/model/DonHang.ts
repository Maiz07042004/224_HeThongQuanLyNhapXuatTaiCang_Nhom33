import { z } from "zod";

// Enum ví dụ cho trạng thái đơn hàng
export enum TrangThaiDonHang {
  ChoXacNhan = "ChoXacNhan",
  DangVanChuyen = "DangVanChuyen",
  HoanThanh = "HoanThanh",
  DaHuy = "DaHuy",
  // Thêm trạng thái khác nếu cần
}

export const DonHangSchema = z.object({
  id: z.number().int().positive(), // ID INT PRIMARY KEY
  maVanDon: z.string().min(1), // MaVanDon NVARCHAR(100)

  idCangDen: z.number().int().positive(), // IDCangDen INT
  idSoChuyenTau: z.number().int().positive(), // IDSoChuyenTau INT
  idLoaiHang: z.number().int().positive(), // IDLoaiHang INT
  idUser: z.number().int().positive(), // IDUser INT

  maTrangThai: z.nativeEnum(TrangThaiDonHang), // MaTrangThai NVARCHAR(50)

  kieuDon: z.string().optional(), // KieuDon NVARCHAR(50)
  loaiDon: z.string().optional(), // LoaiDon NVARCHAR(50)
  soToKhaiHaiQuan: z.string().optional(), // SoToKhaiHaiQuan NVARCHAR(100)
  canNang: z.number().optional(), // CanNang FLOAT
  kichThuoc: z.string().optional(), // KichThuoc NVARCHAR(100)

  thoiGianXuatHang: z.coerce.date().optional(), // ThoiGianXuatHang DATETIME
  thoiGianTaoDon: z.coerce.date().optional(), // ThoiGianTaoDon DATETIME
  ngayNhapKho: z.coerce.date().optional(), // NgayNhapKho DATETIME

  nguoiNhan: z.string().optional(), // NguoiNhan NVARCHAR(100)
  createdAt: z.coerce.date().optional(), // Trường thêm nếu có
  updatedAt: z.coerce.date().optional(),
});

export type DonHang = z.infer<typeof DonHangSchema>;
