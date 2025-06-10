<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="shortcut icon"
	href="<c:url value='/resources/img/ticket.png'/>">
<title>Cảng Tiên Sa</title>
<script src="<c:url value='/resources/library/jquery-3.4.1.min.js'/>"></script>
<script
	src="<c:url value='/resources/library/jquery-3.3.1.slim.min.js' />"></script>
<script
	src="<c:url value='/resources/library/datatablejs/media/js/jquery.dataTables.js'/>"></script>
<script src="<c:url value='/resources/library/popper.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/datatablejs/media/css/jquery.dataTables.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/font-awesome.min.css'/>">
<script src="<c:url value='/resources/library/font-awesome.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/register.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/customReset.css'/>">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600'
	rel='stylesheet' type='text/css'>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css"
	rel="stylesheet">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<style>
fieldset, img {
	border: 0
}

ol, ul, li {
	list-style: none
}

:focus {
	outline: none
}

body, input, textarea, select {
	font-family: 'Open Sans', sans-serif;
	font-size: 16px;
	color: #4c4c4c;
}

p {
	font-size: 12px;
	width: 150px;
	display: inline-block;
	margin-left: 18px;
}

h1 {
	font-size: 32px;
	font-weight: 300;
	color: #4c4c4c;
	text-align: center;
	padding-top: 10px;
	margin-bottom: 10px;
}

html {
	background-color: #ffffff;
}

.testbox {
	margin: 20px auto;
	width: 650px;
	height: 800px;
	-webkit-border-radius: 8px/7px;
	-moz-border-radius: 8px/7px;
	border-radius: 8px/7px;
	background-color: #ebebeb;
	-webkit-box-shadow: 1px 2px 5px rgba(0, 0, 0, .31);
	-moz-box-shadow: 1px 2px 5px rgba(0, 0, 0, .31);
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .31);
	border: solid 1px #cbc9c9;
}

input[type=radio] {
	visibility: hidden;
	background-color: #595ED7;
}

form {
	margin: 0 30px;
}

label.radio {
	cursor: pointer;
	text-indent: 35px;
	overflow: visible;
	display: inline-block;
	position: relative;
	margin-bottom: 10px;
	padding-top: 5px
}

label.radio:before {
	background: #595ED7;
	content: '';
	position: absolute;
	top: 2px;
	left: 0;
	width: 20px;
	height: 20px;
	border-radius: 100%;
}

label.radio:after {
	opacity: 0;
	content: '';
	position: absolute;
	width: 0.5em;
	height: 0.25em;
	background: transparent;
	top: 9.5px;
	left: 6.5px;
	border: 3px solid #ffffff;
	border-top: none;
	border-right: none;
	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	-ms-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

input[type=radio]:checked+label:after {
	opacity: 1;
}

hr {
	color: #a9a9a9;
	opacity: 0.3;
}

.iconlable {
	margin-top: 20px
}

input[type=text], input[type=password] {
	width: 200px;
	height: 50px;
	-webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px;
	-moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px;
	border-radius: 0px 4px 4px 0px/5px 5px 4px 4px;
	background-color: #fff;
	-webkit-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	-moz-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	border: solid 1px #cbc9c9;
	margin-left: -5px;
	margin-top: 05px;
	padding-left: 10px;
}
input[type=date]{
	width: 200px;
	height: 50px;
	-webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px;
	-moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px;
	border-radius: 0px 4px 4px 0px/5px 5px 4px 4px;
	background-color: #fff;
	-webkit-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	-moz-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	border: solid 1px #cbc9c9;
	margin-left: -5px;
	margin-top: 05px;
	padding-left: 10px;
}
input[type=password] {
	margin-bottom: 03px;
	height: 50px;
}

#icon {
	display: inline-block;
	height: 40px;
	width: 30px;
	background-color: #595ED7;
	padding: 8px 24px 8px 13px;
	margin-left: 25px;
	-webkit-border-radius: 4px 0px 0px 4px;
	-moz-border-radius: 4px 0px 0px 4px;
	border-radius: 4px 0px 0px 4px;
	color: white;
	-webkit-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	-moz-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	border: solid 0px #cbc9c9;
}

.gender {
	margin-top: 20px;
	margin-left: 155px;
	margin-bottom: 30px;
}

.accountType {
	margin-top: 20px;
	margin-left: 155px;
	margin-bottom: 30px;
}

.accounttype {
	margin-left: 85px;
	margin-top: 20px;
}

.btnotp {
	font-size: 14px;
	font-weight: 600;
	color: white;
	background-color: #595ED7;
	background-color: #595ED7;
	display: inline-block;
	width: 85px;
	height: 27px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 3px rgba(58, 87, 175, .75);
	-moz-box-shadow: 0 3px rgba(58, 87, 175, .75);
	box-shadow: black;
	transition: all 0.1s linear 0s;
}

.button {
	font-size: 14px;
	font-weight: 600;
	color: white;
	padding: 6px 75px 10px 20px;
	margin: 10px 8px 20px 0px;
	display: inline-block;
	float: right;
	text-decoration: none;
	width: 50px;
	height: 27px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	background-color: #595ED7;
	-webkit-box-shadow: 0 3px rgba(58, 87, 175, .75);
	-moz-box-shadow: 0 3px rgba(58, 87, 175, .75);
	box-shadow: black;
	transition: all 0.1s linear 0s;
	top: 0px;
	position: relative;
	height: 30px;
	background-color: #595ED7
}

.button:hover {
	top: 3px;
	background-color: #595ED7;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
}

.regist {
	width: 100%;
	display: flex;
	justify-content: center;
}

.btn-info {
	background-color: #595ED7 !important;
}
</style>
<body>
	<div class="testbox">

		<h1>Thêm mới nhân viên</h1>
		<form:form action="${pageContext.request.contextPath}/themUser"
			method="POST" modelAttribute="formUser" id="formUser">
			<hr>
			<%-- 			<div class="accounttype" align="center">
				<c:if test="${account.roles.roleID eq 1}">
					<input type="radio" value="1" id="radioOne" name="roleID" />
					<label for="radioOne" class="radio">Admin</label>
					<input type="radio" value="2" id="radioTwo" name="roleID" />
					<label for="radioTwo" class="radio">Nhân viên</label>
				</c:if>
				<input type="radio" value="3" id="radioThree" name="roleID" checked />
				<label for="radioThree" class="radio">Khách hàng</label>
			</div> --%>
			<%-- 				<form:select path="roleS.roleID" name="roleID" id="roleID" --%>
			<%-- 						items="${listRoles1}" class="form-control"> --%>
			<%-- 					</form:select> --%>
			<hr>
			<label class="iconlable" id="icon" for="fullName"><i
				class="icon-user"></i></label>
			<input type="text" name="fullName" id="fullName"
				placeholder="Full name" required />
			<label class="iconlable" id="icon" for="phoneNumber"><i
				class="fa fa-phone" aria-hidden="true"></i></label>
				<span id="phoneNumberError" style="color: red; display: none;">Số
							điện thoại không hợp lệ.</span>
			<input type="text" name="phoneNumber" id="phoneNumber"
				placeholder="Phone number" required />
			<label class="iconlable" id="icon" for="userName"><i
				class="fa fa-user"></i></label>
			<input type="text" name="userName" id="userName"
				placeholder="Username" required />
			<label class="iconlable" id="icon" for="address"><i
				class="fa fa-address-book"></i></label>
			<input type="text" name="address" id="address" placeholder="Address"
				required />
			<label class="iconlable" id="icon" for="password"><i
				class="fa fa-unlock-alt"></i></label>
			<input type="password" name="password" id="password"
				placeholder="Password" required />
			<label class="iconlable" id="icon" for="dateOfBirth"><i
				class="icon-user"></i></label>
			<input type="date" name="dateOfBirth" id="dateOfBirth"
				placeholder="Birth Day" required />
			<label class="iconlable" id="icon" for="email"><i
				class="icon-user"></i></label>
			<input type="text" name="email" id="email" placeholder="Email"
				required />
			<label class="iconlable" id="icon" for="identityCard"><i
				class="fa fa-id-card"></i></label>
			<input type="text" name="identityCard" id="identityCard"
				placeholder="Identity Card" required />

			<div class="gender">
				<input type="radio" value="male" id="male" name="gender" checked />
				<label for="male" class="radio" checked>Male</label> <input
					type="radio" value="female" id="female" name="gender" /> <label
					for="female" class="radio" style="margin-left: 31px;">Female</label>
			</div>
			<div class="accountType">
				<input type="radio" value="2" id="2" name="roleID" checked /> <label
					for="2" class="radio">NV cảng</label> <input type="radio" value="3"
					id="3" name="roleID" /> <label for="3" class="radio"
					style="margin-left: 31px;">NV kiểm định</label>
			</div>


			<div class="regist">
				<button type="submit" id="btnn" class=button>Thêm</button>
			</div>
		</form:form>
	</div>


</body>
<script>

    document.addEventListener('DOMContentLoaded', function() {
        const phoneNumberRegex = /^0\d{9}$/;
        const phoneNumberInput = document.getElementById("phoneNumber");
        const phoneNumberErrorSpan = document.getElementById("phoneNumberError");
        const updateProfileForm = document.getElementById("formUser");

        function validatePhoneNumber() {
            const phoneNumber = phoneNumberInput.value;
            if (phoneNumberRegex.test(phoneNumber)) {
                phoneNumberErrorSpan.style.display = 'none'; 
                return true;
            } else {
                phoneNumberErrorSpan.style.display = 'inline'; 
                return false;
            }
        }

        updateProfileForm.addEventListener('submit', function(event) {

            const isPhoneNumberValid = validatePhoneNumber();

            if (!isPhoneNumberValid ) {
                event.preventDefault();

            }
        });


        phoneNumberInput.addEventListener('input', validatePhoneNumber); 
    });
</script>
</html>
