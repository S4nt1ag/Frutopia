package com.grupoone.frutopia.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.grupoone.frutopia.entities.enums.StatusPedido;

public class PedidoDTO {
	
	private Integer idPedido;	
	private Instant dataPedido;
	private Instant dataEntrega;
	private Instant dataEnvio;
	private Integer status;
	private Double valorTotal;
	private ClienteResumidoDTO cliente;
	private List<ItemPedidoResumidoDTO> listaItemPedido = new ArrayList<>();
	
	public PedidoDTO() {
		super();
	}

	public PedidoDTO(Integer idPedido, Instant dataPedido, Instant dataEntrega, Instant dataEnvio, StatusPedido status,
			Double valorTotal, ClienteResumidoDTO cliente) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		setStatus(status);
		this.valorTotal = valorTotal;
		this.cliente = cliente;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
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

	public ClienteResumidoDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResumidoDTO cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedidoResumidoDTO> getListaItemPedido() {
		return listaItemPedido;
	}

	public void setListaItemPedido(List<ItemPedidoResumidoDTO> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}

}
