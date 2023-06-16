package com.restaurantefood.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantefood.food.domain.model.Cidade;
import com.restaurantefood.food.domain.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.listar();

	}

	@GetMapping("/{cidadeId}")
	public Cidade buscar(@PathVariable Long cidadeId) {
		return cidadeRepository.buscar(cidadeId);
	}

}
