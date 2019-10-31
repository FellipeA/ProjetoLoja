package entity;

import ENUM.TipoPagamento;

public class Venda {
	
	private TipoPagamento tipo;
	private int Quantidade;
	private double ValorTotal;
	
	public Venda(TipoPagamento tipo, int Quantidade, double ValorTotal) {
		this.tipo = tipo;
		this.Quantidade = Quantidade;
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

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public double getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}
	
	
}
