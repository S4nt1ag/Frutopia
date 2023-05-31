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

import com.grupoone.frutopia.dto.CategoriaDTO;
import com.grupoone.frutopia.entities.Categoria;
import com.grupoone.frutopia.services.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> getAllCategoriasDTO() {
		return new ResponseEntity<>(categoriaService.getAllCategoriasDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> getCategoriaById(@Valid @PathVariable Integer id) {
		return new ResponseEntity<>(categoriaService.getCategoriaDTOById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Categoria> saveCategoria(@Valid @RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Categoria> updateCategoria(@Valid @RequestBody Categoria categoria,
			@Valid @PathVariable Integer id) {
		return new ResponseEntity<>(categoriaService.updateCategoria(categoria, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategoria(@Valid @PathVariable Integer id) {
		categoriaService.deleteCategoria(id);
		return ResponseEntity.ok("Entidade deleteda");
	}
}