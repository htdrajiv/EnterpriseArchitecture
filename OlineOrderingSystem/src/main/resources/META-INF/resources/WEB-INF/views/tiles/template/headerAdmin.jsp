<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link href="http://cdn.phpoll.com/css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
</style>

<section>
    <div class="jumbotron" >
        <div class="container">
            <ul>
                <li><a href="/admin/dashboard"><h3>Home</h3></a></li>
                <jsp:include page="/WEB-INF/views/tiles/common/logout.jsp"/>
            </ul>
            <ul>
                <li>
                    <form action="/admin/search" method="post"><input type="text" name="searchBox" placeholder="Search.." value="${searchBoxText}"/></form>
                </li>
            </ul>
            <%--<h1 style="text-align: center;"> Header Section </h1>--%>
        </div>
    </div>
</section>