package com.grupoone.frutopia.dto;

import java.util.List;

import com.grupoone.frutopia.entities.Produto;

public class CategoriaDTO {

	private String nome;
	private String descricao;
	private List<ProdutoDTO> listaProdutosDTO;

	public CategoriaDTO() {

	}

	public CategoriaDTO(String nome, String descricao, List<ProdutoDTO> listaProdutosDTO) {
		this.nome = nome;
		this.descricao = descricao;
		this.listaProdutosDTO = listaProdutos;
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

	public List<ProdutoDTO> getListaProdutos() {
		return listaProdutosDTO;
	}

	public void setListaProdutos(List<ProdutoDTO> listaProdutosDTO) {
		this.listaProdutosDTO = listaProdutosDTO;
	}


}
