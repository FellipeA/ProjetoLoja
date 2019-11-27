package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Cliente;
import entity.Endereco;

public class DaoClienteImp implements DaoCliente
{
	private Connection conexao;
	
	public DaoClienteImp() throws DaoException, ClassNotFoundException, SQLException
	{
		try {
			DaoGenericaInt i = new DaoGenerica();
			conexao = i.getConnection();
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	public void adicionarCliente(Cliente cli) throws DaoException 
	{
		try 
		{
			String sql = "INSERT INTO cliente " + " (CPF, Nome) " + " VALUES (?,?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, cli.getCpf());
			statement.setString(2, cli.getNome());
			statement.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}



	@Override
	public Cliente pesquisarCliente(String cpf) throws DaoException 
	{
		Cliente cli = new Cliente();
		Endereco end = new Endereco();
		try {
			String sql = "select * from Cliente inner join Endereço on Endereço.CPF = Cliente.CPF where Cliente.CPF = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, cpf);
			ResultSet rs = state.executeQuery();
			if(rs.next()) 
			{
			cli.setCpf(rs.getString("CPF"));
			cli.setNome(rs.getString("Nome"));
			end.setCep(rs.getString("CEP"));
			end.setBairro(rs.getString("Bairro"));
			end.setCidade(rs.getString("Cidade"));
			end.setEs(rs.getString("Estado"));
			end.setLog(rs.getString("Logradouro"));
			cli.setNum(Integer.parseInt(rs.getString("Numero")));
			cli.setEnd(end);
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return cli;
	}
	@Override
	public List<Cliente> getClientes() throws DaoException
	{
		List<Cliente> clientes = new LinkedList<Cliente>();
		try {
			String sql = "SELECT * FROM Cliente";
			PreparedStatement state = conexao.prepareStatement(sql);
			ResultSet clients = state.executeQuery();
			while(clients.next()) 
			{
				Cliente cli = new Cliente();
				cli.setNome(clients.getString("nome"));
				cli.setCpf(clients.getString("cpf"));
				clientes.add(cli);
			}
			clients.close();
			state.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return clientes;
	}

	@Override
	public void removerCliente(Cliente cli) throws DaoException {
		try {
			String sql2 = "DELETE FROM Cliente WHERE CPF = ?";
			String sql = "DELETE FROM Endereço where CPF = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			PreparedStatement statement2 = conexao.prepareStatement(sql2);
			statement.setString(1, cli.getCpf());
			statement2.setString(1, cli.getCpf());
			statement.executeUpdate();
			statement2.executeUpdate();
			statement.close();
			statement2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
