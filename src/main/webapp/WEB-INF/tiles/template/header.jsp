<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<div class="header_content">
	<div class="head_content">
		<h1>Header Content</h1>
		<h1>Header Content</h1>
		<h1>Header Content</h1>
		<h1>Header Content</h1>
		<h1>Header Content</h1>
	</div>
	
	<div class="user"> <security:authorize access="isAuthenticated()">
					
  					Welcome username :  ${pageContext.request.userPrincipal.name}
  					
  					<br/>
  					<a href='<spring:url value="/doLogout"></spring:url>'>Logout</a>
  				
				</security:authorize>
				<security:authorize access="isAnonymous()">
  					<a href="<spring:url value="/Registration"></spring:url>">Register</a>
  				
				</security:authorize>
				</div>
				
	<div class="language">
		Language : <a href="?language=en_US">English</a> | <a
			href="?language=mn_MN">Mongolia</a>
	</div>


</div>
