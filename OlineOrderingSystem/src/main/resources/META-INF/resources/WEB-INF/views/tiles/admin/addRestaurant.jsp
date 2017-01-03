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
        background-color: #eaeaea;
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
        padding:10px;
    }
</style>

<form:form name="addRestaurantForm" modelAttribute="restaurantInfoBean"  action="/admin/saveRestaurant" method="post" enctype="multipart/form-data">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
    <input type="hidden" name="id" value="${restaurantInfoBean.id}"/>
    <section class="container">
        <h4>Add Restaurant</h4>
        <table>
            <tr>
                <td>
                    <div>
                        <table>
                            <tr>
                                <td> Name: </td>
                                <td><input value="${restaurantInfoBean.name}" type="text" name="name" required="required"/> </td>
                            </tr>
                            <tr>
                                <td> Description: </td>
                                <td> <input value="${restaurantInfoBean.description}" type="text" name="description" required="required" /> </td>
                            </tr>
                            <tr>
                                <td> Email: </td>
                                <td> <input value="${restaurantInfoBean.email}" type="text" name="email" required="required" /> </td>
                            </tr>
                            <tr>
                                <td> Cuisine Category: </td>
                                <td> <select name="cuisineId" required="required"><c:forEach items="${cuisines}" var="cuisine">
                                        <option ${restaurantInfoBean.cuisineId!=null ? 'selected="selected"' : ''}
                                                value="${cuisine.getId()}">${cuisine.getName()}</option>
                                    </c:forEach></select>
                                </td>
                            </tr>
                            <%--<tr>--%>
                                <%--<td> Image: </td>--%>
                                <%--<td> <input value="${restaurantInfoBean.imageToUpload}" type="file" name="imageToUpload" /> </td>--%>
                            <%--</tr>--%>
                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <br/>
                    <h4>Address</h4>
                    <div class="div-box">
                        <table>
                            <tr>
                                <td>State: </td>
                                <td><input value="${restaurantInfoBean.state}" required="required" type="text" name="state"/></td>
                            </tr>
                            <tr>
                                <td>City: </td>
                                <td><input value="${restaurantInfoBean.city}" required="required" type="text" name="city"/></td>
                            </tr>
                            <tr>
                                <td>Street: </td>
                                <td><input value="${restaurantInfoBean.street}" required="required" type="text" name="street"/></td>
                            </tr>
                                <td>Zip: </td>
                                <td><input value="${restaurantInfoBean.zip}" required="required" type="text" name="zip"/></td>
                            </tr>
                            </tr>
                                <td>Phone: </td>
                                <td><input value="${restaurantInfoBean.phoneNumber}" required="required" type="text" name="phoneNumber"/></td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
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

</form:form>



