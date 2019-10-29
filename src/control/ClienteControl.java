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
	
	public static Cliente pesquisarPorCPF(String cpf) { 
		for (Cliente C : ListaCliente) { 
			if (C.getCpf().contains(cpf)) {
				return C;
		}
			else {
				System.out.println("Cadastrado Não Encontrado");
			}
	}
		return null;
}
	public static void remover(String cpf) { 
		for (Cliente C : ListaCliente) { 
			if (C.getCpf().contains(cpf)) { 
				try {
					ListaCliente.remove(C);
					System.out.println("REMOVIDO COM SUCESSO");
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		}
	}
	
}