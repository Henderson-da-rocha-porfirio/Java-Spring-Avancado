package br.com.tuyo.java.inner;

public class Main {

	public static void main(String[] args) {
		Bebida b1 = new Cha();
		
		Bebida b2 = new Bebida() {
			@Override
			public void preparar() { // Sobrescreve o método preparar
				System.out.println("Preparando bebida n�o identificada");
			} // Implementação para uma nova classe anônima.
		};
		
		b1.preparar();
		b2.preparar();
	}
}
