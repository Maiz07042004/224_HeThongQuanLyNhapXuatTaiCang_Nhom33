<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/bootstrap.min.css'/>">
<link href="<c:url value='/resources/library/jquery-3.4.1.min.js'/>">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.show {
	display: block;
}

ul.nav li {
	font-weight: bold;
}

.mt-2 {
	display: none;
}

.mt-2 li {
	font-weight: normal !important;
}
</style>
<div class="col-12">
	<div class="row" id="row-content">
		<div class="col-md-3" id="menuleft">
			<div class="col-sm-12" id="menu">
				<nav class="nav-sidebar"
					style="border-right: 0; border-right: 1px solid #ddd;">
					<ul class="nav row">
						<li class="col-sm-12" style="margin-top: 20px"><a
							href="<c:url value ='/Ticket_Selling/'/>"><i
								class="fa fa-home" aria-hidden="true"></i>&ensp;Trang Chủ</a></li>
						<li class="col-sm-12" style="margin-top: 20px"><a
							href="<c:url value ='/Ticket_Selling/updateProfile'/>"><i
								class="fa fa-address-book-o" aria-hidden="true"></i>&ensp;Sửa hồ
								sơ</a></li>
						<c:if test="${account.getRoles().roleID eq 1}">
							<li class="col-sm-12" style="margin-top: 20px"><a
								href="<c:url value ='/Ticket_Selling/duyetSeller'/>"><i
									class="fa fa-edit" aria-hidden="true"></i>&ensp;Duyệt Seller
									đăng ký mới</a></li>
							<li class="col-sm-12" style="margin-top: 20px"><a
								href="<c:url value ='/Ticket_Selling/dsSeller'/>"><i
									class="	fa fa-address-card-o" aria-hidden="true"></i>&ensp;Quản
									lí danh sách Seller trong tháng</a></li>
							<li class="col-sm-12" style="margin-top: 20px"><a
								href="<c:url value ='/Ticket_Selling/themAdmin'/>"><i
									class="fa fa-address-card-o" aria-hidden="true"></i>&ensp;Thêm
									mới Admin</a></li>
							<li class="col-sm-12" style="margin-top: 20px"><a
								href="<c:url value ='/Ticket_Selling/listDanhMuc'/>"><i
									class="fa fa-bars" aria-hidden="true"></i>&ensp;Quản lý danh
									sách danh mục</a></li>

						</c:if>
						<c:if test="${account.getRoles().roleID eq 3}">
							<li class="col-sm-12" style="margin-top: 20px"><a
								href="<c:url value ='/Ticket_Selling/listSanPham'/>"><i
									class="fa fa-bars" aria-hidden="true"></i>&ensp;Quản lý danh
									sách sản phẩm</a></li>
							<li class="col-sm-12" style="margin-top: 20px"><a
								href="<c:url value ='/Ticket_Selling/listHangTon'/>"><i
									class="fa fa-database" aria-hidden="true"></i>&ensp;Thống kê
									hàng tồn</a></li>
							<li class="col-sm-12" style="margin-top: 20px"><a
								href="<c:url value ='/Ticket_Selling/quanLyDonHang'/>"><i
									class="fa fa-database" aria-hidden="true"></i>&ensp;Quản lí
									danh sách đơn hàng</a></li>
							<li class="col-sm-12" style="margin-top: 20px"><a
								href="<c:url value ='/Ticket_Selling/thongKeDoanhThu'/>"><i
									class="fa fa-bar-chart" aria-hidden="true"></i>&ensp;Thống kê
									doanh thu trong tháng</a></li>
							<li class="col-sm-12" style="margin-top: 20px"><a
								href="<c:url value ='/Ticket_Selling/dsBuyer'/>"><i
									class="	fa fa-address-card-o" aria-hidden="true"></i>&ensp;Danh sách khách hàng trong tháng</a></li>

						</c:if>
							<c:if test="${account.getRoles().roleID eq 2}">
								<li class="col-sm-12" style="margin-top: 20px"><a
							href="<c:url value ='/Ticket_Selling/showInvoice'/>"><i
								class="fa fa-credit-card" aria-hidden="true"></i>&ensp;Danh sách
								hóa đơn</a></li>
						<li class="col-sm-12" style="margin-top: 20px"><a
							href="<c:url value ='/Ticket_Selling/thongKeTongTien'/>"><i
								class="fa fa-bar-chart" aria-hidden="true"></i>&ensp;Thống kê
								tổng tiền trong tháng</a></li>
							</c:if>
					
						<%-- <c:if test="${account.getRoles().roleID eq 1}">		
						<li  class="col-sm-12" style = "margin-top: 20px"><a href="<c:url value ='/Ticket_Selling/movieList'/>"><i class="fa fa-film" aria-hidden="true"></i>&ensp;Quản lý danh sách phim</a></li>					
						<li  class="col-sm-12" style = "margin-top: 20px"><a href="<c:url value ='/Ticket_Selling/listPhongChieu'/>"><i class="fa fa-desktop" aria-hidden="true"></i>&ensp;Quản lý danh sách phòng chiếu</a></li>
					</c:if>
					<li  class="col-sm-12" style = "margin-top: 20px"><a href="<c:url value ='/Ticket_Selling/listGheNgoi'/>"><i class="fa fa-ticket" aria-hidden="true"></i>&ensp;Quản lý danh sách ghế ngồi</a></li>
					<c:if test="${account.getRoles().roleID eq 1}">		
					
					<li  class="col-sm-12"style = "margin-top: 20px"><a href="<c:url value ='/Ticket_Selling/listGioChieu'/>"><i class="fa fa-clock-o" aria-hidden="true"></i>&ensp;Quản lý danh sách giờ chiếu</a></li>
					<li  class="col-sm-12"id="show" style = "margin-top: 20px"><a href="#"><i class="fa fa-calendar" aria-hidden="true"></i>&ensp;Quản lý danh sách lịch chiếu</a>
						<ul class="mt-2">
							<li style = "margin: 5px 0 0 30px"><a href="<c:url value ='/Ticket_Selling/listPhim_Ngay'/>">Quản lý danh sách phim - ngày chiếu</a></li>
							<li style = "margin: 5px 0 0 30px"><a href="<c:url value ='/Ticket_Selling/listPhim_Gio'/>">Quản lý danh sách phim - giờ chiếu</a></li>
							<li style = "margin: 5px 0 0 30px"><a href="<c:url value ='/Ticket_Selling/listLichChieu'/>">Quản lý thông tin phòng chiếu</a></li>
						</ul>
					</li>
					<li  class="col-sm-12"style = "margin-top: 20px"><a href="<c:url value ='/Ticket_Selling/listTicket'/>"><i class="fa fa-ticket" aria-hidden="true"></i>&ensp;Quản lý danh sách vé</a></li>
					</c:if>
					<li  class="col-sm-12"style = "margin-top: 20px"><a href="<c:url value ='/Ticket_Selling/listKhachHang'/>"><i class="fa fa-users" aria-hidden="true"></i>&ensp;Quản lý danh sách khách hàng</a></li>
					<c:if test="${account.getRoles().roleID eq 1}">		
					<li  class="col-sm-12"style = "margin-top: 20px"><a href="<c:url value ='/Ticket_Selling/listNhanVien'/>"><i class="fa fa-users" aria-hidden="true"></i>&ensp;Quản lý danh sách nhân viên</a></li>
					</c:if>
					<li class="col-sm-12" style = "margin-top: 20px"><a href="<c:url value ='/Ticket_Selling/Show_Time'/>"><i class="fa fa-indent" aria-hidden="true"></i>&ensp;Mua vé</a></li>
					<li class="col-sm-12" style = "margin-top: 20px"><a href="<c:url value ='/thongke'/>"><i class="fa fa-area-chart" aria-hidden="true"></i>&ensp;Thống kê</a></li> --%>
					</ul>

				</nav>
			</div>

			<script>
				$("#show").click(function() {
					$("#show .mt-2").toggle(".show");
				})
			</script>
		</div>