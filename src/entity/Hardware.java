package entity;

import ENUM.TipoGarantia;
import ENUM.TipoHardware;

public class Hardware {
	
	private int id;
	private TipoGarantia garantia;
	private TipoHardware tipo;
	private double preco;
	private String nome;
	
	public Hardware(TipoGarantia garantia, TipoHardware tipo, double preco, String nome) {
		this.garantia = garantia;
		this.tipo = tipo;
		this.preco = preco;
		this.nome = nome;
	}
	
	public Hardware() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public TipoGarantia getGarantia() {
		return garantia;
	}
	public void setGarantia(TipoGarantia garantia) {
		this.garantia = garantia;
	}
	
	public TipoHardware getTipo() {
		return tipo;
	}
	public void setTipo(TipoHardware tipo) {
		this.tipo = tipo;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}