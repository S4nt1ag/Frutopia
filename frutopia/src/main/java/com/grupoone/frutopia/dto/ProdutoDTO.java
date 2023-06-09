package com.grupoone.frutopia.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDTO {
	
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private LocalDate dataCadastro;
	private Double valorUnitario;
	private String imagem;
	private CategoriaDTO categoriaDTO;
	private List<ItemPedidoResumidoDTO> listaItensPedidos = new ArrayList<>();
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Integer idProduto, String nome, String descricao, Integer qtdEstoque, LocalDate dataCadastro,
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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
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

	public List<ItemPedidoResumidoDTO> getListaItensPedidos() {
		return listaItensPedidos;
	}

	public void setListaItensPedidos(List<ItemPedidoResumidoDTO> listaItensPedidos) {
		this.listaItensPedidos = listaItensPedidos;
	}

	@Override
	public String toString() {
		return "Produto [id = " + idProduto + ", nome=" + nome 
				+ ", descrição = " + descricao 
				+ ", qtd estoque = " + qtdEstoque 
				+ ", data cadastro = " + dataCadastro 
				+ ", valor unitario = " + valorUnitario 
				+ ", imagem = " + imagem 
				+ ", categoria = " + categoriaDTO + "]";
	}
}