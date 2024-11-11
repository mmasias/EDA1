# Acerca de los árboles

|||
|-|-|
|Comprender la naturaleza jerárquica de los árboles y sus propiedades fundamentales es esencial para implementar soluciones eficientes en problemas que requieren organización jerárquica de datos, búsqueda eficiente y representación de relaciones padre-hijo.|A diferencia de las estructuras lineales, un árbol es una estructura no lineal donde cada nodo puede tener múltiples conexiones, formando una jerarquía natural que simula una estructura de árbol invertido.|

---

|Qué son|Qué no son|Qué saben|Qué no saben|
|-|-|-|-|
|Una estructura de datos jerárquica que comienza con un nodo raíz y se ramifica en nodos hijos.|No son estructuras lineales como las listas o arrays.|Saben quién es su nodo raíz.|No saben directamente el número total de nodos en todas sus ramas (sin recorrido).|
|Una colección de nodos donde cada uno puede tener múltiples hijos pero un solo padre (excepto la raíz).|No son grafos cíclicos - no pueden tener ciclos.|Saben cómo acceder a los hijos directos de cada nodo.|No conocen todos sus nodos hoja sin realizar un recorrido completo.|
|Una forma de representar relaciones jerárquicas entre datos.|No son estructuras donde los nodos pueden conectarse arbitrariamente entre sí.|Saben identificar si un nodo es hoja (sin hijos) o interno.|No saben la profundidad total sin realizar un recorrido completo.|

## Ejemplo de *correcta* implementación

```java
class Nodo {
    int dato;
    Nodo izquierdo;
    Nodo derecho;
    
    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

class ArbolBinario {
    private Nodo raiz;
    
    public ArbolBinario() {
        this.raiz = null;
    }
    
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }
    
    private Nodo insertarRecursivo(Nodo actual, int dato) {
        if (actual == null) {
            return new Nodo(dato);
        }
        
        if (dato < actual.dato) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, dato);
        } else if (dato > actual.dato) {
            actual.derecho = insertarRecursivo(actual.derecho, dato);
        }
        
        return actual;
    }
}
```

## Implicaciones y consideraciones

- Acceso jerárquico: Para acceder a cualquier nodo, se debe recorrer desde la raíz siguiendo un camino específico.
- Eficiencia de operaciones
  - Acceso a la raíz: O(1)
  - Búsqueda de un nodo: O(n) en el peor caso
  - Inserción/eliminación: O(1) si se conoce el padre
- Flexibilidad: Ideal para representar estructuras jerárquicas como sistemas de archivos, organización empresarial, etc.
- Uso de memoria: Cada nodo requiere espacio para el dato y referencias a sus hijos.

## Variaciones y extensiones

- Árboles binarios: Cada nodo tiene máximo dos hijos
- Árboles AVL: Árboles binarios de búsqueda auto-balanceables
- Árboles B: Optimizados para sistemas de archivos y bases de datos
- Árboles Rojo-Negro: Árboles binarios de búsqueda balanceados por color
