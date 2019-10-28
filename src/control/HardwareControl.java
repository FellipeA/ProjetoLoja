package control;

import entity.Hardware;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HardwareControl {
	private ObservableList<Hardware> listaHardware = 
			FXCollections.observableArrayList();
	
	public void adicionar(Hardware h) { 
		listaHardware.add(h);
	}
	
	public Hardware pesquisarPorNome(String nome) { 
		for (Hardware h : listaHardware) { 
			if (h.getNome().contains(nome)) { 
				return h;
			}
		}
		return null;
	}

	public void remover(String nome) { 
		for (Hardware h : listaHardware) { 
			if (h.getNome().contains(nome)) { 
				try {
					listaHardware.remove(h);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}