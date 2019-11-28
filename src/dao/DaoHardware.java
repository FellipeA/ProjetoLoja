package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import ENUM.TipoGarantia;
import ENUM.TipoHardware;
import entity.Hardware;

public class DaoHardware implements DaoHardwareI
{
	private Connection conexao;
	
	public DaoHardware() throws DaoException, ClassNotFoundException, SQLException
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

	public void adicionarHardware(Hardware h) throws DaoException 
	{
		try 
		{
			String sql = "INSERT INTO Produto " + " (NomeProduto, Preco, Garantia_ID, Hardware_ID) " + " VALUES (?,?,?,?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, h.getNome());
			statement.setDouble(2, h.getPreco());
			statement.setInt(3, h.getGarantia().getId());
			statement.setInt(4, h.getTipo().getId());
			statement.executeUpdate();
			statement.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	public Hardware pesquisarHardware(String nome) throws DaoException 
	{
		Hardware h = new Hardware();
		try {
			String sql = "select * "
					+ "from Produto prod inner join garantia gar on gar.id = prod.garantia_id " + 
					"inner join hardware har on har.id = prod.hardware_id "
					+ "where prod.nomeproduto = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, nome);
			ResultSet rs = state.executeQuery();
			if(rs.next()) 
			{
			h.setNome(rs.getString("nomeproduto"));
			h.setPreco(rs.getDouble("preco"));
			if (Integer.parseInt(rs.getString(6)) == 1) {
				h.setGarantia(TipoGarantia.GARANTIA_PADRÃO);
			} else {
				h.setGarantia(TipoGarantia.GARANTIA_ESTENDIDA);
			}
			if (Integer.parseInt(rs.getString(8)) == 1) {
				h.setTipo(TipoHardware.PLACA_DE_VÍDEO);
			} else if (Integer.parseInt(rs.getString(8)) == 2){
				h.setTipo(TipoHardware.PROCESSADOR);
			} else {
				h.setTipo(TipoHardware.PLACA_MÃE);
			}
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return h;
	}

	public void removerHardware(Hardware h) throws DaoException {
		try {
			String sql = "DELETE FROM Produto where NomeProduto = ? and preco = ? and garantia_id = ? and hardware_id = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, h.getNome());
			statement.setString(2, String.valueOf(h.getPreco()));
			statement.setString(3, String.valueOf(h.getGarantia().getId()));
			statement.setString(4, String.valueOf(h.getTipo().getId()));
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Hardware> getHardwares() throws DaoException {
		List<Hardware> hardwares = new LinkedList<Hardware>();
		try {
			String sql = "SELECT * FROM Produto";
			PreparedStatement state = conexao.prepareStatement(sql);
			ResultSet hardware = state.executeQuery();
			while(hardware.next()) 
			{
				Hardware h = new Hardware();
				h.setNome(hardware.getString("NomeProduto"));
				h.setPreco(Double.parseDouble(hardware.getString("Preco")));
				if (Integer.parseInt(hardware.getString(4)) == 1) {
					h.setGarantia(TipoGarantia.GARANTIA_PADRÃO);
				} else {
					h.setGarantia(TipoGarantia.GARANTIA_ESTENDIDA);
				}
				if (Integer.parseInt(hardware.getString(5)) == 1) {
					h.setTipo(TipoHardware.PLACA_DE_VÍDEO);
				} else if (Integer.parseInt(hardware.getString(5)) == 2){
					h.setTipo(TipoHardware.PROCESSADOR);
				} else {
					h.setTipo(TipoHardware.PLACA_MÃE);
				}
				hardwares.add(h);
			}
			hardware.close();
			state.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return hardwares;
	}


}
