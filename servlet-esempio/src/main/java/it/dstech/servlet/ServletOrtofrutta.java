package it.dstech.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletOrtofrutta extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nomeProdotto");
		int quantità = Integer.parseInt(req.getParameter("quantita"));
		String descrizione = req.getParameter("descrizioneProdotto");
		int prezzo = Integer.parseInt(req.getParameter("prezzo"));

		try {
			creaProdotto(nome, quantità, descrizione, prezzo);
			req.getAttribute("confermaCreazione");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("confermaCreazione.jsp").forward(req, resp);


	}
	
	
	
	public static void creaProdotto(String nome, int quantità, String descrizione,int prezzo) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "95asroma";
		String username = "root";
		String url = "jdbc:mysql://localhost:3306/magazzinoortofrutticolo?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		String queryInserimentoProdotto= "INSERT INTO prodotti(nome, quantità, descrizione, prezzo) VALUES ( ?, ?, ?, ?);";
		PreparedStatement statement = connessione.prepareStatement(queryInserimentoProdotto);
		statement.setString(1, nome);
		statement.setInt(2, quantità);
		statement.setString(3, descrizione);
		statement.setInt(4, prezzo);

		statement.execute();
		
		connessione.close();
		
	}

}

