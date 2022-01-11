package com.hscastro.dto;

import java.io.Serializable;


public class ServicoPrestadoDTO implements Serializable {
	
	private static final long serialVersionUID = -2709945458591238976L;
		
	private String descricao;
	
	private String preco;

	private String data;

	private Long idCliente;


	public ServicoPrestadoDTO() {
		// TODO Auto-generated constructor stub
	}	 

	public ServicoPrestadoDTO(String descricao, String preco, String data, Long idCliente) {
		this.descricao = descricao;
		this.preco = preco;
		this.data = data;
		this.idCliente = idCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}    

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}    	
	
}
