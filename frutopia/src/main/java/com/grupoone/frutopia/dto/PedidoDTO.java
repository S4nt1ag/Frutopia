package com.grupoone.frutopia.dto;

import java.util.Date;
import java.util.List;

import com.grupoone.frutopia.entities.Cliente;

public class PedidoDTO {
	
	private Integer idPedido;
	private Date dataPedido;
	private Date dataEntrega;
	private Date dataEnvio;
	private String status;
	private Double valorTotal;
	private Cliente cliente;
	private List<ItemPedidoDTO> listaItemPedido;
	
	public PedidoDTO() {
		super();
	}
	
	public PedidoDTO(Integer idPedido, Date dataPedido, Date dataEntrega, Date dataEnvio, String status,
			Double valorTotal, Cliente cliente, List<ItemPedidoDTO> listaItemPedido) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.listaItemPedido = listaItemPedido;
	}



	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedidoDTO> getListaItemPedido() {
		return listaItemPedido;
	}

	public void setListaItemPedido(List<ItemPedidoDTO> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}
}
