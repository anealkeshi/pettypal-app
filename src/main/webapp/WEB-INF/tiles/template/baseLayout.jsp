<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:url value="/resources/css/pettyapp.css" var="appCss" />
<link rel="stylesheet" href="${appCss}">

<title><tiles:insertAttribute name="title" /></title>


</head>

<body>

	<div class="container">

		<div class="header">
			<tiles:insertAttribute name="heading" />
		</div>
		<div class="navigation">
			<ul>
				<tiles:insertAttribute name="navigation" />
			</ul>
		</div>

		<div class="content">
			<tiles:insertAttribute name="body" />
		</div>

		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>
