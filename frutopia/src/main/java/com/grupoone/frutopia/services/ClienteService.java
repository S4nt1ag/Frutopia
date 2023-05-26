package com.grupoone.frutopia.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.entities.Cliente;
import com.grupoone.frutopia.repositories.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	public Cliente getClienteById(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
	}

	public Cliente saveCliente(Cliente cliente) {
		Cliente novoCliente = clienteRepository.save(cliente);
		return novoCliente;
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
