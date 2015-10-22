<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>
	<label>Add Share</label>
	<h2>Total Amount to share: ${payment.totalAmount}</h2>
	<table id="shareTable">
		<spring:url value="/payment/share" var="paymentShare" />
		<form:form method="POST" action="${paymentShare}"
			modelAttribute="payment">
			<thead>
				<tr>
					<th></th>
					<th>Name</th>
					<th>Share Amount</th>
					<th>Payed Amount</th>
				</tr>
			</thead>
			<c:forEach var="userPayment" items="${payment.userPayments}"
				varStatus="status">
				<tr>
					<td><form:input path="userPayments[${status.index}].name" />
						<button type="button" class="tableButton"
							onclick="searchUserByEmail(event); return false;">Search</button>
						<form:hidden path="userPayments[${status.index}].userId" /></td>

					<td></td>
					<td><form:input
							path="userPayments[${status.index}].shareAmount" /></td>
					<td><form:input
							path="userPayments[${status.index}].payedAmount" /></td>
				</tr>


			</c:forEach>
			<form:button>Add Share</form:button>
		</form:form>
	</table>

</div>

