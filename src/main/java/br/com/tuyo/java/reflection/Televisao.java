package br.com.tuyo.java.reflection;

public class Televisao {

	private boolean ligada;
	private int canal;
	
	public Televisao() {
		System.out.println("Televis�o criada");
	}
	
	public void ligar() {
		ligada = true;
		System.out.println("Televis�o ligada");
	}
	
	public void desligar() {
		ligada = false;
		System.out.println("Televis�o desligada");
	}
	
	public void mudarCanal(int novoCanal) {
		canal = novoCanal;
		System.out.println("Canal mudado para " + novoCanal);
	}
	
	public boolean isLigada() {
		return ligada;
	}
	
	public int getCanal() {
		return canal;
	}
}
