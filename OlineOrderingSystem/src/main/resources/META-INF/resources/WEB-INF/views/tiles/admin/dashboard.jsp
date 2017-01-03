<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script type="text/javascript" src="/static/js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="/static/js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <%--<link href="/restaurant/restaurantList.css" rel="stylesheet" type="text/css"/>--%>
    <style>
        .box-table
        {
            background-color: #f2f2f2;
            border:1px solid #d5d5d5;
            padding:10px;
            color:#6e6f72;
            border-radius:5px;
            width: 90%;
            margin-left: 20px;
        }
        .menuHolder
        {
            /*background-color: #f4f4f4;*/
            border:1px solid #bdbdbd;
            padding:10px;
            color: #dde0e5;
            border-radius:5px;
            width: auto;
            margin-left: 20px;
            display: table-cell;
        }
        .heading_allcap_c1
        {
            font-size:20px;
            font-family: Arial Cambria Verdana
        font-weight:5000;
            color:#990000; /*#414141;*/
            text-align:left;
            padding:10px 0 10px 0;
            border-bottom:3px solid #616161;
        }
        #mainHolder{
            display: table-row;
        }
        table, td, th {
            /*border: 1px solid #ddd;*/
            text-align: left;
        }

        table {
            border-collapse: collapse;
            width: 70%;
        }

        th, td {
            padding:10px;
        }
    </style>
    <script>
        function confirmDelete(){
            return confirm("Are you sure to delete?");
        }

        $(document).ready(function(){
            $(".hover-desc").hover(function(){
                $.ajax({
                    url: "/rest/getDescription",
                    type:"POST",
                    data:{},
                    success:function(){
                        $("#restaurantDescription").style("display","block");
                    },
                    error: function(){

                    }
                })
                console.log(this.name);
            })
        })

    </script>
</head>
<body>
<section class="container">
    <div id="mainHolder" class="thumbnail">
        <div class="menuHolder">
            <div class="heading_allcap_c1">Restaurants: </div>
            <div><a href="/admin/addRestaurant"><h4>Add new Restaurant</h4></a> </div>
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
                                            <div>
                                                <table>
                                                    <tr>
                                                        <td><a id="${restaurant.id}" name="restaurant" class="hover-desc"
                                                               href="/admin/editRestaurant/${restaurant.id}">${restaurant.name}</a>
                                                        </td>
                                                        <td><a onclick="return confirmDelete();"
                                                               href="/admin/deleteRestaurant/${restaurant.id}">
                                                            <input type="button" value="Delete"/></a>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="menuHolder">
            <div class="heading_allcap_c1">Menus: </div>
            <div><a href="/admin/addMenu"><h4>Add new Menu</h4></a> </div>
            <table>
                <tbody>
                <c:forEach items="${menus}" var="menu">
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
                                            <div>
                                                <table>
                                                    <tr>
                                                        <td><a id="${menu.getId()}" name="menu" class="hover-desc" href="/admin/editMenu/${menu.getId()}">${menu.name}</a></td>
                                                        <td><a onclick="return confirmDelete();" href="/admin/deleteMenu/${menu.getId()}">
                                                            <input type="button" value="Delete"/></a></td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="menuHolder">
            <div class="heading_allcap_c1">Foods: </div>
            <div><a href="/admin/addFood"><h4>Add new Food</h4></a> </div>
            <table>
                <tbody>
                <c:forEach items="${foods}" var="food">
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
                                            <div>
                                                <table>
                                                    <tr>
                                                        <td><a id="${food.id}" name="food" class="hover-desc" href="/admin/editFood/${food.id}">${food.name}</a></td>
                                                        <td><a onclick="return confirmDelete();" href="/admin/deleteFood/${food.id}">
                                                            <input type="button" value="Delete"/></a></td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>
