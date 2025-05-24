import "./App.css";

import { BrowserRouter, Routes, Route } from "react-router-dom";
import { SidebarProvider } from "@/components/ui/sidebar";
import Dashboard from "./app/dashboard/dashboard";
import Thongke from "@/app/dashboard/thongke";

function App() {
  return (
    <BrowserRouter>
      <SidebarProvider>
        <Routes>
          <Route path="/admin" element={<Dashboard />}>
            <Route path="thongke" element={<Thongke />} />
          </Route>
        </Routes>
      </SidebarProvider>
    </BrowserRouter>
  );
}

export default App;
