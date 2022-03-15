package br.com.tuyo.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Buffer<T> { // área de armazenamento temporário

	private List<T> list = new ArrayList<>();
	
	public void adicionar(T elemento) {
		list.add(elemento);
	}
	
	public T remover() {
		T elemento = list.get(0);
		list.remove(0);
		return elemento;
	}
}
