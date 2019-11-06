package entity;

import java.time.LocalDate;
import ENUM.TipoPagamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Venda {
	
	private TipoPagamento tipo;
	private double ValorTotal;
	private ObservableList<Hardware> produtos = 
			FXCollections.observableArrayList();
	private Cliente cliente;
	private LocalDate data;
	
	public Venda(TipoPagamento tipo, double ValorTotal) {
		this.tipo = tipo;
		this.ValorTotal = ValorTotal;
	}
	
	public Venda() {
		
	}

	public TipoPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}

	public double getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}

	public ObservableList<Hardware> getProdutos() {
		return produtos;
	}

	public void setProdutos(ObservableList<Hardware> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate localDate) {
		this.data = localDate;
	}
	
	
}
