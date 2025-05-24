// import { AppSidebar } from "../../components/app-sidebar";
import { ChartAreaInteractive } from "../../components/chart-area-interactive";
import { DataTable } from "../../components/data-table";
import { SectionCards } from "../../components/section-cards";
import { SiteHeader } from "../../components/site-header";
import { SidebarInset } from "@/components/ui/sidebar";

// import data from "./data.json";
import { useEffect, useState } from "react";
import {
  getDataTableTheoNam,
  getDataTableTheoThang,
  getDataThongKeTheoNam,
  getDataThongKeTheoThang,
} from "@/api";
import { z } from "zod";
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
export const TypeDataTableSchema = z.object({
  ID: z.number(),
  Ten: z.string(),
  MaVanDon: z.string(),
  MaTrangThai: z.string(),
  KieuDon: z.string(),
  CangDen: z.string(),
  TenTau: z.string(),
});
export type TypeDataTable = z.infer<typeof TypeDataTableSchema>;

interface ResDataTableItem {
  ID: number;
  user: {
    Ten: string;
  };
  MaVanDon: string;
  MaTrangThai: string;
  KieuDon: string;
  cangDen: {
    Ten: string;
  };
  soChuyenTau: {
    TenTau: string;
  };
}
export default function Thongke() {
  const [dataChart, setDataChart] = useState<DataApi>({
    data: [],
    totalNhap: 0,
    totalXuat: 0,
  });
  // const [dataTable, setDataTable] = useState<DataChart[]>([]);
  const [chartMode, setChartMode] = useState<"monthly" | "weekly">("monthly");
  const [year, setYear] = useState(2025);
  const [oldyear, setOldYear] = useState(year - 1);
  const [oldDataChart, setOldDataChart] = useState<DataApi>({
    data: [],
    totalNhap: 0,
    totalXuat: 0,
  });
  const [month, setMonth] = useState(1);
  const [oldmonth, setOldMonth] = useState(month - 1);

  const [dataTable, setDataTable] = useState<TypeDataTable[]>([]);

  useEffect(() => {
    if (chartMode === "weekly") {
      if (month === 1) {
        setOldMonth(12);
        setOldYear(year - 1);
      } else {
        setOldMonth(month - 1);
        setOldYear(year);
      }
    }
  }, [month, year, chartMode]);

  useEffect(() => {
    const fetchData = async () => {
      if (chartMode === "monthly") {
        const [res, resOld, resDataTable] = await Promise.all([
          getDataThongKeTheoNam(year),
          getDataThongKeTheoNam(oldyear),
          getDataTableTheoNam(year),
        ]);
        if (res && resOld && resDataTable) {
          const data = res.data.map((item: DataChart) => ({
            ...item,
            month: `Tháng ${item.thang}`,
          }));
          res.data = data;
          const dataTable: TypeDataTable[] = (
            resDataTable.data as ResDataTableItem[]
          ).map((item: ResDataTableItem): TypeDataTable => {
            return {
              ID: item.ID,
              Ten: item.user.Ten,
              MaVanDon: item.MaVanDon,
              MaTrangThai: item.MaTrangThai,
              KieuDon: item.KieuDon,
              CangDen: item.cangDen.Ten,
              TenTau: item.soChuyenTau.TenTau,
            };
          });
          setDataChart(res);
          setOldDataChart(resOld);
          setDataTable(dataTable);
        }
      } else {
        const [res, resOld, resDataTable] = await Promise.all([
          getDataThongKeTheoThang(year, month),
          getDataThongKeTheoThang(oldyear, oldmonth),
          getDataTableTheoThang(year, month),
        ]);
        if (res && resOld && resDataTable) {
          const data = res.data.map((item: DataChart) => ({
            ...item,
            week: `Tuần ${item.tuan}`,
          }));
          res.data = data;

          const dataTable: TypeDataTable[] = (
            resDataTable.data as ResDataTableItem[]
          ).map((item: ResDataTableItem): TypeDataTable => {
            return {
              ID: item.ID,
              Ten: item.user.Ten,
              MaVanDon: item.MaVanDon,
              MaTrangThai: item.MaTrangThai,
              KieuDon: item.KieuDon,
              CangDen: item.cangDen.Ten,
              TenTau: item.soChuyenTau.TenTau,
            };
          });
          setDataChart(res);
          setOldDataChart(resOld);
          setDataTable(dataTable);
        }
      }
    };
    fetchData();
  }, [year, oldyear, month, oldmonth, chartMode]);
  return (
    <SidebarInset>
      <SiteHeader />
      <div className="flex flex-1 flex-col">
        <div className="@container/main flex flex-1 flex-col gap-2">
          <div className="flex flex-col gap-4 py-4 md:gap-6 md:py-6">
            <SectionCards
              data={dataChart}
              oldData={oldDataChart}
              oldYear={oldyear}
              oldMonth={oldmonth}
              chartMode={chartMode}
            />
            <div className="px-4 lg:px-6">
              <ChartAreaInteractive
                data={dataChart}
                chartMode={chartMode}
                year={year}
                setYear={setYear}
                setOldYear={setOldYear}
                setMonth={setMonth}
                setChartMode={setChartMode}
              />
            </div>
            <DataTable
              year={year}
              chartMode={chartMode}
              month={month}
              data={dataTable}
            />
          </div>
        </div>
      </div>
    </SidebarInset>
  );
}
