package com.grupoone.frutopia.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer idEndereco;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{8}")
	@Column(name = "cep")
	private String cep;
	
	@NotBlank
	@Column(name = "rua")
	private String rua;
	
	@NotBlank
	@Column(name = "bairro")
	private String bairro;
	
	@NotBlank
	@Column(name = "cidade")
	private String cidade;
	
	@NotBlank
	@Column(name = "numero")
	private Integer numero;
	
	@NotBlank
	@Column(name = "complemento")
	private String complemento;
	
	@NotBlank
	@Pattern(regexp = "^[a-z]{2}")
	@Column(name = "uf")
	private String uf;
	
	@OneToOne(mappedBy = "endereco") // (1,1)
	private Cliente cliente;
	
	public Endereco () {
		
	}

	public Endereco(Integer idEndereco, @NotBlank @Pattern(regexp = "^[0-9]{8}") String cep, @NotBlank String rua,
			@NotBlank String bairro, @NotBlank String cidade, @NotBlank Integer numero, @NotBlank String complemento,
			@NotBlank @Pattern(regexp = "^[a-z]{2}") String uf, Cliente cliente) {
		super();
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
		this.cliente = cliente;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idEndereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(idEndereco, other.idEndereco);
	}
	
}
