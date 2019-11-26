package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Cliente;

public class DaoEndereco implements IDaoEndereco{
	
	private Connection c = null;
	
	public DaoEndereco() {
		try {
			DaoGenericaInt dao = new DaoGenerica();
			c = dao.getConnection();
		} catch (DaoException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void adicionarEndereco(Cliente cli) throws DaoException 
	{
		try 
		{
			String sql = "INSERT INTO Endereço " + " (CEP, Logradouro, Cidade, Bairro, Estado, Numero, CPF) " + " VALUES (?,?,?,?,?,?,?)";
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1, cli.getCep());
			statement.setString(2, cli.getEnd().getLog());
			statement.setString(3, cli.getEnd().getCidade());
			statement.setString(4, cli.getEnd().getBairro());
			statement.setString(5, cli.getEnd().getEs());
			statement.setString(6, String.valueOf(cli.getNum()));
			statement.setString(7, cli.getCpf());
			statement.executeUpdate();
			statement.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
}
