import { IconTrendingDown, IconTrendingUp } from "@tabler/icons-react";

import { Badge } from "@/components/ui/badge";
import {
  Card,
  CardAction,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { DataApi } from "@/app/dashboard/thongke";

export function SectionCards({
  data,
  oldData,
  oldYear,
  oldMonth,
  chartMode,
}: {
  data: DataApi;
  oldData: DataApi;
  oldYear: number;
  oldMonth?: number;
  chartMode: "monthly" | "weekly";
}) {
  const tongDon = data.totalNhap + data.totalXuat;
  const tongDonOld = oldData.totalNhap + oldData.totalXuat;
  const percentTongDon =
    tongDonOld === 0 ? 0 : ((tongDon - tongDonOld) / tongDonOld) * 100;
  const percentXuat =
    oldData.totalXuat === 0
      ? 0
      : ((data.totalXuat - oldData.totalXuat) / oldData.totalXuat) * 100;
  const percentNhap =
    oldData.totalNhap === 0
      ? 0
      : ((data.totalNhap - oldData.totalNhap) / oldData.totalNhap) * 100;

  return (
    <div className="*:data-[slot=card]:from-primary/5 *:data-[slot=card]:to-card dark:*:data-[slot=card]:bg-card grid grid-cols-1 gap-4 px-4 *:data-[slot=card]:bg-gradient-to-t *:data-[slot=card]:shadow-xs lg:px-6 @xl/main:grid-cols-2 @5xl/main:grid-cols-4">
      <Card className="@container/card">
        <CardHeader>
          <CardDescription>Tổng đơn</CardDescription>
          <CardTitle className="text-2xl font-semibold tabular-nums @[250px]/card:text-3xl">
            {tongDon}
          </CardTitle>
          <CardAction>
            <Badge variant="outline">
              {percentTongDon >= 0 ? <IconTrendingUp /> : <IconTrendingDown />}
              {percentTongDon >= 0 ? "+" : "-"}
              {Math.abs(percentTongDon).toFixed(1)}%
            </Badge>
          </CardAction>
        </CardHeader>
        <CardFooter className="flex-col items-start gap-1.5 text-sm">
          <div className="line-clamp-1 flex gap-2 font-medium">
            {percentTongDon >= 0 ? "Tăng" : "Giảm"}{" "}
            {percentTongDon >= 0 ? (
              <IconTrendingUp className="size-4" />
            ) : (
              <IconTrendingDown className="size-4" />
            )}
          </div>
          <div className="text-muted-foreground">
            {chartMode === "weekly"
              ? `So với tháng ${oldMonth} năm ${oldYear}`
              : `So với năm ${oldYear}`}
          </div>
        </CardFooter>
      </Card>
      <Card className="@container/card">
        <CardHeader>
          <CardDescription>Đơn xuất khẩu</CardDescription>
          <CardTitle className="text-2xl font-semibold tabular-nums @[250px]/card:text-3xl">
            {data.totalXuat}
          </CardTitle>
          <CardAction>
            <Badge variant="outline">
              {percentXuat >= 0 ? <IconTrendingUp /> : <IconTrendingDown />}
              {percentXuat >= 0 ? "+" : "-"}
              {Math.abs(percentXuat).toFixed(1)}%
            </Badge>
          </CardAction>
        </CardHeader>
        <CardFooter className="flex-col items-start gap-1.5 text-sm">
          <div className="line-clamp-1 flex gap-2 font-medium">
            {percentXuat >= 0 ? "Tăng" : "Giảm"}{" "}
            {percentXuat >= 0 ? (
              <IconTrendingUp className="size-4" />
            ) : (
              <IconTrendingDown className="size-4" />
            )}
          </div>
          <div className="text-muted-foreground">
            {chartMode === "weekly"
              ? `So với tháng ${oldMonth} năm ${oldYear}`
              : `So với năm ${oldYear}`}
          </div>
        </CardFooter>
      </Card>
      <Card className="@container/card">
        <CardHeader>
          <CardDescription>Đơn nhập khẩu</CardDescription>
          <CardTitle className="text-2xl font-semibold tabular-nums @[250px]/card:text-3xl">
            {data.totalNhap}
          </CardTitle>
          <CardAction>
            <Badge variant="outline">
              {percentNhap >= 0 ? <IconTrendingUp /> : <IconTrendingDown />}
              {percentNhap >= 0 ? "+" : "-"}
              {Math.abs(percentNhap).toFixed(1)}%
            </Badge>
          </CardAction>
        </CardHeader>
        <CardFooter className="flex-col items-start gap-1.5 text-sm">
          <div className="line-clamp-1 flex gap-2 font-medium">
            {percentNhap >= 0 ? "Tăng" : "Giảm"}{" "}
            {percentNhap >= 0 ? (
              <IconTrendingUp className="size-4" />
            ) : (
              <IconTrendingDown className="size-4" />
            )}
          </div>
          <div className="text-muted-foreground">
            {chartMode === "weekly"
              ? `So với tháng ${oldMonth} năm ${oldYear}`
              : `So với năm ${oldYear}`}
          </div>
        </CardFooter>
      </Card>
      <Card className="@container/card">
        <CardHeader>
          <CardDescription>Tỷ lệ Xuất-Nhập khẩu</CardDescription>
          <CardTitle className="text-2xl font-semibold tabular-nums @[250px]/card:text-3xl">
            {Math.ceil(
              (data.totalXuat / (data.totalNhap + data.totalXuat)) * 100
            )}
            % -{" "}
            {Math.ceil(
              100 - (data.totalXuat / (data.totalNhap + data.totalXuat)) * 100
            )}
            %
          </CardTitle>
          <CardAction></CardAction>
        </CardHeader>
        <CardFooter className="flex-col items-start gap-1.5 text-sm">
          <div className="line-clamp-1 flex gap-2 font-medium">
            {percentNhap > percentXuat ? "Nhập siêu" : "Xuất siêu"}{" "}
            {/* <IconTrendingUp className="size-4" /> */}
          </div>
          {/* <div className="text-muted-foreground">Meets growth projections</div> */}
        </CardFooter>
      </Card>
    </div>
  );
}
