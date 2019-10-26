package ENUM;

public enum TipoPagamento {
		
	CARTAO_CREDITO("Cartão de Crédito"), CARTAO_DEBITO("Cartão de Débito"), DINHEIRO("Dinheiro");
	
	private String tipo;
	
	private TipoPagamento(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return tipo;
	}
}
