package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.servlet.repos.DBManagment;

public class CreaProdotto extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai provato a fare l'accesso all'aggiunta di un prodotto dalla get");
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		int qta = Integer.parseInt(req.getParameter("qta"));
		String descrizione =req.getParameter("descrizione");
		int prezzo = Integer.parseInt(req.getParameter("prezzo"));
		Prodotto p = new Prodotto();
		p.setNome(nome);
		p.setQuantità(qta);
		p.setDescrizione(descrizione);
		p.setPrezzo(prezzo);
		try {
			DBManagment dbManagment = new DBManagment();
			dbManagment.addProdotto(p);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);

	}
}