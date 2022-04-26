package com.tuyo.injdep.notificacao;


import com.tuyo.injdep.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);
	
}
