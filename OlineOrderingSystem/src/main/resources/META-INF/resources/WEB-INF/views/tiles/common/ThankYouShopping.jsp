<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Thank You</title>
</head>
<body>
	<section>
      <div class="jumbotron">
        <div class="container">
          <h3>Thank You For Shopping!!!</h3>
          <h4>Receipt sent through email. </h4>
        </div>
        <a href="<spring:url value='restaurantList' />" class="btn btn-default">
          <span class="glyphicon-hand-right glyphicon"></span> Continue shopping
        </a>
      </div>
    </section>
</body>
</html>