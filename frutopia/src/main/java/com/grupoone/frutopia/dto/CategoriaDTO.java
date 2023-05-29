package com.grupoone.frutopia.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {

    private String nome;
    private String descricao;
    private List<ProdutoNomeDTO> listaProdutosDTO = new ArrayList<>();

    public CategoriaDTO() {

    }

    public CategoriaDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

    public List<ProdutoNomeDTO> getListaProdutosDTO() {
        return listaProdutosDTO;
    }

    public void setListaProdutosDTO(List<ProdutoNomeDTO> listaProdutosDTO) {
        this.listaProdutosDTO = listaProdutosDTO;
    }
}