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
<h1> Creare entitate</h1>
<form:form method="post" 
	action="${pageContext.request.contextPath}/trucks/add"
	modelAttribute="truck">
	
	<label for="brand">BRAND</label>
	<form:input path="brand"/>
	
	<label for="capacity">CAPACITY</label>
	<form:input path="capacity"/>
	
	<label for="accidents">ACCIDENTS</label>
	<form:input path="accidents"/>
	
	
	
	<input type="submit" value="Salveaza" /><br/>

</form:form>
</body>
</html>