package com.grupoone.frutopia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.CategoriaDTO;
import com.grupoone.frutopia.dto.CategoriaResumidaDTO;
import com.grupoone.frutopia.dto.ItemPedidoResumidoDTO;
import com.grupoone.frutopia.dto.ProdutoDTO;
import com.grupoone.frutopia.dto.ProdutoResumidoDTO;
import com.grupoone.frutopia.entities.ItemPedido;
import com.grupoone.frutopia.entities.Produto;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.repositories.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ProdutoDTO> getAllProdutoDto() {
		List<Produto> listaProdutos = produtoRepository.findAll();
		List<ProdutoDTO> listaProdutosDto 
		= modelMapper.map(listaProdutos, new TypeToken<List<ProdutoDTO>>() {}.getType());

		for (int i = 0; i < listaProdutos.size(); i++) {
			CategoriaDTO categoriaDTO = modelMapper.map(listaProdutos.get(i).getCategoria(), CategoriaDTO.class);
			listaProdutosDto.get(i).setCategoriaDTO(categoriaDTO);

			List<ItemPedidoResumidoDTO> listaItenPedidos = new ArrayList<>();
			for (ItemPedido item : listaProdutos.get(i).getListaItensPedidos()) {
				ItemPedidoResumidoDTO itemPedidoDTO = modelMapper.map(item, ItemPedidoResumidoDTO.class);
				listaItenPedidos.add(itemPedidoDTO);
			}
			listaProdutosDto.get(i).setListaItensPedidos(listaItenPedidos);
		}
		return listaProdutosDto;
	}

	public ProdutoResumidoDTO getProdutoDtoById(Integer id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada"));
		ProdutoResumidoDTO produtoResDto = new ProdutoResumidoDTO();

		produtoResDto.setIdProduto(produto.getIdProduto());
		produtoResDto.setNome(produto.getNome());
		produtoResDto.setDescricao(produto.getDescricao());
		produtoResDto.setQtdEstoque(produto.getQtdEstoque());
		produtoResDto.setDataCadastro(produto.getDataCadastro());
		produtoResDto.setValorUnitario(produto.getValorUnitario());
		produtoResDto.setImagem(produto.getImagem());
		CategoriaResumidaDTO categoriaResDto = modelMapper.map(produto.getCategoria(), CategoriaResumidaDTO.class);
		produtoResDto.setCategoriaResDTO(categoriaResDto);
		
		List<ItemPedidoResumidoDTO> listaItensPedidos = new ArrayList<>();
		for(ItemPedido item : produto.getListaItensPedidos()) {
			ItemPedidoResumidoDTO itemPedidoDTO = modelMapper.map(item, ItemPedidoResumidoDTO.class);
			listaItensPedidos.add(itemPedidoDTO);
		}		
		produtoResDto.setListaItensPedidos(listaItensPedidos);	
		
		return produtoResDto;
	}

	public Produto saveProduto(Produto produto) {
		try {
			return produtoRepository.save(produto);

		} catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}

	public Produto updateProduto(Produto produto, Integer id) {
		try {
			Produto updateProduto = produtoRepository.findById(id).get();
			updateData(updateProduto, produto);
			return produtoRepository.save(updateProduto);
		} catch (EntityNotFoundException e) {
			throw new NoSuchElementException("");
		}
	}

	private void updateData(Produto updateProduto, Produto produto) {
		updateProduto.setNome(produto.getNome());
		updateProduto.setDescricao(produto.getDescricao());
		updateProduto.setQtdEstoque(produto.getQtdEstoque());
		updateProduto.setDataCadastro(produto.getDataCadastro());
		updateProduto.setValorUnitario(produto.getValorUnitario());
		updateProduto.setImagem(produto.getImagem());
		updateProduto.setCategoria(produto.getCategoria());
	}

	public Boolean deleteProduto(Integer id) {
		Produto produtoDeleted = produtoRepository.findById(id).orElse(null);
		if (produtoDeleted != null) {
			produtoRepository.deleteById(id);
			produtoDeleted = produtoRepository.findById(id).orElse(null);
			if (produtoDeleted != null) {
				return false;
			} else {
				return true;
			}

		} else {
			return false;
		}
	}
}