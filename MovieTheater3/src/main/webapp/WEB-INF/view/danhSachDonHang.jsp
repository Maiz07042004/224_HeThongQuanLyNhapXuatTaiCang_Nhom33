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
					<th scope="col">Đã hoàn thành</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listInvoice" items="${listInvoice}">

					<tr>
						<td>${listInvoice.invoiceId}</td>

						<td>${listInvoice.buyerId}</td>
						<td>${listInvoice.date}</td>
						<td>${listInvoice.status}</td>
						<c:if test="${listInvoice.status ne 'Ðã hoàn thành'}">
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/updateInvoiceSeller/${listInvoice.invoiceId}'/>"><button
										onclick="return confirm('Cập nhật trạng thái đơn hàng!!')">
										<i class="fa fa-check" aria-hidden="true"></i>
									</button></a></td>
						</c:if>
						<c:if test="${listInvoice.status eq 'Ðã hoàn thành'}">
							<td align="center">
								<button>
									<i class="fa fa-check-circle-o"></i>
								</button>
							</td>
						</c:if>
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