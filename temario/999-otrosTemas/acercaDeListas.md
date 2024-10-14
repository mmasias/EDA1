# Listas como Estructura de Datos

|||
|-|-|
|Entender correctamente qué son y qué no son las listas, así como sus capacidades y limitaciones, es crucial para utilizarlas eficientemente en el diseño de algoritmos y estructuras de datos más complejas. Su simplicidad y flexibilidad las hacen una herramienta fundamental en la programación, siempre que se tengan en cuenta sus características específicas.|Contrariamente a la creencia común, una lista como estructura de datos no está enlazada a todos sus elementos, sino solo al primer elemento de la secuencia.|

---

|Qué son|Qué no son|Qué saben|Qué no saben|
|-|-|-|-|
|Una estructura de datos que mantiene una secuencia ordenada de elementos.|No son arrays con acceso directo a todos sus elementos.|Saben cómo acceder al primer elemento de la secuencia.|No saben directamente cuántos elementos contienen (a menos que se implemente un contador explícito).|
|Un objeto que contiene una única referencia al primer nodo de la secuencia (comúnmente llamado "cabeza" o "head").|No son contenedores que almacenan físicamente todos sus elementos en una ubicación contigua de memoria.|Saben cómo añadir un nuevo elemento al principio de la secuencia.|No saben cómo acceder directamente a un elemento en una posición arbitraria.|
|Una forma de organizar datos de manera lineal y dinámica.|No son estructuras que mantienen referencias directas a todos sus elementos.|Saben su estado de vacío (si tienen o no elementos).|No conocen el último elemento de la secuencia (a menos que se mantenga una referencia específica).|

## Ejemplo de *correcta* implementación

```java
class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }

    ...
}
```

## Implicaciones y consideraciones

- Acceso secuencial: Para acceder a cualquier elemento que no sea el primero, se debe recorrer la lista desde el inicio.
- Eficiencia de operaciones
  - Inserción/eliminación al principio: O(1)
  - Acceso/inserción/eliminación en otra posición: O(n) en el peor caso
- Flexibilidad: Fácil inserción y eliminación de elementos sin necesidad de reorganizar toda la estructura.
- Uso de memoria: Eficiente para listas de tamaño variable, ya que solo se asigna memoria para los elementos existentes.

## Variaciones y extensiones

- Listas doblemente enlazadas: Cada nodo tiene referencias al siguiente y al anterior.
- Listas circulares: El último nodo apunta de vuelta al primero.
- Listas con cola: Se mantiene una referencia adicional al último elemento para operaciones eficientes al final.
