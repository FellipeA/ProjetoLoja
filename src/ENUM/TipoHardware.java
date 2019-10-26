package ENUM;

public enum TipoHardware {

	PLACA_DE_VÍDEO("Placa de Vídeo"), PROCESSADOR("Processador"), PLACA_MÃE("Placa Mãe");
	
	private String nome;
	
	TipoHardware(String nome) {
		this.nome= nome;
	}
	
	public String toString() {
		return nome;
	}
}
