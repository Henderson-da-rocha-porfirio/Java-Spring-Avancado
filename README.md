# ToString - Retorno em String dos dados do objeto

Como usar o toString?
Todas as classes que utilizamos no Java, sejam nossas ou de APIs da plataforma, descendem de uma única classe em comum: a classe Object. Ela disponibiliza métodos valiosos que são acessíveis a partir de qualquer outra classe, mesmo que esta não tenha sido declarada como subclasse de Object. Em outras palavras, nunca precisaremos escrever public class ClasseQualquer extends Object para que um objeto de tipo ClasseQualquer possa utilizar os métodos de Object.

Um desses métodos é o toString, que apesar de simples é bastante útil. Ele retorna uma string que representa textualmente o objeto do qual ele fora chamado. A classe Object já possui uma implementação de toString que retorna uma string com o seguinte valor:

getClass().getName() + '@' + Integer.toHexString(hashCode())
Essa string é apenas no nome da classe a qual o objeto pertence, seguido do caractere ‘@’ e do hash code do objeto, representado em base hexadecimal.

A maioria das classes do Java, entretanto, reimplementam toString para que a string retornada seja mais significativa do que a gerada pela implementação padrão de Object. Como exemplo, podemos instanciar um objeto da classe LocalTime, que representa um horário, e imprimir a string retornada pelo seu toString:

import java.time.LocalTime;

public class Programa {
    public static void main(String[] args) {
        LocalTime meioDia = LocalTime.of(12, 0);

        System.out.println(meioDia.toString());
        // imprime "12:00"
    }
}
Perceba que toString, nesse caso, retorna apenas uma representação simples do horário. Já para objetos da classe Point, utilizada pra representar a localização de um ponto num plano cartesiano, toString retorna o nome da classe seguido dos valores das suas variáveis entre colchetes, um padrão seguido também por outras classes do Java:

import java.awt.Point;

public class Programa {
    public static void main(String[] args) {
        Point origem = new Point(0, 0);

        System.out.println(origem.toString());
        // imprime "java.awt.Point[x=0,y=0]"
    }
}
No entanto, qual seria a vantagem de sobrescrever o toString ? Ao invés de criar outro método qualquer que tenha a mesma finalidade de retornar uma string que represente o nosso objeto? Acontece que o toString é invocado automaticamente quando tentamos imprimir um objeto usando métodos como print, println, format, entre outros. Ou, quando concatenamos um objeto com uma string usando o operador “+”.

Como exemplo, podemos declarar, então, a seguinte classe:

import java.time.LocalDate;

public class User {

    final String cpf;
    final LocalDate dataDeNascimento;
    
    public static void main(String[] args) {
        User newUser = new User("012.345.567-89", LocalDate.of(1990, 1, 1));
        System.out.print(newUser);
        // imprime "CPF: 012.345.567-89
                    Data de nascimento(AAA-MM-DD):1990-01-01"
    }
    
    User(String cpf, LocalDate data) {
        this.cpf = cpf;
        dataDeNascimento = data;
    }
    
    public String toString() {
        return String.format("CPF: %s%nData de nascimento(AAA-MM-DD):" + dataDeNascimento, cpf);
    }
}
Perceba que neste código foi possível concatenar o objeto dataDeNascimento ao resto da string que forma o valor retornado pelo toString de User e que conseguimos imprimir este valor apenas usando o próprio objeto newUser com argumento de print.

Sobrescrever o toString, embora pareça trivial, nos permite escrever códigos mais concisos e exibir informações de um objeto de uma determinada classe, aproveitando dos mecanismos de herança e encapsulamento do Java.

#### Fonte: https://blog.cod3r.com.br/como-usar-o-tostring/
