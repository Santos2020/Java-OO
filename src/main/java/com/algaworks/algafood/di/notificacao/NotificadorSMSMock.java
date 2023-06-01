package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;

@Profile("dev")
@Primary
@Component
public class NotificadorSMSMock implements Notificador {
	
	public NotificadorSMSMock() {
		System.out.println("Notificação po SMS MoCK");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s por SMS atraves do telefone %s: %s\n", cliente.getNome(),
				cliente.getTelefone(), mensagem);
	}

}
