package control;
import java.util.Collection;

import entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClienteControl {
	Cliente C = new Cliente();
	private static ObservableList<Cliente> ListaCliente = 
			FXCollections.observableArrayList();
	
	public ObservableList<Cliente> getListaCliente() {
		return ListaCliente;
	}

	public static void adicionar(Cliente C) { 
		ListaCliente.add(C);
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