# Pilas

## ¿Por qué?

- Las pilas son una estructura de datos fundamental en ciencias de la computación.
- Proporcionan una forma eficiente de manejar datos con un comportamiento "último en entrar, primero en salir" (LIFO).
- Son esenciales para entender y resolver problemas que implican recursión, gestión de memoria y reversión de operaciones.

## ¿Qué?

Una pila es una estructura de datos lineal que sigue el principio de LIFO (Last In, First Out).

- Los elementos se añaden y se eliminan solo desde un extremo, llamado "tope" de la pila.
- El último elemento insertado es el primero en ser removido.
- Operaciones básicas:
  1. **Push**: añadir un elemento al tope de la pila
  2. **Pop**: remover el elemento del tope de la pila
  3. **Peek** o **Top**: ver el elemento en el tope sin removerlo

## ¿Para qué?

Las pilas se utilizan en diversas aplicaciones y situaciones:

- Gestión de llamadas a funciones en la ejecución de programas
- Evaluación de expresiones matemáticas (notación polaca inversa)
- Comprobación de paréntesis y llaves en expresiones
- Implementación de la función "deshacer" en aplicaciones
- Navegación en el historial de un navegador web
- Algoritmos de recorrido en profundidad (DFS) en grafos
- Conversión de expresiones infix a postfix

## ¿Cómo?

Implementación básica de una pila en Java usando un array:

```java
public class Pila {
    private int maxTamaño;
    private int[] arregloPila;
    private int tope;

    public Pila(int tamaño) {
        maxTamaño = tamaño;
        arregloPila = new int[maxTamaño];
        tope = -1;
    }

    public void push(int valor) {
        if (tope < maxTamaño - 1) {
            arregloPila[++tope] = valor;
        } else {
            System.out.println("La pila está llena");
        }
    }

    public int pop() {
        if (!estaVacia()) {
            return arregloPila[tope--];
        } else {
            System.out.println("La pila está vacía");
            return -1;
        }
    }

    public int peek() {
        if (!estaVacia()) {
            return arregloPila[tope];
        } else {
            System.out.println("La pila está vacía");
            return -1;
        }
    }

    public boolean estaVacia() {
        return (tope == -1);
    }

    public boolean estaLlena() {
        return (tope == maxTamaño - 1);
    }
}

public class EjemploPila {
    public static void main(String[] args) {
        Pila pila = new Pila(5);
        pila.push(1);
        pila.push(2);
        pila.push(3);
        System.out.println(pila.pop());
        System.out.println(pila.peek());
    }
}
```

Implementación básica de una pila en Java usando listas:

```java
class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public void push(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public int pop() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return -1; 
        }
        int valor = tope.dato;
        tope = tope.siguiente;
        return valor;
    }

    public int peek() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return -1; 
        }
        return tope.dato;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void imprimirPila() {
        Nodo actual = tope;
        System.out.print("Tope -> ");
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}

public class EjemploPila {
    public static void main(String[] args) {
        Pila pila = new Pila();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.imprimirPila(); 
        System.out.println(pila.pop());  
        System.out.println(pila.peek()); 
        pila.imprimirPila(); 
    }
}
```

### Operaciones comunes y su complejidad

1. Push: O(1)
1. Pop: O(1)
1. Peek: O(1)
1. Verificar si está vacía/llena: O(1)

### Consideraciones para la implementación

- Manejar casos de desbordamiento (overflow) y subdesbordamiento (underflow)
- Elegir entre implementación con array (tamaño fijo) o lista enlazada (tamaño dinámico)
- Considerar la implementación de una pila genérica para manejar diferentes tipos de datos
