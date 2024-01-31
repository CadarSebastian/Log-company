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
DETALII Truck <br/>
<table>
	<tr>
		<td>Id</td>
		<td>${truck.truckid}</td>
	</tr>
	<tr>
		<td>Brand</td>
		<td>${truck.brand}</td>
	</tr>
	<tr>
		<td>Capacity</td>
		<td>${truck.capacity}</td>
	</tr>
	<tr>
		<td>Accidents</td>
		<td>${truck.accidents}</td>
	</tr>

</table>
<a href="<c:url value="/trucks/all"/>">Back</a>

</body>
</html>