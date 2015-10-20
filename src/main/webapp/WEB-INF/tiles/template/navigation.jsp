<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<ul>
	<li><a href="<spring:url value="/welcome"/>">Home</a></li>
	<li><a href="<spring:url value="/showMessage"/>">Show Message</a></li>
	
</ul>
<div style="display:block; float:right; width:100px"><security:authorize access="isAuthenticated()"> <a href="<spring:url value="/doLogout"/>">Logout</a>  </security:authorize></div>
