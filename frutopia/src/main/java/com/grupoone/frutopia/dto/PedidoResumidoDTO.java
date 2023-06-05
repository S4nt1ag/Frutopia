package com.grupoone.frutopia.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import com.grupoone.frutopia.entities.enums.StatusPedido;

public class PedidoResumidoDTO {

	private Integer idPedido;
	private Instant dataPedido;
	private LocalDateTime dataEntrega;
	private LocalDateTime dataEnvio;
	private StatusPedido status;
	private Double valorTotal;
	
	public PedidoResumidoDTO() {
		super();
	}

	public PedidoResumidoDTO(Integer idPedido, Instant dataPedido, LocalDateTime dataEntrega, LocalDateTime dataEnvio,
			StatusPedido status, Double valorTotal) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Double getValorTotal() {
		return valorTotal;
	}	

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

}
