<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
   <head>
   
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/menucss.css"/>">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">


    <title>Insert title here</title>


                <fmt:setLocale value="${sessionScope.local}" />
                <fmt:setBundle basename="localization.local" var="loc" />

               <fmt:message bundle="${loc}" key="local.message" var="message" />
               <fmt:message bundle="${loc}" key="local.menu.men" var="menu_men" />
               <fmt:message bundle="${loc}" key="local.menu.women" var="menu_women" />
               <fmt:message bundle="${loc}" key="local.menu.cart" var="menu_cart" />
               <fmt:message bundle="${loc}" key="local.menu.signIn" var="menu_signIn" />
               <fmt:message bundle="${loc}" key="local.menu.signOut" var="menu_signOut" />
               <fmt:message bundle="${loc}" key="local.menu.cart" var="cart" />

   </head>
   
   <body>


     <nav class="navbar navbar-default navbar-static">
            
            <div class="navbar-header">
		        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".js-navbar-collapse">
			           <span class="sr-only"></span>
			           <span class="icon-bar"></span>
			           <span class="icon-bar"></span>
			           <span class="icon-bar"></span>
		        </button>
	
	      </div>
	
	      <div class="collapse navbar-collapse js-navbar-collapse">
	
		       <ul class="nav navbar-nav">
		             <li class="dropdown dropdown-large" >
             
				          <a href="<c:url value="/showMainPage"/>" class="store">STORE</a>
				    
                    </li>
             
               <c:forEach items="${groupCategory}" var="element">
             
                     <li class="dropdown dropdown-large">
             
				   <c:url var="openLink" value="/subcategory" >
				   
				        <c:param name="categoryId" value="${element.id}"/>
				   
				   </c:url>
				   
				   <a href="${openLink}">${element.title}</a>
		    
                    </li>
            
             </c:forEach>

			
			        <li class="dropdown dropdown-large" >
             
				         <a href="#">Sale</a>
                    </li>
            
	        </ul>
		    <div class="user">
            
                     <c:if test = "${user.name != null }">
                        <a  href="<c:url value="showUserInfo"/>">${user.name}</a>
                            <a href="<c:url value="/SignOut"/>"> ${menu_signOut} </a>
                    </c:if>
                     <c:if test = "${user.email == null}">
                            <a href="<c:url value="/showSignIn"/>"> ${menu_signIn} </a>
                     </c:if>
                    
            
            </div>
            
            
            <div class="user">
            
                 <a href="<c:url value="showCartPage"/>">${cart}
                 <svg class="bi bi-bag" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M14 5H2v9a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V5zM1 4v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4H1z"/>
                    <path d="M8 1.5A2.5 2.5 0 0 0 5.5 4h-1a3.5 3.5 0 1 1 7 0h-1A2.5 2.5 0 0 0 8 1.5z"/>
                </svg>
               </a>
            
            </div>
            
            <div class="user">
            
                 <a href="/showFavorites">
                  <svg class="bi bi-heart" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                   <path fill-rule="evenodd" d="M8 2.748l-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                 </svg>
               </a>
            </div>
	</div><!-- /.nav-collapse -->
</nav>

</body>
</html>