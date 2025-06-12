<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH SẢN PHẨM</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới sản phẩm thành công!</p>
			</c:if>
			<c:if test="${param['update']}">
				<p style="color: green;">Cập nhật sản phẩm thành công!</p>
			</c:if>
			<c:if test="${param['delete']}">
				<p style="color: red;">Sản phẩm đã được xóa!</p>
			</c:if>
		</div>
		<table id="example" class="table table-striped text-center">
			<thead>
				<tr>
					<th scope="col">Mã sản phẩm</th>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Cập nhật</th>
					<th scope="col">Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listProduct" items="${listProduct}">
					<tr>
						<td>${listProduct.productID}</td>
						<td>${listProduct.productName}</td>
						<td align="center"><a
							href="<c:url value ='/Ticket_Selling/updateSanPham/${listProduct.productID}'/>"><button>
									<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
								</button></a></td>
						<td align="center"><a
							href="<c:url value ='/Ticket_Selling/deleteSanPham/${listProduct.productID}'/>"><button
									onclick="return confirm('Xác nhận xóa sản phẩm này?')">
									<i class="fa fa-trash-o" aria-hidden="true"></i>
								</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row" style="height: 20px"></div>
		<button style="float: right;" type="button" class="btn btn-primary"
			onclick="location.href='<c:url value ='/Ticket_Selling/themMoiSanPham'/>';">Thêm
			mới</button>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>