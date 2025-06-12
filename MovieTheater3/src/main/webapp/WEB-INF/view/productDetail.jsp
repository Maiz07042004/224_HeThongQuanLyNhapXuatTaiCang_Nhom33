<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<style>
div.payment div.checkout {
	float: right;
}
</style>
<div class="col-md-8" id="content">
	<!-- <body style="background-color: #eff0f3"> -->
	<div>
		<div>
			<p class="text-show-time">THÔNG TIN CHI TIẾT SẢN PHẨM</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['confirmBuying']}">
				<p style="color: green;">Đơn hàng của bạn đã được xác nhận!</p>
			</c:if>
			<div>
				<div>
					<div class="row" style="display: none;">
						<div class="col-sm-5">
							<label class="label-attribute">Mã Sản Phẩm:</label>
						</div>
						<div class="col-sm-7">
							<input type="text" id="productID" name="productID"
								value="${product.productID}"></input>
						</div>
					</div>	
				</div>
				<div class="box-movie row">
					<div class="box-img-movie col-sm-2">
						<img src="<c:url value='/resources/img/${product.smallImage}'/>"
							class="img-fluid">
					</div>
					<div class="col-sm-10">
						<label class="text-movie-name">${product.productName}</label>
						<hr>
						<div class="row">
							<div class="col-sm-5">
								<label class="label-attribute">Giá</label>
							</div>
							<div class="col-sm-7">
								<label class="label-value" style="color: red;">${product.price}</label>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-5">
								<label class="label-attribute">Kho:</label>
							</div>
							<div class="col-sm-7">
								<label class="label-value">${product.quantity}</label>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-5">
								<label class="label-attribute">Số lượng:</label>
							</div>
							<div class="col-sm-7">
								<input  style="text-align:center; width:90px;" type="number" id="soLuong" name="soLuong" value="1">
							</div>
						</div>
					</div>
					<div class="payment" style="margin-left:720px;margin-top:30px; ">
						<div class="checkout" style="margin-left:10px;">
							<button class="btn btn-primary" type="button"
								onclick="Buying()" class=btnotp> Đặt mua</button>
						</div>
						<div class="checkout">
							<button class="btn btn-primary" type="button"
								onclick="addToCart()" class=btnotp>Thêm vào giỏ hàng</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div style="margin-top:30px;">
	<a class="btn btn-primary" style="float: right;"
		href="<c:url value ='/Ticket_Selling/'/>"><i class="fa fa-home"
		aria-hidden="true"></i>&nbsp;&nbsp; Về trang chủ</a>
		</div>
</div>
<script type="text/javascript">
	function addToCart() {
		var soLuong = document.getElementById("soLuong").value;
		var productID = document.getElementById("productID").value;
		//Change if change localhost port
		var url = "http://localhost:8012/OnlineShopping/Ticket_Selling/addToCart/"
				+ soLuong + "/" + productID;
		window.location.href = url;
	}
</script>
<script type="text/javascript">
	function Buying() {
		var soLuong = document.getElementById("soLuong").value;
		var productID = document.getElementById("productID").value;
		//Change if change localhost port
		var url = "http://localhost:8012/OnlineShopping/Ticket_Selling/Buying/"
				+ productID + "/" + soLuong;
		window.location.href = url;
	}
</script>
<%@include file="include/footer.jsp"%>
