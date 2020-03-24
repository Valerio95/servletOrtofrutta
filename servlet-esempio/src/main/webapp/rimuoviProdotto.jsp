<%@page import="java.util.List"%>
<%@page import="it.dstech.servlet.Prodotto"%>
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
<%=p.getId()%> - <%=p.getNome()%> - <%=p.getQuantità()%> <br><br>

<% } %>

<form action="rimuovi" method="post">
	ID: <input type="number" name="id" /><br><br>
	<input type="submit" value="RIMUOVI"> <br><br>
</form>

<br><br>
<form action="intro">