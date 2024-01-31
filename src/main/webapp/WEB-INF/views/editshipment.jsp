<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Editare entitate</h1>
<form:form method="post" 
	action="${pageContext.request.contextPath}/shipments/edit"
	modelAttribute="shipment">
	
	<label for="shipmentid">ID</label>
	<form:input path="shipmentid"/>
	
	<label for="distance">DISTANCE</label>
	<form:input path="distance"/>
	
	<label for="weight">WEIGHT</label>
	<form:input path="weight"/>
	
	<label for="destination">DESTINATION</label>
	<form:input path="destination"/>
	
	<input type="submit" value="Salveaza" /><br/>

</form:form>
</body>
</html>