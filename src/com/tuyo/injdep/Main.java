package com.tuyo.injdep;

import com.tuyo.injdep.modelo.Cliente;
import com.tuyo.injdep.notificacao.Notificador;
import com.tuyo.injdep.notificacao.NotificadorEmail;
import com.tuyo.injdep.notificacao.NotificadorSMS;
import com.tuyo.injdep.service.AtivacaoClienteService;

public class Main {
    public static void main(String[] args) {

        /*Instanciando os clientes:*/
        Cliente joao = new Cliente("João", "joao@xyz.com", "3499998888");
        Cliente maria = new Cliente("Maria", "maria@xyz.com", "1177772222");

        /*INJEÇÃO DE DEPENDÊNCIA: Intanciando o NotificadorSMS(ou NotificadorEmail)
        injetando o notificador na instanciação de AtivacaoClienteService */
        Notificador notificador = new NotificadorSMS();

        /*Instanciando o serviço de ativação de cliente:*/
        /*injetando o 'notificador' na instanciação de AtivacaoClienteService:*/
        AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(notificador);

        /*Ativando os dois clientes*/
        ativacaoCliente.ativar(joao);
        ativacaoCliente.ativar(maria);
    }
}
