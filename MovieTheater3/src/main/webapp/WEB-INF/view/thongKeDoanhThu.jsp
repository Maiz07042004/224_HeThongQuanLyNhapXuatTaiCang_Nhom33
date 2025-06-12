<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH ĐƠN HÀNG</p>
		</div>

		<table id="example" class="table table-striped text-center">
			<thead>
				<tr>
					<th scope="col">Mã hóa đơn</th>
					<th scope="col">Người mua</th>
					<th scope="col">Ngày</th>
					<th scope="col">Trạng thái</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listInvoice" items="${listInvoice}">

					<tr>
						<td>${listInvoice.invoiceId}</td>
						<td>${listInvoice.buyerId}</td>
						<td>${listInvoice.date}</td>
						<td>${listInvoice.status}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<div>
			<c:set var="tong" value="${0}" />
			<c:forEach var="listInvoice" items="${listInvoice}">
				<c:forEach var="listInvoiceDetail" items="${listInvoiceDetail}">
					<c:forEach var="listProduct" items="${listProduct}">
						<c:if
							test="${listInvoiceDetail.id.invoiceID eq listInvoice.invoiceId}">
							<c:if
								test="${listInvoiceDetail.id.productID eq listProduct.productID}">
								<c:set var="tong"
								value="${tong + listProduct.price * listInvoiceDetail.soLuongMua}" />
							</c:if>
							
						</c:if>
					</c:forEach>
				</c:forEach>
			</c:forEach>
			<label style="width: 750px; margin-top: 15px;">Tổng doanh thu
				tháng này:</label> <label style="font-size: 25px; color: red;">${tong}đ</label>
		</div>
		<div class="row" style="height: 20px"></div>
		<button style="float: right;" type="button" class="btn btn-primary"
			onclick="location.href='<c:url value ='/Ticket_Selling/'/>';">Trang
			chủ</button>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>