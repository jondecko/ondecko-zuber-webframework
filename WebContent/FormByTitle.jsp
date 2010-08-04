<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<jsp:include page="/includes/cssIncludes.jsp"></jsp:include>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
<h2>Form By Title</h2>
<jsp:include page="/includes/homeLink.jsp" />

<form method="POST" action="listEmpByTitle.do">
Title:
<select name="title">
	<c:forEach var="option" items="${results}">
	<option value="${option.TITLE}">${option.TITLE}</option>
	</c:forEach>
</select>

<br />
<br />
<input type="SUBMIT" />
</form>

</body>
</html>