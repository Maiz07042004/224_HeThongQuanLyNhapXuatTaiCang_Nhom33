<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH VÉ</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới vé thành công!</p>
			</c:if>
			<c:if test="${param['update']}">
				<p style="color: green;">Cập nhật vé thành công!</p>
			</c:if>
			<c:if test="${param['delete']}">
				<p style="color: red;">vé đã được xóa!</p>
			</c:if>
		</div>
		<div style="margin-top: 20px">
			<table id="example" class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Loại vé</th>
						<th scope="col">Giá vé</th>
						<th scope="col">Cập nhật</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listTicket" items="${listTicket}">
						<tr>
							<td>${listTicket.ticketType}</td>
							<td>${listTicket.price}</td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/updateVe/${listTicket.ticketID}'/>"><button>
										<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
									</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row" style="height: 20px"></div>
			<button style="float: right;" type="button" class="btn btn-primary" 
			onclick="location.href='<c:url value ='/themmoive'/>';">Thêm
				mới</button>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>