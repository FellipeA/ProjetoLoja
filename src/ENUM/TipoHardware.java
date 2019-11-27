package ENUM;

public enum TipoHardware {

	PLACA_DE_VÍDEO(1,"Placa de Vídeo"), PROCESSADOR(2,"Processador"), PLACA_MÃE(3,"Placa Mãe");
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	private int id;
	private String nome;
	
	TipoHardware(int id,String nome) {
		this.id = id;
		this.nome= nome;
	}
	
	public String toString() {
		return nome;
	}
}
