package it.dstech.servlet.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.dstech.servlet.Prodotto;

public class DBManagment {

		private Connection connessione;

		public DBManagment() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String password = "95asroma"; 
			String username = "root"; 
			String url = "jdbc:mysql://localhost:3306/magazzinoortofrutticolo?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
			this.connessione = DriverManager.getConnection(url, username, password);
		}

		public void addProdotto(Prodotto p) throws SQLException {
			PreparedStatement controlloProdotti = this.connessione.prepareStatement("select * from prodotti ");
			ResultSet executecontrolloProdotti = controlloProdotti.executeQuery();
			String nome="";
			int quantità=0;
			while (executecontrolloProdotti.next()) {
				nome=executecontrolloProdotti.getString(2);
				quantità=executecontrolloProdotti.getInt(3);
				}
			if(p.getNome().equalsIgnoreCase(nome)) {
				PreparedStatement updateQuery = this.connessione.prepareStatement("Update prodotti set quantità = ? where nome = ?");
				updateQuery.setInt(1, p.getQuantità()+quantità);
				updateQuery.setString(2, p.getNome());
				updateQuery.execute();
			}
			else {
			PreparedStatement prepareStatement = this.connessione.prepareStatement("INSERT INTO prodotti(nome, quantità, descrizione, prezzo) VALUES ( ?, ?, ?, ?);");
			prepareStatement.setString(1, p.getNome());
			prepareStatement.setInt(2, p.getQuantità());
			prepareStatement.setString(3, p.getDescrizione());
			prepareStatement.setInt(4, p.getPrezzo());
			prepareStatement.execute();
			PreparedStatement prepareStatement2 = this.connessione.prepareStatement("select Max(id) from prodotti where nome = ?");
			prepareStatement2.setString(1, p.getNome());
			ResultSet executeQuery = prepareStatement2.executeQuery();
			int id=0;
			while (executeQuery.next()) {
			id=	executeQuery.getInt(1);
			}
			PreparedStatement prepareStatement3 = this.connessione.prepareStatement("INSERT INTO prodotti_venduti(id_prodotti_venduti) VALUES ( ?);");
			prepareStatement3.setInt(1,id);
			prepareStatement3.execute();
			}
		}
		public void rimuoviProdotto(int id) throws SQLException {
			PreparedStatement prepareStatement = this.connessione.prepareStatement("delete from prodotti where id = ? limit 1");
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
		}

		public boolean vendiProdotto(int id, int qta) throws SQLException {
			PreparedStatement prepareStatement = this.connessione.prepareStatement("select * from prodotti where id = ? limit 1");
			prepareStatement.setInt(1, id);
			ResultSet executeQuery = prepareStatement.executeQuery();
			Prodotto prodottoDB = new Prodotto();
			while (executeQuery.next()) {
				prodottoDB.setId(executeQuery.getInt(1));
				prodottoDB.setQuantità(executeQuery.getInt(3));
				prodottoDB.setNome(executeQuery.getString(2));
			}

			if (qta > prodottoDB.getQuantità()) {
				return false;
			}

			PreparedStatement updateQuery = this.connessione.prepareStatement("Update prodotti set quantità = ? where id = ?");
			updateQuery.setInt(1, prodottoDB.getQuantità() - qta);
			updateQuery.setInt(2, prodottoDB.getId());
			updateQuery.execute();
			PreparedStatement prepareStatement2 = this.connessione.prepareStatement("select * from prodotti_venduti where id_prodotti_venduti = ?");
			prepareStatement2.setInt(1, id);
			ResultSet executeQuery2 = prepareStatement2.executeQuery();
			int qta2=0;
			while (executeQuery2.next()) {
				qta2=executeQuery2.getInt(2);
			}
			PreparedStatement updateQuery2 = this.connessione.prepareStatement("Update prodotti_venduti set numero_vendite = ? where id_prodotti_venduti = ?");
			updateQuery2.setInt(1,qta+qta2);
			updateQuery2.setInt(2, prodottoDB.getId());
			updateQuery2.execute();
			return true;

		}

		public List<Prodotto> getAll() throws SQLException {
			PreparedStatement updateQuery = this.connessione.prepareStatement("select * from prodotti;");
			ResultSet executeQuery = updateQuery.executeQuery();
			List<Prodotto> elenco = new ArrayList<>();
			while(executeQuery.next()) {
				Prodotto temp = new Prodotto();
				temp.setId(executeQuery.getInt(1));
				temp.setNome(executeQuery.getString(2));
				temp.setQuantità(executeQuery.getInt(3));
				temp.setDescrizione(executeQuery.getString(4));
				temp.setPrezzo(executeQuery.getInt(5));

				elenco.add(temp);
			}
			return elenco;
		}
		public List<Prodotto> creaListaVendite() throws SQLException {
			PreparedStatement updateQuery = this.connessione.prepareStatement("select * from prodotti_venduti;");
			ResultSet executeQuery = updateQuery.executeQuery();
			List<Prodotto> elenco = new ArrayList<>();
			Prodotto temp = new Prodotto();
			int id=0;
			while(executeQuery.next()) {
				
				id= executeQuery.getInt(3);
				temp.setQuantità(executeQuery.getInt(2));
				PreparedStatement updateQuery2 = this.connessione.prepareStatement("select * from prodotti where id=?;");
				updateQuery2.setInt(1, id);
				ResultSet executeQuery2 = updateQuery2.executeQuery();
				while(executeQuery2.next()) {
					temp.setNome(executeQuery2.getString(2));
					elenco.add(temp);
				}
				
			}
			
			return elenco;
		}
	}

