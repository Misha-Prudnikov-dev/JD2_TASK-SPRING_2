<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<title>Checkout</title>

               <fmt:setLocale value="${sessionScope.local}" />
               <fmt:setBundle basename="localization.local" var="loc" />

              <fmt:message bundle="${loc}" key="local.checkout.city" var="city" />
              <fmt:message bundle="${loc}" key="local.checkout.street" var="street"/>
              <fmt:message bundle="${loc}" key="local.checkout.numberHouse" var="numberHouse"/>
              <fmt:message bundle="${loc}" key="local.checkout.payment.card" var="CardUponReceipt"/>
              <fmt:message bundle="${loc}" key="local.checkout.payment.cash" var="inCash"/>
              <fmt:message bundle="${loc}" key="local.checkout.order" var="order"/>
              <fmt:message bundle="${loc}" key="local.cart.checkout" var="checkout"/>
              
</head>
<body>


     <header>
    
    <jsp:include page="header.jsp"/>

   </header>
   
   <main>
   
   <jsp:include page="menu.jsp"/>
   
   </main>
   
   
   <div class="container">
  

    <div class="col-sm-6">
	<h1>${checkout}</h1>
	<br>
    <form class="form-horizontal" action="Controller" method="post">
       <input type="hidden" name="command" value="Checkout" />
    
      <div class="form-group">
             <label for="inputEmail3" class="col-sm-2 control-label">${city}</label>
      <div class="col-sm-10">
             <input type="text" class="form-control" name="city" id="inputEmail3" placeholder="${city}">
    </div>
  </div>
  <div class="form-group">
           <label for="inputPhone" class="col-sm-2 control-label">${street}</label>
   <div class="col-sm-10">
           <input type="text" class="form-control" name="street" id="inputPhone" placeholder="${street}">
   </div>
  </div>
  <div class="form-group">
         <label for="inputPhone" class="col-sm-2 control-label">${numberHouse}</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" name="numberHouse" id="inputPhone" placeholder="${numberHouse}">
    </div>
  </div>
    <div class="form-group">

       <label class="radio-inline">
           <input type="radio" name="typePayment" id="inlineRadio1" value="cardUponReceipt">${CardUponReceipt}
      </label>
      <br>
      <br>
      <label class="radio-inline">
           <input type="radio" name="typePayment" id="inlineRadio2" value="inCash">${inCash}
     </label>
</div>
  <div class="form-group" >
    <div class="col-sm-offset-2 col-sm-10">
      	<input type="submit" name="Checkout" id="Checkout" class="btn btn-primary" value="${order}">
    </div>
  </div>
</form>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
  </div>

<br/>

</div>

</body>
</html>