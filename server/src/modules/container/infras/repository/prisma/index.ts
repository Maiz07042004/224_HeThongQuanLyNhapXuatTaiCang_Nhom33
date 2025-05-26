import { IContainerRepository } from "@/modules/container/interface";
import { ThongKeSoLuongContainerTheoTungKhoRawDTO } from "@/modules/container/model/dto";
import { PrismaClient } from "@prisma/client";

export class PrismaContainerRepository implements IContainerRepository {
  constructor(private readonly prisma: PrismaClient) {}
  async thongKeSoLuongContainerTheoTungKho(): Promise<
    ThongKeSoLuongContainerTheoTungKhoRawDTO[]
  > {
    return await this.prisma.$queryRaw<
      ThongKeSoLuongContainerTheoTungKhoRawDTO[]
    >`
      SELECT 
    K.Ten AS kho,
    COUNT(CDH.IDContainer) AS soLuong
  FROM 
    Container_DonHang CDH
  JOIN 
    Khu KH ON CDH.IDKhu = KH.ID
  JOIN 
    Kho K ON KH.IDKho = K.ID
  GROUP BY 
    K.Ten
  ORDER BY 
    soLuong DESC;`;
  }
}
