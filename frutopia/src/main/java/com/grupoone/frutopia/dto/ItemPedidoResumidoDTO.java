package com.grupoone.frutopia.dto;

public class ItemPedidoResumidoDTO {

	private Integer id;
	private Integer quantidade;
	private Double precoVenda;
	
	public ItemPedidoResumidoDTO() {
		super();
	}

	public ItemPedidoResumidoDTO(Integer id, Integer quantidade, Double precoVenda) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}	
}
