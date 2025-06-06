"use client";

// import {
//   Bar,
//   BarChart,
//   CartesianGrid,
//   XAxis,
//   ResponsiveContainer,
//   Legend,
//   YAxis,
// } from "recharts";
import {
  Line,
  LineChart,
  CartesianGrid,
  XAxis,
  ResponsiveContainer,
  Legend,
  YAxis,
  Tooltip,
} from "recharts";

// import { useIsMobile } from "@/hooks/use-mobile";
import {
  Card,
  // CardAction,
  CardContent,
  CardDescription,
  // CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import {
  ChartConfig,
  // ChartContainer,
  // ChartTooltip,
  // ChartTooltipContent,
} from "@/components/ui/chart";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
// import { ToggleGroup, ToggleGroupItem } from "@/components/ui/toggle-group";
// import { TrendingUp } from "lucide-react";
import { CategoricalChartState } from "recharts/types/chart/types";
import { DataApi } from "@/app/dashboard/thongke";

// import { set } from "zod";

export const description = "An interactive area chart";

const chartConfig = {
  nhap: {
    label: "Nhập khẩu",
    color: "#FBBF24", // vàng
  },
  xuat: {
    label: "Xuất khẩu",
    color: "#4F46E5", // xanh dương
  },
} satisfies ChartConfig;

type ChartAreaInteractiveProps = {
  data: DataApi;
  chartMode: "monthly" | "weekly";
  year: number;
  setYear: (year: number) => void;
  setOldYear: (year: number) => void;
  setMonth: (month: number) => void;
  setChartMode: (mode: "monthly" | "weekly") => void;
};
export function ChartAreaInteractive(props: ChartAreaInteractiveProps) {
  const { data, chartMode, year, setYear, setMonth, setChartMode, setOldYear } =
    props;
  const handleClick = async (e: CategoricalChartState) => {
    if (!e?.activePayload?.length) return;
    const clickedThangLabel = e.activePayload?.[0]?.payload?.month;
    if (!clickedThangLabel) return;

    const clickedThang = e.activePayload?.[0]?.payload?.thang;
    if (isNaN(clickedThang)) return;
    setMonth(clickedThang);
    setYear(year);
    setChartMode("weekly");
  };

  return (
    <Card>
      <CardHeader>
        <CardTitle>Biểu đồ thống kê đơn xuất nhập khẩu tại cảng</CardTitle>
        <CardDescription>
          {chartMode === "monthly"
            ? "Thống kê theo tháng"
            : "Thống kê theo tuần"}
        </CardDescription>
        {chartMode === "weekly" && (
          <button
            onClick={() => {
              setChartMode("monthly");
              setYear(year);
              setOldYear(year - 1);
            }}
          >
            ← Quay lại theo tháng
          </button>
        )}
        <div className="absolute right-4 top-4">
          <Select
            value={String(year)}
            onValueChange={(val) => {
              setYear(Number(val));
              setOldYear(Number(val) - 1);
            }}
          >
            <SelectTrigger className="w-[120px]">
              <SelectValue placeholder="Năm" />
            </SelectTrigger>
            <SelectContent>
              <SelectItem value="2025">2025</SelectItem>
              <SelectItem value="2024">2024</SelectItem>
              <SelectItem value="2023">2023</SelectItem>
            </SelectContent>
          </Select>
        </div>
      </CardHeader>
      <CardContent className="h-[400px]">
        <ResponsiveContainer width="100%" height="100%">
          <LineChart data={data.data} onClick={handleClick}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey={chartMode === "monthly" ? "month" : "week"} />
            <YAxis />
            <Tooltip />
            <Legend />
            <Line
              type="monotone"
              dataKey="nhap"
              stroke={chartConfig.nhap.color}
              name={chartConfig.nhap.label}
              strokeWidth={2}
              dot={{ r: 3 }}
              activeDot={{ r: 5 }}
            />
            <Line
              type="monotone"
              dataKey="xuat"
              stroke={chartConfig.xuat.color}
              name={chartConfig.xuat.label}
              strokeWidth={2}
              dot={{ r: 3 }}
              activeDot={{ r: 5 }}
            />
          </LineChart>
        </ResponsiveContainer>
      </CardContent>
    </Card>
  );
}
