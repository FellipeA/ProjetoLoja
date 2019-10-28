package ENUM;

public enum TipoGarantia {

	GARANTIA_PADRÃO("Garantia Padrão",3), GARANTIA_ESTENDIDA("Garantia Estendida",6);
	
	private String nome;
	private int meses;
	
	TipoGarantia(String nome, int meses) {
		this.nome = nome;
		this.meses = meses;
	}
	
	public String toString() {
		return nome;
	}
	
	public int getTempo() {
		return meses;
	}
}
