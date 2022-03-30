# Interface Serializable ( Serialização )
### Transformar alguma coisa em uma série de bytes.
### Útil para transformar em arquivo ou transferir por rede.
### Gravação do objeto do Java em arquivo
### É uma interface de marcação, ela não tem métodos. Não precisa, então, implementá-los.
### Toda a árvore do objeto precisa ser serializada.
### Usar transient para que a serialização não seja gravada.
### Exemplo: private transient Bola bola; Bola não será gravada no arquivo.
### E no caso do objeto ser transient, mesmo que faça parte da árvore da serialização, não precisará implementar de Serializable.
### Ter cuidado para não gerar a exceção: java.io.InvalidClassException = Classe local incompatível. Este erro é porque não foi definido o SerialVersionUID manualmente, e por isso ele está conflitando com as versões.
### Todo objeto que passa pela serialização, ele recebe uma numeração. Esse é baseado nas informações da classe.
## Serial Version UID
### Quando um objeto está sendo serializado:
#### 1. Ele ver quais são os atributos
#### 2. Pega os métodos
#### 3. De posse com essas informações, um algoritmo interno e tranforma num número.
#### 4. Este número não muda para o objeto.
#### 5. Por isso é importante definir manualmente o SerialVersionUID
#### 6. Ter muito cuidado ao excluir atributos ou mudar os nomes dos atributos gravados inicialmente no SerialVersionUID. SE isso ocorrer, ele não gerará exceção mas dará erro, porque ele imprimirá null.