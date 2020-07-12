<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="by.htp.ishop.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>SUBCATEGORY</title>
</head>
<body>
    
    
    
      <header>
    
    <jsp:include page="header.jsp"/>

   </header>
   
   <main>
   
   <jsp:include page="menu.jsp"/>
   
   </main>
   

   
       <div class="container"> 
       
            <ul class="list-inline">
               <c:forEach items="${groupSubcategory}" var="element">
                  
                  <li>
                      <h4>
                           <c:url var="openLink" value="/groupProductBySubcategory" >
                                <c:param name="subcategory" value="${element.id}" ></c:param>
                          </c:url>
                  
                          <a href="${openLink}">${element.title}</a>
                  
                    </h4>
               </li>
              
              </c:forEach> 
           </ul>   
       
       </div>


</body>
</html>