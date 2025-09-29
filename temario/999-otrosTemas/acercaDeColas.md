# Acerca de las colas

|||
|-|-|
|Comprender la naturaleza secuencial de las colas y sus restricciones de acceso es fundamental para utilizarlas correctamente en situaciones donde el orden de llegada determina el orden de procesamiento.|Contrariamente a la intuición, una cola no permite acceder a elementos en posiciones intermedias, sino únicamente al frente y (opcionalmente) al final.|

---

|Qué son|Qué no son|Qué saben|Qué no saben|
|-|-|-|-|
|Una estructura de datos que sigue el principio FIFO (First In, First Out).|No son estructuras que permiten acceso aleatorio a sus elementos.|Saben cuál es el elemento al frente de la cola.|No saben cuántos elementos contienen sin mantener un contador explícito.|
|Un objeto que mantiene referencias al primer elemento (frente) y opcionalmente al último (final).|No son listas que permiten inserción o eliminación en posiciones arbitrarias.|Saben cuál es el siguiente elemento a procesar.|No saben qué elementos están en medio sin desencolarlos todos.|
|Una abstracción que garantiza procesamiento en orden de llegada.|No son estructuras donde se puede "saltarse la fila" accediendo a elementos posteriores.|Saben si están vacías consultando el frente.|No conocen la posición de un elemento específico sin recorrer toda la cola.|

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

class Cola {
    private Nodo frente;
    private Nodo finalCola;

    public Cola() {
        this.frente = null;
        this.finalCola = null;
    }

    public void enqueue(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
    }

    public int dequeue() {
        assert !estaVacia() : "No se puede desencolar de una cola vacía";
        int valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            finalCola = null;
        }
        return valor;
    }

    public int peek() {
        assert !estaVacia() : "No se puede consultar el frente de una cola vacía";
        return frente.dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
```

## Implicaciones y consideraciones

- Acceso secuencial obligatorio: Para acceder a cualquier elemento que no sea el frente, se debe desencolar todos los elementos anteriores.
- Eficiencia de operaciones
  - Enqueue (encolar): O(1) cuando se mantiene referencia al final
  - Dequeue (desencolar): O(1)
  - Peek (consultar frente): O(1)
  - Búsqueda de elemento: O(n) requiriendo desencolar
- Uso apropiado: Ideal para sistemas de espera, gestión de tareas en orden de llegada, buffers de comunicación, algoritmos BFS en grafos.
- Mantenimiento de dos referencias: A diferencia de la pila, una cola eficiente requiere mantener referencias tanto al frente como al final para lograr operaciones en O(1).

## Variaciones y extensiones

- Cola circular: Utiliza un array con índices que "envuelven" al llegar al final, optimizando el uso de memoria.
- Cola de prioridad: Modifica FIFO para procesar elementos según su prioridad en lugar de su orden de llegada.
- Cola doble (deque): Permite inserción y eliminación en ambos extremos, combinando características de pila y cola.
- Cola con tamaño limitado: Útil para buffers de comunicación o control de recursos con capacidad fija.