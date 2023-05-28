package com.grupoone.frutopia.entities.enums;

public enum StatusPedido {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);

	private int code; // código do enum
	
	private StatusPedido(int code) { // construtor para o enum
		this.code = code;
	}
	
	public int getCode() { // para deixar o código acessível
		return code;
	}
	
	public static StatusPedido valueOf(int code) { // para converter valor numérico do enum para Enum
		for(StatusPedido value : StatusPedido.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de StatusPedido inválido");
	}
}
