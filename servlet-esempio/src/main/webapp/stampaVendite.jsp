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

<%List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("lista"); 
for(Prodotto p : listaProdotti){
%>
 <%=p.getNome()%> - <%=p.getQuantità()%> <br><br>

<% } %>

<form action="intro">
<input type="submit" value="Torna in home"> </form>
</body>
</html>