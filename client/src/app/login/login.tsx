import { useState } from "react";
import styles from "./login.module.css";
import { login } from "@/api";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

export default function Login() {
  const [showPassword, setShowPassword] = useState(false);
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });
  const [errorRes, setErrorRes] = useState({
    email: "",
    password: "",
  });

  const navigate = useNavigate();

  const togglePassword = () => setShowPassword(!showPassword);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
    // Reset lỗi khi gõ lại
    setErrorRes({ email: "", password: "" });
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const result = await login(formData.username, formData.password);
      localStorage.setItem("ten", result.Ten);
      localStorage.setItem("email", result.Email);
      localStorage.setItem("chucvu", result.ChucVu);
      if (result.ChucVu === "Quản trị viên") {
        toast.success("Đăng nhập thành công!");
        setTimeout(() => {
          navigate("/admin/thongke");
        }, 500);
      }
    } catch (error) {
      const message = (error as Error).message;
      if (message.includes("Mật khẩu")) {
        setErrorRes({ email: "", password: message });
      } else if (
        message.includes("không tìm thấy") ||
        message.includes("email")
      ) {
        setErrorRes({ email: message, password: "" });
      } else {
        // fallback error
        setErrorRes({ email: "", password: "Lỗi không xác định!" });
      }
    }
  };

  return (
    <div className={styles["login-wrapper"]}>
      <div className={styles.background} />
      <div className={styles.fog} />

      <div className={styles["login-container"]}>
        <div className={styles.logo}>
          <span className={styles["logo-text"]}>Đăng nhập</span>
          <div className={styles["logo-icon"]}>TS</div>
        </div>

        <form onSubmit={handleSubmit}>
          <div className={styles["form-group"]}>
            <input
              type="email"
              name="username"
              value={formData.username}
              onChange={handleChange}
              className={styles["form-input"]}
              placeholder="Email"
              required
            />
            <span className={styles["user-icon"]}>👤</span>
            {errorRes.email && (
              <div className={styles["error-message"]}>{errorRes.email}</div>
            )}
          </div>

          <div
            className={`${styles["form-group"]} ${styles["password-group"]}`}
          >
            <input
              type={showPassword ? "text" : "password"}
              name="password"
              value={formData.password}
              onChange={handleChange}
              className={styles["form-input"]}
              placeholder="Password"
              required
            />
            <button
              type="button"
              className={styles["password-toggle"]}
              onClick={togglePassword}
            >
              👁️
            </button>
            {errorRes.password && (
              <div className={styles["error-message"]}>{errorRes.password}</div>
            )}
          </div>

          <button type="submit" className={styles["login-btn"]}>
            Đăng nhập
          </button>
        </form>
      </div>
    </div>
  );
}
