<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Inserisci i parametri del nuovo prodotto</h1>

<form action="negozio" method="post">
	Nome:<input type="text" name="nome" /><br><br>
	Quantità:<input type="number"min = "1" name="qta" /><br><br>
	Descrizione:<input type="text" name="descrizione" /><br><br>
	Prezzo:<input type="number" min = "1" name="prezzo" /><br><br>
	<input type="submit" name ="azione" value="Aggiungi" /> <br>
</form>
</body>
</html>