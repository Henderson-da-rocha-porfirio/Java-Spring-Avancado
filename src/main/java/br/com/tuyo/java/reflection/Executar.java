package br.com.tuyo.java.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Apenas métodos anotados com essa annotation serão executados.

@Target(ElementType.METHOD) // Target define onde esta annotation poderá ser utilizada. Sendo utilizada em método, deve-se por: METHOD.
@Retention(RetentionPolicy.RUNTIME) // RetentionPolicy = 3 tipos: RUNTIME, CLASS e SOURCE (Usada apenas para a escrita do código fonte. Quando roda o código, ela não funciona).
public @interface Executar {
	String value();
}
