package control;

import java.sql.SQLException;

import dao.DaoCliente;
import dao.DaoClienteImp;
import dao.DaoException;
import entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClienteControl {
	private static ObservableList<Cliente> ListaCliente = 
			FXCollections.observableArrayList();
	
	public ObservableList<Cliente> getListaCliente() {
		return ListaCliente;
	}

	public static void adicionar(Cliente c) 
	{
		try 
		{
			DaoCliente iCliente = new DaoClienteImp();
			iCliente.adicionarCliente(c);
			ListaCliente.add(c);
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{	
			e.printStackTrace();
		}
	}
	
	public static Cliente pesquisarPorCPF(String cpf) { 
		for (Cliente C : ListaCliente) { 
			if (C.getCpf().contains(cpf)) {
				return C;
		}
	}
		return null;
}
	
	public static void remover(String cpf) { 
		for (Cliente C : ListaCliente) { 
			if (C.getCpf().contains(cpf)) { 
				try {
					ListaCliente.remove(C);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}