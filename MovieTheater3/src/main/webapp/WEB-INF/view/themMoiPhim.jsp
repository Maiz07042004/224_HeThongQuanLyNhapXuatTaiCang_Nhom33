<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<!-- <body class="box-body"> -->
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">THÊM MỚI PHIM</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['exits']}">
				<p style="color: red">Mã phim này đã tồn tại trong hệ thống!</p>
			</c:if>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<div style="margin-top: 20px">
			<form:form action="${contextPath}/Ticket_Selling/thucHienThemMoi"
				method="GET" modelAttribute="movie">
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập mã phim:</label>
					<div class="col-sm-8">
						<form:input path="movieID" name="movieID" id="movieID" type="text"
							class="form-control" placeholder="MV00001..."></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập tên phim(VN):</label>
					<div class="col-sm-8">
						<form:input path="movieNameVN" name="movieNameVN" id="movieNameVN"
							type="text" class="form-control"
							placeholder="Nhập tên phim bằng tiếng Việt"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập tên phim(ENG):</label>
					<div class="col-sm-8">
						<form:input path="movieNameEnglish" name="movieNameEnglish"
							id="movieNameEnglish" type="text" class="form-control"
							placeholder="Nhập tên phim bằng tiếng Anh"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập tên diễn viên
						chính:</label>
					<div class="col-sm-8">
						<form:input path="actor" name="actor" id="actor" type="text"
							class="form-control" placeholder="Nhập tên diễn viên chính"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập tên đạo diễn:</label>
					<div class="col-sm-8">
						<form:input path="director" name="director" id="director"
							type="text" class="form-control" placeholder="Nhập tên đạo diễn"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập tên công ty sản
						xuẩt:</label>
					<div class="col-sm-8">
						<form:input path="movieProductionCompany"
							name="movieProductionCompany" id="movieProductionCompany"
							type="text" class="form-control"
							placeholder="Nhập tên công ty sản xuẩt"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập version phim:</label>
					<div class="col-sm-8">
						<form:input path="version" name="version" id="version"
							type="number" class="form-control"
							placeholder="Nhập version phim"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập thời lượng
						phim:</label>
					<div class="col-sm-8">
						<form:input path="duration" name="duration" id="duration"
							type="number" class="form-control"
							placeholder="Nhập thời lượng phim"></form:input>
					</div>
				</div>
				<%-- <div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập phòng chiếu:</label>
					<div class="col-sm-8">
						<form:select path="cinemaRoom.cinemaRoomID" items="${listRoom}"
							class="form-control">
						</form:select>
					</div>
				</div> --%>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập ngày khởi
						chiếu:</label>
					<div class="col-sm-8">
						<form:input path="fromDate" name="fromDate" id="fromDate"
							type="date" class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập ngày kết thúc:</label>
					<div class="col-sm-8">
						<form:input path="toDate" name="toDate" id="toDate" type="date"
							class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Mô tả nội dung phim:</label>
					<div class="col-sm-8">
						<form:textarea path="content" name="content" id="content"
							style="height: 100px" class="form-control"
							placeholder="Mô tả nội dung phim"></form:textarea>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Chọn hình ảnh minh
						họa:</label>
					<div class="col-sm-8">
						<form:input path="smallImage" name="smallImage" id="smallImage"
							type="file" class="form-control"></form:input>
					</div>
				</div>
				<div class="row" style="height: 20px"></div>
				<form:button style="float: right; width: 150px;" type="submit"
					class="btn btn-primary" onclick="myFunction()">
					<i class="fa fa-check" aria-hidden="true"></i>&ensp;Thêm mới
			</form:button>
			</form:form>
			<button style="float: right; margin-right: 10px; width: 150px;"
				class="btn btn-primary"
				onclick="location.href='<c:url value ='/Ticket_Selling/movieList'/>';">
				<i class="fa fa-arrow-left" aria-hidden="true"></i>&ensp;Quay lại
			</button>
		</div>
	</div>
</div>
<script>
		function myFunction() {
			var movieID = document.getElementById("movieID").value;
			if(movieID == ""){
				alert("Vui lòng nhập mã phim!.");
				event.preventDefault();
				event.stopPropagation();
			}
		}
</script>
<%@include file="include/footer.jsp"%>