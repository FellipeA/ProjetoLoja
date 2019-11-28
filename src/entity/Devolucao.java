package entity;


import ENUM.TipoGarantia;
import ENUM.TipoHardware;

public class Devolucao 
{
	private String cliente;
	private String venda;
	private TipoHardware produto;
	private TipoGarantia garantia;
	private String razao;
	
	public Devolucao(String cliente, String venda, TipoHardware produto, TipoGarantia garantia, String razao) 
	{	
		this.cliente = cliente;
		this.venda = venda;
		this.produto = produto;
		this.garantia = garantia;
		this.razao = razao;
	}
	public Devolucao() 
	{
		
	}
	public String getCliente()
	{
		return cliente;
	}
	public void setCliente(String cliente)
	{
		this.cliente = cliente;
	}
	public String getVenda()
	{
		return venda;
	}
	public void setVenda(String venda)
	{
		this.venda = venda;
	}
	public TipoHardware getTipo() 
	{
		return produto;
	}
	public void setTipo(TipoHardware produto) 
	{
		this.produto = produto;
	}
	public TipoGarantia getGarantia() 
	{
		return garantia;
	}
	public void setGarantia(TipoGarantia garantia) 
	{
		this.garantia = garantia;
	}
	public String getRazao()
	{
		return razao;	
	}
	public void setRazao(String razao)
	{
		this.razao = razao;
	}

}
