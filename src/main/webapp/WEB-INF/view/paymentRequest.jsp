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
				
				<table>
				
				<tr>
					<td class="label">
						<label class="form-label" for="description"><spring:message code="description" /></label>
					</td>
						<td class="data">
							<form:input id="description" path="description" type="text" class="form:input-large"/>
							<form:errors path="description" cssStyle="color: red;"/>
						</td>
				</tr>
				<tr>
					<td class="label">
						<label class="form-label" for="paymentDate"><spring:message code="paymentDate" /></label>
					</td>
					<td class="data">
						<form:input id="paymentDate" path="paymentDate" type="text" class="form:input-large"/>
						<form:errors path="paymentDate" cssStyle="color: red;"/>
					</td>
				</tr>
				<tr>
				<td class="label">
					<label class="control-label col-lg-2" for="totalAmount"><spring:message code="totalAmount" /></label>
					</td>
					
						<td class="data">
							<form:input id="totalAmount" path="totalAmount" type="text" class="form:input-large"/>
							<form:errors path="totalAmount" cssStyle="color: red;"/>
						</td>
					
				</tr>
				<tr>
				<td class="label">
					<label class="label" for="tip"><spring:message code="tip" /></label>
					</td>
					
						<td class="data">
							<form:input id="tip" path="tip" type="text" class="form:input-large"/>
							<form:errors path="tip" cssStyle="color: red;"/>
						</td>
					
				</tr>
				
				<tr>
				<td class="label">
					<label class="label" for="tip"><spring:message code="tax" /></label>
					</td>
					
						<td class="data">
							<form:input id="tax" path="tax" type="text" class="form:input-large"/>
							<form:errors path="tax" cssStyle="color: red;"/>
						</td>
					
				</tr>
				
				<tr >
				<td class="label">
					<label class="label" for="numberOfFriends"><spring:message code="numberOfFriends" /></label>
				</td>
						<td class="data">
							<form:input id="numberOfFriends" path="numberOfFriends" type="text" class="form:input-large"/>
							<form:errors path="numberOfFriends" cssStyle="color: red;"/>
						</td>
					
				</tr>		 
				
				<tr>
				<td class="label">
					<label class="label" for="receiptImage"><spring:message code="payment.receiptImage" /></label>
				</td>
						<td class="data">
							<form:input id="receiptImage" path="receiptImage" type="file" class="form:input-large"/>
							<form:errors path="receiptImage" cssStyle="color: red;"/>
						</td>
					
				</tr>						
				<tr>
				<td colspan="2">
					<div class="button-container">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="<spring:message code='payment.add' />"/>
					</div>
				</td>
				</tr>
				</table>
			</fieldset>
		</form:form>
	</div>