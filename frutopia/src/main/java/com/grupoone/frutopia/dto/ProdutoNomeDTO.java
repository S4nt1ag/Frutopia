package com.grupoone.frutopia.dto;

public class ProdutoNomeDTO {
	private String nome;

	public ProdutoNomeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoNomeDTO(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "ProdutoNomeDTO [nome=" + nome + "]";
	}
	
	
}
