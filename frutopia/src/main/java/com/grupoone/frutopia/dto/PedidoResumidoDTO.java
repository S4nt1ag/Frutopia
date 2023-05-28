package com.grupoone.frutopia.dto;

import java.time.Instant;

import com.grupoone.frutopia.entities.enums.StatusPedido;

public class PedidoResumidoDTO {

	private Instant dataPedido;
	private Instant dataEntrega;
	private Instant dataEnvio;
	private Integer status;
	private Double valorTotal;
	private ClienteResumidoDTO clienteResumidoDTO;
	
	public PedidoResumidoDTO() {
		super();
	}

	public PedidoResumidoDTO(Instant dataPedido, Instant dataEntrega, Instant dataEnvio, StatusPedido status, Double valorTotal,
			ClienteResumidoDTO clienteResumidoDTO) {
		super();
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		setStatus(status);
		this.valorTotal = valorTotal;
		this.clienteResumidoDTO = clienteResumidoDTO;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Instant getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Instant dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Instant getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Instant dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public StatusPedido getStatus() {
		return StatusPedido.valueOf(status);
	}

	public void setStatus(StatusPedido status) {
		if(status != null) {
			this.status = status.getCode();
		}
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
