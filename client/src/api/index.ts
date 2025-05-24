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
