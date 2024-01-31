<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
DETALII Driver <br/>
<table>
	<tr>
		<td>Id</td>
		<td>${driver.driverid}</td>
	</tr>
	<tr>
		<td>NAME</td>
		<td>${driver.name}</td>
	</tr>
	<tr>
		<td>AGE</td>
		<td>${driver.age}</td>
	</tr>
	<tr>
		<td>Hours</td>
		<td>${driver.hours}</td>
	</tr>

</table>
<a href="<c:url value="/drivers/all"/>">Back</a>

</body>
</html>