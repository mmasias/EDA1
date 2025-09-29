# Acerca de las pilas

|||
|-|-|
|Comprender la naturaleza restrictiva de las pilas y sus propiedades fundamentales es esencial para reconocer cuándo su uso es apropiado y cuándo resulta limitante.|Contrariamente a lo que podría pensarse, una pila no permite acceder a elementos arbitrarios de su contenido, sino únicamente al elemento que se encuentra en el tope.|

---

|Qué son|Qué no son|Qué saben|Qué no saben|
|-|-|-|-|
|Una estructura de datos que sigue el principio LIFO (Last In, First Out).|No son estructuras de acceso aleatorio como los arrays.|Saben cuál es el elemento en el tope de la pila.|No saben cuántos elementos contienen sin realizar operaciones destructivas.|
|Un objeto que mantiene una referencia al último elemento insertado (el tope).|No son listas que permiten recorrer todos sus elementos.|Saben si están vacías o no.|No saben qué elementos hay debajo del tope sin desapilarlos.|
|Una abstracción que restringe deliberadamente el acceso a un único punto de entrada/salida.|No son estructuras que permiten inserción o eliminación en posiciones arbitrarias.|Saben cómo añadir y remover elementos del tope eficientemente.|No conocen el contenido completo sin modificar su estado.|

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

class Pila {
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
        assert !estaVacia() : "No se puede desapilar de una pila vacía";
        int valor = tope.dato;
        tope = tope.siguiente;
        return valor;
    }

    public int peek() {
        assert !estaVacia() : "No se puede consultar el tope de una pila vacía";
        return tope.dato;
    }

    public boolean estaVacia() {
        return tope == null;
    }
}
```

## Implicaciones y consideraciones

- Acceso restringido: Solo se puede acceder al elemento del tope, haciendo imposible consultar o modificar elementos en otras posiciones sin alterar la estructura.
- Eficiencia de operaciones
  - Push (apilar): O(1)
  - Pop (desapilar): O(1)
  - Peek (consultar tope): O(1)
  - Búsqueda de elemento específico: O(n) requiriendo desapilar
- Uso apropiado: Ideal para situaciones donde el orden de procesamiento debe ser inverso al orden de llegada (deshacer acciones, validación de paréntesis, evaluación de expresiones postfijas).
- Limitación fundamental: Para conocer cualquier propiedad del contenido completo (tamaño, existencia de un elemento), se requiere desapilar todos los elementos, destruyendo la estructura original.

## Variaciones y extensiones

- Pila con array de tamaño fijo: Implementación más eficiente en memoria pero con límite de capacidad.
- Pila con array dinámico: Combina eficiencia de arrays con crecimiento automático.
- Pila con tamaño máximo: Útil para controlar límites de recursión o prevenir desbordamientos.
- Pila con mínimo en O(1): Mantiene registro del elemento mínimo sin afectar las operaciones básicas.