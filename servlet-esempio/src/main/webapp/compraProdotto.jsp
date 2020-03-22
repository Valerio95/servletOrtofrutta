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

<% List<Prodotto> prodotto = (List<Prodotto>) request.getAttribute("prodotto"); %>

<form action="compra">
  <label for="nomeParametro">Inserisci il prodotto:</label>
	<select name = "nomeParametro">
	
	<% for (Prodotto prod : prodotto){%>
	  <option value="<%=prod %>"><%=prod %></option>
	  
	  <% } %>
	</select>
	<br>
  <label for="limit">Inserisci quante città vuoi vedere:</label>
  <input type="number" id="limit" min = "1"  max = "15" name="limit"><br><br>
  <input type="submit" value="Mostra">

</form>



</body>
</html>