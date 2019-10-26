package ENUM;

public enum TipoHardware {

	PLACA_DE_V�DEO("Placa de V�deo"), PROCESSADOR("Processador"), PLACA_M�E("Placa M�e");
	
	private String nome;
	
	TipoHardware(String nome) {
		this.nome= nome;
	}
	
	public String toString() {
		return nome;
	}
}
