<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="<c:url value='/resources/img/ticket.png'/>">
<title>MTS</title>
<link rel="shortcut icon"
	href="<c:url value='/resources/css/login.css'/>">
<script
	src="<c:url value='/resources/library/jquery-3.3.1.slim.min.js' />"></script>
<script
	src="<c:url value='/resources/library/datatablejs/media/js/jquery.dataTables.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/customReset.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/confirmBookingTicket.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/login.css'/>">
<script src="<c:url value='/resources/library/font-awesome.min.js'/>"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- web-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700"
	rel="stylesheet">
</head>

<body>
	<!--header-->
	<div class="header-w3l">
		<h1>MTS</h1>
	</div>
	<!--//header-->
	<!--main-->
	<form action="login" method="post" modelAttribute="formLogin">
		<div class="main-w3layouts-agileinfo">
			<!--form-stars-here-->
			<div class="wthree-form">
				<div class="form-sub-w3">
					<input type="text" name="userName" placeholder="Username "
						required="required" />
					<div class="icon-w3">
						<i class="fa fa-user" aria-hidden="true"></i>
					</div>
				</div>
				<div class="form-sub-w3">
					<input type="password" name="password" placeholder="Password"
						required="required" />
					<div class="icon-w3">
						<i class="fa fa-unlock-alt" aria-hidden="true"></i>
						<a style="color: #595ed7" href="/OnlineShopping/forgotpassword"><u>Forgot Password.</u></a>
					</div>
				</div>
				<div class="submit-agileits">
					<input type="submit" value="Login">
				</div>
				<div class="submit-agileits">
					<a style="color: #595ed7" href="/OnlineShopping/register"><u>Don't have an account? Register here.</u></a>
				</div>

			</div>
		</div>
	</form>
	<div align="center" style="margin-top: 10px">
		<c:if test="${param['messageRegister']}">
			<script type="text/javascript">
				$(document).ready(function() {
					alert('Bạn đã đăng ký thành công, đăng nhập thôi nào!!');
				});
			</script>
		</c:if>

		<c:if test="${param['message']}">
			<script type="text/javascript">
				$(document).ready(function(e) {
					alert('Sai Username hoặc Password');
				});
			</script>
		</c:if>

		<c:if test="${param['approvingmessage']}">
			<script type="text/javascript">
				$(document).ready(function(e) {
					alert('Tài khoản của bạn đang được duyệt bởi Admin');
				});
			</script>
		</c:if>
		<c:if test="${param['updatepassword']}">
			<script type="text/javascript">
				$(document).ready(function(e) {
					alert('Cập nhật mật khẩu thành công');
				});
			</script>
		</c:if>
	</div>
<div align="center" style="margin-top: 10px">
		<c:if test="${param['messageWrongEmail']}">
			<script type="text/javascript">
				$(document).ready(function() {
					alert('Email not found!!');
				});
			</script>
		</c:if>
		<c:if test="${param['messagePassword']}">
			<script type="text/javascript">
				$(document).ready(function() {
					alert('OTP sent!!');
				});
			</script>
		</c:if>
	</div>
</body>
</html>