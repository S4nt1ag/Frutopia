package com.grupoone.frutopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoone.frutopia.entities.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

	boolean existsById(Integer id);
}
