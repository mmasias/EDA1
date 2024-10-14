# Colas

## ¿Por qué?

- Las colas son una estructura de datos fundamental en ciencias de la computación.
- Proporcionan una forma eficiente de manejar datos con un comportamiento "primero en entrar, primero en salir" (FIFO).
- Son esenciales para modelar situaciones de espera, gestionar recursos compartidos y en algoritmos de búsqueda en anchura.

## ¿Qué?

Una cola es una estructura de datos lineal que sigue el principio de FIFO (First In, First Out).

- Los elementos se añaden al final de la cola (enqueue) y se eliminan desde el frente (dequeue).
- El primer elemento insertado es el primero en ser removido.
- Operaciones básicas:
  1. **Enqueue**: añadir un elemento al final de la cola
  2. **Dequeue**: remover el elemento del frente de la cola
  3. **Peek** o **Front**: ver el elemento en el frente sin removerlo
- Puede implementarse usando arrays o listas enlazadas.

## ¿Para qué?

Las colas se utilizan en diversas aplicaciones y situaciones:

1. Gestión de procesos en sistemas operativos
1. Manejo de solicitudes en servidores web
1. Implementación de búfers en flujos de datos
1. Algoritmos de búsqueda en anchura (BFS) en grafos
1. Simulación de sistemas de atención al cliente
1. Gestión de tareas en impresoras
1. Implementación de caché en sistemas de bases de datos

## ¿Cómo?

Implementación básica de una cola en Java usando un array:

```java

// #2Think...

```

Implementación básica de una cola en Java usando listas:

```java
class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class Cola {
    private Nodo frente;
    private Nodo final;

    public Cola() {
        this.frente = null;
        this.final = null;
    }

    public void enqueue(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (estaVacia()) {
            frente = nuevoNodo;
            final = nuevoNodo;
        } else {
            final.siguiente = nuevoNodo;
            final = nuevoNodo;
        }
    }

    public int dequeue() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return -1; 
        }
        int valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            final = null;
        }
        return valor;
    }

    public int peek() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return -1; 
        }
        return frente.dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void imprimirCola() {
        Nodo actual = frente;
        System.out.print("Frente -> ");
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("Final");
    }
}

public class EjemploCola {
    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.imprimirCola();
        System.out.println(cola.dequeue());
        System.out.println(cola.peek()); 
        cola.imprimirCola(); 
    }
}
```

### Operaciones comunes y su complejidad:

1. Enqueue: O(1)
1. Dequeue: O(1)
1. Peek: O(1)
1. Verificar si está vacía: O(1)

### Ventajas de la implementación con lista enlazada:

- Tamaño dinámico: la cola puede crecer según sea necesario
- No hay límite predefinido para el número de elementos
- Eficiente en memoria, solo se asigna lo necesario

### Consideraciones para la implementación:

- Mantener referencias tanto al frente como al final de la cola para operaciones eficientes
- Manejar el caso de cola vacía en las operaciones dequeue y peek
- Actualizar correctamente las referencias al frente y al final en todas las operaciones
- Considerar la implementación de una cola circular para optimizar el uso de memoria en ciertas aplicaciones