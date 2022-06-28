# Generics e Diamond
## Chega de NullPointerException! Use a nova classe Optional do Java 8
````
Para usar generics, utilizamos o diamante(<>) com um tipo genérico; aqui, utilizamos o T que é uma convenção, mas funcionaria com X por exemplo.
Depois criamos um atributo obj do tipo T, criamos o construtor e um método que retorna o valor desse obj.
Agora, para instanciar o objeto, precisamos passar entre <> o tipo que vamos passar para o construtor; 
fizemos isso com Integer, Double e String(tipos primitivos não funcionam).
O nome generics vem do fato de você ter um tipo genérico na sua classe. Usando generics porém, você deve especificar o tipo que será usado
quando você estiver instanciando um objeto dessa classe.
````