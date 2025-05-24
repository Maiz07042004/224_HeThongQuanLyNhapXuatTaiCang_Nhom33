import * as React from "react";
import * as XLSX from "xlsx";
import {
  DndContext,
  closestCenter,
  useSensor,
  useSensors,
  MouseSensor,
  TouchSensor,
  KeyboardSensor,
  type DragEndEvent,
  type UniqueIdentifier,
} from "@dnd-kit/core";
import { restrictToVerticalAxis } from "@dnd-kit/modifiers";
import {
  SortableContext,
  arrayMove,
  verticalListSortingStrategy,
} from "@dnd-kit/sortable";
import { z } from "zod";
import {
  ColumnFiltersState,
  SortingState,
  VisibilityState,
  getCoreRowModel,
  getFilteredRowModel,
  getSortedRowModel,
  useReactTable,
  flexRender,
  getPaginationRowModel,
  getFacetedRowModel,
  getFacetedUniqueValues,
  type ColumnDef,
} from "@tanstack/react-table";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import { Button } from "@/components/ui/button";
import { Badge } from "@/components/ui/badge";
import { DownloadIcon, ChevronLeft, ChevronRight } from "lucide-react";
import { TypeDataTable, TypeDataTableSchema } from "@/app/dashboard/thongke";

const columns: ColumnDef<z.infer<typeof TypeDataTableSchema>>[] = [
  { accessorKey: "Ten", header: "Tên" },
  { accessorKey: "MaVanDon", header: "Mã Vận Đơn" },
  {
    accessorKey: "MaTrangThai",
    header: "Mã Trạng Thái",
    cell: ({ getValue }) => {
      const value = getValue<string>();

      let text = "";
      let className = "px-3 py-1 text-sm font-medium rounded-full ";

      switch (value) {
        case "CHO_XUAT":
          text = "Chờ Xuất";
          className +=
            "bg-blue-100 text-blue-800 dark:bg-blue-300 dark:text-blue-900";
          break;
        case "HOAN_THANH":
          text = "Hoàn Thành";
          className +=
            "bg-green-100 text-green-800 dark:bg-green-300 dark:text-green-900";
          break;
        case "DA_XUAT":
          text = "Đã Xuất";
          className +=
            "bg-yellow-100 text-yellow-800 dark:bg-yellow-300 dark:text-yellow-900";
          break;
        default:
          text = value;
          className +=
            "bg-gray-100 text-gray-700 dark:bg-gray-300 dark:text-gray-900";
      }

      return <Badge className={className}>{text}</Badge>;
    },
  },

  {
    accessorKey: "KieuDon",
    header: "Kiểu Đơn",
    cell: ({ getValue }) => {
      const value = getValue<string>();

      let className = "";

      if (value === "Xuất khẩu") {
        className =
          "bg-green-100 text-green-800 dark:bg-green-300 dark:text-green-900";
      } else if (value === "Nhập khẩu") {
        className =
          "bg-yellow-100 text-yellow-800 dark:bg-yellow-300 dark:text-yellow-900";
      } else {
        className =
          "bg-gray-100 text-gray-700 dark:bg-gray-300 dark:text-gray-900";
      }

      return (
        <Badge
          className={className + " px-3 py-1 text-sm font-medium rounded-full"}
        >
          {value}
        </Badge>
      );
    },
  },

  { accessorKey: "CangDen", header: "Cảng Đến" },
  { accessorKey: "TenTau", header: "Tên Tàu" },
];

export function DataTable({
  year,
  month,
  chartMode,
  data: initialData,
}: {
  year: number;
  month: number;
  chartMode: string;
  data: TypeDataTable[];
}) {
  const [data, setData] = React.useState(() => initialData);
  React.useEffect(() => {
    setData(initialData);
  }, [initialData]);
  const sortableId = React.useId();

  const sensors = useSensors(
    useSensor(MouseSensor),
    useSensor(TouchSensor),
    useSensor(KeyboardSensor)
  );

  const dataIds = React.useMemo<UniqueIdentifier[]>(
    () => data.map(({ ID }) => ID),
    [data]
  );

  const [sorting, setSorting] = React.useState<SortingState>([]);
  const [columnFilters, setColumnFilters] = React.useState<ColumnFiltersState>(
    []
  );
  const [columnVisibility, setColumnVisibility] =
    React.useState<VisibilityState>({});

  const table = useReactTable({
    data,
    columns,
    state: {
      sorting,
      columnFilters,
      columnVisibility,
    },
    getRowId: (row) => row.ID.toString(),
    onSortingChange: setSorting,
    onColumnFiltersChange: setColumnFilters,
    onColumnVisibilityChange: setColumnVisibility,
    getCoreRowModel: getCoreRowModel(),
    getFilteredRowModel: getFilteredRowModel(),
    getSortedRowModel: getSortedRowModel(),
    getPaginationRowModel: getPaginationRowModel(),
    getFacetedRowModel: getFacetedRowModel(),
    getFacetedUniqueValues: getFacetedUniqueValues(),
  });

  function handleDragEnd(event: DragEndEvent) {
    const { active, over } = event;
    if (active && over && active.id !== over.id) {
      const oldIndex = dataIds.indexOf(active.id);
      const newIndex = dataIds.indexOf(over.id);
      setData((prevData) => arrayMove(prevData, oldIndex, newIndex));
    }
  }

  function exportToExcel() {
    const worksheet = XLSX.utils.json_to_sheet(data);
    console.log(data);
    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, "Data");
    if (chartMode === "weekly") {
      const fileName = `Xuatnhapkhau_nam-${year}_thang-${month}.xlsx`;
      XLSX.writeFile(workbook, fileName);
    } else {
      const fileName = `Xuatnhapkhau_nam-${year}.xlsx`;
      XLSX.writeFile(workbook, fileName);
    }
  }

  return (
    <div className="rounded-lg border overflow-hidden m-[24px]">
      <div className="flex justify-between items-center px-4 pb-2 m-[10px]">
        {/* Dropdown lọc Kiểu Đơn */}
        <div className="flex items-center gap-2">
          <span className="text-sm font-medium">Lọc Kiểu Đơn:</span>
          <Select
            onValueChange={(value) => {
              table
                .getColumn("KieuDon")
                ?.setFilterValue(value === "all" ? undefined : value);
            }}
            defaultValue="all"
          >
            <SelectTrigger className="w-[160px]">
              <SelectValue placeholder="Chọn kiểu đơn" />
            </SelectTrigger>
            <SelectContent>
              <SelectItem value="all">Tất cả</SelectItem>
              <SelectItem value="Xuất khẩu">Xuất khẩu</SelectItem>
              <SelectItem value="Nhập khẩu">Nhập khẩu</SelectItem>
            </SelectContent>
          </Select>
        </div>

        {/* Nút Export giữ nguyên bên phải */}
        <div>
          <Button onClick={exportToExcel} className="gap-2">
            <DownloadIcon className="h-4 w-4" />
            Xuất Excel
          </Button>
        </div>
      </div>

      {/* Bảng */}
      <DndContext
        collisionDetection={closestCenter}
        modifiers={[restrictToVerticalAxis]}
        onDragEnd={handleDragEnd}
        sensors={sensors}
        id={sortableId}
      >
        <Table>
          <TableHeader className="bg-muted sticky top-0 z-10">
            {table.getHeaderGroups().map((headerGroup) => (
              <TableRow key={headerGroup.id}>
                {headerGroup.headers.map((header) => (
                  <TableHead key={header.id}>
                    {header.isPlaceholder
                      ? null
                      : flexRender(
                          header.column.columnDef.header,
                          header.getContext()
                        )}
                  </TableHead>
                ))}
              </TableRow>
            ))}
          </TableHeader>
          <TableBody>
            <SortableContext
              items={dataIds}
              strategy={verticalListSortingStrategy}
            >
              {table.getRowModel().rows.map((row) => (
                <TableRow key={row.id}>
                  {row.getVisibleCells().map((cell) => (
                    <TableCell key={cell.id}>
                      {flexRender(
                        cell.column.columnDef.cell ??
                          ((info) => String(info.getValue())),
                        cell.getContext()
                      )}
                    </TableCell>
                  ))}
                </TableRow>
              ))}
            </SortableContext>
          </TableBody>
        </Table>
      </DndContext>

      {/* Pagination */}
      <div className="flex flex-col items-center justify-center space-y-2 p-4">
        <div className="text-sm text-muted-foreground">
          Trang {table.getState().pagination.pageIndex + 1} /{" "}
          {table.getPageCount()}
        </div>
        <div className="flex items-center justify-center space-x-2">
          <Button
            variant="outline"
            size="sm"
            onClick={() => table.previousPage()}
            disabled={!table.getCanPreviousPage()}
          >
            <ChevronLeft className="mr-2 h-4 w-4" />
            Trước
          </Button>
          <Button
            variant="outline"
            size="sm"
            onClick={() => table.nextPage()}
            disabled={!table.getCanNextPage()}
          >
            Sau
            <ChevronRight className="ml-2 h-4 w-4" />
          </Button>
        </div>
      </div>
    </div>
  );
}
