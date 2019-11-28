package control;
import java.sql.SQLException;

import dao.DaoEndereco;
import dao.DaoException;
import dao.DaoFuncionario;
import dao.DaoFuncionariol;
import dao.DaoGenericaInt;
import entity.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionarioControl {
	Funcionario F = new Funcionario();
	private static ObservableList<Funcionario> ListaFuncionario = 
			FXCollections.observableArrayList();
	
	public static void adicionar(Funcionario F) { 
		try {
			DaoFuncionario iFuncionario = new DaoFuncionariol();
			iFuncionario.adicionarFuncionario(F);
			DaoEndereco iEnd = new DaoEndereco();
			iEnd.adicionarEndereco(F);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Funcionario pesquisarPorCPF(String cpf) { 
		Funcionario Func = new Funcionario();
		try {
			DaoFuncionario iFuncionario = new DaoFuncionariol();
			Func = iFuncionario.pesquisarFuncionario(cpf);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Func;
	}
		
	public static void remover(String cpf) { 
		
	}
	
}