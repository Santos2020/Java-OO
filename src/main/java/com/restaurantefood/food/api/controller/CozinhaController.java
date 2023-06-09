package com.restaurantefood.food.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantefood.food.domain.exception.EntidadeEmUsoException;
import com.restaurantefood.food.domain.exception.EntidadeNaoEncrontradaException;
import com.restaurantefood.food.domain.model.Cozinha;
import com.restaurantefood.food.domain.repository.CozinhaRepository;
import com.restaurantefood.food.domain.service.CadastroCozinha;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	CadastroCozinha cadastroCozinha;

	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();

	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinha.salvar(cozinha);
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);

		if (cozinhaAtual != null) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			cozinhaRepository.salvar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual);
		}
		return ResponseEntity.notFound().build();

	}
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
		try {
			cadastroCozinha.excluir(cozinhaId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncrontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}

