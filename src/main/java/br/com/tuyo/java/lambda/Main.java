package br.com.tuyo.java.lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//List<Integer> list = Arrays.asList(4, 5, 2, 1, 0, 3);  // Variavel List sem Lambda. Para iteracao (repeticao).
		
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(1);
		list.add(0);
		list.add(3);
	
		list.sort((x, y) -> -x.compareTo(y)); // sort pode ser chamado na lista com lambda. o " -x " é para o resultado ser decrescente. Caso contrário, retirar o " - ".
		
		list.replaceAll(e -> e * 2); // Substitui todos os elementos.
		
		list.removeIf(e -> e % 2 != 0); // Remove elementos.
	
		list.forEach(e -> System.out.println(e)); // Permite que itere nos elementos sem fazer iteração.
	}
}
