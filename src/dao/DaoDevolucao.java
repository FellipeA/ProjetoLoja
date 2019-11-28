package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ENUM.TipoGarantia;
import ENUM.TipoHardware;
import entity.Devolucao;

public class DaoDevolucao implements DaoDevolucaoI{
			private Connection conexao;
			
			public DaoDevolucao() throws DaoException, ClassNotFoundException, SQLException
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
			@Override
			public void adicionarDevolucao(Devolucao d) throws DaoException 
			{
				try 
				{
					String sql = "INSERT INTO Devolucao " + " (cliente, venda, produto, garantia, razao) " + " VALUES (?,?,?,?,?)";
					PreparedStatement statement = conexao.prepareStatement(sql);
					statement.setString(1, d.getCliente());
					statement.setString(2, d.getVenda());
					statement.setInt(3, d.getTipo().getId());
					statement.setInt(4, d.getGarantia().getId());
					statement.setString(5, d.getRazao());
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
			public Devolucao pesquisarDevolucao(String cliente) throws DaoException 
			{
				Devolucao d = new Devolucao();
				try {
					String sql = "select * "
							+ "from Devolucao d inner join garantia gar on gar.id = prod.garantia_id " + 
							"inner join hardware har on har.id = prod.hardware_id "
							+ "where d.cliente = ?";
					PreparedStatement state = conexao.prepareStatement(sql);
					state.setString(1, cliente);
					ResultSet rs = state.executeQuery();
					if(rs.next()) 
					{
					d.setVenda(rs.getString("venda"));
					if (Integer.parseInt(rs.getString(8)) == 1) {
						d.setTipo(TipoHardware.PLACA_DE_VÍDEO);
					} else if (Integer.parseInt(rs.getString(8)) == 2){
						d.setTipo(TipoHardware.PROCESSADOR);
					} else {
						d.setTipo(TipoHardware.PLACA_MÃE);
					}
					if (Integer.parseInt(rs.getString(6)) == 1) {
						d.setGarantia(TipoGarantia.GARANTIA_PADRÃO);
					} else {
						d.setGarantia(TipoGarantia.GARANTIA_ESTENDIDA);
					}
					}
				} catch (SQLException e) 
				{
					e.printStackTrace();
					throw new DaoException(e);
				}
				return d;
			}


			@Override
			public List<Devolucao> getDevolucao() throws DaoException {
				List<Devolucao> devolucoes = new LinkedList<Devolucao>();
				try {
					String sql = "SELECT * FROM Devolucao";
					PreparedStatement state = conexao.prepareStatement(sql);
					ResultSet devolucao1 = state.executeQuery();
					while(devolucao1.next()) 
					{
						Devolucao d = new Devolucao();
						d.setCliente(devolucao1.getString("cliente"));
						d.setVenda(devolucao1.getString("venda"));
						if (Integer.parseInt(devolucao1.getString(4)) == 1) {
							d.setGarantia(TipoGarantia.GARANTIA_PADRÃO);
						} else {
							d.setGarantia(TipoGarantia.GARANTIA_ESTENDIDA);
						}
						if (Integer.parseInt(devolucao1.getString(5)) == 1) {
							d.setTipo(TipoHardware.PLACA_DE_VÍDEO);
						} else if (Integer.parseInt(devolucao1.getString(5)) == 2){
							d.setTipo(TipoHardware.PROCESSADOR);
						} else {
							d.setTipo(TipoHardware.PLACA_MÃE);
						}
						devolucoes.add(d);
					}
					devolucao1.close();
					state.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new DaoException(e);
				}
				return devolucoes;
			}
			//Pronto
}


		