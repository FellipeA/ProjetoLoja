package entity;


import ENUM.Cidades;
import ENUM.Estado;

public class Endereco {
	private String 	cep = "11111";
	private String  log = "R. Aguia de Haia";
	private Cidades	Cidade = Cidades.SP;
	private String 	Bairro = "Cidade AE Carvalho";
	private Estado 	Es = Estado.SP;

public String getCep() {
	return cep;
}

public void setCep(String cep) {
	this.cep = cep;
}

public String getLog() {
	return log;
}

public void setLog(String log) {
	this.log = log;
}

public Cidades getCidade() {
	return Cidade;
}

public void setCidade(Cidades cidade) {
	Cidade = cidade;
}

public String getBairro() {
	return Bairro;
}

public void setBairro(String bairro) {
	Bairro = bairro;
}

public Estado getEs() {
	return Es;
}

public void setEs(Estado es) {
	Es = es;
}

public Endereco() {
}


}
