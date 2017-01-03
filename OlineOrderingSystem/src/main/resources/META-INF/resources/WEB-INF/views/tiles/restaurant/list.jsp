<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <%--<link href="/restaurant/restaurantList.css" rel="stylesheet" type="text/css"/>--%>
    <style>
        .box-table
        {
            background-color: #d5d5d5;
            border:1px solid #d5d5d5;
            padding:10px;
            color:#6e6f72;
            border-radius:5px;
            width: 90%;
            margin-left: 20px;
        }
        .heading_allcap_c1
        {
            font-size:24px;
            font-family: Arial Cambria Verdana
        font-weight:5000;
            color:#990000; /*#414141;*/
            text-align:left;
            padding:10px 0 10px 0;
            border-bottom:3px solid #616161;
        }
    </style>
</head>
<body>
<div class="heading_allcap_c1">Available Restaurants</div>
<div id="restaurantHolder">
    <table>
        <tbody>
        <c:forEach items="${restaurants}" var="restaurant">
            <tr>
                <td>
                    <div class="box-table">
                        <table>
                            <tr>
                                <td><a href="#">
                                    <img src=""/>
                                    </a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/restaurant/details/${restaurant.id}">${restaurant.name}</a>
                                </td>
                            </tr>
                            <%--<tr>--%>
                                <%--<td>--%>
                                    <%--<div>--%>
                                        <%--<table>--%>
                                            <%--<tr>--%>
                                                <%--<td>State</td>--%>
                                                <%--<td>City</td>--%>
                                                <%--<td>Street</td>--%>
                                                <%--<td>Zip</td>--%>
                                                <%--<td></td>--%>
                                            <%--</tr>--%>
                                            <%--<c:forEach items="${restaurant.addressList}" var="address">--%>
                                                <%--<a href="/restaurant/byLocation/${address.addressId}">--%>
                                                    <%--<tr>--%>
                                                        <%--<td>${address.state}</td>--%>
                                                        <%--<td>${address.city}</td>--%>
                                                        <%--<td>${address.street}</td>--%>
                                                        <%--<td>${address.zip}</td>--%>
                                                    <%--</tr>--%>
                                                <%--</a>--%>
                                            <%--</c:forEach>--%>
                                        <%--</table>--%>
                                    <%--</div>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                        </table>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
