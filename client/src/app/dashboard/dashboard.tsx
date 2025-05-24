import { Outlet } from "react-router-dom";
import { AppSidebar } from "../../components/app-sidebar";
import { SidebarInset } from "@/components/ui/sidebar";

export default function Dashboard() {
  return (
    <>
      {" "}
      <AppSidebar variant="inset" />
      <SidebarInset>
        <Outlet />
      </SidebarInset>
    </>
  );
}
