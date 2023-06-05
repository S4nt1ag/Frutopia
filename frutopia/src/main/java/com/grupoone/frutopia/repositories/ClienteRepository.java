package com.grupoone.frutopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoone.frutopia.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	boolean existsById(Integer id);
	
	Boolean existsByEmail(String email);
}
