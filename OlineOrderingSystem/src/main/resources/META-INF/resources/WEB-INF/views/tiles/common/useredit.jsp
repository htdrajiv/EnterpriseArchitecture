<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Edit Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<div id="login-box">
		<h3>User Edit</h3>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<spring:url value="/useredit" var="signupURL" />
		<form:form class="" modelAttribute="userInfoBean" method="POST"
			action="${signupURL}" onsubmit="return checkPassword();">
			<div class="">
				<form:errors path="*" cssClass="text-danger">Error test</form:errors>
			</div>
			<table>
				<tr>
					<td>First Name:</td>
					<td><input value="${userInfoBean.firstName}" type='text' name='firstName' value=''
						required="required"></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input value="${userInfoBean.lastName}" type='text' name='lastName' value=''
						required="required"></td>
				</tr>
				
				<tr>
					<td>Phone No:</td>
					<td><input value="${userInfoBean.phoneNo}" type='text' name='phoneNo' required="required" /></td>
				</tr>
				<tr>
					<td>Street:</td>
					<td><input value="${userInfoBean.street}" type='text' name='street' required="required" /></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><input value="${userInfoBean.state}" type='text' name='state' required="required" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input value="${userInfoBean.city}" type='text' name='city' required="required" /></td>
				</tr>

				<tr>
					<td>Zip:</td>
					<td><input value="${userInfoBean.zip}" type='text' name='zip' required="required" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input value="${userInfoBean.email}" type='text' name='email' required="required" /></td>
				</tr>


				<tr>
					<td>Password:</td>
					<td><input value="${userInfoBean.password}" type='password' id="password" name='password' required="required" /></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input value="${userInfoBean.password}" type='password' id="matchPassword" name='matchPassword' required="required" /></td>
				</tr>
				<tr>
					<span style="color:red">Your email would be used as username</span>
				</tr>

				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Edit" /></td>
				</tr>

				<tr>
					<td><input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<script type="text/javascript">
		function checkPassword() {
			var firstInput = document.getElementById("password").value;
			var secondInput = document.getElementById("matchPassword").value;
			if (firstInput != secondInput) {
				alert("Password doesn't match!!");
				return false;
			}
			return true;
		}
	</script>


</body>
</html>