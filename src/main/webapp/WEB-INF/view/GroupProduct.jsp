<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
      <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/GroupProduct.css"/>">
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
 
<title>Products</title>

              <fmt:setLocale value="${sessionScope.local}" />
              <fmt:setBundle basename="localization.local" var="loc" />

              <fmt:message bundle="${loc}" key="local.Product.stock" var="stock" />
              <fmt:message bundle="${loc}" key="local.groupProduct" var="count" />

</head>
<body>


    <header>
    
    <jsp:include page="header.jsp"/>

   </header>
   
   <main>
   
   <jsp:include page="menu.jsp"/>
   
   </main>
   
 <div class="container">

    <div class="product-wrap">
 
         <div class="product-count">
             ${count} ${fn:length(groupProduct)} 
        
        
        </div>

<c:forEach items="${groupProduct}" var="element">


<div class="product-item"> 

        <c:url var="openLink" value="/showProductInfo" >
                  <c:param name="productId" value="${element.id}" ></c:param>
        </c:url> 

       <a href="${openLink}">
      <img src="<c:url value="resources/img/"/>${element.getProductImageByIndex(0).image}">  ${element.title} 
     
  <div class="product-list"> 
        <span class="price">$<fmt:formatNumber value="${element.price}" pattern=".00"/></span>
            <c:if test="${ element.quantity == 0}">    
                  <h5>${stock}</h5>
           </c:if>  
  </div></a>
</div>

</c:forEach>
</div>
</div>
</body>
</html>