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
		<td>${shipment.shipmentid}</td>
	</tr>
	<tr>
		<td>NAME</td>
		<td>${shipment.distance}</td>
	</tr>
	<tr>
		<td>AGE</td>
		<td>${shipment.weight}</td>
	</tr>
	<tr>
		<td>Hours</td>
		<td>${shipment.destination}</td>
	</tr>

</table>
<a href="<c:url value="/shipments/all"/>">Back</a>

</body>
</html>