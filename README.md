# Stream

### Uma sequência de elementos que suportam operações agregadas sequenciais e paralelas. O exemplo a seguir ilustra uma operação agregada usando [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html) e [IntStream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html):
````
     int sum = widgets.stream()
                      .filter(w -> w.getColor() == RED)
                      .mapToInt(w -> w.getWeight())
                      .sum();
````
