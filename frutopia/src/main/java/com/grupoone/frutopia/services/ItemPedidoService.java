package com.grupoone.frutopia.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.ItemPedidoDTO;
import com.grupoone.frutopia.entities.ItemPedido;
import com.grupoone.frutopia.entities.Pedido;
import com.grupoone.frutopia.entities.Produto;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.exceptions.NullPointExPedidoProduto;
import com.grupoone.frutopia.repositories.ItemPedidoRepository;
import com.grupoone.frutopia.repositories.PedidoRepository;
import com.grupoone.frutopia.repositories.ProdutoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ItemPedidoDTO> getAllItensPedidosDto() {
		List<ItemPedido> listaItens = itemPedidoRepository.findAll();
		List<ItemPedidoDTO> listaItensDto = modelMapper.map(listaItens, new TypeToken<List<ItemPedidoDTO>>() {
		}.getType());

		for (int i = 0; i < listaItens.size(); i++) {
			Produto produto = listaItens.get(i).getProduto();
			Integer idProduto = produto.getIdProduto();
			listaItensDto.get(i).getProdutoDTO().setIdProduto(idProduto);

			Pedido pedido = listaItens.get(i).getPedido();
			Integer idPedido = pedido.getIdPedido();
			listaItensDto.get(i).getPedidoDTO().setIdPedido(idPedido);
		}
		return listaItensDto;
	}

	public ItemPedidoDTO getItemPedidoDtoById(Integer id) {
		ItemPedido itemPedido = itemPedidoRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada"));
		ItemPedidoDTO itemPedidoDto = new ItemPedidoDTO();

		// alterar Model
		itemPedidoDto.setId(itemPedido.getIdItemPedido());
		itemPedidoDto.setPrecoVenda(itemPedido.getPrecoVenda());
		itemPedidoDto.setQuantidade(itemPedido.getQuantidade());
		itemPedidoDto.setPercentualDesconto(itemPedido.getPercentualDesconto());
		itemPedidoDto.setValorBruto(itemPedido.getValorBruto());
		itemPedidoDto.setValorLiquido(itemPedido.getValorLiquido());
		try {
			itemPedidoDto.getPedidoDTO().setIdPedido(itemPedido.getPedido().getIdPedido());
			itemPedidoDto.getProdutoDTO().setIdProduto(itemPedido.getProduto().getIdProduto());
		} 
		catch (NullPointerException e) {
			throw new NullPointExPedidoProduto("");
		}
		return itemPedidoDto;
	}

	public ItemPedido saveItemPedido(ItemPedido ItemPedido) {
		try {
			return itemPedidoRepository.save(ItemPedido);
		} 
		catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}

	public ItemPedido updateItemPedido(ItemPedido itemPedido, Integer id) {
		try {
			System.out.println("TESTE");
			if (produtoRepository.existsById(id) && pedidoRepository.existsById(id)) {
				ItemPedido updateItemPedido = itemPedidoRepository.findById(id).get();
				updateData(updateItemPedido, itemPedido);
				return itemPedidoRepository.save(updateItemPedido);
			} 
			else {
				throw new NoSuchElementException("");
			}
		} 
		catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}

	private void updateData(ItemPedido updateItemPedido, ItemPedido itemPedido) {
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
			} 
			else {
				return true;
			}
		} 
		else {
			return false;
		}
	}
}
