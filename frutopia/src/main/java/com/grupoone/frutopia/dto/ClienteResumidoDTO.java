package com.grupoone.frutopia.dto;

public class ClienteResumidoDTO {
	
	private Integer idCliente;
	private String nomeCompleto;
	
	public ClienteResumidoDTO() {
		super();
	}

	public ClienteResumidoDTO(Integer idCliente, String nomeCompleto) {
		super();
		this.idCliente = idCliente;
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
}
