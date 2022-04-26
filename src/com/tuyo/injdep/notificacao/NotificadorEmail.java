package com.tuyo.injdep.notificacao;

import com.com.tuyo.injdep.modelo.Cliente;

/*Classe que é responsável em notificar o cliente através de uma mensagem de email:*/
/* %s = place over: substitui uma String*/
public class NotificadorEmail implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}
