<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
 
<title>Cart</title>

               
              <fmt:setLocale value="${sessionScope.local}" />
              <fmt:setBundle basename="localization.local" var="loc" />

              <fmt:message bundle="${loc}" key="local.cart" var="cartMessage" />
              <fmt:message bundle="${loc}" key="local.cart.product" var="product"/>
              <fmt:message bundle="${loc}" key="local.cart.price" var="price"/>
              <fmt:message bundle="${loc}" key="local.cart.quantity" var="quantity"/>
              <fmt:message bundle="${loc}" key="local.cart.priceUnitProduct" var="priceUnitProduct"/>
              <fmt:message bundle="${loc}" key="local.cart.delete" var="productDelete"/>
              <fmt:message bundle="${loc}" key="local.cart.checkout" var="checkout"/>
              <fmt:message bundle="${loc}" key="local.cart.total" var="cartTotal"/>


</head>
<body>

     <header>
    
         <jsp:include page="header.jsp"/>

   </header>
   
   <main>
   
        <jsp:include page="menu.jsp"/>
   
   </main>
  
 <div class="container">
 
     <c:if test="${ empty groupProductCart}">
            
                    ${cartMessage}
     </c:if>
     
     <c:if test="${ ! empty groupProductCart}">
            
         ${fn:length(groupProductCart)} 
     
  <table id="cart" class="table table-hover table-condensed">
    <thead>
      <tr>
        <th style="width:50%">${product}</th>
        <th style="width:10%">${price}</th>
        <th style="width:8%">${quantity}</th>
        <th style="width:22%" class="text-center">${priceUnitProduct}</th>
        <th style="width:10%"></th>
      </tr>
    </thead>
    <c:set var="total" value="${0}"/>
   <c:forEach items="${groupProductCart}" var="element">
    <tbody>
      <tr>
        <td data-th="Product">
          <div class="row">
            <div class="col-sm-2 hidden-xs"><img src="././img/${element.product.getProductImageByIndex(0).image}" alt="..." class="img-responsive" /></div>
            <div class="col-sm-10">
              <h4 class="nomargin">${element.product.title}</h4>
              <p>${element.product.description}</p>
            </div>
          </div>
        </td>
        <td data-th="Price">$<fmt:formatNumber value="${element.product.price*element.quantity}" pattern=".00"/></td>
        <td data-th="Quantity">${element.quantity}
             <c:set var="total" value="${total+element.product.price*element.quantity}"/>
         
        </td>
        <td data-th="Subtotal" class="text-center">$${element.product.price}</td>
        <td class="actions" data-th="">
        <c:url var="urlVar" value="/deleteProductFromCart" />
       <form:form action="${urlVar}" method="post"> 
	 	     <input type="hidden" name="productId" value="${element.product.id}" /> 
		     <input type="submit" class="btn btn-danger"  value="Delete"/><br>
	  </form:form>
        </td>
      </tr>
    </tbody>
  </c:forEach>    
    <tfoot>
      <tr class="visible-xs">
        <td class="text-center"><strong></strong></td>
      </tr>
      <tr>
        <td colspan="2" class="hidden-xs"></td>
        
        <td class="hidden-xs text-center"><strong>${cartTotal} $<fmt:formatNumber value="${total}" pattern=".00"/></strong></td>
        <td><a href="<c:url value="/showCheckout" />" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
      
      </tr>
    </tfoot>
  </table>
  </c:if>
</div>
  
</body>
</html>