package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Funcionario;

public interface DaoFuncionario 
{
	void adicionarFuncionario(Funcionario f) throws DaoException;
	void removerFuncionario(String cpf) throws DaoException;
	Funcionario pesquisarFuncionario(String cpf) throws DaoException;
	List<Funcionario> getFuncionario() throws DaoException;
}
