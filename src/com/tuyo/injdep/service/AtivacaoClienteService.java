package com.tuyo.injdep.service;

import com.tuyo.injdep.modelo.Cliente;
import com.tuyo.injdep.notificacao.Notificador;

/*Classe de Serviço - Classe de negócio que tem que ativar um cliente*/
/*Classe que tem que notificar o cliente que ele está ativo*/
public class AtivacaoClienteService {

	/*NotificadorEmail instanciado*/
	private Notificador notificador;
	
	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();

		/*Notificando o cliente que está ativo conforme o método acima e passando a mensagem abaixo, conforme implementado em NotificadorEmail*/
		this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
	
}
