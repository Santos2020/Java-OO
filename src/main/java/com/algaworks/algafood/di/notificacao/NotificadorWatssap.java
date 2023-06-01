package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;
@Profile("prod")
//@Primary
@Component
public class NotificadorWatssap implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s por Watssap atraves do telefone %s: %s\n", cliente.getNome(),
				cliente.getTelefone(), mensagem);
	}

}
