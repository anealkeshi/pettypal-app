<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
<div style="text-align: center; padding:20px; width: 100px; margin:auto;">
    <div>
		<div >
    		<div >
			  	<div>
			    	<h3>Please sign in</h3>
			    	<br/>
			 	</div>
			  	<div  >
			  	<c:if test="${not empty error}">
					<div style="color:red">
						<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
					</div>
				</c:if>
			    	<form action="<spring:url value="/postLogin"></spring:url>" method="post">
                    <fieldset>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
			    	  	<div>
			    		    <input placeholder="User Name" name='username' type="text">
			    		</div>
			    		<div >
			    			<input placeholder="Password" name='password'  type="password" value="">
			    		</div>
			    		<div style="text-align: right"><input type="submit" value="Login"></div>
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
