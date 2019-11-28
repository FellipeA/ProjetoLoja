package dao;
import java.util.List;
import entity.Cliente;
import entity.Devolucao;

public interface DaoDevolucaoI {
		void adicionarDevolucao(Devolucao Dev) throws DaoException;
		Devolucao pesquisarDevolucao(String cliente) throws DaoException;
		List<Devolucao> getDevolucao() throws DaoException;
		//Pronto

}
