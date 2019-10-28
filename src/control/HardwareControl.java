package control;

import entity.Hardware;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HardwareControl {
	private ObservableList<Hardware> listaHardware = 
			FXCollections.observableArrayList();
	
	public void adicionar(Hardware h) { 
		getLista().add(h);
	}
	
	public Hardware pesquisarPorNome(String nome) { 
		for (Hardware h : getLista()) { 
			if (h.getNome().contains(nome)) { 
				return h;
			}
		}
		return null;
	}

	public void remover(String nome) { 
		for (Hardware h : getLista()) { 
			if (h.getNome().contains(nome)) { 
				getLista().remove(h);
			}
		}
	}
	public ObservableList<Hardware> getLista() {
		return listaHardware;
	}
}