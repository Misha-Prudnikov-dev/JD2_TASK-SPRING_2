<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Favorites</title>

 <link rel="stylesheet" type="text/css" href="./GroupProduct.css"/>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
 
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
            
             ${fn:length(groupProductFavorites)} 
        
        
        </div>

<c:forEach items="${groupProductFavorites}" var="element">


<div class="product-item"> 
       <a href="Controller?command=go_to_product_info&productId=${element.id}">
      <img src="././img/${element.productImage.image}">${element.title} 
      
  <div class="product-list"> 
        <span class="price">$<fmt:formatNumber value="${element.price}" pattern=".00"/>
        
        <a href="Controller?command=delete_product_favorites&productId=${element.id}">
        <svg class="bi bi-trash" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
              <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
              <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
        </svg>
        </a>
        
        </span>
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