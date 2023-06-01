package com.algaworks.algafood.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.service.ClienteAtivadoEvent;

@Component
public class EmissorNotaFiscalService {

	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("Emitindo nota fiscal Cliente: " + event.getCliente().getNome());
	}

}
