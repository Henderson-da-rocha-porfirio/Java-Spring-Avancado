package br.com.tuyo.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Buffer<T> { // área de armazenamento temporário
							// <T> = Significa que é uma classe Buffer "parametrizada pelo tipo 'T' = <T>"
	private List<T> list = new ArrayList<>(); // Uso do Generics
												//<T> = Uso genérico
	public void adicionar(T elemento) {
		list.add(elemento);
	} // método adicionar tipo void, não retorna nada.
	
	public T remover() {
		T elemento = list.get(0);
		list.remove(0);
		return elemento;
	}
}
