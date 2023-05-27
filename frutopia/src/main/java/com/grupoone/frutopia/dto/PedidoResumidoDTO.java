package com.grupoone.frutopia.dto;

import java.util.Date;

public class PedidoResumidoDTO {

	private Date dataPedido;
	private Date dataEntrega;
	private Date dataEnvio;
	private String status;
	private Double valorTotal;
	private ClienteResumidoDTO clienteResumidoDTO;
	
	public PedidoResumidoDTO() {
		super();
	}

	public PedidoResumidoDTO(Date dataPedido, Date dataEntrega, Date dataEnvio, String status, Double valorTotal,
			ClienteResumidoDTO clienteResumidoDTO) {
		super();
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.clienteResumidoDTO = clienteResumidoDTO;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ClienteResumidoDTO getClienteResumidoDTO() {
		return clienteResumidoDTO;
	}

	public void setClienteResumidoDTO(ClienteResumidoDTO clienteResumidoDTO) {
		this.clienteResumidoDTO = clienteResumidoDTO;
	}
}
