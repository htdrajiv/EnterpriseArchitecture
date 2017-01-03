<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet"
      href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<style>
    .div-box {
        width: 90%;
        height: 50%;
        padding: 50px;
        border: 2px solid #d5d5d5;
        box-sizing: border-box;
        overflow-x: hidden;
        overflow-y: hidden;
        background-color: #d5d5d5;
        color:#6e6f72;
        border-radius:5px;
    }
    table, td, th {
        border: 1px solid #ddd;
        text-align: left;
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        padding: 10px;
    }
</style>
<script type="text/javascript">
    window.onload = showHide;
    function showHide(){
        var input = document.getElementById("restaurant").value;
        if(input=="--Select--"){
            document.getElementById("addMenu").style.display = "none";
        }else document.getElementById("addMenu").style.display = "block";

        return true;
    }
</script>

<section class="container">

    <form:form name="addMenuForm" modelAttribute="menu"  action="/admin/saveMenu" method="post">
        <input type="hidden" name="menuId" value="${menu.id}"/>
        <div>
            <table>
                <tr>
                    <td>Select Restaurant:
                        <select id="restaurant" name="restaurantId" onchange="showHide();">
                            <option selected="selected">--Select--</option>
                            <c:forEach items="${restaurants}" var="restaurant">
                                <option ${menu.restaurant==restaurant ? 'selected="selected"' : ''}
                                        value="${restaurant.getId()}">${restaurant.getName()}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td></td>
                </tr>
            </table>
        </div>
        <div id="addMenu" <%--style="display: none;"--%>>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
            <section class="container">
                <h4>Add Menu</h4>
                <table>
                    <tr>
                        <td>
                            <div>
                                <table>
                                    <tr>
                                        <td> Name: </td>
                                        <td><input value="${menu.name}" type="text" name="name" required="required"/> </td>
                                    </tr>
                                    <tr>
                                        <td> Description: </td>
                                        <td> <input value="${menu.description}" type="text" name="description" required="required" /> </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                        <%--<tr>--%>
                        <%--<td>--%>
                        <%--<br/>--%>
                        <%--<h4>Address</h4>--%>
                        <%--<div class="div-box">--%>
                        <%--<table>--%>
                        <%--<tr>--%>
                        <%--<td>State: </td>--%>
                        <%--<td><input  type="text" name="state"/></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                        <%--<td>City: </td>--%>
                        <%--<td><input  type="text" name="city"/></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                        <%--<td>Street: </td>--%>
                        <%--<td><input  type="text" name="street"/></td>--%>
                        <%--</tr>--%>
                        <%--<td>Zip: </td>--%>
                        <%--<td><input type="text" name="zip"/></td>--%>
                        <%--</tr>--%>
                        <%--</table>--%>
                        <%--</div>--%>
                        <%--</td>--%>
                        <%--</tr>--%>
                    <tr>
                        <td>
                            <input class="btn btn-primary" type="submit" value="submit" />
                            <a href="/admin/dashboard"><input type="button" value="Cancel" class="btn btn-primary"></a>
                        </td>
                    </tr>
                        <%--<tr>--%>
                        <%--<td colspan="2"><a href="${pageContext.request.contextPath}/login/loginForm" >Go To Login Page</a></td>--%>
                        <%--</tr>--%>
                </table>
            </section>

        </div>
    </form:form>

</section>





