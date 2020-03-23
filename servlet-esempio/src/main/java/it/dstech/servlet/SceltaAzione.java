package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.servlet.repos.DBManagment;

public class SceltaAzione extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		System.out.println(azione);
		if ("aggiungi".equalsIgnoreCase(azione)) {
			req.getRequestDispatcher("creaProdotto.jsp").forward(req, resp);
		} else if ("stampa".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Prodotto> lista = db.getAll();
				req.setAttribute("lista", lista);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			req.getRequestDispatcher("stampa.jsp").forward(req, resp);
		} else if ("vendi".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Prodotto> lista = db.getAll();
				req.setAttribute("lista", lista);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	req.getRequestDispatcher("compraProdotto.jsp").forward(req, resp);
		}else if ("stampaVendite".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Prodotto> lista = db.creaListaVendite();
				req.setAttribute("lista", lista);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			req.getRequestDispatcher("stampaVendite.jsp").forward(req, resp);

	}else if ("rimuovi".equalsIgnoreCase(azione)) {
		try {
			DBManagment db = new DBManagment();
			List<Prodotto> lista = db.getAll();
			req.setAttribute("lista", lista);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
req.getRequestDispatcher("rimuoviProdotto.jsp").forward(req, resp);
}}}
