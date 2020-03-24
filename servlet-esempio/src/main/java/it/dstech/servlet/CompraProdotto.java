package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.servlet.repos.DBManagment;

public class CompraProdotto extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai provato a fare l'accesso all'aggiunta di un prodotto dalla get");
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int qta = Integer.parseInt(req.getParameter("qta")); 
		try {
			DBManagment db = new DBManagment();
			boolean vendiProdotto = db.vendiProdotto(id, qta);
			if(vendiProdotto) {
				req.getRequestDispatcher("welcome.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("messaggio", "quantita insufficente per essere venduta");
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
