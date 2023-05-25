package com.grupoone.frutopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoone.frutopia.entities.Categoria;

public interface ClienteRepository extends JpaRepository<Categoria, Integer> {

	boolean existsById(Integer id);

}
