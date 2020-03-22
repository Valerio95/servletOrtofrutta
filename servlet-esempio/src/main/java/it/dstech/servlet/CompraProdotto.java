package it.dstech.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompraProdotto extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Prodotto> prodotti = creaListaProdotti();
			req.setAttribute("prodotto", prodotti);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("compraProdotti.jsp").forward(req, resp);
	}
	
	private List<Prodotto> creaListaProdotti() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "95asroma";
		String username = "root";
		String url = "jdbc:mysql://localhost:3306/magazzinoortofrutticolo?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		PreparedStatement statement = connessione
				.prepareStatement("select nome from prodotti");
		ResultSet risultatoQuery = statement.executeQuery();
		List<Prodotto> elencoProdotti = new ArrayList<>();
		
		while (risultatoQuery.next()) {
			String nome = risultatoQuery.getString("nome");
			int quantità=risultatoQuery.getInt("quantità");
			Prodotto nuovoProdotto=new Prodotto(nome,quantità);
			elencoProdotti.add(nuovoProdotto);
		}
		connessione.close();
		return elencoProdotti;
		

	}
	
}
