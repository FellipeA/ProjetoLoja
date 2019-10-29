package control;
import entity.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionarioControl {
	Funcionario F = new Funcionario();
	private static ObservableList<Funcionario> ListaFuncionario = 
			FXCollections.observableArrayList();
	
	public static void adicionar(Funcionario F) { 
		ListaFuncionario.add(F);
	}
	
	public static Funcionario pesquisarPorCPF(String cpf) { 
		for (Funcionario F : ListaFuncionario) { 
			if (F.getCpf().contains(cpf)) {
				return F;
		}
	}
		return null;
}
	public static void remover(String cpf) { 
		for (Funcionario F : ListaFuncionario) { 
			if (F.getCpf().contains(cpf)) { 
				try {
					ListaFuncionario.remove(F);
					System.out.println("REMOVIDO COM SUCESSO");
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		}
	}
	
}