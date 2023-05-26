package com.grupoone.frutopia.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.EnderecoDTO;
import com.grupoone.frutopia.entities.Cliente;
import com.grupoone.frutopia.entities.Endereco;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.repositories.EnderecoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<EnderecoDTO> getAllEnderecosDTO() {
		//EnderecoDTO enderecoDTO = new EnderecoDTO();
		List<Endereco> listaEndereco = enderecoRepository.findAll();
		List<EnderecoDTO> listaEnderecoDTO = modelMapper.map(listaEndereco, new TypeToken<List<EnderecoDTO>>() {}.getType());		
		
		for (int i = 0; i < listaEndereco.size(); i++) {
			
			Cliente cliente = listaEndereco.get(i).getCliente();
			Integer idCliente = cliente.getIdCliente();
			listaEnderecoDTO.get(i).getCliente().setIdCliente(idCliente);
		}
		
		return listaEnderecoDTO;
	}
	
	public Endereco getEnderecoById(Integer id) {
		return enderecoRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
	}

	public Endereco saveEndereco(Endereco endereco) {
		
		try {
		Endereco novoEndereco = enderecoRepository.save(endereco);
		return novoEndereco;
		}
		
		catch (DataAccessException e) {
            throw new IdNotFoundException("");
        }
	}
	
	public Endereco updateEndereco(Endereco endereco, Integer id) {
		try {
			Endereco updateEndereco = enderecoRepository.getReferenceById(id);
			updateData(updateEndereco, endereco);
			return enderecoRepository.save(updateEndereco);
		}
		catch (EntityNotFoundException e) {
			throw new NoSuchElementException("");
		}
	}
	
	private void updateData(Endereco updateEndereco, Endereco instrutor) {
		updateEndereco.setCep(instrutor.getCep());
		updateEndereco.setRua(instrutor.getRua());
		updateEndereco.setBairro(instrutor.getBairro());
		updateEndereco.setCidade(instrutor.getCidade());
		updateEndereco.setNumero(instrutor.getNumero());
		updateEndereco.setComplemento(instrutor.getComplemento());
		updateEndereco.setUf(instrutor.getUf());
	}

	public Boolean deleteEndereco(Integer id) {
		Endereco enderecoDeleted = enderecoRepository.findById(id).orElse(null);
		if (enderecoDeleted != null) {
			enderecoRepository.deleteById(id);
			enderecoDeleted = enderecoRepository.findById(id).orElse(null);
			if (enderecoDeleted != null) {
				return false;
			} else {
				return true;
			}

		} else {
			return false;
		}
	}
}
