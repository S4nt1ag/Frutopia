package com.grupoone.frutopia.dto;

public class ItemPedidoDTO {

	private Integer id;
	private Integer quantidade;
	private Double precoVenda;
	private Double percentualDesconto;
	private Double valorBruto;
	private Double valorLiquido;
	private PedidoResumidoDTO pedidoResumidoDTO;
	private ProdutoDTO produtoDto;
	
	public ItemPedidoDTO() {
		super();
	}

	public ItemPedidoDTO(Integer id, Integer quantidade, Double precoVenda, Double percentualDesconto,
			Double valorBruto, Double valorLiquido, PedidoResumidoDTO pedidoResumidoDTO, ProdutoDTO produtoDto) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
		this.pedidoResumidoDTO = pedidoResumidoDTO;
		this.produtoDto = produtoDto;
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

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public PedidoResumidoDTO getPedidoResumidoDTO() {
		return pedidoResumidoDTO;
	}

	public void setPedidoResumidoDTO(PedidoResumidoDTO pedidoResumidoDTO) {
		this.pedidoResumidoDTO = pedidoResumidoDTO;
	}

	public ProdutoDTO getProdutoDTO() {
		return produtoDto;
	}

	public void setProdutoDTO(ProdutoDTO produtoDto) {
		this.produtoDto = produtoDto;
	}

	@Override
	public String toString() {
		return "Item Pedido [id=" + id + ", quantidade=" + quantidade + ", precoVenda=" + precoVenda
				+ ", percentualDesconto=" + percentualDesconto + ", valorBruto=" + valorBruto + ", valorLiquido="
				+ valorLiquido + "]";
	}
}
