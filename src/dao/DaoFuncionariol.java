package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Endereco;
import entity.Funcionario;

public class DaoFuncionariol implements DaoFuncionario
{
	private Connection con;
	
	public DaoFuncionariol() throws DaoException, ClassNotFoundException, SQLException
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
	public void adicionarFuncionario(Funcionario f) throws DaoException 
	{
		try
		{
			String sql = "INSERT INTO Funcionario " + " (Nome,CPF, Salario) " + " VALUES (?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, f.getNome());
			statement.setString(2, f.getCpf());
			statement.setDouble(3, f.getSalario());
			statement.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void removerFuncionario(String cpf) throws DaoException 
	{
		try {
			String sql2 = "DELETE FROM Funcionario WHERE CPF = ?";
			String sql = "DELETE FROM Endereço where CPF = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			PreparedStatement statement2 = con.prepareStatement(sql2);
			statement.setString(1, cpf);
			statement2.setString(1, cpf);
			statement.executeUpdate();
			statement2.executeUpdate();
			statement.close();
			statement2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Funcionario pesquisarFuncionario(String cpf) throws DaoException 
	{
		Funcionario f = new Funcionario();
		Endereco end = new Endereco();
		try 
		{
			String sql = "select * from Funcionario inner join Endereço on Endereço.CPF = Funcionario.CPF where Funcionario.CPF = ?";
			PreparedStatement state = con.prepareStatement(sql);
			state.setString(1, cpf);
			ResultSet rs = state.executeQuery();
			if(rs.next()) 
			{
			f.setCpf(rs.getString("CPF"));
			f.setNome(rs.getString("Nome"));
			end.setCep(rs.getString("CEP"));
			end.setBairro(rs.getString("Bairro"));
			end.setCidade(rs.getString("Cidade"));
			end.setEs(rs.getString("Estado"));
			end.setLog(rs.getString("Logradouro"));
			f.setEnd(end);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return f;
	}

	@Override
	public List<Funcionario> getFuncionario() throws DaoException 
	{
		List<Funcionario> funcionario = new LinkedList<Funcionario>();
		try {
			String sql = "SELECT * FROM Funcionario";
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet func = state.executeQuery();
			while(func.next()) 
			{
				Funcionario f = new Funcionario();
				f.setNome(func.getString("nome"));
				f.setCpf(func.getString("cpf"));
				funcionario.add(f);
			}
			func.close();
			state.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return funcionario;
	}
	
}
