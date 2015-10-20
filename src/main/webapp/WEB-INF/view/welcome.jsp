<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<h3>
	welcome.springmvc :
	<spring:message code="welcome.springmvc" text="default text" />
</h3>

<p>Current Locale : ${pageContext.response.locale}</p>

