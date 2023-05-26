package com.grupoone.frutopia.dto;

import java.util.Date;
import java.util.List;

import com.grupoone.frutopia.entities.Endereco;
import com.grupoone.frutopia.entities.Pedido;

public class ClienteDTO {

//	private Integer idCliente;
	private String cpf;
	private Date dataNascimento;
	private String email;
	private Endereco endereco;
	private String nomeCompleto;
	private String telefone;
	private List<Pedido> listaPedidos;
	
	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(String cpf, Date dataNascimento, String email, Endereco endereco, String nomeCompleto,
			String telefone, List<Pedido> listaPedidos) {
		super();
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.endereco = endereco;
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
		this.listaPedidos = listaPedidos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	@Override
	public String toString() {
		return "ClienteDTO [cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email + ", endereco="
				+ endereco + ", nomeCompleto=" + nomeCompleto + ", telefone=" + telefone + ", listaPedidos="
				+ listaPedidos + "]";
	}
	
}
