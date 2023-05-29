package com.grupoone.frutopia.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoResumidoDTO {
	
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private LocalDate dataCadastro;
	private Double valorUnitario;
	private String imagem;
	private CategoriaResumidaDTO categoriaResDTO;
	private List<ItemPedidoResumidoDTO> listaItensPedidos = new ArrayList<>();
	
	public ProdutoResumidoDTO() {
		super();
	}

	public ProdutoResumidoDTO(Integer idProduto, String nome, String descricao, Integer qtdEstoque, LocalDate dataCadastro,
			Double valorUnitario, String imagem, CategoriaResumidaDTO categoriaResDTO) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.categoriaResDTO = categoriaResDTO;
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

	public CategoriaResumidaDTO getCategoriaResDTO() {
		return categoriaResDTO;
	}

	public void setCategoriaResDTO(CategoriaResumidaDTO categoriaResDTO) {
		this.categoriaResDTO = categoriaResDTO;
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
				+ ", categoria = " + categoriaResDTO + "]";
	}
}