<%@page import="it.dstech.servlet.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%=request.getAttribute("messaggio")%> 


<form action="intro">
<input type="submit" value="Torna in home"> </form>
</body>
</html>