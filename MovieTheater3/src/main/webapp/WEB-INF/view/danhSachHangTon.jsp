<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH SẢN PHẨM</p>
		</div>
		<table id="example" class="table table-striped text-center">
			<thead>
				<tr>
					<th scope="col">Mã sản phẩm</th>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Số lượng còn lại</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listProduct" items="${listProduct}">
					<tr>
						<td>${listProduct.productID}</td>
						<td>${listProduct.productName}</td>
						<td>${listProduct.quantity}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row" style="height: 20px"></div>
		<button style="float: right;" type="button" class="btn btn-primary"
			onclick="location.href='<c:url value ='/Ticket_Selling/themMoiSanPham'/>';">Trang chủ</button>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>