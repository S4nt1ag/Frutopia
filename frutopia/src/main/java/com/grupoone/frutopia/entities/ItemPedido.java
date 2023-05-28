package com.grupoone.frutopia.entities;

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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idItemPedido"
        )
@Entity
@Table(name = "item_pedido")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Integer idItemPedido;
	
	@NotNull(message = "Invalid quantity: Quantity is NULL")
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@NotNull(message = "Invalid price: Price is NULL")
	@Column(name = "preco_venda")
	private Double precoVenda;
	
	@NotNull(message = "Invalid discount: Discount is NULL")
	@Column(name = "percentual_desconto")
	private Double percentualDesconto;
	
	@NotNull(message = "Invalid value: Gross_Amout is NULL")
	@Column(name = "valor_bruto")
	private Double valorBruto;
	
	@NotNull(message = "Invalid value: Net_Amount is NULL")
	@Column(name = "valor_liquido")
	private Double valorLiquido;
	
	@NotNull(message = "Invalid FK: FK is NULL")
	@ManyToOne
	@JoinColumn(name = "id_pedido_FK", referencedColumnName = "id_pedido")
	private Pedido pedido;
	
	@NotNull(message = "Invalid FK: FK is NULL")
	@ManyToOne
	@JoinColumn(name = "id_produto_FK", referencedColumnName = "id_produto")
	private Produto produto;

	public ItemPedido() {
		super();
	}
	
	public ItemPedido(Integer idItemPedido, @NotBlank Integer quantidade, @NotBlank Double precoVenda,
			Double percentualDesconto, Double valorBruto, Double valorLiquido, Pedido pedido, Produto produto) {
		super();
		this.idItemPedido = idItemPedido;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idItemPedido, pedido, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(idItemPedido, other.idItemPedido) && Objects.equals(pedido, other.pedido)
				&& Objects.equals(produto, other.produto);
	}
}
