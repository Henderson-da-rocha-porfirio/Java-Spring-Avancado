# Interface Serializable ( Serialização )
### Transformar alguma coisa em uma série de bytes.
### Útil para transformar em arquivo ou transferir por rede.
### Gravação do objeto do Java em arquivo
### É uma interface de marcação, ela não tem métodos. Não precisa, então, implementá-los.
### Toda a árvore do objeto precisa ser serializada.
### Usar transient para que a serialização não seja gravada.
### Exemplo: private transient Bola bola; Bola não será gravada no arquivo.
### E no caso do objeto ser transient, mesmo que faça parte da árvore da serialização, não precisará implementar de Serializable.