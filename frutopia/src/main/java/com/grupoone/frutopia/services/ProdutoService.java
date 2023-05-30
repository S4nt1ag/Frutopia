package com.grupoone.frutopia.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.grupoone.frutopia.dto.CategoriaDTO;
import com.grupoone.frutopia.dto.CategoriaResumidaDTO;
import com.grupoone.frutopia.dto.ItemPedidoResumidoDTO;
import com.grupoone.frutopia.dto.ProdutoDTO;
import com.grupoone.frutopia.dto.ProdutoResumidoDTO;
import com.grupoone.frutopia.entities.Categoria;
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
	
	public Produto saveProduto(String nome, String descricao, String qtdEstoque, String dataCadastro, 
			String valorUnitario, MultipartFile imagem, String categoria){
		try {
			Produto produto = new Produto();
			produto.setNome(nome);
			produto.setDescricao(descricao);
			produto.setQtdEstoque(Integer.parseInt(qtdEstoque));
			produto.setDataCadastro(LocalDate.parse(dataCadastro));
			produto.setValorUnitario(Double.parseDouble(valorUnitario));
			
			try {
				produto.setImagem(imagem.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Categoria novaCategoria = new Categoria();
			novaCategoria.setIdCategoria(Integer.parseInt(categoria));
			produto.setCategoria(novaCategoria);
					
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

	public void deleteProduto(Integer id) {
		Produto produtoDeleted = produtoRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada"));

		produtoRepository.delete(produtoDeleted);
	}
}