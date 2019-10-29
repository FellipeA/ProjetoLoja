package ENUM;

public enum Cidades {

	SP("São Paulo"), RJ("Rio de Janeiro"), MG("Minas Gerais");
	
	private String estado;
	
	Cidades(String Cidades) {
		this.estado = Cidades;
	}
	
	public String toString() {
		return estado;
	}
}

