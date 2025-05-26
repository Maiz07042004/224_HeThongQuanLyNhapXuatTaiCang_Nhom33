import { SidebarProvider } from "@/components/ui/sidebar";
import { Outlet } from "react-router-dom";

import { AppSidebar } from "../../components/app-sidebar";
import { SidebarInset } from "@/components/ui/sidebar";

export default function DashboardLayout() {
  const chucvu = localStorage.getItem("chucvu");
  return chucvu === "Quản trị viên" ? (
    <SidebarProvider>
      <AppSidebar variant="inset" />
      <SidebarInset>
        <Outlet />
      </SidebarInset>
    </SidebarProvider>
  ) : (
    <div className="flex flex-col h-screen">
      <h1 className="text-center">Bạn không có quyền truy cập trang này</h1>
    </div>
  );
}
