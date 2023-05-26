package com.grupoone.frutopia.dto;

import java.util.List;

public class CategoriaDTO {

	private String nome;
	private String descricao;
	private List<ProdutoDTO> listaProdutosDTO;

	public CategoriaDTO() {

	}

	public CategoriaDTO(String nome, String descricao, List<ProdutoDTO> listaProdutosDTO) {
		this.nome = nome;
		this.descricao = descricao;
		this.listaProdutosDTO = listaProdutosDTO;
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

	public List<ProdutoDTO> getListaProdutosDTO() {
		return listaProdutosDTO;
	}

	public void setListaProdutosDTO(List<ProdutoDTO> listaProdutosDTO) {
		this.listaProdutosDTO = listaProdutosDTO;
	}


}
