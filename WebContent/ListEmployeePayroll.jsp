<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
<head>
	<jsp:include page="/includes/cssIncludes.jsp" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<c:set var="sum" value="${0}" />	
<div class="main">
	<jsp:include page="/includes/listingHeader.jsp" />
	<c:forEach var="result" items="${results}">
		<div class="resultDiv">
			<div class="cell">${result.EMPID}</div>
			<div class="cell">${result.NAME}</div>
			<div class="cell">${result.TITLE}</div>
			<div class="cell">${result.SALARY}</div>
			<div class="cell">${result.ADDRESS}</div>
			<div class="cell">${result.VACATION}</div>
		</div>
		<c:set var="sum" value="${sum + result.SALARY}" />
	</c:forEach>
	<div class="resultHeader">
		<div class="cell"><p></p></div>
		<div class="cell"><p></p></div>
		<div class="cell"><p></p></div>
		<div class="cell">${sum}</div>
		<div class="cell"><p></p></div>
		<div class="cell"><p></p></div>
	</div>

<div class="footer"><h2>Footer</h2></div>
</div>

</body>
</html>