# Java-Avancado
### Verificar as branchs

## Conversão DTO e Entidade
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

## Diferenças entre @Controller e @RestController
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

## Por que usar @Transactional?
> A anotação @Transactional é usada para garantir que uma série de operações de banco de dados seja tratada como uma única transação. Se alguma das operações falhar, a transação inteira é revertida, garantindo a integridade dos dados. É útil quando você tem várias operações que precisam ser todas bem-sucedidas, ou nenhuma delas. No caso de salvar várias entidades relacionadas, você pode querer que todas sejam salvas com sucesso ou que nenhuma seja salva, para evitar um estado inconsistente no banco de dados.

## Métodos HTTP:

* GET: Você está criando o DTO com base em dados recuperados (por exemplo, do banco de dados). Você chama explicitamente os métodos set para preencher os campos.
* POST: Você está recebendo o DTO como parte da solicitação HTTP. O Spring chama os métodos set para você, com base no corpo da solicitação. Você não precisa chamar os métodos set explicitamente.

## Validação
- As validações ajudam a garantir que os dados recebidos estão no formato correto e que todos os campos obrigatórios estão presentes. Isso aumenta a robustez do código e ajuda a prevenir erros que podem ocorrer devido a dados incorretos ou incompletos.

### 1. Utilizando Anotações de Validação:
- Você pode adicionar anotações de validação diretamente no DTO para definir as regras de validação. Por exemplo:
````
public class ConfiguracaoAgendaSpDto {

    @NotNull(message = "ID é obrigatório")
    private Long id;

    @Min(value = 1, message = "A quantidade de atendimentos simultâneos deve ser pelo menos 1")
    private int qtdeAtendSimultaneos;

    @NotNull(message = "A data de início da vigência é obrigatória")
    private LocalDate dataInicioVigencia;

    // ... outros campos e validações
}
````
### 2. Validando no Serviço:
- Você também pode adicionar validações personalizadas no serviço, verificando manualmente os campos e lançando exceções ou retornando mensagens de erro conforme necessário.
````
public ConfiguracaoAgendaSpResultadoDto salvarConfiguracaoDto(ConfiguracaoAgendaSpDto configuracaoAgendaSpDto) {
    if (configuracaoAgendaSpDto.getId() == null) {
        throw new IllegalArgumentException("ID é obrigatório");
    }

    if (configuracaoAgendaSpDto.getQtdeAtendSimultaneos() < 1) {
        throw new IllegalArgumentException("A quantidade de atendimentos simultâneos deve ser pelo menos 1");
    }

    // ... outras validações e lógica de negócios
}
````
### 3. Utilizando um Validador Personalizado:
- Se as validações forem complexas, você pode criar um validador personalizado que implementa a interface Validator do Spring. Isso permite encapsular a lógica de validação em uma classe separada e reutilizá-la conforme necessário.

````
public class ConfiguracaoAgendaSpDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ConfiguracaoAgendaSpDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ConfiguracaoAgendaSpDto dto = (ConfiguracaoAgendaSpDto) target;

        if (dto.getId() == null) {
            errors.rejectValue("id", "id.obrigatorio", "ID é obrigatório");
        }

        // ... outras validações
    }
}
````
### 4. Como usar a validação nos métodos: 
- Adicionar o @Valid na assinatura do método do controlador onde o DTO é recebido, para que as validações sejam acionadas:
````
@PostMapping("/configuracao")
public ResponseEntity<?> salvarConfiguracao(@Valid @RequestBody ConfiguracaoAgendaSpDto dto) {
    // ... lógica do controlador
}
````

## Método vs Assinatura
 - Método: É um conjunto de instruções que fazem uma tarefa particular e podem retornar um valor. No seu caso, salvarConfiguracao é um método.

- Assinatura do Método: É uma parte do método que inclui o nome do método e a lista de parâmetros. Ele não inclui o corpo do método (código dentro das chaves {}). Por exemplo, a assinatura do método salvarConfiguration seria public ConfigurationAgendaDto salvarConfiguration(ConfigurationAgendaPostDto configurationPostDto).

🚀🚨😉
