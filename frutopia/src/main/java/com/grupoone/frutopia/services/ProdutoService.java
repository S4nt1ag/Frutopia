package com.grupoone.frutopia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.ItemPedidoDTO;
import com.grupoone.frutopia.dto.ProdutoDTO;
import com.grupoone.frutopia.entities.Produto;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.exceptions.NullPointExPedidoProduto;
import com.grupoone.frutopia.repositories.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ProdutoDTO> getAllProdutoDto() {
		List<Produto> listaProduto = produtoRepository.findAll();
		List<ProdutoDTO> produtoDto = modelMapper.map(listaProduto, new TypeToken<List<ProdutoDTO>>() {
		}.getType());
		List<ItemPedidoDTO> listaItemPedidosDTO = new ArrayList<>();

		for (int i = 0; i < listaProduto.size(); i++) {
			ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
			itemPedidoDTO.setId(itemPedidoDTO.getId());
			listaItemPedidosDTO.add(itemPedidoDTO);
			// Categoria categoria = listaProduto.get(i).getCategoria();
			// Integer idCategoria = categoria.getIdCategoria();
			// produtoDto.get(i).getCategoriaDTO().set(idCategoria);

		}
		return produtoDto;
	}

	public ProdutoDTO getProdutoDtoById(Integer id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada"));
		ProdutoDTO produtoDto = new ProdutoDTO();

		// alterar Model
		produtoDto.setIdProduto(produto.getIdProduto());
		produtoDto.setNome(produto.getNome());
		produtoDto.setDescricao(produto.getDescricao());
		produtoDto.setQtdEstoque(produto.getQtdEstoque());
		produtoDto.setDataCadastro(produto.getDataCadastro());
		produtoDto.setValorUnitario(produto.getValorUnitario());
		produtoDto.setImagem(produto.getImagem());

		try {

		} catch (NullPointerException e) {
			throw new NullPointExPedidoProduto("");
		}
		return produtoDto;
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
			Produto updateProduto = produtoRepository.getReferenceById(id);
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