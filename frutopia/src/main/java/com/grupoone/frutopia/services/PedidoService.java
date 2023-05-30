package com.grupoone.frutopia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.ClienteResumidoDTO;
import com.grupoone.frutopia.dto.ItemPedidoResumidoDTO;
import com.grupoone.frutopia.dto.PedidoDTO;
import com.grupoone.frutopia.dto.RelatorioPedidoDTO;
import com.grupoone.frutopia.dto.RelatorioPedidoItemDTO;
import com.grupoone.frutopia.entities.ItemPedido;
import com.grupoone.frutopia.entities.Pedido;
import com.grupoone.frutopia.entities.Produto;
import com.grupoone.frutopia.exceptions.IdNotFoundException;
import com.grupoone.frutopia.repositories.ItemPedidoRepository;
import com.grupoone.frutopia.repositories.PedidoRepository;
import com.grupoone.frutopia.repositories.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EmailService emailService;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<PedidoDTO> getAllPedidosDto() {
		List<Pedido> listaPedidos =  pedidoRepository.findAll();
		List<PedidoDTO> listaPedidosDto = 
				modelMapper.map(listaPedidos, new TypeToken<List<PedidoDTO>>() {}.getType());
		
		for(int i = 0; i < listaPedidos.size(); i++) {
			ClienteResumidoDTO clienteDto = modelMapper.map(listaPedidos.get(i).getCliente(),ClienteResumidoDTO.class);
			listaPedidosDto.get(i).setCliente(clienteDto);

			List<ItemPedidoResumidoDTO> listaItemPedido = new ArrayList<>();
			for(ItemPedido item : listaPedidos.get(i).getListaItemPedido()) {
				ItemPedidoResumidoDTO itemPedidoDTO = modelMapper.map(item, ItemPedidoResumidoDTO.class);
				listaItemPedido.add(itemPedidoDTO);
			}
			
			listaPedidosDto.get(i).setListaItemPedido(listaItemPedido);
		}
		
		return listaPedidosDto;
	}
	
	public PedidoDTO getPedidoDtoById(Integer id) {
		Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Entidade não foi encontrada"));
		PedidoDTO pedidoDTO = new PedidoDTO();

		pedidoDTO.setIdPedido(pedido.getIdPedido());
		pedidoDTO.setDataPedido(pedido.getDataPedido());
		pedidoDTO.setDataEntrega(pedido.getDataEntrega());
		pedidoDTO.setDataEnvio(pedido.getDataEnvio());
		pedidoDTO.setStatus(pedido.getStatus());
		pedidoDTO.setValorTotal(pedido.getValorTotal());
		ClienteResumidoDTO clienteDto = modelMapper.map(pedido.getCliente(),ClienteResumidoDTO.class);
		pedidoDTO.setCliente(clienteDto);
		
		List<ItemPedidoResumidoDTO> listaItemPedido = new ArrayList<>();
		for(ItemPedido item : pedido.getListaItemPedido()) {
			ItemPedidoResumidoDTO itemPedidoDTO = modelMapper.map(item, ItemPedidoResumidoDTO.class);
			listaItemPedido.add(itemPedidoDTO);
		}
		
		pedidoDTO.setListaItemPedido(listaItemPedido);
		
		return pedidoDTO;
	}
	
	public Pedido savePedido(Pedido pedido) {
		try {
			//calculo de valores brutos e liquidos
			Pedido pedidoResponse =  pedidoRepository.save(pedido);
			
//			geraRelatorioPedido(pedido);
			return pedido;
		} catch(DataAccessException e) {
			throw new IdNotFoundException("");
		}
		
	}
	
	public Pedido updatePedido(Pedido pedido, Integer id) {
		try {
			if(pedido.getCliente() != null) {
				Pedido updatePedido = pedidoRepository.findById(id).get();
				updateData(updatePedido, pedido);
				return pedidoRepository.save(updatePedido);
			} else {
				throw new NoSuchElementException("");
			}
			
		} catch (DataAccessException e) {
			throw new IdNotFoundException("");
		}
	}
	
	private void updateData(Pedido updatePedido, Pedido pedido) {
		updatePedido.setDataPedido(pedido.getDataPedido());
		updatePedido.setDataEntrega(pedido.getDataEntrega());
		updatePedido.setDataEnvio(pedido.getDataEnvio());
		updatePedido.setStatus(pedido.getStatus());
		updatePedido.setValorTotal(pedido.getValorTotal());
		updatePedido.setCliente(pedido.getCliente());
		updatePedido.setListaItemPedido(pedido.getListaItemPedido());
	}
	
	public Boolean deletePedido(Integer id) {
		Pedido pedidoDeleted = pedidoRepository.findById(id).orElse(null);
		
		if(pedidoDeleted != null) { 
			pedidoRepository.delete(pedidoDeleted);
			pedidoDeleted = pedidoRepository.findById(id).orElse(null);
			if(pedidoDeleted != null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public RelatorioPedidoDTO geraRelatorioPedido(Integer id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		RelatorioPedidoDTO relatorio = new RelatorioPedidoDTO();
		relatorio.setIdPedido(pedido.getIdPedido());
		relatorio.setDataPedido(pedido.getDataPedido());
		
		Double valorTotal = 0.0;
		
		List<RelatorioPedidoItemDTO> itensRelatorio = new ArrayList<>();
		
		for(ItemPedido item : pedido.getListaItemPedido()) {
			
			Double percentualDesconto = 1 - ((item.getPercentualDesconto())/100.00) ;
			Double valorBruto = (item.getPrecoVenda())*(item.getQuantidade());
			Double valorLiquido = valorBruto*percentualDesconto;
			
			RelatorioPedidoItemDTO itemRelatorio = new RelatorioPedidoItemDTO();
			
			itemRelatorio.setCodigoProduto(item.getProduto().getIdProduto());
			itemRelatorio.setNomeProduto(item.getProduto().getNome());
			itemRelatorio.setPrecoVenda(item.getPrecoVenda());
			itemRelatorio.setQuantidade(item.getQuantidade());
			itemRelatorio.setValorBruto(valorBruto);
			itemRelatorio.setPercentualDesconto(item.getPercentualDesconto());
			itemRelatorio.setValorLiquido(valorLiquido);
			
			atualizaItemPedido(item, valorBruto, valorLiquido);
			
			itensRelatorio.add(itemRelatorio);
			
			valorTotal += valorLiquido;
		}
		
		relatorio.setValorTotal(valorTotal);
		relatorio.setListaItemPedido(itensRelatorio);
		
		emailService.enviarEmail("frutopia.projeto.api@gmail.com", "Boa tarde", relatorio.toString());
		
		return relatorio;
	}
	
	private void atualizaItemPedido(ItemPedido item, Double valorBruto, Double valorLiquido) {
		ItemPedido itemPedido = itemPedidoRepository.findById(item.getIdItemPedido()).orElse(null);
				
		if(itemPedido != null) {
			itemPedido.setValorBruto(valorBruto);
			itemPedido.setValorLiquido(valorLiquido);
			itemPedidoRepository.save(itemPedido);
		}
		
		Produto produto = produtoRepository.findById(item.getProduto().getIdProduto()).orElse(null);
		
		if(produto != null) {
			produto.setQtdEstoque(produto.getQtdEstoque() - item.getQuantidade());
			produtoRepository.save(produto);
		}
	}
}
