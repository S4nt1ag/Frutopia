package com.grupoone.frutopia.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.grupoone.frutopia.entities.Pedido;

public class ClienteDTO {

	private Integer idCliente;
	private String cpf;
	private Instant dataNascimento;
	private String email;
	private EnderecoResumidoDTO enderecoResumidoDto;
	private String nomeCompleto;
	private String telefone;
	private List<Pedido> listaPedidos = new ArrayList<>();

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Integer idCliente, String cpf, Instant dataNascimento, String email,
			EnderecoResumidoDTO enderecoResumidoDto, String nomeCompleto, String telefone) {
		super();
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.enderecoResumidoDto = enderecoResumidoDto;
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnderecoResumidoDTO getEnderecoResumidoDto() {
		return enderecoResumidoDto;
	}

	public void setEnderecoResumidoDto(EnderecoResumidoDTO enderecoResumidoDto) {
		this.enderecoResumidoDto = enderecoResumidoDto;
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
				+ enderecoResumidoDto + ", nomeCompleto=" + nomeCompleto + ", telefone=" + telefone + ", listaPedidos="
				+ listaPedidos + "]";
	}

}
