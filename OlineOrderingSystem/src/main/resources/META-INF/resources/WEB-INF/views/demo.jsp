<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
<jsp:include page="tiles/admin/header.jsp" flush="true"/>
<%--<c:url value="/resources/text.txt" var="url"/>--%>
<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
Spring URL: ${springUrl} at ${time}  inside templates
<br>
<%--JSTL URL: ${url}--%>
<br>
Message: ${message}
</body>

</html>