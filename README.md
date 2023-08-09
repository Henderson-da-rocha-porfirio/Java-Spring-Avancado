# Java-Avancado
### Verificar as branchs


- Conversão DTO para Entidade (POST)
> No método POST, você geralmente recebe um DTO do cliente. Esses DTOs precisam ser convertidos em entidades antes de serem salvos no banco de dados. Essa é a razão pela qual você escreveu um método convertDtoToEntities que pega um DTO e preenche as entidades correspondentes.

- Conversão Entidade para DTO (GET)
> Por outro lado, no método GET, você está recuperando entidades do banco de dados e precisa convertê-las em DTOs para enviá-las ao cliente. Essa é uma operação diferente e geralmente requer um método separado.

- Por que não um único método para ambos?
> A conversão de DTO para entidade e de entidade para DTO geralmente envolve lógica diferente. Embora possam parecer semelhantes, elas estão operando em direções opostas.

- DTO para Entidade: Você está tomando os dados que vêm do cliente (que podem ser parciais, formatados de uma certa maneira, etc.) e convertendo-os para as entidades que são usadas internamente e salvas no banco de dados.
Entidade para DTO: Você está tomando as entidades completas do banco de dados e convertendo-as para um formato que é adequado para enviar ao cliente. Isso pode incluir omitir alguns campos, formatar dados de uma certa maneira, etc.
Por causa dessas diferenças na lógica e nos requisitos, geralmente é mais claro e menos propenso a erros ter métodos separados para essas duas operações. Se você tentasse combiná-los em um único método, provavelmente acabaria com um código mais complexo e difícil de manter.

- Uso de Bibliotecas
Em projetos maiores, é comum usar bibliotecas como o ModelMapper ou o MapStruct para lidar com essas conversões. Essas bibliotecas podem reduzir a quantidade de código manual que você precisa escrever e fornecer uma abordagem mais consistente e configurável para a conversão entre DTOs e entidades. Isso pode ser especialmente útil se você tiver muitas conversões semelhantes a serem feitas em todo o seu projeto.


- @Controller:

> É uma anotação de nível de classe usada em componentes Spring MVC para indicar que uma classe é um controlador Spring.
As classes anotadas com @Controller podem servir tanto HTML quanto JSON, XML ou qualquer outro tipo de resposta, dependendo de como são configuradas.
Quando você usa @Controller, o Spring não converte automaticamente a resposta em JSON ou outro formato. É necessário adicionar explicitamente a anotação @ResponseBody no método ou usar uma biblioteca de visualização como Thymeleaf para servir páginas HTML.
@RestController:

- @RestController é uma anotação especializada que combina @Controller e @ResponseBody.
  
> Essa anotação é usada quando você deseja criar um serviço RESTful e a resposta será automaticamente convertida para o formato desejado (como JSON), sem a necessidade de adicionar a anotação @ResponseBody em cada método.
Normalmente, quando você está construindo uma API RESTful que só retorna dados (não HTML), você usaria @RestController.

- Exemplo usando @Controller:

````
@Controller
public class MyController {
    @GetMapping("/hello")
    @ResponseBody // Isso é necessário para enviar a resposta como texto simples ou JSON
    public String sayHello() {
        return "Hello, World!";
    }
}
````
- Exemplo usando @RestController:

````
@RestController
public class MyRestController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!"; // JSON ou texto simples, sem necessidade de @ResponseBody
    }
}
````

- Em resumo, use @Controller se você estiver lidando com páginas da web e visões, e use @RestController se estiver construindo uma API RESTful onde as respostas são normalmente em JSON ou outro formato de dados.
