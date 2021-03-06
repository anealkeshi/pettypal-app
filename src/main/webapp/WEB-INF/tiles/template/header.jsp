<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

	<div class="head_content">
	<a href="<spring:url value="/"></spring:url>"> <img src='<spring:url value="/images/cashlogo.png"></spring:url>' alt="PettyPal" height="100" width="200"> </a>
	
	</div>
	
	
				
	<div class="language">
		Language : <a href="?language=en_US">English</a> | <a
			href="?language=mn_MN">Монгол хэл</a>
			
			<div style="position: relative; vertical-align: bottom; text-align:right; padding-top:10px"> <security:authorize access="isAuthenticated()">
					
  					Welcome username :  ${pageContext.request.userPrincipal.name}
  					
  					<br/>
  					<a href='<spring:url value="/doLogout"></spring:url>'>Logout</a>
  				
				</security:authorize>
				<security:authorize access="isAnonymous()">
  					<div style="color:#339900"><a href="<spring:url value="/Registration"></spring:url>"><spring:message code="register.add.btn"> </spring:message></a>|
  					<a href="<spring:url value="/login"></spring:url>"><spring:message code="login.add.btn"> </spring:message></a>
  				</div>
				</security:authorize>
				</div>
	</div>

