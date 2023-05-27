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

import com.grupoone.frutopia.dto.ItemPedidoDTO;
import com.grupoone.frutopia.entities.ItemPedido;
import com.grupoone.frutopia.services.ItemPedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/itens_pedidos")
public class ItemPedidoController {

	@Autowired
	ItemPedidoService itemPedidoService;

	@GetMapping
	public ResponseEntity<List<ItemPedidoDTO>> getAllItensDtoPedidos() {
		return new ResponseEntity<>(itemPedidoService.getAllItensPedidosDto(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedidoDTO> getItemPedidoDtoById(@Valid @PathVariable Integer id) {
		return new ResponseEntity<>(itemPedidoService.getItemPedidoDtoById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ItemPedido> saveItemPedido(@Valid @RequestBody ItemPedido categoria) {
		return new ResponseEntity<>(itemPedidoService.saveItemPedido(categoria), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ItemPedido> updateItemPedido(@Valid @RequestBody ItemPedido categoria,
			@Valid @PathVariable Integer id) {
		return new ResponseEntity<>(itemPedidoService.updateItemPedido(categoria, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ItemPedido> deleteItemPedido(@Valid @PathVariable Integer id) {
		itemPedidoService.deleteItemPedido(id);
		return ResponseEntity.ok().build();
	}
}
