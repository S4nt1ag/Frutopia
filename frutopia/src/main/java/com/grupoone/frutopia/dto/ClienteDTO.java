package com.grupoone.frutopia.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDTO {

	private Integer idCliente;
	private String cpf;
	private LocalDate dataNascimento;
	private String email;
	private EnderecoResumidoDTO enderecoResumidoDto;
	private String nomeCompleto;
	private String telefone;
	private List<PedidoResumidoDTO> listaPedidosResumidosDto = new ArrayList<>();

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Integer idCliente, String cpf, LocalDate dataNascimento, String email,
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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

	public List<PedidoResumidoDTO> getListaPedidosResumidosDto() {
		return listaPedidosResumidosDto;
	}

	public void setListaPedidosResumidosDto(List<PedidoResumidoDTO> listaPedidosResumidosDto) {
		this.listaPedidosResumidosDto = listaPedidosResumidosDto;
	}

	@Override
	public String toString() {
		return "ClienteDTO [idCliente=" + idCliente + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email="
				+ email + ", enderecoResumidoDto=" + enderecoResumidoDto + ", nomeCompleto=" + nomeCompleto
				+ ", telefone=" + telefone + ", listaPedidosResumidosDto=" + listaPedidosResumidosDto + "]";
	}


}
