package com.grupoone.frutopia.dto;

public class RelatorioPedidoItemDTO {
	
	private Integer codigoProduto;
	private String nomeProduto;
	private Double precoVenda;
	private Integer quantidade;
	private Double valorBruto;
	private Double percentualDesconto;
	private Double valorLiquido;
	
	public RelatorioPedidoItemDTO() {
		super();
	}

	public RelatorioPedidoItemDTO(Integer codigoProduto, String nomeProduto, Double precoVenda, Integer quantidade,
			Double valorBruto, Double percentualDesconto, Double valorLiquido) {
		super();
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.valorBruto = valorBruto;
		this.percentualDesconto = percentualDesconto;
		this.valorLiquido = valorLiquido;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	@Override
	public String toString() {
		return "código do produto: " + codigoProduto + "\n    nome do produto:" + nomeProduto
				+ "\n    preço na venda:" + precoVenda + "\n    quantidade:" + quantidade + "\n    valor bruto:" + valorBruto
				+ "\n    percentual de desconto:" + percentualDesconto + "%\n    valor líquido:" + String.format("%,.2f", valorLiquido) + "\n";
	}
	
	
	
}
