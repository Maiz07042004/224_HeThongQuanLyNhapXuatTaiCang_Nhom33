// components/PortStatsChart.tsx
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
  CartesianGrid,
} from "recharts";
import { DataChartPortStats } from "./thongke";

// export interface PortData {
//   CangDen: string;
//   SoLuongDon: number;
// }

export default function PortStatsChart({
  data,
}: {
  data: DataChartPortStats[];
}) {
  return (
    <ResponsiveContainer width="100%" height={300}>
      <BarChart data={data}>
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey="CangDen" />
        <YAxis />
        <Tooltip />
        <Bar dataKey="SoLuongDon" name={"Số lượng"} fill="#8884d8" />
      </BarChart>
    </ResponsiveContainer>
  );
}
