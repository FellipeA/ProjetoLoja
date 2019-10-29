package entity;

public class Cliente {
	private String 	nome;
	private String 	cpf;
	private int    	num;
	private String  Cep;
	

public Cliente() {

}

public Cliente(String nome, String cpf, String cep, int num, String Cep) {
	this.nome = 	nome;
	this.cpf  = 	cpf;
	this.num  =		num;
	this.Cep  =     Cep;
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
