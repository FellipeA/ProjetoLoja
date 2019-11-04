package ENUM;

public enum TipoPagamento {
		
	CARTAO_CREDITO("Cart�o de Cr�dito",1), CARTAO_DEBITO("Cart�o de D�bito",1), DINHEIRO("Dinheiro",1.05);
	
	private String tipo;
	private double desconto;
	
	private TipoPagamento(String tipo, double desconto) {
		this.tipo = tipo;
		this.desconto= desconto;
	}
	
	public String toString() {
		return tipo;
	}

	public double getDesconto() {
		return desconto;
	}

}
