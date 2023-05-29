package com.grupoone.frutopia.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.ItemPedidoDTO;
import com.grupoone.frutopia.dto.PedidoResumidoDTO;
import com.grupoone.frutopia.dto.ProdutoDTO;
import com.grupoone.frutopia.entities.ItemPedido;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
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
			ProdutoDTO produtoDto = modelMapper.map(listaItens.get(i).getProduto(), ProdutoDTO.class);
			listaItensDto.get(i).setProdutoDTO(produtoDto);

			PedidoResumidoDTO pedidoDto = modelMapper.map(listaItens.get(i).getPedido(), PedidoResumidoDTO.class);
			listaItensDto.get(i).setPedidoResumidoDTO(pedidoDto);
		}
		return listaItensDto;
	}

	public ItemPedidoDTO getItemPedidoDtoById(Integer id) {
		ItemPedido itemPedido = itemPedidoRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada"));

		ItemPedidoDTO itemPedidoDto = new ItemPedidoDTO();
		itemPedidoDto.setId(itemPedido.getIdItemPedido());
		itemPedidoDto.setPrecoVenda(itemPedido.getPrecoVenda());
		itemPedidoDto.setQuantidade(itemPedido.getQuantidade());
		itemPedidoDto.setPercentualDesconto(itemPedido.getPercentualDesconto());
		itemPedidoDto.setValorBruto(itemPedido.getValorBruto());
		itemPedidoDto.setValorLiquido(itemPedido.getValorLiquido());

		PedidoResumidoDTO pedidoDto = modelMapper.map(itemPedido.getPedido(), PedidoResumidoDTO.class);
		itemPedidoDto.setPedidoResumidoDTO(pedidoDto);

		ProdutoDTO produtoDto = modelMapper.map(itemPedido.getProduto(), ProdutoDTO.class);
		itemPedidoDto.setProdutoDTO(produtoDto);

		return itemPedidoDto;
	}

	public ItemPedido saveItemPedido(ItemPedido ItemPedido) {
		try {
			return itemPedidoRepository.save(ItemPedido);
		} catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}

	public ItemPedido updateItemPedido(ItemPedido itemPedido, Integer id) {
		try {
			ItemPedido updateItemPedido = itemPedidoRepository.findById(id)
					.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada"));
			updateData(updateItemPedido, itemPedido);
			return itemPedidoRepository.save(updateItemPedido);
		} catch (DataAccessException e) {
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

	public void deleteItemPedido(Integer id) {
		ItemPedido itemPedido = itemPedidoRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada"));

		itemPedidoRepository.delete(itemPedido);
	}
}
