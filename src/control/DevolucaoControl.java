package control;

import entity.Devolucao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DevolucaoControl 
{
	private ObservableList<Devolucao> lista = FXCollections.observableArrayList();
	public void adicionar(Devolucao d) 
	{ 
		getLista().add(d);
	}
	public ObservableList<Devolucao> getLista() 
	{
		ASD
		return lista;
	}
}
