package entity;

public class Funcionario {
	private String 	nome;
	private String 	cpf;
	private int    	num;
	private String  Cep;
	private double  salario;
	private Endereco end;
	

public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

public Funcionario() {

}

public Funcionario(String nome, String cpf, String cep, int num, String Cep, double salario) {
	this.nome = 	nome;
	this.cpf  = 	cpf;
	this.num  =		num;
	this.Cep  =     Cep;
	this.salario =  salario;
}

public double getSalario() {
	return salario;
}

public void setSalario(double salario) {
	this.salario = salario;
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
