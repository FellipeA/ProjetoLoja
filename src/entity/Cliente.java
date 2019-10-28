package entity;

public class Cliente {
	private String 	nome;
	private String 	cpf;
	private String 	cep;
	private int    	num;
	
public Cliente(String nome, String cpf, String cep, int num) {
	this.nome = 	nome;
	this.cpf  = 	cpf;
	this.cep  = 	cep;
	this.num  =		num ;
}

public Cliente() {
	
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

public void setNum(int num) {
	this.num = num;
}



}
