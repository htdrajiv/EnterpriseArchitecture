<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link href="http://cdn.phpoll.com/css/animate.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
ul {
	width: 960px;
	display: table;
	table-layout: fixed;
}

ul li {
	display: table-cell;
}

ul li a {
	display: block;
}

.hidden {
	display: none;
}
</style>

<section>
	<div class="jumbotron">
		<div class="container">
			<ul>
				<li><a href="/user/dashboard"><h3>Home</h3></a></li>
				<jsp:include page="/WEB-INF/views/tiles/common/logout.jsp" />
				<li class="active"><a class="glyphicon glyphicon-shopping-cart"
					href="<a:url value='/cart'/>">Cart[]</a></li>
				<a:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a href="/useredit/${pageContext.request.userPrincipal.name}"><h3>Edit User</h3></a></li>
				</a:if>
				<a:if test="${pageContext.request.userPrincipal.name == null}">
					<li class="hidden"></li>
				</a:if>
				<a:if test="${pageContext.request.userPrincipal.name != null }">
					<li><a href="<a:url value="/order/userorder"/>"><h3>My Orders</h3></a></li>
				</a:if>
			    <a:if test="${pageContext.request.userPrincipal.name == null}">
					<li class="hidden"></li>
				</a:if>
				
			</ul>
			<%--<h1 style="text-align: center;"> Header Section </h1>--%>
		</div>
	</div>
</section>