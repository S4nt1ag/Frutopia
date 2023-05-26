package com.grupoone.frutopia.dto;

import java.util.Date;

public class ProdutoDTO {
	
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private Date dataCadastro;
	private Double valorUnitario;
	private String imagem;
	private CategoriaDTO categoriaDTO;
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Integer idProduto, String nome, String descricao, Integer qtdEstoque, Date dataCadastro,
			Double valorUnitario, String imagem, CategoriaDTO categoriaDTO) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.categoriaDTO = categoriaDTO;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

	@Override
	public String toString() {
		return "ProdutoDTO [idProduto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao + ", qtdEstoque="
				+ qtdEstoque + ", dataCadastro=" + dataCadastro + ", valorUnitario=" + valorUnitario + ", imagem="
				+ imagem + ", categoriaDTO=" + categoriaDTO + "]";
	}
	
	
	
	
	

}
