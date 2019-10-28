package control;
import entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClienteControl {
	Cliente C = new Cliente();
	private static ObservableList<Cliente> ListaCliente = 
			FXCollections.observableArrayList();
	
	public static void adicionar(Cliente C) { 
		ListaCliente.add(C);
	}
	
	public static Cliente pesquisarPorNome(String nome) { 
		for (Cliente C : ListaCliente) { 
			if (C.getCpf().contains(nome)) { 
				return C;
			}
		}
		return null;
	}

	public static void remover(String nome) { 
		for (Cliente C : ListaCliente) { 
			if (C.getNome().contains(nome)) { 
				try {
					ListaCliente.remove(C);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}