package ENUM;

public enum TipoGarantia {

	GARANTIA_PADRÃO(1,"Garantia Padrão"), GARANTIA_ESTENDIDA(2,"Garantia Estendida");
	
	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	private String nome;
	private int id;
	
	TipoGarantia(int id,String nome) {
		this.nome = nome;
		this.id = id;
	}
	
	public String toString() {
		return nome;
	}
	
}
