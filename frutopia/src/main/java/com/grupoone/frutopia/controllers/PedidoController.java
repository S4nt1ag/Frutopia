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

import com.grupoone.frutopia.dto.PedidoDTO;
import com.grupoone.frutopia.entities.Pedido;
import com.grupoone.frutopia.services.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<PedidoDTO>> getAllPedidosDto() {
		return new ResponseEntity<>(pedidoService.getAllPedidosDto(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> getPedidoDtobyId(@Valid @PathVariable Integer id) {
		return new ResponseEntity<>(pedidoService.getPedidoDtoById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Pedido> savePedido(@Valid @RequestBody Pedido pedido) {
		return new ResponseEntity<>(pedidoService.savePedido(pedido), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pedido> updatePedido(@Valid @RequestBody Pedido pedido,
			@Valid @PathVariable Integer id) {
		return new ResponseEntity<>(pedidoService.updatePedido(pedido, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePedido(@Valid @PathVariable Integer id) {
		Boolean resp = pedidoService.deletePedido(id);
		if (resp)
			return new ResponseEntity<>(resp, HttpStatus.OK);
		else
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
	}
	
}
