package com.tuyo.injdep.notificacao;

import com.tuyo.injdep.modelo.Cliente;

/*Classe que é responsável em notificar o cliente através de uma mensagem de email:*/
/* %s = place over: substitui uma String*/
/*Classe implementa a interface Notificador*/
public class NotificadorEmail implements Notificador {

	/*Sobrescrevendo o método notificar com a Interface Notificador:*/
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}
