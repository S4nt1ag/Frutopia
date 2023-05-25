package com.grupoone.frutopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoone.frutopia.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	boolean existsById(Integer id);

}