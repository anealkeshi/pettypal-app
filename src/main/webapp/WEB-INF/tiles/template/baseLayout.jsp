<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>


</head>

<body>

	<div>
		<div >
			<ul >
				<tiles:insertAttribute name="navigation" />
			</ul>
			<h3>Petty Cash</h3>
		</div>


		<div>
			<h1>
				<tiles:insertAttribute name="heading" />
			</h1>
			<p>
				<tiles:insertAttribute name="tagline" />
			</p>
		</div>

		<div>
			<tiles:insertAttribute name="body" />
		</div>

		<div>
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>
