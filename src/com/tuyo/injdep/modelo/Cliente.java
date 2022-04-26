package com.tuyo.injdep.modelo;


public class Cliente {

	private String nome;
	private String email;
	private String telefone;
	private boolean ativo = false;

	/*Construtor que recebe as propriedades acima como parâmetro:*/
	public Cliente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	/*Métodos Get para acesso:*/
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public boolean isAtivo() {
		return ativo;
	}

	/*Método ativar:*/
	public void ativar() {
		this.ativo = true;
	}

}
