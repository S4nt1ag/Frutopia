package com.grupoone.frutopia.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idProduto"
        )
@Entity
@Table(name = "produto")
    public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer idProduto;

	@NotBlank
	@Column(name = "nome")
	private String nome;

	@NotBlank
	@Column(name = "descricao", unique = true)
	private String descricao;

	@NotBlank
	@Column(name = "qtd_estoque")
	private Integer qtdEstoque;

	@NotBlank
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@NotBlank
	@Column(name = "valor_unitario")
	private Double valorUnitario;

	@NotBlank
	@Column(name = "imagem")
	private String imagem;

	@NotBlank
	@ManyToOne
	@JoinColumn(name = "id_categoria_FK", referencedColumnName = "id_categoria")
	private Categoria categoria;

	@OneToMany(mappedBy = "produto")
	private List<ItemPedido> listaItensPedidos;

	
	public Produto() {
		
	}

	public Produto(Integer idProduto, @NotBlank String nome, @NotBlank String descricao, @NotBlank Integer qtdEstoque,
			@NotBlank Date dataCadastro, @NotBlank Double valorUnitario, @NotBlank String imagem,
			@NotBlank Categoria categoria) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.categoria = categoria;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<ItemPedido> getListaItensPedidos() {
		return listaItensPedidos;
	}

	public void setListaItensPedidos(List<ItemPedido> listaItensPedidos) {
		this.listaItensPedidos = listaItensPedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(idProduto, other.idProduto);
	}
	
}
	
	
		