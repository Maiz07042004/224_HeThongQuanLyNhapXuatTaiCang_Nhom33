import { Search, Mic } from "lucide-react";

export default function Home() {
  return (
    <div className="relative min-h-screen font-sans flex flex-col overflow-hidden">
      {/* Video Background */}
      <video
        className="absolute top-0 left-0 w-full h-full object-cover z-0"
        src="https://danangport.com/wp-content/uploads/2024/12/1203-1.mp4"
        autoPlay
        muted
        loop
        playsInline
      />

      {/* Overlay */}
      <div className="absolute top-0 left-0 w-full h-full bg-black/30 z-10" />

      {/* Page Content */}
      <div className="relative z-20 flex flex-col min-h-screen">
        {/* Header */}
        <header className="bg-white bg-opacity-80 backdrop-blur-sm shadow-md sticky top-0 z-30">
          <div className="max-w-7xl mx-auto px-6 py-4 flex items-center justify-between">
            {/* Logo + Tiêu đề */}
            <div className="flex items-center space-x-4">
              <img
                src="https://danangport.com/wp-content/uploads/2020/10/LOGO-2020-update-2.svg"
                alt="main-logo"
                className="w-20 h-20 object-contain"
              />
              <div>
                <h1 className="text-xl font-semibold text-gray-700">
                  CẢNG ĐÀ NẴNG
                </h1>
                <h2 className="text-3xl font-bold text-blue-800 mt-1">
                  CẢNG TIÊN SA
                </h2>
              </div>
            </div>

            {/* Search */}
            <div className="w-full max-w-md ml-auto">
              <div className="relative">
                <input
                  type="text"
                  placeholder="Tìm kiếm"
                  className="w-full px-4 py-3 pl-12 pr-12 border border-blue-300 rounded-full focus:outline-none focus:ring-2 focus:ring-blue-400 shadow-sm transition duration-300"
                />
                <Search className="absolute left-4 top-1/2 transform -translate-y-1/2 text-blue-500 w-5 h-5" />
                <Mic className="absolute right-4 top-1/2 transform -translate-y-1/2 text-blue-500 w-5 h-5" />
              </div>
            </div>
          </div>

          {/* Navigation */}
          <nav className="border-t border-gray-200">
            <div className="max-w-7xl mx-auto px-6">
              <div className="flex justify-center space-x-10 py-4 text-1xl font-medium text-gray-700">
                {[
                  "Trang chủ",
                  "Giới thiệu",
                  "Xuất khẩu",
                  "Nhập khẩu",
                  "Đăng nhập",
                ].map((item, index) => (
                  <a
                    key={index}
                    href={item === "Đăng nhập" ? "/login" : `/`}
                    className="hover:text-blue-600 hover:underline transition"
                  >
                    {item}
                  </a>
                ))}
              </div>
            </div>
          </nav>
        </header>

        {/* Main Content */}
        <main className="flex-1 flex flex-col items-center justify-center px-6 py-20 text-white text-center">
          <h2 className="text-5xl font-bold mb-6 drop-shadow-lg">
            CẢNG ĐÀ NẴNG
          </h2>
          <p className="text-xl leading-relaxed drop-shadow max-w-3xl">
            Được thành lập từ năm 1901, trải qua những thăng trầm của lịch sử,
            Cảng Đà Nẵng luôn đồng hành cùng sự phát triển của thành phố và khu
            vực miền Trung.
          </p>
        </main>

        {/* Footer */}
        <footer className="bg-white bg-opacity-90 backdrop-blur-md border-t border-gray-200 text-center text-gray-700 text-sm py-6">
          <div className="max-w-7xl mx-auto grid grid-cols-2 md:grid-cols-4 gap-6">
            {[
              "Liên hệ với chúng tôi",
              "Về chúng tôi",
              "Thông tin dịch vụ",
              "Thông tin thủ tục hàng hải",
            ].map((title, idx) => (
              <div key={idx}>
                <h3 className="font-semibold text-gray-800 text-base mb-1">
                  {title}
                </h3>
              </div>
            ))}
          </div>
        </footer>
      </div>
    </div>
  );
}
