<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">THỐNG KÊ VÉ ĐÃ BÁN</p>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<form:form method="GET" modelAttribute="movies" align="center"
			action="${contextPath}/thongkeSLV">
			<select id="slmovie" name="movieID"
				onchange="location=options[selectedIndex].value;">
				<c:forEach var="movie" items="${listMovie}">
					<option hidden>-- Chọn một bộ phim --</option>
					<option value="thongkeSLV?movieID=${movie.movieID}">${movie.movieNameVN }</option>
				</c:forEach>
			</select>
		</form:form>
		<div style="margin-top: 20px">
			<table id="example" class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Mã phim</th>
						<th scope="col">Tên phim</th>
						<th scope="col">Loại vé</th>
						<th scope="col">Số lượng vé</th>
						<th scope="col">Ngày</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="thongke" items="${listThongke}">
						<tr>
							<td>${thongke[0]}</td>
							<td>${thongke[1]}</td>
							<td>${thongke[2]}</td>
							<td>${thongke[3]}</td>
							<td>${thongke[4]}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div id="doanhthu" style="margin-top: 5%;">
				<div class="form-group">
				<label for="my-input">Tổng tiền vé loại 1: </label>
				<label for="my-input">${tienveloai1 } Đ</label>
			</div>
			<div class="form-group">
				<label for="my-input">Tổng tiền vé loại 2: </label>
				<label for="my-input">${tienveloai2 } Đ</label>
			</div>
			<div class="form-group">
				<label for="my-input">Tổng tiền vé: </label>
				<label for="my-input">${tongtien } Đ</label>
			</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
//		$('#slmovie').change(function () { 
//	        $('#doanhthu').show();
//	    });
		
	});
</script>
<%@include file="include/footer.jsp"%>