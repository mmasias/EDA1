# Acerca de las listas

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

    public void insertarAlPrincipio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void eliminarPrimero() {
        assert !estaVacia() : "No se puede eliminar de una lista vacía";
        cabeza = cabeza.siguiente;
    }

    public int obtenerPrimero() {
        assert !estaVacia() : "No se puede obtener el primer elemento de una lista vacía";
        return cabeza.dato;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int contarElementos() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    public int obtenerEnPosicion(int posicion) {
        assert posicion >= 0 : "La posición debe ser no negativa";
        assert posicion < contarElementos() : "La posición está fuera de rango";
        
        Nodo actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }
}
```

## Implicaciones y consideraciones

- Acceso secuencial: Para acceder a cualquier elemento que no sea el primero, se debe recorrer la lista desde el inicio.
- Eficiencia de operaciones
  - Inserción/eliminación al principio: O(1)
  - Acceso/inserción/eliminación en otra posición: O(n) en el peor caso
  - Contar elementos: O(n) requiere recorrido completo
- Flexibilidad: Fácil inserción y eliminación de elementos sin necesidad de reorganizar toda la estructura.
- Uso de memoria: Eficiente para listas de tamaño variable, ya que solo se asigna memoria para los elementos existentes.
- Validaciones con assertions: Se requiere que el código cliente verifique precondiciones antes de operar (lista no vacía, posición válida).

## Variaciones y extensiones

- Listas doblemente enlazadas: Cada nodo tiene referencias al siguiente y al anterior.
- Listas circulares: El último nodo apunta de vuelta al primero.
- Listas con cola: Se mantiene una referencia adicional al último elemento para operaciones eficientes al final.
- Listas con contador: Se mantiene un atributo que registra el número de elementos, evitando recorridos para obtener el tamaño.