package com.grupoone.frutopia.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.ItemPedidoDTO;
import com.grupoone.frutopia.entities.ItemPedido;
import com.grupoone.frutopia.repositories.ItemPedidoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemPedidoService {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<ItemPedidoDTO> getAllItensPedidosDto() {
		List<ItemPedido> listaItens = itemPedidoRepository.findAll();
		List<ItemPedidoDTO> listaItensDto = modelMapper.map(listaItens, new TypeToken<List<ItemPedidoDTO>>() {}.getType());		
				
			for (int i = 0; i < listaItens.size(); i++) {
			Produto produto = listaItens.get(i).getProduto();
			Integer idProduto = produto.getId(); // verificar classe	
			listaItensDto.get(i).getProduto().setIdProduto(idProduto); // verificar classe

			Pedido pedido = listaItens.get(i).getPedido();
			Integer idPedido = pedido.getId(); // verificar classe	
			listaItensDto.get(i).getPedido().setIdPedido(idPedido); // verificar classe
		}

		return listaItensDto;
	}

	public ItemPedidoDTO getItemPedidoDtoById(Integer id) {
		
		ItemPedido itemPedido = itemPedidoRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
		ItemPedidoDTO itemPedidoDto = new ItemPedidoDTO();
		
		if(itemPedido == null) {
			return null;
		}		
		
		// alterar Model
		itemPedidoDto.setPrecoVenda(itemPedido.getPrecoVenda());
		itemPedidoDto.setQuantidade(itemPedido.getQuantidade());
		itemPedidoDto.setPercentualDesconto(itemPedido.getPercentualDesconto());
		itemPedidoDto.setValorBruto(itemPedido.getValorBruto());
		itemPedidoDto.setValorLiquido(itemPedido.getValorLiquido());
		itemPedidoDto.setPedido(itemPedido.getPedido().getIdPedido()); // verificar
		itemPedidoDto.setProduto(itemPedido.getProduto().getIdProduto()); // verificar

		return itemPedidoDto;
	}

	public ItemPedido saveItemPedido(ItemPedido ItemPedido) {
		ItemPedido novoItemPedido = itemPedidoRepository.save(ItemPedido);
		return novoItemPedido;
	}

	public ItemPedido updateItemPedido(ItemPedido itemPedido, Integer id) {
		try {
			ItemPedido updateItemPedido = itemPedidoRepository.findById(id).get();
			updateData(updateItemPedido, itemPedido);
			return itemPedidoRepository.save(updateItemPedido);
		} catch (EntityNotFoundException e) {
			throw new NoSuchElementException("");
		}
	}

	private void updateData(ItemPedido updateItemPedido, ItemPedido itemPedido) {
		updateItemPedido.setIdItemPedido(itemPedido.getIdItemPedido());
		updateItemPedido.setPrecoVenda(itemPedido.getPrecoVenda());
		updateItemPedido.setPercentualDesconto(itemPedido.getPercentualDesconto());
		updateItemPedido.setValorBruto(itemPedido.getValorBruto());
		updateItemPedido.setValorLiquido(itemPedido.getValorLiquido());
		updateItemPedido.setPedido(itemPedido.getPedido());
		updateItemPedido.setProduto(itemPedido.getProduto());		
	}

	public Boolean deleteItemPedido(Integer id) {
		ItemPedido ItemPedidoDeleted = itemPedidoRepository.findById(id).orElse(null);
		if (ItemPedidoDeleted != null) {
			itemPedidoRepository.deleteById(id);
			ItemPedidoDeleted = itemPedidoRepository.findById(id).orElse(null);
			if (ItemPedidoDeleted != null) {
				return false;
			} else {
				return true;
			}

		} else {
			return false;
		}
	}
}
