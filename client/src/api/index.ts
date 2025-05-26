export const getDataThongKeTheoNam = async (nam: number) => {
  const response = await fetch(
    `http://localhost:3000/v1/donhang/thongke/${nam}`
  );
  if (!response.ok) {
    throw new Error("Failed to fetch data");
  }
  return response.json();
};
export const getDataThongKeTheoThang = async (nam: number, thang: number) => {
  const response = await fetch(
    `http://localhost:3000/v1/donhang/thongke/${nam}/${thang}`
  );
  if (!response.ok) {
    throw new Error("Failed to fetch data");
  }
  return response.json();
};
export const getDataTableTheoNam = async (nam: number) => {
  const res = await fetch(`http://localhost:3000/v1/donhang/list?nam=${nam}`);
  if (!res.ok) {
    throw new Error("Failed to fetch data");
  }
  return res.json();
};
export const getDataTableTheoThang = async (nam: number, thang: number) => {
  const res = await fetch(
    `http://localhost:3000/v1/donhang/list?nam=${nam}&&thang=${thang}`
  );
  if (!res.ok) {
    throw new Error("Failed to fetch data");
  }
  return res.json();
};

export const login = async (email: string, password: string) => {
  try {
    const res = await fetch("http://localhost:3000/v1/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email, password }),
    });

    const data = await res.json();

    if (!res.ok) {
      // Lỗi backend trả về -> throw lên với message
      throw new Error(data.error || "Đăng nhập thất bại");
    }

    return data;
  } catch (error) {
    console.error("Lỗi khi đăng nhập:", (error as Error).message);
    throw error;
  }
};

export const getDataContainerStatistics = async () => {
  const response = await fetch(
    `http://localhost:3000/v1/container/thongke_soluongcontainer`
  );
  if (!response.ok) {
    throw new Error("Failed to fetch data");
  }
  return response.json();
};

export const getDataShippingCompany = async (nam: number) => {
  const res = await fetch(
    `http://localhost:3000/v1/donhang/thongke-hangtau/${nam}`
  );
  if (!res.ok) {
    throw new Error("Failed to fetch data");
  }
  return res.json();
};
export const getDataPortStats = async (nam: number) => {
  const res = await fetch(
    `http://localhost:3000/v1/donhang/thongke-cangden/${nam}`
  );
  if (!res.ok) {
    throw new Error("Failed to fetch data");
  }
  return res.json();
};
