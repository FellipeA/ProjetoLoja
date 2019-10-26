package ENUM;

public enum Estado {

	SP("S�o Paulo"), RJ("Rio de Janeiro"), MG("Minas Gerais");
	
	private String estado;
	
	Estado(String estado) {
		this.estado = estado;
	}
	
	public String toString() {
		return estado;
	}
}
