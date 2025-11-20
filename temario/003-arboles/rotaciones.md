# Árboles > rotaciones

## ¿Por qué?

La estructura de un Árbol Binario de Búsqueda (BST) presenta una vulnerabilidad crítica relacionada con el orden de inserción de los datos. Aunque teóricamente ofrece una eficiencia de búsqueda logarítmica O(log n), esta premisa solo se cumple si el árbol mantiene una forma equilibrada.

Cuando se insertan datos que ya están ordenados (o casi ordenados), el árbol crece exclusivamente hacia una dirección (derecha para ascendente, izquierda para descendente). Esto provoca que la estructura de árbol degenere en una estructura lineal (similar a una lista enlazada), degradando el rendimiento de todas las operaciones a O(n).

**Ejemplo de degeneración vs. objetivo:**

```
    Degenerado (Lista)          Balanceado (Objetivo)
        1                              2
         \                            / \
          2                          1   3
           \
            3
```

**Ejemplo con 8 nodos:**

```
    Degenerado (Altura 8)               Balanceado (Altura 4)
    1                                            4
     \                                         /   \
      2                                       2     6
       \                                     / \   / \
        3                                   1   3 5   7
         \                                             \
          4                                             8
           \
            5
             \
              6
               \
                7
                 \
                  8
```

Es necesario, por tanto, un mecanismo que permita reorganizar los nodos para reducir la altura del árbol sin perder la propiedad fundamental de orden del BST.

## ¿Qué?

La rotación es una operación local de transformación estructural aplicada sobre dos nodos adyacentes (padre e hijo). Esta operación altera la jerarquía entre estos dos nodos, invirtiendo su relación padre-hijo, al tiempo que preserva rigurosamente el orden inorden de todos los elementos del subárbol.

No implica la creación ni eliminación de nodos, sino únicamente la reasignación de referencias (punteros) entre un conjunto limitado de nodos (el padre, el hijo y sus respectivos subárboles).

## ¿Para qué?

La aplicación de rotaciones permite:

1.  **Restaurar el equilibrio:** Permite reducir la altura de ramas excesivamente largas, distribuyendo los nodos de manera más uniforme.
2.  **Garantizar la eficiencia:** Al mantener la altura del árbol acotada (idealmente cerca de log n), se asegura que las operaciones de búsqueda, inserción y eliminación se mantengan eficientes.
3.  **Habilitar estructuras auto-balanceadas:** Es el mecanismo base sobre el que se construyen estructuras avanzadas como árboles AVL o Rojo-Negro, que aplican estas operaciones automáticamente.

## ¿Cómo?

La rotación se realiza manipulando las referencias de los nodos involucrados. Existen dos variantes simétricas.

### Rotación a la Izquierda

Se aplica cuando un subárbol está desbalanceado hacia la derecha (el hijo derecho es el que hace pesada la rama).

**Algoritmo:**
Dado un nodo `P` (Padre) y su hijo derecho `Q`:
1.  `Q` asciende para ocupar la posición de `P`.
2.  `P` desciende para convertirse en el hijo izquierdo de `Q`.
3.  El subárbol izquierdo de `Q` (si existe) se reasigna como hijo derecho de `P`.

**Representación visual:**

```
    P                 Q
   / \               / \
  A   Q     ==>     P   C
     / \           / \
    B   C         A   B
```

### Rotación a la Derecha

Se aplica cuando un subárbol está desbalanceado hacia la izquierda (el hijo izquierdo es el que hace pesada la rama).

**Algoritmo:**
Dado un nodo `Q` (Padre) y su hijo izquierdo `P`:
1.  `P` asciende para ocupar la posición de `Q`.
2.  `Q` desciende para convertirse en el hijo derecho de `P`.
3.  El subárbol derecho de `P` (si existe) se reasigna como hijo izquierdo de `Q`.

**Representación visual:**

```
      Q             P
     / \           / \
    P   C   ==>   A   Q
   / \               / \
  A   B             B   C
```

### Implementación conceptual

Aunque la implementación varía según el lenguaje, la lógica de punteros para una rotación a la derecha sobre un nodo `y` (donde `x` es su hijo izquierdo) sigue estos pasos:

1.  El hijo derecho de `x` pasa a ser hijo izquierdo de `y`.
2.  El padre de `y` pasa a ser padre de `x`.
3.  `y` pasa a ser hijo derecho de `x`.

## ¿Y ahora qué?

Una vez comprendida la mecánica de la rotación manual, se debe abordar cómo automatizar este proceso para crear árboles que se gestionen a sí mismos:

-   [Árboles AVL](avl.md): Utilizan un factor de equilibrio estricto para decidir cuándo rotar.
-   [Árboles Rojo-Negro](rbtree.md): Utilizan propiedades de coloración para un balanceo más flexible.
