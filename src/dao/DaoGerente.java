package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Endereco;
import entity.Funcionario;
import entity.Gerente;

public class DaoGerente implements DaoGerentel
{
private Connection con;
	
	public DaoGerente() throws DaoException, ClassNotFoundException, SQLException
	{
		try 
		{
			DaoGenericaInt i = new DaoGenerica();
			con = i.getConnection();
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	@Override
	public void adicionarGerente(Gerente g) throws DaoException 
	{
		try
		{
			String sql = "INSERT INTO Gerente " + " (Senha) " + " VALUES (?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, g.getSenha());
			statement.executeUpdate();
			statement.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		
	}

	@Override
	public void removerGerente(Gerente g) throws DaoException 
	{
		try {
			String sql2 = "DELETE FROM Gerente WHERE ID = ?";
			PreparedStatement statement2 = con.prepareStatement(sql2);
			statement2.setInt(1, g.getID());
			statement2.executeUpdate();
			statement2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Gerente pesquisarGerente(int id) throws DaoException 
	{
		Gerente g = new Gerente();
		Endereco end = new Endereco();
		try 
		{
			String sql = "select * from Gerente inner join Endereço on Endereço.CPF = Funcionario.CPF where Funcionario.CPF = ?";
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, id);
			ResultSet rs = state.executeQuery();
			if(rs.next()) 
			{
			g.setID(rs.getInt("ID"));
			g.setSenha(rs.getString("Senha"));	
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return g;
	}

	@Override
	public List<Gerente> getGerente() throws DaoException 
	{
		List<Gerente> gerente = new LinkedList<Gerente>();
		try {
			String sql = "SELECT * FROM Gerente";
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet func = state.executeQuery();
			while(func.next()) 
			{
				Gerente g = new Gerente();
				g.setID(func.getInt("ID"));
				g.setSenha(func.getString("Senha"));
				gerente.add(g);
			}
			func.close();
			state.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return gerente;
	}
	
}
