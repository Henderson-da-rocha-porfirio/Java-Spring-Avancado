package com.tuyo.injdep.notificacao;


import com.tuyo.injdep.modelo.Cliente;

public interface Notificador {

	/*Interface Notificador para facilitar a vida =) que serve para Email, SMS ou qualquer notificador*/
	void notificar(Cliente cliente, String mensagem);
	
}
