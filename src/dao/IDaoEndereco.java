package dao;

import java.util.List;

import entity.Cliente;
import entity.Funcionario;

public interface IDaoEndereco {
		void adicionarEndereco(Cliente f) throws DaoException;
		void adicionarEndereco(Funcionario f) throws DaoException;
		
}
