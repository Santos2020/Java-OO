package com.restaurantefood.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.restaurantefood.food.domain.exception.EntidadeEmUsoException;
import com.restaurantefood.food.domain.exception.EntidadeNaoEncrontradaException;
import com.restaurantefood.food.domain.model.Cozinha;
import com.restaurantefood.food.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinha {

	@Autowired
	CozinhaRepository cozinhaRepository;

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.salvar(cozinha);

	}

	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.remover(cozinhaId);
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncrontradaException(
					String.format("não existem um cadastro de cozinha com código %d", cozinhaId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("conzinha %d não pode ser removida porque esta em uso", cozinhaId));
		}
	}

}
