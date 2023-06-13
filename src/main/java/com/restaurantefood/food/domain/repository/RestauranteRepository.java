package com.restaurantefood.food.domain.repository;

import java.util.List;

import com.restaurantefood.food.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> listar();

	Restaurante buscar(Long id);

	Restaurante salvar(Restaurante restaurante);

	void remover(Restaurante restaurante);

}
