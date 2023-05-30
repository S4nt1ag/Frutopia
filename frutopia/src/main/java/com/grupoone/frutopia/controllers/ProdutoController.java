package com.grupoone.frutopia.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grupoone.frutopia.dto.ProdutoDTO;
import com.grupoone.frutopia.dto.ProdutoResumidoDTO;
import com.grupoone.frutopia.entities.Produto;
import com.grupoone.frutopia.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> getAllProdutosDto() {
		return new ResponseEntity<>(produtoService.getAllProdutoDto(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResumidoDTO> getProdutoDtoByIdDto(@Valid @PathVariable Integer id) {
		return new ResponseEntity<>(produtoService.getProdutoDtoById(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE
			, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Produto> saveProduto(@RequestPart("nome")String nome, @RequestPart("descricao")String descricao,
			@RequestPart("qtdEstoque") String qtdEstoque, @RequestPart("dataCadastro")String dataCadastro,
			@RequestPart("valorUnitario")String valorUnitario, @RequestPart("imagem")MultipartFile imagem,
			@RequestPart("categoria")String categoria) throws IOException {
		
	    return new ResponseEntity<>(produtoService.saveProduto(nome, descricao, qtdEstoque, dataCadastro, valorUnitario,
	    		imagem, categoria), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> updateProduto(@Valid @RequestBody Produto produto,
			@Valid @PathVariable Integer id) {
		return new ResponseEntity<>(produtoService.updateProduto(produto, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deleteProduto(@Valid @PathVariable Integer id) {
		produtoService.deleteProduto(id);
		return ResponseEntity.noContent().build();
	}
}