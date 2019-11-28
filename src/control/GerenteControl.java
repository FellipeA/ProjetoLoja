package control;

import java.sql.SQLException;

import dao.DaoEndereco;
import dao.DaoException;
import dao.DaoGerente;
import dao.DaoGerentel;
import entity.Gerente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GerenteControl 
{
	Gerente G = new Gerente();
	private static ObservableList<Gerente> ListaGerente = 
			FXCollections.observableArrayList();
	
	public static void adicionar(Gerente G) { 
		try {
			DaoGerentel iGerente = new DaoGerente();
			iGerente.adicionarGerente(G);
			//DaoEndereco iEnd = new DaoEndereco();
			//iEnd.adicionarEndereco(G);
			ListaGerente.add(G);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
