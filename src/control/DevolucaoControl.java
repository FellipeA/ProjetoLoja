package control;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DaoDevolucao;
import dao.DaoDevolucaoI;
import dao.DaoException;
import entity.Devolucao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DevolucaoControl 
{
	private ObservableList<Devolucao> listaDevolucao = FXCollections.observableArrayList();
	
	public void adicionar(Devolucao d) { 
		try {
			DaoDevolucaoI IDevolucao = new DaoDevolucao();
			IDevolucao.adicionarDevolucao(d);
			listaDevolucao.add(d);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Devolucao pesquisarPorNome(String Cliente) { 
		Devolucao d = new Devolucao();
		try {
			DaoDevolucaoI iDevolucao = new DaoDevolucao();
			d = iDevolucao.pesquisarDevolucao(Cliente);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	
	public List<Devolucao> getListaDevolucao() {
		List<Devolucao> devolucoes = new LinkedList();
		try {
			DaoDevolucaoI iDevolucao = new DaoDevolucao();
			devolucoes = iDevolucao.getDevolucao();
			
		} catch (ClassNotFoundException | DaoException | SQLException e) {
			e.printStackTrace();
		}
		return devolucoes;
		//Pronto

	}
}
