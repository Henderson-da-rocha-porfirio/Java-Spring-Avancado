package com.tuyo.injdep.service;

import com.tuyo.injdep.modelo.Cliente;
import com.tuyo.injdep.notificacao.Notificador;

/*Classe de Serviço - Classe de negócio que tem que ativar um cliente*/
/*Classe que tem que notificar o cliente que ele está ativo*/
/*Classe depende da Interface Notificador. Não fica dependente de NotificadorEmail ou NotificadorSMS*/

public class AtivacaoClienteService {

	/* Usando atributo Notificador (usando o Polimorfismo(princípio que diz
	 que podemos usar o objeto de várias formas) com a Interface Notificador(objeto) ):*/
	private Notificador notificador;

	/*Construtor criado para instanciar o notificador*/
	/*Objeto tipo Notificador passando no parâmetro(polimorfismo)*/
	/*Essa classe só funciona para enviar a mensagem(seja por sms, email ou etc.) para o cliente se for criada uma dependência*/
	/*Notificador se tornou uma dependência de AtivacaoClienteService*/
	/*E agora, fazendo o mesmo em EmissaoNotaFiscalService, não dependendem mais dos tipos das classes sms ou email porque
	dependem da interface, do objeto, Notificador*/
	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();

		/*Notificando o cliente que está ativo conforme o método acima e passando a mensagem abaixo, conforme implementado em NotificadorEmail*/
		this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
	
}
