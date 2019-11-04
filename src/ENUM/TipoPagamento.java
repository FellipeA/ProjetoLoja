package ENUM;

public enum TipoPagamento {
		
	CARTAO_CREDITO("Cartão de Crédito",1), CARTAO_DEBITO("Cartão de Débito",1), DINHEIRO("Dinheiro",1.05);
	
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
