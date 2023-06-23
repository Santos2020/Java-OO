package com.restaurantefood.food.domain.exception;

public class EntidadeNaoEncrontradaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncrontradaException(String mensagem) {
		super(mensagem);
	}

}
