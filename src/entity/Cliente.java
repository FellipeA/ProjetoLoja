package entity;

public class Cliente {
	private String 	nome;
	private String 	cpf;
	private int    	num;
	private String  Cep;
	private Endereco end;
	

public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

public Cliente() {

}

public Cliente(String nome, String cpf, int num, String Cep, Endereco end) {
	this.nome = 	nome;
	this.cpf  = 	cpf;
	this.num  =		num;
	this.Cep  =     Cep;
	this.end = end;
}

public String getCep() {
	return Cep;
}

public void setCep(String cep) {
	Cep = cep;
}



public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}



public int getNum() {
	return num;
}


public void setNum(int num) {
	this.num = num;
}




}
