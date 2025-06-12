<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/headerAdmin.jsp"%>
<div class="col-md-8" id="content">
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['error']}">
			<label
				style="font-size: 28px; color: red; font-family: arial; text-align: center; width: 100%;">Không tồn tại dữ liệu tương ứng!</label>
			</c:if>
		</div>
	<c:if test="${param['messageAdmin']}">
			<script type="text/javascript">
				$(document).ready(function() {
					alert('Thêm Admin thành công!!');
				});
			</script>
		</c:if>


<%@include file="include/footerAdmin.jsp"%>
</div>
