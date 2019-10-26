package ENUM;

public enum TipoPagamento {
		
	CARTAO_CREDITO("Cart�o de Cr�dito"), CARTAO_DEBITO("Cart�o de D�bito"), DINHEIRO("Dinheiro");
	
	private String tipo;
	
	private TipoPagamento(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return tipo;
	}
}
