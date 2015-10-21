<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register New User</title>
</head>
<body>

<form:form  modelAttribute="newUser" action="Registration" enctype="multipart/form-data">
			<fieldset>

				<form:errors path="*" cssStyle="color:red;" element="div"/>
				<div>
					<label for="firstName"><spring:message code="register.firsname.label"/></label>
					<div >
						<form:input id="firstName" path="firstName" type="text"/>
						<form:errors path="firstName" cssStyle="color:red;"/>
					</div>
				</div>
				
				<div>
					<label for="lastName"><spring:message code="register.lastname.label"/></label>
					<div >
						<form:input id="lastName" path="lastName" type="text"/>
						<form:errors path="lastName" cssStyle="color:red;"/>
					</div>
				</div>
				
				<div>
					<label for="birthDate"><spring:message code="register.birthdate.label"/></label>
					<div >
						<form:input id="birthDate" path="birthDate" type="text"/>
						<form:errors path="birthDate" cssStyle="color:red;"/>
					</div>
				</div>

				
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="productImage"><spring:message code="addProduct.form.productImage.label"/></label>
					<div class="col-lg-10">
						<form:input id="productImage" path="productImage" type="file" />
					</div>
				</div>


				<div>
					<div >
						<input type="submit" id="btnAdd" value ="Register"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
		
		
</body>
</html>
