<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PettyPal System</title>
</head>
<body>


	<security:authorize access="isAuthenticated()">
					
					<div id="dashboard">
					
					
					
					
					</div>
  					

	</security:authorize>
	<security:authorize access="isAnonymous()">
	
	<h3>
		Welcome to PettyPal System
  					
  					<br />
	</h3>

	</security:authorize>

</body>
</html>
