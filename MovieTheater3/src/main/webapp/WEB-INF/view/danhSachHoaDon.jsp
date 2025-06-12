<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH HÓA ĐƠN</p>
		</div>

		<table id="example" class="table table-striped text-center">
			<thead>
				<tr>
					<th scope="col">Mã hóa đơn</th>
					<th scope="col">Tên người bán</th>
					<th scope="col">Ngày</th>
					<th scope="col">Trạng thái</th>
					<th scope="col">Đã nhận hàng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listInvoice" items="${listInvoice}">

					<tr>
						<td>${listInvoice.invoiceId}</td>

						<td>${listInvoice.sellerId}</td>
						<td>${listInvoice.date}</td>
						<td>${listInvoice.status}</td>

						<td align="center"><a
							href="<c:url value ='/Ticket_Selling/updateInvoice/${listInvoice.invoiceId}'/>"><button
									onclick="return confirm('Cập nhật trạng thái đơn hàng!!')">
									<i class="fa fa-check" aria-hidden="true"></i>
								</button></a></td>


					</tr>

				</c:forEach>
			</tbody>
		</table>
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