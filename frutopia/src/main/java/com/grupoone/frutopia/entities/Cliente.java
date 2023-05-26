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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCliente")

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@NotBlank
	@Email
	@Column(name = "email", unique = true)
	private String email;

	@NotBlank
	@Column(name = "nome_completo")
	private String nomeCompleto;

	@NotBlank
	@Pattern(regexp = "^[0-9]{11}")
	@Column(name = "cpf", unique = true)
	private String cpf;

	@NotBlank
	@Pattern(regexp = "^[0-9]{8,15}")
	@Column(name = "telefone", unique = true)
	private String telefone;

<<<<<<< HEAD
	@NotNull
=======
//	@NotBlank
>>>>>>> Breno
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@NotBlank
	@Column(name = "senha")
	private String senha;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> listaPedidos;

	@NotNull
	@OneToOne
	@JoinColumn(name = "id_endereco_FK", referencedColumnName = "id_endereco")
	private Endereco endereco;

	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente, @NotBlank @Email String email, @NotBlank String nomeCompleto,
			@NotBlank @Pattern(regexp = "^[0-9]{11}") String cpf,
			@NotBlank @Pattern(regexp = "^[0-9]{8,15}") String telefone, @NotBlank Date dataNascimento,
			@NotBlank String senha, List<Pedido> listaPedidos, Endereco endereco) {
		super();
		this.idCliente = idCliente;
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.listaPedidos = listaPedidos;
		this.endereco = endereco;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}

}
