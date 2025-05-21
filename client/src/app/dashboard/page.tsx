import { AppSidebar } from "../../components/app-sidebar";
import { ChartAreaInteractive } from "../../components/chart-area-interactive";
import { DataTable } from "../../components/data-table";
import { SectionCards } from "../../components/section-cards";
import { SiteHeader } from "../../components/site-header";
import { SidebarInset, SidebarProvider } from "@/components/ui/sidebar";

import data from "./data.json";
import { useEffect, useState } from "react";
import { getDataThongKeTheoNam, getDataThongKeTheoThang } from "@/api";
export type DataChart = {
  thang?: string;
  tuan?: string;
  nhap: number;
  xuat: number;
  week?: string;
  month?: string;
};
export type DataApi = {
  data: DataChart[];
  totalNhap: number;
  totalXuat: number;
};
export default function Page() {
  const [dataChart, setDataChart] = useState<DataApi>({
    data: [],
    totalNhap: 0,
    totalXuat: 0,
  });
  // const [dataTable, setDataTable] = useState<DataChart[]>([]);
  const [chartMode, setChartMode] = useState<"monthly" | "weekly">("monthly");
  const [year, setYear] = useState(2025);
  const [month, setMonth] = useState(1);
  useEffect(() => {
    const fetchData = async () => {
      if (chartMode === "monthly") {
        const res = await getDataThongKeTheoNam(year);
        if (res) {
          const data = res.data.map((item: DataChart) => ({
            ...item,
            month: `Tháng ${item.thang}`,
          }));
          res.data = data;
          setDataChart(res);
        }
      } else {
        const res = await getDataThongKeTheoThang(year, month);
        if (res) {
          const data = res.data.map((item: DataChart) => ({
            ...item,
            week: `Tuần ${item.tuan}`,
          }));
          res.data = data;
          setDataChart(res);
        }
      }
    };
    fetchData();
  }, [year, month, chartMode]);
  return (
    <SidebarProvider>
      <AppSidebar variant="inset" />
      <SidebarInset>
        <SiteHeader />
        <div className="flex flex-1 flex-col">
          <div className="@container/main flex flex-1 flex-col gap-2">
            <div className="flex flex-col gap-4 py-4 md:gap-6 md:py-6">
              <SectionCards />
              <div className="px-4 lg:px-6">
                <ChartAreaInteractive
                  data={dataChart}
                  chartMode={chartMode}
                  year={year}
                  setYear={setYear}
                  setMonth={setMonth}
                  setChartMode={setChartMode}
                />
              </div>
              <DataTable data={data} />
            </div>
          </div>
        </div>
      </SidebarInset>
    </SidebarProvider>
  );
}
