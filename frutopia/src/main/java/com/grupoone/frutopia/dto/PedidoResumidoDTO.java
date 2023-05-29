package com.grupoone.frutopia.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import com.grupoone.frutopia.entities.enums.StatusPedido;

public class PedidoResumidoDTO {

	private Integer idProduto;
	private Instant dataPedido;
	private LocalDateTime dataEntrega;
	private LocalDateTime dataEnvio;
	private Integer status;
	private Double valorTotal;
	
	public PedidoResumidoDTO() {
		super();
	}

	public PedidoResumidoDTO(Integer idProduto, Instant dataPedido, LocalDateTime dataEntrega, LocalDateTime dataEnvio,
			StatusPedido status, Double valorTotal) {
		super();
		this.idProduto = idProduto;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		setStatus(status);
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

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
