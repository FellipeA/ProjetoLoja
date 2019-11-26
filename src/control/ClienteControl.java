package control;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DaoCliente;
import dao.DaoClienteImp;
import dao.DaoEndereco;
import dao.DaoException;
import entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClienteControl {
	private static ObservableList<Cliente> ListaCliente = 
			FXCollections.observableArrayList();
	
	public List<Cliente> getListaCliente() {
		List<Cliente> clientes = new LinkedList();
		try {
			DaoCliente iCliente = new DaoClienteImp();
			clientes = iCliente.getClientes();
			
		} catch (ClassNotFoundException | DaoException | SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	

	public static void adicionar(Cliente c) 
	{
		try 
		{
			DaoCliente iCliente = new DaoClienteImp();
			iCliente.adicionarCliente(c);
			DaoEndereco iEnd = new DaoEndereco();
			iEnd.adicionarEndereco(c);
			ListaCliente.add(c);
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{	
			e.printStackTrace();
		}
	}
	
	public static Cliente pesquisarPorCPF(String cpf) { 
		Cliente C = new Cliente();
		try {
			DaoCliente iCliente = new DaoClienteImp();
			C = iCliente.pesquisarCliente(cpf);
		} catch (ClassNotFoundException | DaoException | SQLException e) {
			e.printStackTrace();
		}
		return C;
	} 
	
	public static void remover(String cpf) throws ClassNotFoundException, SQLException { 
		try {
			DaoCliente iCliente = new DaoClienteImp();
			iCliente.removerCliente(pesquisarPorCPF(cpf));
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	
}