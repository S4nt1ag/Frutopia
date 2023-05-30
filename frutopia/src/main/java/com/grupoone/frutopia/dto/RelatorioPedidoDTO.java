package com.grupoone.frutopia.dto;

import java.time.Instant;
import java.util.List;

public class RelatorioPedidoDTO {

	private Integer idPedido;
	private Instant dataPedido;
	private Double valorTotal;
	private List<RelatorioPedidoItemDTO> listaItemPedido;
	
	public RelatorioPedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatorioPedidoDTO(Integer idPedido, Instant dataPedido, Double valorTotal,
			List<RelatorioPedidoItemDTO> listaItemPedido) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.listaItemPedido = listaItemPedido;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<RelatorioPedidoItemDTO> getListaItemPedido() {
		return listaItemPedido;
	}

	public void setListaItemPedido(List<RelatorioPedidoItemDTO> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}

	@Override
	public String toString() {
		
		String itensPedidos = "";
		
		for(RelatorioPedidoItemDTO item : this.listaItemPedido) {
			itensPedidos += "\n  -- " + item.toString();
		}
		
		return "-Relatorio de Pedido-\n\nId do Pedido: " + idPedido + ""
				+ "\nData do Pedido: " + dataPedido + "\nValor Total:" + valorTotal
				+ "\nLista de Itens do Pedido:\n" + itensPedidos;
		
	}
	
}
