<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>ProductCard</title>

    <!-- Bootstrap -->
	<link rel="stylesheet" href="<spring:url value="/resources/ProductInfo.css"/>">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

              <fmt:setLocale value="${sessionScope.local}" />
              <fmt:setBundle basename="localization.local" var="loc" />

              <fmt:message bundle="${loc}" key="local.productInfo.color" var="color" />
              <fmt:message bundle="${loc}" key="local.productInfo.size" var="size" />
              <fmt:message bundle="${loc}" key="local.productInfo.weight" var="weight" />
              <fmt:message bundle="${loc}" key="local.cart.quantity" var="quantity" />
              <fmt:message bundle="${loc}" key="local.productInfo.addToCart" var="addToCart" />
              <fmt:message bundle="${loc}" key="local.Product.stock" var="stock" />
              <fmt:message bundle="${loc}" key="local.productInfo.manufacturer.country" var="country" />
              <fmt:message bundle="${loc}" key="local.productInfo.manufacturer.brand" var="brand" />

</head>
<body>

    <header>
    
        <jsp:include page="header.jsp"/>

   </header>
   
   <main>
   
       <jsp:include page="menu.jsp"/>
   
   </main>
   
  <div class="body">
  <div class="product_img">
    <img src="<c:url value="resources/img/"/>${productInfo.getProductImageByIndex(0).image}" alt=""/>
  </div>
  <div class="product_info">
    <div class="seller_info">
    </div>
    
    <div class="product_title">${productInfo.title}</div>
    <div class="product_model">${productInfo.code}</div>
    
    <div class="product_price">
    
  <!--  <c:url var="openLink" value="/#" />

    
    <a href="Controller?command=add_product_favorites&productId=${productInfo.id}" >
     <svg class="bi bi-heart" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
     <path fill-rule="evenodd" d="M8 2.748l-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
     </svg>
    </a> -->
    
    </div>
    
    <div class="product_price">$<fmt:formatNumber value="${productInfo.price}" pattern=".00"/></div>
    <div class="product_descr">${productInfo.description}</div>
    
    <div class="product_color">${color} : ${productInfo.productDetail.color}</div>
    <div class="product_color">${size} : ${productInfo.productDetail.size}</div>
      
    <div class="product_color">${weight} : ${productInfo.productDetail.weight}</div>
    <div class="product_color">${brand} : ${productInfo.manufacturer.title}</div>
    
    <div class="product_color">${country} : ${productInfo.manufacturer.country}</div>
    <div class="product_quantity">${quantity}
    <br> 
   </div>
    
    <div class="add_to_cart">
          <c:if test="${productInfo.quantity>0}">
          <c:url var="urlVar" value="/addToCart"  />
          
                  <form:form action="${urlVar}" method="post"> 
	 	                  <input type="hidden" name="productId" value="${productInfo.id}" /> 
		                  <input type="number" class="form-control text-center" name="quantityProduct" min="1" max="${productInfo.quantity}" value=1>
                          <br>
		                 <input type="submit" class="btn btn-primary btn-lg"  value="${addToCart}"/><br>
	           </form:form>
    
       </c:if>
       <c:if test="${productInfo.quantity==0}">
       
               <h3>${stock}</h3>
       </c:if>
   </div>
    
   </div>
  </div>
</body>
</html>