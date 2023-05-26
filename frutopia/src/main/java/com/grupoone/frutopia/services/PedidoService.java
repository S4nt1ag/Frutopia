package com.grupoone.frutopia.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.entities.Pedido;
import com.grupoone.frutopia.repositories.PedidoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}
	
	public Pedido getPedidoById(Integer id) {
		return pedidoRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
	}
	
	public Pedido savePedido(Pedido pedido) {
		Pedido novoPedido = pedidoRepository.save(pedido);
		return novoPedido;
	}
	
	public Pedido updatePedido(Pedido pedido, Integer id) {
		try {
			Pedido updatePedido = pedidoRepository.getReferenceById(id);
			updateData(updatePedido, pedido);
			return pedidoRepository.save(updatePedido);
		} catch(EntityNotFoundException e) {
			throw new NoSuchElementException("");
		}
	}
	
	private void updateData(Pedido updatePedido, Pedido pedido) {
		updatePedido.setDataPedido(pedido.getDataPedido());
		updatePedido.setDataEntrega(pedido.getDataEntrega());
		updatePedido.setDataEnvio(pedido.getDataEnvio());
		updatePedido.setStatus(pedido.getStatus());
		updatePedido.setValorTotal(pedido.getValorTotal());
		updatePedido.setCliente(pedido.getCliente());
	}
	
	public Boolean deletePedido(Integer id) {
		Pedido pedidoDeleted = pedidoRepository.findById(id).orElse(null);
		
		if(pedidoDeleted != null) { 
			pedidoRepository.delete(pedidoDeleted);
			pedidoDeleted = pedidoRepository.findById(id).orElse(null);
			if(pedidoDeleted != null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}
