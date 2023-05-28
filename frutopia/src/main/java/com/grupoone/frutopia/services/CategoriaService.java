package com.grupoone.frutopia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.CategoriaDTO;
import com.grupoone.frutopia.dto.ProdutoNomeDTO;
import com.grupoone.frutopia.entities.Categoria;
import com.grupoone.frutopia.entities.Produto;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.repositories.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<CategoriaDTO> getAllCategoriasDTO() {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		List<CategoriaDTO> listaCategoriasDto = modelMapper.map(listaCategorias, new TypeToken<List<CategoriaDTO>>() {
		}.getType());

		return listaCategoriasDto;
	}

	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}

	public Categoria getCategoriaById(Integer id) {

		return categoriaRepository.findById(id).orElseThrow(() -> new IdNotFoundException(""));
	}

	public CategoriaDTO getCategoriaDTOById(Integer id) {
		Categoria categoria = categoriaRepository.findById(id).orElse(null);

		if (categoria == null)
			return null;

		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setNome(categoria.getNome());
		categoriaDTO.setDescricao(categoria.getDescricao());

		List<ProdutoNomeDTO> produtoNomeDTO = new ArrayList<>();

		for (Produto produto : categoria.getListaProdutos()) {
			ProdutoNomeDTO listaProdutoNomeDTO = new ProdutoNomeDTO();
			listaProdutoNomeDTO.setNome(produto.getNome());
			produtoNomeDTO.add(listaProdutoNomeDTO);
		}

		categoriaDTO.setListaProdutosDTO(produtoNomeDTO);
		return categoriaDTO;
	}

	public Categoria saveCategoria(Categoria categoria) {
		Categoria novoCategoria = categoriaRepository.save(categoria);
		return novoCategoria;
	}

	public Categoria updateCategoria(Categoria categoria, Integer id) {
		try {
			Categoria updateCategoria = categoriaRepository.getReferenceById(id);
			updateData(updateCategoria, categoria);
			return categoriaRepository.save(updateCategoria);
		} catch (EntityNotFoundException e) {
			throw new NoSuchElementException("");
		}
	}

	private void updateData(Categoria updateCategoria, Categoria categoria) {
		updateCategoria.setNome(categoria.getNome());
		updateCategoria.setDescricao(categoria.getDescricao());
	}

	public Boolean deleteCategoria(Integer id) {
		Categoria categoriaDeleted = categoriaRepository.findById(id).orElse(null);
		if (categoriaDeleted != null) {
			categoriaRepository.deleteById(id);
			categoriaDeleted = categoriaRepository.findById(id).orElse(null);
			if (categoriaDeleted != null) {
				return false;
			} else {
				return true;
			}

		} else {
			return false;
		}
	}
}
