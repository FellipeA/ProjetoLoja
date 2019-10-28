package entity;

public class Cliente {
	private String 	nome;
	private String 	cpf;
	private String 	cep;
	private String  log;
	private String Cidade;
	private int    	num;
	
	
	
public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

public Cliente(String nome, String cpf, String cep, int num) {
	this.nome = 	nome;
	this.cpf  = 	cpf;
	this.cep  = 	cep;
	this.num  =		num ;
}

public Cliente() {
	//comentario
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

public String getCep() {
	return cep;
}

public void setCep(String cep) {
	this.cep = cep;
}

public int getNum() {
	return num;
}

public String getCidade() {
	return Cidade;
}

public void setCidade(String cidade) {
	Cidade = cidade;
}

public void setNum(int num) {
	this.num = num;
}



}
