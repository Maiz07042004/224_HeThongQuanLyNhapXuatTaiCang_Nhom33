import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "@/app/login/login";
import DashboardLayout from "./app/dashboard/DashboardLayout";
import Thongke from "./app/dashboard/thongke";
import { ToastContainer } from "react-toastify";
import Home from "./app/home/home";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/admin" element={<DashboardLayout />}>
            <Route path="thongke" element={<Thongke />} />
          </Route>
        </Routes>
      </BrowserRouter>
      <ToastContainer position="top-right" autoClose={3000} />
    </>
  );
}

export default App;
