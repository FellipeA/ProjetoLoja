package control;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DaoCliente;
import dao.DaoClienteImp;
import dao.DaoException;
import dao.DaoHardware;
import dao.DaoHardwareI;
import entity.Cliente;
import entity.Hardware;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HardwareControl {
	private ObservableList<Hardware> listaHardware = 
			FXCollections.observableArrayList();
	
	public void adicionar(Hardware h) { 
		try {
			DaoHardwareI iHardware = new DaoHardware();
			iHardware.adicionarHardware(h);
			listaHardware.add(h);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Hardware pesquisarPorNome(String nome) { 
		Hardware h = new Hardware();
		try {
			DaoHardwareI iHardware = new DaoHardware();
			h = iHardware.pesquisarHardware(nome);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return h;
	}

	public void remover(Hardware h) { 
		try {
			DaoHardwareI iHardware = new DaoHardware();
			iHardware.removerHardware(h);
		} catch (DaoException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Hardware> getListaHardware() {
		List<Hardware> hardware = new LinkedList();
		try {
			DaoHardwareI iHardware = new DaoHardware();
			hardware = iHardware.getHardwares();
			
		} catch (ClassNotFoundException | DaoException | SQLException e) {
			e.printStackTrace();
		}
		return hardware;
	}
	
	
	
}