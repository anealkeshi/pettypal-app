<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="paymentRequest" /></h2>

	<div class="container">
		<form:form  modelAttribute="newPayment" class="form-horizontal" enctype="multipart/form-data" >
			<fieldset>
				<legend><spring:message code="createPayment" /></legend>

				<form:errors path="*" cssStyle="color: red;" element="div"/>
				<div class="form-group">
					<label class="form-label" for="description"><spring:message code="description" /></label>
					<div class="form-input">
						<form:input id="description" path="description" type="text" class="form:input-large"/>
						<form:errors path="description" cssStyle="color: red;"/>
					</div>
				</div>
				<div class="form-group">
					<label class="form-label" for="paymentDate"><spring:message code="paymentDate" /></label>
					<div class="form-input">
						<form:input id="paymentDate" path="paymentDate" type="text" class="form:input-large"/>
						<form:errors path="paymentDate" cssStyle="color: red;"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="totalAmount"><spring:message code="totalAmount" /></label>
					
						<div class="form-input">
							<form:input id="totalAmount" path="totalAmount" type="text" class="form:input-large"/>
							<form:errors path="totalAmount" cssStyle="color: red;"/>
						</div>
					
				</div>
				<div class="form-group">
					<label class="label" for="tip"><spring:message code="tip" /></label>
					
						<div class="form-input">
							<form:input id="tip" path="tip" type="text" class="form:input-large"/>
							<form:errors path="tip" cssStyle="color: red;"/>
						</div>
					
				</div>
				
				<div class="form-group">
					<label class="label" for="tip"><spring:message code="tax" /></label>
					
						<div class="form-input">
							<form:input id="tax" path="tax" type="text" class="form:input-large"/>
							<form:errors path="tax" cssStyle="color: red;"/>
						</div>
					
				</div>
				
				<div class="form-group">
					<label class="label" for="numberOfFriends"><spring:message code="numberOfFriends" /></label>
					
						<div class="form-input">
							<form:input id="numberOfFriends" path="numberOfFriends" type="text" class="form:input-large"/>
							<form:errors path="numberOfFriends" cssStyle="color: red;"/>
						</div>
					
				</div>		
				
				<div class="form-group">
					<label class="label" for="receiptImage"><spring:message code="payment.receiptImage" /></label>
					
						<div class="form-input">
							<form:input id="receiptImage" path="receiptImage" type="file" class="form:input-large"/>
							<form:errors path="receiptImage" cssStyle="color: red;"/>
						</div>
					
				</div>			
				<div class="form-group">
					<div class="button-container">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="<spring:message code='payment.add' />"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</div>