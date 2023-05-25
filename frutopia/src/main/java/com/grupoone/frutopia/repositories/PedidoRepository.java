package com.grupoone.frutopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoone.frutopia.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	boolean existsById(Integer id);
	
}
