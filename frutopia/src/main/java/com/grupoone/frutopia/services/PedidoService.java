package com.grupoone.frutopia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.ClienteResumidoDTO;
import com.grupoone.frutopia.dto.ItemPedidoResumidoDTO;
import com.grupoone.frutopia.dto.PedidoDTO;
import com.grupoone.frutopia.entities.ItemPedido;
import com.grupoone.frutopia.entities.Pedido;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<PedidoDTO> getAllPedidosDto() {
		List<Pedido> listaPedidos =  pedidoRepository.findAll();
		List<PedidoDTO> listaPedidosDto = 
				modelMapper.map(listaPedidos, new TypeToken<List<PedidoDTO>>() {}.getType());
		
		for(int i = 0; i < listaPedidos.size(); i++) {
			ClienteResumidoDTO clienteDto = modelMapper.map(listaPedidos.get(i).getCliente(),ClienteResumidoDTO.class);
			listaPedidosDto.get(i).setCliente(clienteDto);

			List<ItemPedidoResumidoDTO> listaItemPedido = new ArrayList<>();
			for(ItemPedido item : listaPedidos.get(i).getListaItemPedido()) {
				ItemPedidoResumidoDTO itemPedidoDTO = modelMapper.map(item, ItemPedidoResumidoDTO.class);
				listaItemPedido.add(itemPedidoDTO);
			}
			
			listaPedidosDto.get(i).setListaItemPedido(listaItemPedido);
		}
		
		return listaPedidosDto;
	}
	
	public PedidoDTO getPedidoDtoById(Integer id) {
		Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada"));
		PedidoDTO pedidoDTO = new PedidoDTO();

		pedidoDTO.setIdPedido(pedido.getIdPedido());
		pedidoDTO.setDataPedido(pedido.getDataPedido());
		pedidoDTO.setDataEntrega(pedido.getDataEntrega());
		pedidoDTO.setDataEnvio(pedido.getDataEnvio());
		pedidoDTO.setStatus(pedido.getStatus());
		pedidoDTO.setValorTotal(pedido.getValorTotal());
		ClienteResumidoDTO clienteDto = modelMapper.map(pedido.getCliente(),ClienteResumidoDTO.class);
		pedidoDTO.setCliente(clienteDto);
		
		List<ItemPedidoResumidoDTO> listaItemPedido = new ArrayList<>();
		for(ItemPedido item : pedido.getListaItemPedido()) {
			ItemPedidoResumidoDTO itemPedidoDTO = modelMapper.map(item, ItemPedidoResumidoDTO.class);
			listaItemPedido.add(itemPedidoDTO);
		}
		
		pedidoDTO.setListaItemPedido(listaItemPedido);
		
		return pedidoDTO;
	}
	
	public Pedido savePedido(Pedido pedido) {
		try {
			return pedidoRepository.save(pedido);
		} catch(DataAccessException e) {
			throw new IdNotFoundException("");
		}
		
	}
	
	public Pedido updatePedido(Pedido pedido, Integer id) {
		try {
			if(pedido.getCliente() != null) {
				Pedido updatePedido = pedidoRepository.findById(id).get();
				updateData(updatePedido, pedido);
				return pedidoRepository.save(updatePedido);
			} else {
				throw new NoSuchElementException("");
			}
			
		} catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}
	
	private void updateData(Pedido updatePedido, Pedido pedido) {
		updatePedido.setDataPedido(pedido.getDataPedido());
		updatePedido.setDataEntrega(pedido.getDataEntrega());
		updatePedido.setDataEnvio(pedido.getDataEnvio());
		updatePedido.setStatus(pedido.getStatus());
		updatePedido.setValorTotal(pedido.getValorTotal());
		updatePedido.setCliente(pedido.getCliente());
		updatePedido.setListaItemPedido(pedido.getListaItemPedido());
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
