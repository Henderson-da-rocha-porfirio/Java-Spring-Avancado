# Método Split() - Divisão de Arrays por Partes
## O método string split() quebra uma determinada string em torno de correspondências da expressão regular fornecida. Depois de dividir em relação à expressão regular fornecida, esse método retorna uma matriz de caracteres.
## Exemplo:  
```
Input String: 016-78967
Regular Expression: - 
Output : {"016", "78967"}
```
## Duas Variantes do Método Split()
### 1. Public String [ ] split ( String regex, int limit )

#### Parâmetros:

##### regex – uma expressão regular delimitadora
##### Limit - o limite resultante
##### Return: Um array de strings é calculado dividindo a string dada.
##### Lança Exceção: PatternSyntaxException – se a sintaxe da expressão regular fornecida for inválida.  

O parâmetro limit pode ter 3 valores: 

limit > 0 – Se este for o caso, então o padrão será aplicado no máximo limite-1 vezes, o comprimento do array resultante não será maior que n, e a última entrada do array resultante conterá todas as entradas além do último padrão correspondido.
limit < 0 – Neste caso, o padrão será aplicado o maior número de vezes possível, e o array resultante pode ser de qualquer tamanho.
limit = 0 – Neste caso, o padrão será aplicado o maior número de vezes possível, o array resultante pode ser de qualquer tamanho e as strings vazias à direita serão descartadas.

## Exemplo 2:
### jerk@para@heroes -> String que vai sofrer a divisão (split).

|Regex  |	Limit | 	Result|
|:---:  |	:---: | 	:---:|
|@	| 2	|{“jerk”, ”para@heroes”}|
|@	| 5	|{“jerk”, ”para”, ”heroes”}| 
|@	|-2	|{“jerk”, ”para”, ”heroes”}|
|s  | 	5	|{“je”, ”“, “@para@je”, “”, “”}|
|s  |  	-2|	{“je”, ” “, ” “, “@para@je”, “”, “”}|
|s  |  	0|	{“je”, ””, ”@para@je”}|
