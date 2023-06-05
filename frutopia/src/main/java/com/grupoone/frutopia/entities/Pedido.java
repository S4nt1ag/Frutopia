package com.grupoone.frutopia.entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.grupoone.frutopia.entities.enums.StatusPedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPedido")

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer idPedido;

	@NotNull
	@Column(name = "data_pedido")  // para garantir formato do LocalDateTime salvo no Json
	private Instant dataPedido;

	@Column(name = "data_entrega")
	private LocalDateTime dataEntrega;

	@Column(name = "data_envio")
	private LocalDateTime dataEnvio;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20)
	private StatusPedido status;

	@Column(name = "valor_total")
	private Double valorTotal;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_cliente_FK", referencedColumnName = "id_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> listaItenPedidos = new ArrayList<>();

	public Pedido() {
		super();
	}

	public Pedido(Integer idPedido, Instant dataPedido, LocalDateTime dataEntrega, LocalDateTime dataEnvio,
			StatusPedido status, Double valorTotal, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}
	
	public void setDataPedido(Instant dataPedido) {
        Instant currentDate = Instant.now(); 

       if (dataPedido.isAfter(currentDate)) {
           this.dataPedido = dataPedido;
       } else {
           throw new IllegalArgumentException("Data de Pedido inválida: Datas retroativas não são permitidas.");
       }
    }

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getListaItemPedido() {
		return listaItenPedidos;
	}

	public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
		this.listaItenPedidos = listaItemPedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(idPedido, other.idPedido);
	}
	
}
