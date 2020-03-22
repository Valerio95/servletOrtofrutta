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

<form action="negozio">
  <label for="nomeProdotto">Inserisci il nome del prodotto:</label>
  <input type="text" id="nomeProdotto" name="nomeProdotto"><br><br>
  <label for="quantita">Inserisci la quantità del prodotto:</label>
  <input type="number" id="quantita" name="quantita"><br><br>
   <label for="descrizioneProdotto">Inserisci la descrizione del prodotto:</label>
  <input type="text" id="descrizioneProdotto" name="descrizioneProdotto"><br><br>
  <label for="prezzo">Inserisci il prezzo del prodotto:</label>
  <input type="number" id="prezzo" name="prezzo"><br><br>
  <input type="submit" value="Crea">

</form>

</body>
</html>