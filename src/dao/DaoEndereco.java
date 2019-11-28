package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Cliente;
import entity.Funcionario;

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
	public void adicionarEndereco(Funcionario f) throws DaoException 
	{
		try 
		{
			String sql = "INSERT INTO Endereço " + " (CEP, Logradouro, Cidade, Bairro, Estado, Numero, CPF) " + " VALUES (?,?,?,?,?,?,?)";
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1, f.getCep());
			statement.setString(2, f.getEnd().getLog());
			statement.setString(3, f.getEnd().getCidade());
			statement.setString(4, f.getEnd().getBairro());
			statement.setString(5, f.getEnd().getEs());
			statement.setString(6, String.valueOf(f.getNum()));
			statement.setString(7, f.getCpf());
			statement.executeUpdate();
			statement.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	@Override
	public void adicionarEndereco(Cliente f) throws DaoException {
		try 
		{
			String sql = "INSERT INTO Endereço " + " (CEP, Logradouro, Cidade, Bairro, Estado, Numero, CPF) " + " VALUES (?,?,?,?,?,?,?)";
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1, f.getCep());
			statement.setString(2, f.getEnd().getLog());
			statement.setString(3, f.getEnd().getCidade());
			statement.setString(4, f.getEnd().getBairro());
			statement.setString(5, f.getEnd().getEs());
			statement.setString(6, String.valueOf(f.getNum()));
			statement.setString(7, f.getCpf());
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
