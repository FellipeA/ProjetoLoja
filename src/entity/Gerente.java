package entity;

public class Gerente extends Funcionario{
	private String senha;
	private int id;
	public Gerente(String nome, String cpf, String cep, int num, double salario, String Senha, int id) {
		super(nome, cpf, cep, num, cep, salario);
	}
	
	public Gerente() {
	}
	
	public boolean autentica(String senha) {
		return ((this.senha == senha) ? true : false);
  }
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setID(int id)
	{
		this.id = id;
	}
	public int getID()
	{
		return id;
	}
}
