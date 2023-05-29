package com.grupoone.frutopia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoone.frutopia.dto.EnderecoDTO;
import com.grupoone.frutopia.entities.Endereco;
import com.grupoone.frutopia.services.EnderecoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> getAllEnderecosDTO() {
		return new ResponseEntity<>(enderecoService.getAllEnderecosDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDTO> getEnderecoDTOById(@Valid @PathVariable Integer id) {
		return new ResponseEntity<>(enderecoService.getEnderecoById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Endereco> saveEndereco(@Valid @RequestBody Endereco endereco) {
		return new ResponseEntity<>(enderecoService.saveEndereco(endereco), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> updateEndereco(@Valid @RequestBody Endereco endereco, @Valid @PathVariable Integer id) {
		return new ResponseEntity<>(enderecoService.updateEndereco(endereco, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteEndereco(@Valid @PathVariable Integer id) {
		Boolean resp = enderecoService.deleteEndereco(id);
		if (resp)
			return new ResponseEntity<>(resp, HttpStatus.OK);
		else
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
	}
}