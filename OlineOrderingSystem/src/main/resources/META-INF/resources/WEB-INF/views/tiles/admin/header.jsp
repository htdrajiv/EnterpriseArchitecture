<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta charset="UTF-8"/>
    <title></title>
    <link href="/css/header.css" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
    <li><a href="#" >Home</a></li>
    <li><a href="#" >Restaurants</a></li>
    <li>
        <input style="margin-top: 15px" type="text" name="searchText" value="Search.."/>
        <input type="submit" value="search"/>
    </li>
    <li> <jsp:include page="../common/logout.jsp" flush="true"/></li>
</ul>

</body>
</html>