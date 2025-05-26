import PortStatsChart from "./PortStatsChart";
import { Card, CardHeader, CardTitle, CardContent } from "@/components/ui/card";
import { DataChartPortStats } from "./thongke";

// const mockPortData = [
//   { CangDen: "Cảng Hải Phòng", SoLuongDon: 120 },
//   { CangDen: "Cảng Cát Lái", SoLuongDon: 85 },
//   { CangDen: "Cảng Đà Nẵng", SoLuongDon: 65 },
//   { CangDen: "Cảng Sài Gòn", SoLuongDon: 95 },
//   { CangDen: "Cảng Nội Bài", SoLuongDon: 95 },
//   { CangDen: "Cảng Hiệp Phước", SoLuongDon: 95 },
//   { CangDen: "Cảng jaisdj", SoLuongDon: 95 },
//   { CangDen: "Cảng jakdjsj", SoLuongDon: 95 },
//   { CangDen: "Cảng ajaja", SoLuongDon: 95 },
// ];

// type PortData = { CangDen: string; SoLuongDon: number };

export default function PortStatisticsPage({
  data,
}: {
  data: DataChartPortStats[];
}) {
  // const [data, setData] = useState<PortData[]>([]);

  // useEffect(() => {
  //   // Giả lập fetch
  //   setTimeout(() => {
  //     setData(mockPortData);
  //   }, 500);
  // }, []);

  return (
    <Card className="shadow-md">
      <CardHeader>
        <CardTitle>📊 Thống kê theo cảng đến</CardTitle>
      </CardHeader>
      <CardContent>
        <PortStatsChart data={data} />
      </CardContent>
    </Card>
  );
}
