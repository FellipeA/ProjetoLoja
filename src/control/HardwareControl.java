package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Hardware;

public class HardwareControl {
	private ObservableList<Hardware> lista = 
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

	public ObservableList<Hardware> getLista() {
		return lista;
	}
}