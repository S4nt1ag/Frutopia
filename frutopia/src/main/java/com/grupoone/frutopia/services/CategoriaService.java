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
import com.grupoone.frutopia.dto.ProdutoNomeDTO;
import com.grupoone.frutopia.entities.Categoria;
import com.grupoone.frutopia.entities.Produto;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private EmailService emailService;
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<CategoriaDTO> getAllCategoriasDTO() {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		List<CategoriaDTO> listaCategoriasDto = modelMapper.map(listaCategorias, new TypeToken<List<CategoriaDTO>>() {
		}.getType());
		for (int i = 0; i < listaCategorias.size(); i++) {
			
			List<ProdutoNomeDTO> listaProdutoNomeDto = new ArrayList<>();
			for(Produto item : listaCategorias.get(i).getListaProdutos()) {
				ProdutoNomeDTO produtoNome = modelMapper.map(item, ProdutoNomeDTO.class);
				listaProdutoNomeDto.add(produtoNome);
			}
			
			listaCategoriasDto.get(i).setListaProdutosDTO(listaProdutoNomeDto);
		}
		return listaCategoriasDto;
	}

	public CategoriaDTO getCategoriaDTOById(Integer id) {
		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Entidade nÃ£o encontrada"));

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
		
		emailService.enviarEmail("frutopia.projeto.api@gmail.com", "Boa tarde", categoria.toString());
		return categoriaDTO;
	}

	public Categoria saveCategoria(Categoria categoria) {
		try {
			Categoria novoCategoria = categoriaRepository.save(categoria);
			return novoCategoria;
		} catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}

	public Categoria updateCategoria(Categoria categoria, Integer id) {
		try {
			if (categoria != null) {
			Categoria updateCategoria = categoriaRepository.getReferenceById(id);
			updateData(updateCategoria, categoria);
			return categoriaRepository.save(updateCategoria);
			} else {
				throw new NoSuchElementException("");
			}
		} catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}

	private void updateData(Categoria updateCategoria, Categoria categoria) {
		updateCategoria.setNome(categoria.getNome());
		updateCategoria.setDescricao(categoria.getDescricao());
	}

	public void deleteCategoria(Integer id) {
		Categoria categoriaDeleted = categoriaRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Entidade nÃ£o foi encontrada"));
		
		categoriaRepository.delete(categoriaDeleted);
	}
}