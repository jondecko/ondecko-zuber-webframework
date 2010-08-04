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
<h2>ListEmployeesSelect</h2>
<div class="main">
	<jsp:include page="/includes/listingHeader.jsp" />
	<form method="POST" action="listEmpByPayroll.do">
	<c:forEach var="result" items="${results}">
		<div class="resultDiv">
			<div class="cell">${result.EMPID}</div>
			<div class="cell">${result.NAME}</div>
			<div class="cell">${result.TITLE}</div>
			<div class="cell">${result.SALARY}</div>
			<div class="cell">${result.ADDRESS}</div>
			<div class="cell">${result.VACATION}</div>
			<div><input type="checkbox" name="selections" value="${result.EMPID}" /></div>
		</div>
	</c:forEach>
	<jsp:include page="/includes/resultFooter.jsp" />
	<div class="footer"><h2>Footer</h2></div>
	<input type="SUBMIT" />
	</form>
</div>

</body>
</html>