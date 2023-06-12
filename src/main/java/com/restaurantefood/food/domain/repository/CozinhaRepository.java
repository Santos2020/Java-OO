package com.restaurantefood.food.domain.repository;

import java.util.List;

import com.restaurantefood.food.domain.model.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> todas();
	Cozinha porId(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Cozinha cozinha);

}
