<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><tiles:getAsString name="title" /></title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href=""<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>
	
	<header id="site-content">
		<tiles:insertAttribute name="body" />
	</header>
	
	<header id="footer">
		<tiles:insertAttribute name="footer" />
	</header>
</body>
</html>