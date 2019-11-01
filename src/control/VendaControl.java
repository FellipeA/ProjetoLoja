package control;

import entity.Hardware;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VendaControl {
	private ObservableList<Hardware> listaItens = 
			FXCollections.observableArrayList();
	
	public void adicionar(Hardware h) { 
		listaItens.add(h);
	}
	
	public ObservableList<Hardware> getlistaItens() {
		return listaItens;
	}
	
	
}