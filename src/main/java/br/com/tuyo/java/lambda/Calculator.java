package br.com.tuyo.java.lambda;

@FunctionalInterface // Anotação para interface funcional. Para obrigar a interface a ser funcional.
public interface Calculator { // Interface Funcional: tem que ser uma interface e tem que ter um método só.

	public void calculate(int x, int y); // Método
}
