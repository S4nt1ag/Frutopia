package com.grupoone.frutopia.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.entities.Categoria;
import com.grupoone.frutopia.repositories.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public List<Categoria> getAllCategoriaes() {
		return categoriaRepository.findAll();
	}

	public Categoria getCategoriaById(Integer id) {
		return categoriaRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
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
