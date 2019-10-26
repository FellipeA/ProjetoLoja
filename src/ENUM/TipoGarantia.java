package ENUM;

public enum TipoGarantia {

	GARANTIA_PADRÃO("Garantia Padrão"), GARANTIA_ESTENDIDA("Garantia Estendida");
	
	private String nome;
	
	TipoGarantia(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
}
