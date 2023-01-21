# Stream

### Uma sequência de elementos que suportam operações agregadas sequenciais e paralelas. O exemplo a seguir ilustra uma operação agregada usando [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html) e [IntStream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html):
````
     int sum = widgets.stream()
                      .filter(w -> w.getColor() == RED)
                      .mapToInt(w -> w.getWeight())
                      .sum();
````

## Exemplos:

### Filtrando e iterando
#### - Um método muito útil é o filter(), vou colocar um código para ver o funcionamento:
#### - Primeiro criei um objeto simples:
````
public class Item {

    private Integer id;
    private String name;

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
````
#### - E uma lista:
````
Item item = new Item(1, "Ajkahdlkasd");

Item item2 = new Item(2, "glçkmslksjkf");
Item item3 = new Item(3, "bsdklojksjdfç");
Item item4 = new Item(4, "ikjdnjksdnfskjdn");
Item item5 = new Item(10, "psdkjfsdkjfhkjsfh");

List<Item> itens = new ArrayList<>();

itens.add(item);
itens.add(item2);
itens.add(item3);
itens.add(item4);
itens.add(item5);
````

#### - A ideia é pegar apenas os ids acima de 5 e imprimir, para isso usei o filter() e o forEach():
````
itens.stream()
        .filter(i -> i.getId() > 5)
        .forEach(i -> System.out.println(i));
````        
#### - E o resultado é esse:
````
Item[id=10, name='psdkjfsdkjfhkjsfh'
````

#### - Como apenas um tem o id mais que 5, apenas ele foi impresso.

### *** Importante ressaltar que esse código não altera em nada o que está dentro de List, outros métodos úteis são os maps, nesse aqui vou criar uma lista só com os códigos:
````
IntStream ids = itens.stream()
        .mapToInt(i -> i.getId());
        ids.forEach(System.out::println);
````
#### - E aqui vou imprimir:
````
1
2
3
4
10
````



### - É possível fazer a mesma coisa com double e long e existe um map mais genérico para outras operações.

#### - Encontrando um objeto dentro de uma lista:
#### - A api do stream também possui um método chamado findAny() que pode ser combinado com o filter():
````
Optional<Item> itemFiltrado = itens.stream()
        .filter(i -> i.getId() == 10)
        .findAny();
````

#### - Dependendo do que for fazer é possível realizar uma ação usando os comando acima e mais um método chamado ifPresent():
#### - O principal ponto até aqui: repare na quantidade pequena de código para fazer essas coisas.

### - Obtendo coleções a partir de streams
````
List<Item> itensFiltrados = itens.stream()
        .collect(Collectors.toList());
````

#### - É simples mesmo. E o melhor é poder colocar filtros nisso:
````
List<Item> itensFiltrados = itens.stream()
        .filter(i -> i.getId() < 8)
        .collect(Collectors.toList());
````

#### - E aqui há um mundo de possibilidades, podendo executar um forEach() dentro do stream e programar algoritmos mais complexos com menos código.

#### Obtendo maps a partir de streams também é simples, nesse caso eu apenas alterei o id de Integer para String e peguei o map:
````
Map<String, String> mapItens = itens.stream()
        .collect(Collectors.toMap(
                i -> i.getId().toString(),
                i -> i.getName()));
````
E está aqui o resultado:
````
{1=Ajkahdlkasd, (...) }
````
