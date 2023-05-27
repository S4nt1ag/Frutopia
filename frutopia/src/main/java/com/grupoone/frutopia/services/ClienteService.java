package com.grupoone.frutopia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.ClienteDTO;
import com.grupoone.frutopia.dto.EnderecoResumidoDTO;
import com.grupoone.frutopia.entities.Cliente;
import com.grupoone.frutopia.entities.Endereco;
import com.grupoone.frutopia.entities.Pedido;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.repositories.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ClienteDTO> getAllClientesDto() {
		List<Cliente> listaClientes = clienteRepository.findAll();
		List<ClienteDTO> listaClientesDto = modelMapper.map(listaClientes, new TypeToken<List<ClienteDTO>>() {
		}.getType());

		for (int i = 0; i < listaClientes.size(); i++) {

			EnderecoResumidoDTO enderecoDto = modelMapper.map(listaClientes.get(i).getEndereco(),
					EnderecoResumidoDTO.class);
			listaClientesDto.get(i).setEnderecoResumidoDto(enderecoDto);

		}
		return listaClientesDto;

	}

	public ClienteDTO getClienteDtoById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		ClienteDTO clienteDto = new ClienteDTO();

		if (null == cliente)
			return null;

		clienteDto.setCpf(cliente.getCpf());
		clienteDto.setDataNascimento(cliente.getDataNascimento());
		clienteDto.setEmail(cliente.getEmail());
		clienteDto.setNomeCompleto(cliente.getNomeCompleto());
		clienteDto.setTelefone(cliente.getTelefone());
		clienteDto.setEnderecoResumidoDto(modelMapper.map(cliente.getEndereco(),
				EnderecoResumidoDTO.class));

		List<Pedido> listaPedidos = new ArrayList<>();
		for (Pedido pedido : cliente.getListaPedidos()) {
			Pedido pedidoDTO = new Pedido();
			pedidoDTO.setIdPedido(pedido.getIdPedido());
			pedidoDTO.setDataPedido(pedido.getDataPedido());
			pedidoDTO.setDataEntrega(pedido.getDataEntrega());
			pedidoDTO.setDataEnvio(pedido.getDataEnvio());
			pedidoDTO.setStatus(pedido.getStatus());
			pedidoDTO.setValorTotal(pedido.getValorTotal());

			listaPedidos.add(pedidoDTO);
		}

		clienteDto.setListaPedidos(listaPedidos);

		return clienteDto;
	}

	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	public Cliente getClienteById(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
	}

	public Cliente saveCliente(Cliente cliente) {
		try {

			Cliente novoCliente = clienteRepository.save(cliente);
			return novoCliente;
		} catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}

	public Cliente updateCliente(Cliente cliente, Integer id) {
		try {
			Cliente updateCliente = clienteRepository.getReferenceById(id);
			updateData(updateCliente, cliente);
			return clienteRepository.save(updateCliente);
		} catch (EntityNotFoundException e) {
			throw new NoSuchElementException("");
		}
	}

	private void updateData(Cliente updateCliente, Cliente cliente) {
		updateCliente.setEmail(cliente.getEmail());
		updateCliente.setNomeCompleto(cliente.getNomeCompleto());
		updateCliente.setCpf(cliente.getCpf());
		updateCliente.setTelefone(cliente.getTelefone());
		updateCliente.setDataNascimento(cliente.getDataNascimento());
	}

	public Boolean deleteCliente(Integer id) {
		Cliente clienteDeleted = clienteRepository.findById(id).orElse(null);
		if (clienteDeleted != null) {
			clienteRepository.deleteById(id);
			clienteDeleted = clienteRepository.findById(id).orElse(null);
			if (clienteDeleted != null) {
				return false;
			} else {
				return true;
			}

		} else {
			return false;
		}
	}
}
