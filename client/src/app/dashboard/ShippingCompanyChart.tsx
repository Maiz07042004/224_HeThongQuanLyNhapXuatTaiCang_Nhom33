// components/ShippingCompanyChart.tsx
import { PieChart, Pie, Tooltip, Cell, ResponsiveContainer } from "recharts";
import { DataChartShippingCompany } from "./thongke";

const COLORS = ["#0088FE", "#00C49F", "#FFBB28", "#FF8042", "#8B5CF6"];

// interface ShippingData {
//   HangTau: string;
//   SoLuongDon: number;
// }

export default function ShippingCompanyChart({
  data,
}: {
  data: DataChartShippingCompany[];
}) {
  return (
    <ResponsiveContainer width="100%" height={300}>
      <PieChart>
        <Pie
          data={data}
          dataKey="soLuongDon"
          nameKey="hangTau"
          cx="50%"
          cy="50%"
          outerRadius={120}
          fill="#8884d8"
          label
        >
          {data.map((entry, index) => (
            <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
          ))}
        </Pie>
        <Tooltip />
      </PieChart>
    </ResponsiveContainer>
  );
}
