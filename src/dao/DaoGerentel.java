package dao;

import java.util.List;

import entity.Gerente;;

public interface DaoGerentel 
{
	void adicionarGerente(Gerente g) throws DaoException;
	void removerGerente(Gerente g) throws DaoException;
	Gerente pesquisarGerente(int id) throws DaoException;
	List<Gerente> getGerente() throws DaoException;
}
