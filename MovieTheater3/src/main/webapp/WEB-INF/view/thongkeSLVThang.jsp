<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">THỐNG KÊ VÉ ĐÃ BÁN THEO THÁNG</p>
		</div>
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<form:form method="GET" modelAttribute="movies" align="center"
				action="${contextPath}/thongkeSLVThang">
				<select name="movieID" onchange="location=options[selectedIndex].value;">
					<c:forEach var="movie" items="${listMovie}" >
						<option hidden>-- Chọn một bộ phim -- </option>
						<option value="thongkeSLVThang?movieID=${movie.movieID}">${movie.movieNameVN }</option>
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
					<c:forEach var="thongke" items="${listThongkeSLVDTO}">
						<tr>
							<td>${thongke.getMovieID()}</td>
							<td>${thongke.getMovieName()}</td>
							<td>${thongke.getSlV()}</td>
							<td>${thongke.getMonth()}</td>
							<td>${thongke.getDoanhThu()}</td>
						
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>