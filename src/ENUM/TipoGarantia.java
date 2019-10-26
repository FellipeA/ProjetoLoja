package ENUM;

public enum TipoGarantia {

	GARANTIA_PADR�O("Garantia Padr�o"), GARANTIA_ESTENDIDA("Garantia Estendida");
	
	private String nome;
	
	TipoGarantia(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
}
