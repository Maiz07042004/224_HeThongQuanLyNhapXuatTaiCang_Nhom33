import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from "recharts";
import { Card, CardHeader, CardTitle, CardContent } from "@/components/ui/card";
import { DataChartContainer } from "./thongke";
// const dummyData = [
//   { kho: "Kho A", soLuong: 40 },
//   { kho: "Kho B", soLuong: 25 },
//   { kho: "Kho C", soLuong: 60 },
// ];

export default function ContainerStatisticsPage({
  data,
}: {
  data: DataChartContainer[];
}) {
  return (
    <Card className="shadow-md ">
      <CardHeader>
        <CardTitle>Container từng kho</CardTitle>
      </CardHeader>
      <CardContent>
        <ResponsiveContainer width="100%" height={300}>
          <BarChart data={data}>
            <XAxis dataKey="kho" />
            <YAxis />
            <Tooltip />
            <Bar dataKey="soLuong" name={"Số lượng"} fill="#4f46e5" />
          </BarChart>
        </ResponsiveContainer>
      </CardContent>
    </Card>
  );
}
