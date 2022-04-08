# NAMOROAPP - UTILIZANDO LOMBOK
### * ENDPOINT vs API
#### - ENDPOINT: é a URL onde seu serviço pode ser acessado por uma aplicação cliente.
````
Endpoints podem existir sem APIs.
````
#### - API: é um conjunto de rotinas, protocolos e ferramentas para construir aplicações.
````
APIs também podem existir sem endpoints.
````
#### - Quando trabalham em conjunto:
````
Os endpoints são interfaces entre a API e a aplicação consumidora.
````
### - Exemplo:
|  Client (C)  | :---: | API (A)|
|:--:|   :---:     |   :---:     |
| C | ENDPOINT  | A |
|  C |ENDPOINT | A  |
|  C |ENDPOINT | A  |

# E-NAMORO RESTful API
## Aplicativo de Namoro
### US = USER STORIES
### Requerimentos
### - O App permitirá que os usuários:
### - US 1º Registrarem-se
##### - Para se considerarem registrados:
##### i. nome_usuario
##### ii. password
##### iii. idade
##### iv. email
##### v. gênero
##### vi. numero_telefone
##### vii. cidade
##### viii. estado
##### ix. país
### - US 2º Adicionarem seus interesses
##### - Para terem as condições pós-registro de fazerem e incluírem:
##### i. permissao para dar likes
##### ii. permissao para dar dislikes
##### iii. hobbies
##### iv. perfil_url
##### v. sobre
### - US 3º Ver todos os outros usuários registrados
##### - Para terem o direito de:
##### i. permissao para ver outros usuários registrados
### - US 4º Marcarem encontros com outros usuários
##### - Para achar encontros através de critérios como:
##### i. idade
##### ii. cidade
##### iii. estado
##### iv. país

# NAMORO ENDPOINTS
## Endpoints do Aplicativo de Namoro
### US = USER STORIES
### Requerimentos
### - O App fará:
### - 1º Endpoint = Registrar usuário
````
/namoro/api/usuarios/registrar_usuarios
````
### - 2º Endpoint = Atualizar Interesses
````
/namoro/api/interesses/update
````
### - 3º Endpoint = Deletar interesses
````
/namoro/api/interesses/delete/{interesseId}
````
### - 4º Endpoint = Dar Match (parceiro(a) que combine)
````
/namoro/api/usuarios/matches/{usuarioId}
````
### - Compreendendo:
````
/namoro/api/usuarios/registrar_usuarios
````
#### a. /namoro = é o contexto que deve ser passado em application.properties:
````
server.servlet.context-path=/namoro
````
#### b. /api = é o mapeamento principal do Controlador que deve ser configurado na Controller: ContaUsuarioController:
````
@RequestMapping("/api")
````
#### c. / = é o mapeamento do endpoint para a pagina de registros:
````
@PostMapping("/usuarios/registrar_usuarios") 
````

# LOMBOK
## É uma ferramenta Open-Source que remove toda a codificação padrão conhecida numa classe Java.
### Anotações que diminuem consideravelmente o tamanho do código:
#### @Getter
#### @Setter
#### @NoArgsConstructor
#### @AllArgsConstructor
#### @EqualsAndHashCode
#### @ToString
#### @FieldNameConstants
#### @RequiredArgsConstructor
#### @Log, @Log4j, @Log4j2, @Slf4j, @XSlf4j, @CommonsLog, @JBossLog, @Flogger, @CustomLog
#### @Data
#### @Builder
#### @SuperBuilder
#### @Singular
#### @Delegate
#### @Value
#### @Accessors
#### @Wither
#### @With
#### @SneakyThrows
#### @val
#### @var
#### experimental @var
#### @UtilityClass
### Usando o Lombok:
#### 1. É necessário instalar a dependência no início da criação do projeto ou posteriormente no pom.xml
#### 2. Para versões do Intellij acima de 2020.3, ele já vem instalado como plugin padrão. Não se fazendo necessária instalação.
#### 3. Caso contrário:
````
Go to File > Settings > Plugins
Click on Browse repositories...
Search for Lombok Plugin
Click on Install plugin
Restart IntelliJ IDEA
````
#### 4. Introduzir as anotações nas entidades:
````
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
````
#### 5. Criar os repositoriós.
#### 6. Criar os endpoints (controllers)
