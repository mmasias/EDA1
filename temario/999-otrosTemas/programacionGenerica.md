# Programación genérica

## ¿Por qué?

La diversidad y variabilidad de los tipos de datos con los que trabajan las aplicaciones modernas es vasta, y el desarrollo de algoritmos y estructuras de datos para cada tipo de información es redundante y contraproducente. Surge de aquí la necesidad de escribir código que sea independiente del tipo de dato con el que opera, pero que al mismo tiempo, mantenga la seguridad y la robustez del tipo.

## ¿Qué?

La programación genérica se refiere a la definición de clases, interfaces y métodos de manera que puedan operar en tipos de datos aún no especificados. Estos tipos se determinan posteriormente cuando se utiliza o instancia dicha clase o método. En Java, la programación genérica se introdujo para proporcionar mecanismos de tipo seguro sin comprometer el rendimiento del programa, permitiendo la reutilización de código y la reducción de errores en tiempo de ejecución.

## ¿Para qué?

|||
|-|-|
Reutilización de código|Evita la duplicación de código al permitir la definición de algoritmos que funcionen de manera general para diferentes tipos.
Seguridad de tipo|Aumenta la robustez del código al detectar posibles errores de tipo en tiempo de compilación en lugar de en tiempo de ejecución.
Rendimiento mejorado|Al conocer los tipos en tiempo de compilación, el compilador Java puede realizar optimizaciones específicas, en contraposición a las técnicas de "todo es un objeto" que podrían afectar el rendimiento.
Flexibilidad|Ofrece la capacidad de adaptar código a nuevas situaciones sin reescribir o modificar las estructuras originales.

## ¿Cómo?

La programación genérica en Java se implementa mediante el uso de "type parameters" (parámetros de tipo). Estos parámetros de tipo actúan como marcadores para los tipos reales que se utilizarán cuando se instancia una clase o se invoca un método.

### Definición de clases e interfaces genéricas

- **Sintaxis básica**: Para definir una clase genérica, se usa un identificador de tipo genérico entre paréntesis angulares (<>). Por ejemplo, ```class Box<T> { }``` define una clase Box que tiene un tipo genérico T.
- **Uso de tipos genéricos**: Dentro de la clase, el tipo genérico T puede utilizarse como cualquier otro tipo de dato. Por ejemplo, se puede tener un atributo de tipo T, o métodos que retornen o reciban parámetros de tipo T.

```java
public class Box<T> {
    private T t;
    public void set(T t) { 
        this.t = t; 
    }
    public T get() { 
        return t; 
    }
}
```

### Utilización de Clases Genéricas:

- **Especificación de tipo en la instancia**: Al crear un objeto de una clase genérica, se debe especificar el tipo de dato genérico. Por ejemplo: ```Box<Integer> integerBox = new Box<>();```.
- **Inferencia de tipos**: A partir de Java 7, se introduce el operador diamante (<>), que permite al compilador inferir el tipo genérico necesario, simplificando la sintaxis.

```java
Box<Integer> integerBox = new Box<Integer>();
Box<String> stringBox = new Box<>();

```

### Métodos Genéricos

Similar a las clases genéricas, pero aplicado a métodos. 

- **Métodos independientes de la clase**: Un método genérico puede ser definido dentro de una clase genérica o en una clase no genérica. La sintaxis involucra añadir un identificador de tipo genérico antes del tipo de retorno del método. Por ejemplo: ```public <T> void print(T obj) { }```.

```java
public static <U> void displayBoxContent(Box<U> box) {
    U content = box.get();
    System.out.println(content);
}
```

### Wildcards

Son útiles en situaciones donde es necesario referirse a objetos genéricos sin conocer el tipo exacto:

```java
public void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}
```

### Limitaciones y Bounded Types

- **Restricciones de tipo**: Se pueden establecer restricciones para los tipos genéricos utilizando la palabra clave **extends** (para clases) o **implements** (para interfaces). Esto garantiza que el tipo genérico cumpla con ciertas características.

Por ejemplo, se puede limitar un tipo a ser una subclase de otro:

```java
public class NumericBox<T extends Number> {
    // implementación...
}
```
