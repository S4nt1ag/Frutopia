package com.grupoone.frutopia.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.entities.Produto;
import com.grupoone.frutopia.repositories.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}

	public Produto getProdutoById(Integer id) {
		return produtoRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
	}

	public Produto saveProduto(Produto produto) {
		Produto novoProduto = produtoRepository.save(produto);
		return novoProduto;
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
		updateProduto.setDescricao(produto.getDescricao()) ;
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
