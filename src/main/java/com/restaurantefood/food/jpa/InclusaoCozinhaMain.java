package com.restaurantefood.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.restaurantefood.food.AlgafoodApiApplication;
import com.restaurantefood.food.domain.model.Cozinha;


public class InclusaoCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Bolos da Vovo");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Food Truck");
		
		cozinha1 = cadastroCozinha.adicionar(cozinha1);
		cozinha2 = cadastroCozinha.adicionar(cozinha2);
	}
	
}