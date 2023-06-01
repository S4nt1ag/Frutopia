package com.grupoone.frutopia.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grupoone.frutopia.dto.CepDTO;
import com.grupoone.frutopia.dto.ClienteDTO;
import com.grupoone.frutopia.dto.EnderecoDTO;
import com.grupoone.frutopia.entities.Endereco;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.repositories.EnderecoRepository;

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
			CepDTO cep = consultaApiCep(endereco.getCep());

			endereco.setRua(cep.getLogradouro());
			endereco.setCidade(cep.getLocalidade());
			endereco.setUf(cep.getUf());
			endereco.setBairro(cep.getBairro());

			Endereco novoEndereco = enderecoRepository.save(endereco);

			return novoEndereco;
		}

		catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}

	public Endereco updateEndereco(Endereco endereco, Integer id) {

		try {
			Endereco updateEndereco = enderecoRepository.findById(id)
					.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada!"));

			updateData(updateEndereco, endereco);
			return enderecoRepository.save(updateEndereco);

		} catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}

	}

	private void updateData(Endereco updateEndereco, Endereco endereco) {
		
		CepDTO cep = consultaApiCep(endereco.getCep());
		
		updateEndereco.setCep(endereco.getCep());
		updateEndereco.setRua(cep.getLogradouro());
		updateEndereco.setBairro(cep.getBairro());
		updateEndereco.setCidade(cep.getLocalidade());
		updateEndereco.setNumero(endereco.getNumero());
		updateEndereco.setComplemento(endereco.getComplemento());
		updateEndereco.setUf(cep.getUf());
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

	private CepDTO consultaApiCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://viacep.com.br/ws/{cep}/json";

		Map<String, String> params = new HashMap<>();
		params.put("cep", cep); // "cep" nome dentro {} do uri

		CepDTO cepDto = restTemplate.getForObject(uri, CepDTO.class, params);
		return cepDto;
	}
}
