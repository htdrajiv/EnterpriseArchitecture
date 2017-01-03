<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
        table#menu tr td {
            border: solid;
        }
    </style>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
      <script src="<c:url value='/static/js/controllers.js'></c:url>"></script>
</head>
<body>

<section class="container" ng-app="cartApp">
<div class="heading_allcap_c1">${restaurant.name}</div>
<div class="box-table">
    <table>
        <tr>
            <td>
                <div>
                <table>
                    <tr>
                        <td><img src="/static/images/restaurant/food_delivery.jpeg" /></td>
                    </tr>
                </table>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <table>
                        <tr>
                            <td>${restaurant.description}</td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr><td><br/>Locations: </td></tr>
        <tr>
            <td>
            <div>
                <table>

                    <c:forEach items="${restaurant.addressList}" var="address">
                        <tr>
                            <td>${address.state}, </td>
                            <td>${address.city}, </td>
                            <td>${address.street}, </td>
                            <td>${address.zip}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            </td>
        </tr>

        <tr><td><br/>Menus:</td></tr>
        <tr>
            <td>
                <div>
                    <table>
                        <c:forEach items="${restaurant.menus}" var="menu">
                            <tr>
                                <td><b style="color:chocolate">${menu.name}</b></td>
                            </tr>
                            <tr>
                                <td>${menu.description}</td>
                            </tr>
                            <tr>
                                <td>Available Foods: </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>
                                        <table id="menu">
                                            <tr>
                                                <td>Name</td>
                                                <td>Description</td>
                                                <td>Type</td>
                                                <td>Price</td>
                                                <td>Action</td>
                                            </tr>
                                            <c:forEach items="${menu.food}" var="food">
                                                <tr>
                                                    <td>${food.name}</td>
                                                    <td>${food.description}</td>
                                                    <td>${food.type}</td>
                                                    <td>${food.price}</td>
                                                    <td>    <p ng-controller="cartCtrl">
    	<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${food.id}')">
    		<span class="glyphicon-hand-right glyphicon"/>Add To Cart
    	</a>

    </p> </td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </td>
        </tr>
    </table>
</div>

</section>
</body>
</html>