# Listas

## ¿Por qué?

- Las estructuras de datos son fundamentales en la programación y el diseño de algoritmos eficientes.
- Las listas enlazadas ofrecen una alternativa flexible a los arrays, permitiendo una gestión dinámica de la memoria.
- Comprender las listas enlazadas es esencial para desarrollar habilidades avanzadas en programación y optimización de código.

## ¿Qué?

Una lista enlazada es una estructura de datos **lineal** que consiste en una secuencia de elementos llamados nodos.

Características principales:

- Cada nodo contiene dos componentes:
  1. Datos (el valor almacenado)
  2. Un puntero o referencia al siguiente nodo
- El último nodo apunta a null, indicando el final de la lista
- No requiere un tamaño fijo predefinido, a diferencia de los arrays
- Tipos comunes:
  - Lista simplemente enlazada
  - Lista doblemente enlazada
  - Lista circular

## ¿Para qué?

Las listas enlazadas se utilizan en diversas aplicaciones y situaciones:

1. Implementación de otras estructuras de datos como pilas, colas y grafos
1. Gestión de memoria en sistemas operativos
1. Implementación de funciones "deshacer" en aplicaciones
1. Mantenimiento de directorios de archivos
1. Navegación entre páginas web (historial del navegador)
1. Cuando se necesita inserción y eliminación frecuente de elementos en cualquier posición

## ¿Cómo?

### Implementación básica de una lista enlazada simple

```java
class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void insertarAlPrincipio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void eliminarAlPrincipio() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
        }
    }

    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}

public class EjemploListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.insertarAlPrincipio(3);
        lista.insertarAlPrincipio(2);
        lista.insertarAlPrincipio(1);
        lista.imprimirLista();
    }
}
```

#### Operaciones comunes y su complejidad:

1. Inserción al principio: O(1)
1. Eliminación al principio: O(1)
1. Inserción/eliminación al final: O(n) para lista simple, O(1) para lista doblemente enlazada con puntero al final
1. Búsqueda: O(n)

#### Consideraciones para la implementación:

- Manejo cuidadoso para evitar pérdidas de memoria o errores
- Uso de nodo "dummy" o centinela para simplificar operaciones
- Implementación de iteradores para recorrer la lista de manera eficiente

### Más...

- [Listas básicas](/src/listas/basica/README.md) - Exprimimos los conceptos y los llevamos al límite en tres lenguages: Java, Python y JavaScript.
- Por qué estas listas se pueden quedar cortas: abordamos la [aproximación con programación genérica](/src/listas/generica/README.md) y vemos que pasa con este concepto en los tres lenguajes.