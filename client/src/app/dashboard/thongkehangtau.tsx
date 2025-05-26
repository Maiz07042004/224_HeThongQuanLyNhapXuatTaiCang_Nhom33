import ShippingCompanyChart from "./ShippingCompanyChart";
import { Card, CardHeader, CardTitle, CardContent } from "@/components/ui/card";
import { DataChartShippingCompany } from "./thongke";

// const mockShippingData = [
//   { HangTau: "Vinalines", SoLuongDon: 90 },
//   { HangTau: "Maersk", SoLuongDon: 110 },
//   { HangTau: "COSCO", SoLuongDon: 70 },
//   { HangTau: "MOL", SoLuongDon: 50 },
//   { HangTau: "Yang Ming", SoLuongDon: 60 },
// ];

// type ShippingData = { HangTau: string; SoLuongDon: number };

export default function ShippingCompanyStatisticsPage({
  data,
}: {
  data: DataChartShippingCompany[];
}) {
  return (
    <Card className="shadow-md">
      <CardHeader>
        <CardTitle>Thống kê theo hãng tàu</CardTitle>
      </CardHeader>
      <CardContent>
        <ShippingCompanyChart data={data} />
      </CardContent>
    </Card>
  );
}
