<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet"
      href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<style>
body { padding-top:30px; }
.form-control { margin-bottom: 10px; }
</style>

<script type="text/javascript">
    function newAddress(){
    	var abc = document.getElementById("address").value=0;
    	document.getElementById("street").value="";
    	document.getElementById("city").value="";
    	document.getElementById("state").value="";
    	document.getElementById("zip").value="";
    	document.getElementById("street").disabled = false;
    	document.getElementById("city").disabled = false;
    	document.getElementById("state").disabled = false; 
    	document.getElementById("zip").disabled = false;
    }
    function setFields() {
//    	alert("Setting Field");
    	var abc = document.getElementById("address");
    	var address1 = abc.options[abc.selectedIndex].text;
    	var splited = address1.split(",");
//    	alert(abc.value);
    	document.getElementById("Address").value =abc.value;
    	document.getElementById("street").value=splited[0];
    	document.getElementById("city").value=splited[1];
    	document.getElementById("state").value=splited[2];
    	document.getElementById("zip").value=splited[3];
    	document.getElementById("street").disabled = true;
    	document.getElementById("city").disabled = true;
    	document.getElementById("state").disabled = true; 
    	document.getElementById("zip").disabled = true;
//    	alert(abc.options[abc.selectedIndex].text);
    }

</script>

<section class="container">

    <form:form name="addOrderAddress" modelAttribute="OrderAddress"  action="/order/address" method="post">
        <div>
            <table>
                <tr>
                    <td>Order Delivery Address:
                        <select id="address" name="deliveryId" onchange="setFields()">
                            <option selected="selected">--Select--</option>
                            <c:forEach items="${Address}" var="address">
                                <option value="${address.getAddressId()}">${address.getStreet()},${address.getCity()},${address.getState()},${address.getZip()}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><button type="button" class="btn btn-primary" onclick="newAddress()">New Address</button></td>
                </tr>
            </table>

        </div>
        <div id="addAddress">

            <section class="container">
                <h4>New Delivery Address</h4>
                <div class="container">
				    <div class="row">
				        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">

				            <legend> Order Address!</legend>
				            <form:form action="/order/Address" modelAttribute="OrderAddress" method="post" class="form" role="form">
				            <div class="row">
				                <div class="col-xs-6 col-md-6">
				                    <form:input class="form-control" path="street" name="street" placeholder="Street" type="text" id="street"
				                        required="autofocus"/>
				                        <input type="hidden"
                                              name="HiddenAddressId" id="Address"
                                              value="0" /> 
				                </div>
				                <div class="col-xs-6 col-md-6">
				                    <form:input class="form-control" path="city" name="city" placeholder="City" type="text" id="city"  />
				                </div>
				            </div>
				            <form:input class="form-control" path="state" name="state" placeholder="State" id="state" type="text" />
				            <form:input class="form-control" path="zip" name="zip" placeholder="ZipCode" id="zip" type="text" />
				            <form:input class="form-control" path="phoneNo" name="phoneNo" placeholder="Phone" id="phoneNo" type="text" />
				            
				            <br />
				            <br />
				            <button class="btn btn-lg btn-primary btn-block" type="submit">
				                PlaceOrder</button>
				            </form:form>
				        </div>
				    </div>
				</div>
            </section>

        </div>
    </form:form>

</section>





