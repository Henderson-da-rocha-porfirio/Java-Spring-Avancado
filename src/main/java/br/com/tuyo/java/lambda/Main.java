package br.com.tuyo.java.lambda;

public class Main {

	public static void main(String[] args) {
		
//		Calculator calc = new Calculator() {
//			
//			@Override
//			public void calculate(int x) {   						-> Forma antiga sem usar expressoes Lambdas
//				x = x * x;
//				System.out.println(x);
//			}
//		};
		
		//Calculator calc = (e, f) -> e = e * e;					-> Usando expressoes Lambdas. Com e sem parametros. Se tiver dois parametros, utilizar os ().
		//calc.calculate(7, 0);

		Calculator2 calc = p -> p * p; // 						 Expressao Lambda: não usa as classes anônimas. Usa o operador arrow " -> "
		
		System.out.println(calc.calculate(9));
	}
}
