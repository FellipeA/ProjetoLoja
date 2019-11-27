package ENUM;

public enum TipoHardware {

	PLACA_DE_V�DEO(1,"Placa de V�deo"), PROCESSADOR(2,"Processador"), PLACA_M�E(3,"Placa M�e");
	
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
