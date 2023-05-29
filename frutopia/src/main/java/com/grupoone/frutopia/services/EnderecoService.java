package com.grupoone.frutopia.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.ClienteDTO;
import com.grupoone.frutopia.dto.EnderecoDTO;
import com.grupoone.frutopia.entities.Categoria;
import com.grupoone.frutopia.entities.Endereco;
import com.grupoone.frutopia.entities.Pedido;
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
		List<Endereco> listaEndereco = enderecoRepository.findAll();
		List<EnderecoDTO> listaEnderecoDTO = modelMapper.map(listaEndereco, new TypeToken<List<EnderecoDTO>>() {
		}.getType());

		for (int i = 0; i < listaEndereco.size(); i++) {
			ClienteDTO clienteDto = modelMapper.map(listaEndereco.get(i).getCliente(), ClienteDTO.class);
			listaEnderecoDTO.get(i).setClienteDTO(clienteDto);
		}
		return listaEnderecoDTO;
	}

	public EnderecoDTO getEnderecoById(Integer id) {

		Endereco endereco = enderecoRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada!"));

		EnderecoDTO enderecoDto = new EnderecoDTO();

		enderecoDto.setIdEndereco(endereco.getIdEndereco());
		enderecoDto.setCep(endereco.getCep());
		enderecoDto.setRua(endereco.getRua());
		enderecoDto.setBairro(endereco.getBairro());
		enderecoDto.setCidade(endereco.getCidade());
		enderecoDto.setNumero(endereco.getNumero());
		enderecoDto.setComplemento(endereco.getComplemento());
		enderecoDto.setUf(endereco.getUf());
		ClienteDTO clienteDto = modelMapper.map(endereco.getCliente(), ClienteDTO.class);
		enderecoDto.setClienteDTO(clienteDto);

		return enderecoDto;
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
			// if(endereco != null) {
				Endereco updateEndereco = enderecoRepository.findById(id)
						.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada!"));
				
				updateData(updateEndereco, endereco);
				return enderecoRepository.save(updateEndereco);
			//} else {
				//throw new NoSuchElementException("");
			//}
			
		} catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
					
	}

	private void updateData(Endereco updateEndereco, Endereco endereco) {
		
		updateEndereco.setCep(endereco.getCep());
		updateEndereco.setRua(endereco.getRua());
		updateEndereco.setBairro(endereco.getBairro());
		updateEndereco.setCidade(endereco.getCidade());
		updateEndereco.setNumero(endereco.getNumero());
		updateEndereco.setComplemento(endereco.getComplemento());
		updateEndereco.setUf(endereco.getUf());	
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
