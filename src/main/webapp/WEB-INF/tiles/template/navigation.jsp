<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<ul>
	<li><a href="<spring:url value="/welcome"/>"><spring:message code="link.home"> </spring:message></a></li>
	<li><a href="<spring:url value="/payment"/>"><spring:message code="link.create.payment"> </spring:message></a></li>
	
</ul>