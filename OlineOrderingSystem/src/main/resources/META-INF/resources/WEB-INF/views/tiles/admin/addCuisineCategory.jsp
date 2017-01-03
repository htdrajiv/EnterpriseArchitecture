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
</style>

<form:form name="addCuisineForm" modelAttribute="cuisine"  action="/admin/saveCuisine" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
    <section class="container">
        <h4>Add Cuisine</h4>
        <table>
            <tr>
                <td>
                    <div>
                        <table>
                            <tr>
                                <td> Name: </td>
                                <td><input type="text" name="name" required="required"/> </td>
                            </tr>
                            <tr>
                                <td> Description: </td>
                                <td> <input type="text" name="description" required="required" /> </td>
                            </tr>
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
                                <td><input  type="text" name="state"/></td>
                            </tr>
                            <tr>
                                <td>City: </td>
                                <td><input  type="text" name="city"/></td>
                            </tr>
                            <tr>
                                <td>Street: </td>
                                <td><input  type="text" name="street"/></td>
                            </tr>
                            <td>Zip: </td>
                            <td><input type="text" name="zip"/></td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <input class="btn btn-primary" type="submit" value="submit" />
                </td>
            </tr>
                <%--<tr>--%>
                <%--<td colspan="2"><a href="${pageContext.request.contextPath}/login/loginForm" >Go To Login Page</a></td>--%>
                <%--</tr>--%>
        </table>
    </section>

</form:form>



