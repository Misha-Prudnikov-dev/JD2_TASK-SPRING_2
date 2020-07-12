<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/menucss.css"/>">

<title></title>

                <fmt:setLocale value="${sessionScope.local}" />
                <fmt:setBundle basename="localization.local" var="loc" />

               <fmt:message bundle="${loc}" key="local.message" var="message" />
               <fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
               <fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
                              
               <fmt:message bundle="${loc}" key="local.header.line.delivery" var="delivery" />
               <fmt:message bundle="${loc}" key="local.header.line.payment" var="payment" />
               <fmt:message bundle="${loc}" key="local.header.line.about_as" var="about_as" />
               <fmt:message bundle="${loc}" key="local.header.line.faq" var="faq" />
               <fmt:message bundle="${loc}" key="local.header.line.contacts" var="contacts" />
               <fmt:message bundle="${loc}" key="local.header.line.support" var="support" />
               
               

</head>
<body>


    <div class="list-inline">
     
         <li><a href="delivery.jsp" target="_blank" title="${delivery}" >${delivery}</a></li>
         <li><a href="payment.jsp" target="_blank" title="${payment}" >${payment}</a></li>
         <li><a href="faq.jsp" target="_blank" title="${faq}" >${faq}</a></li>
         <li><a href="AboutAs.jsp" target="_blank" title="${about_as}" >${about_as}</a></li>
         <li><a href="Support.jsp" target="_blank" title="${support}" >${support}</a></li>
         <li><a href="Contacts.jsp" target="_blank" title="${contacts}" >${contacts}</a></li>
         
     

  <div class="local">
	 <table>
          <tr>
             <td>
	               <form action="Controller" method="post"> 
	                      <input type="hidden" name="command" value="changeLocal"/>
	 	                  <input type="hidden" name="local" value="ru" /> 
		                  <input type="submit" class="btn btn-primary btn-xs"  value="${ru_button}"/><br>
	              </form>
 
                        
             </td>
              <td>

  	                <form action="Controller" method="post">
	                       <input type="hidden" name="command" value="changeLocal"/>
 		                   <input type="hidden" name="local" value="en" />
 		                   <input type="submit" class="btn btn-primary btn-xs" value="${en_button}" /><br>
                    </form>
             </td>
       </tr>
   </table>
  
	</div> 

</body>
</html>