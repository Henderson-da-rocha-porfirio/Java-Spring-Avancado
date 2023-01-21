# Stream

### Uma sequência de elementos que suportam operações agregadas sequenciais e paralelas. O exemplo a seguir ilustra uma operação agregada usando Streame IntStream:
````
     int sum = widgets.stream()
                      .filter(w -> w.getColor() == RED)
                      .mapToInt(w -> w.getWeight())
                      .sum();
````
