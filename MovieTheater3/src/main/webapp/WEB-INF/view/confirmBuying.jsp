<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<style>
div.payment div.checkout {
	float: right;
	width: 100px;
}
</style>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">Thanh toán</p>
		</div>
		<table id="example" class="table table-striped text-center">
			<thead>
				<tr>
					<th scope="col">Ảnh</th>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Số lượng</th>
					<th scope="col">Đơn giá</th>
				</tr>
			</thead>
			<tbody>
			<c:set var="tong" value="${0}" />
				<c:forEach var="listGioHangDetail" items="${listGioHangDetail}">
					<c:forEach var="listProduct" items="${listProduct}">
						
						<c:if
							test="${listGioHangDetail.gioHangID.productID eq listProduct.productID}">

							<tr>
								<td><img width="45" height="45"
									src="<c:url value='/resources/img/${listProduct.smallImage}'/>"
									class="img-fluid"></td>
								<td>${listProduct.productName}</td>
								<td>${listGioHangDetail.quantity}</td>
								<td>${listProduct.price}</td>
								<c:set var="tong"
									value="${tong + listProduct.price * listGioHangDetail.quantity}" />
							</tr>
						</c:if>

					</c:forEach>
				</c:forEach>

			</tbody>
		</table>
		<label style="width: 750px; margin-top:15px;">Tổng thanh toán:</label>
		<label style="font-size: 25px;color: red;">${tong}đ</label>
		<div class="row" style="height: 20px"></div>
		<div class="checkout">
			<div class="payment">
				<label style="width: 750px;">Phương thức thanh toán:</label> <select
					name="checkout" id="checkout">
					<option value="cod">Thanh toán khi nhận hàng</option>
					<option value="online">Thanh toán Online</option>
				</select>
			</div>
			<div style="margin-top: 15px;" class="payment">
				<button style="float: right;" type="button" class="btn btn-primary"
					onclick="location.href='<c:url value ='/Ticket_Selling/confirmed'/>';">Xác
					nhận</button>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>