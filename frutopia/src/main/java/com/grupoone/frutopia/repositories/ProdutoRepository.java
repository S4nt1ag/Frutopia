package com.grupoone.frutopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoone.frutopia.entities.Categoria;
import com.grupoone.frutopia.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

		boolean existsById(Integer id);

}
