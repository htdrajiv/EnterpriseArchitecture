<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .top-bar, .top-bar ul {
        background-color: #eee;
    }
</style>
<a:url value="/j_spring_security_logout" var="logoutUrl" />
<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>

<a:if test="${pageContext.request.userPrincipal.name != null}">
    <li>
        <label> Welcome : ${pageContext.request.userPrincipal.name} |</label>
    </li>
    <li><a href="javascript:formSubmit()">Logout</a></li>
   
   
</a:if>
<a:if test="${pageContext.request.userPrincipal.name == null}">
    <li><a href="/login">Login</a></li>
</a:if>



<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

