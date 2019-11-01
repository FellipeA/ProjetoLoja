package entity;

public class Endereco {
	private String 	cep;
	private String  log;
	private String	Cidade;
	private String 	Bairro;
	private String 	Es;

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

public String getCidade() {
	return Cidade;
}

public void setCidade(String cidade) {
	Cidade = cidade;
}

public String getBairro() {
	return Bairro;
}

public void setBairro(String bairro) {
	Bairro = bairro;
}

public String getEs() {
	return Es;
}

public void setEs(String es) {
	Es = es;
}

public Endereco() {
}


}
