# Árboles > eliminación

Eliminar un nodo de un árbol es la operación más compleja de las básicas. A diferencia de la inserción y búsqueda, la eliminación debe mantener la estructura y propiedades del árbol tras remover un elemento que puede tener hijos.

## El problema de la eliminación

Cuando eliminamos un nodo que tiene hijos, surge la pregunta: **¿qué hacer con esos hijos?** La respuesta depende del tipo de árbol y del número de hijos que tenga el nodo.

## Eliminación en árboles sin criterio de ordenación

En [árboles genéricos](/src/arboles/ejemplo000/) o [árboles binarios simples](/src/arboles/ejemplo004/), no hay restricciones de ordenamiento que mantener.

**Estrategias posibles:**
- **Promover un hijo:** Elegir uno de los hijos para ocupar la posición del nodo eliminado
- **Reconectar al padre:** Conectar todos los hijos directamente con el abuelo
- **Reestructurar:** Reorganizar el subárbol completo

La elección depende de las necesidades de la aplicación. No hay una respuesta única.

## Eliminación en árboles binarios de búsqueda (BST)

En un [BST](/src/arboles/ejemplo005/), debemos mantener la propiedad fundamental: **izquierda < raíz < derecha** después de cada eliminación.

### Los tres casos

#### Caso 1: Nodo hoja (sin hijos)

El caso más simple. El nodo no tiene hijos, por lo que simplemente se elimina.

```
Antes:          Después:
    5               5
   / \             / \
  3   7           3   7
 /
2  (eliminar)
```

**Acción:** Desvincular el nodo de su padre.

#### Caso 2: Nodo con un solo hijo

El nodo tiene exactamente un hijo (izquierdo o derecho). La solución es "saltar" el nodo eliminado, conectando su hijo directamente con su padre.

```
Antes:          Después:
    5               5
   / \             / \
  3   7           1   7
 /                 \
1                   2
 \
  2  (eliminar 3)
```

**Acción:** El hijo único toma la posición del nodo eliminado.

#### Caso 3: Nodo con dos hijos

El caso complejo. El nodo tiene ambos hijos. No podemos simplemente "promover" uno sin violar la propiedad BST.

**Estrategia del sucesor inorden:**

1. Encontrar el **sucesor inorden** del nodo a eliminar
   - Es el nodo más pequeño del subárbol derecho
   - Equivalente: el mínimo valor mayor que el nodo a eliminar

2. Copiar el valor del sucesor al nodo a eliminar

3. Eliminar el sucesor (que será caso 1 o caso 2, nunca caso 3)

```
Eliminar 5:

Antes:              Paso 1: Encontrar sucesor (6)    Después:
    5                   5*                               6
   / \                 / \                              / \
  3   8               3   8                            3   8
 / \ / \             / \ / \                          / \ / \
2  4 6  9           2  4 6* 9                        2  4 7  9
      \                   \
       7                   7

* El 6 es el sucesor (mínimo del subárbol derecho de 5)
  Copiamos 6 a la posición de 5, luego eliminamos el 6 original
  El 7 (hijo derecho de 6) toma el lugar de 6
```

**Alternativa - Predecesor inorden:**

- El nodo más grande del subárbol izquierdo
- Funciona igual de bien
- Elegir uno consistentemente o alternar para balanceo

### Algoritmo general

```
eliminar(valor):
    1. Buscar nodo con ese valor (mantener referencia al padre)
    2. Si no existe: terminar
    3. Determinar caso:
       - Sin hijos → desvincular de padre
       - Un hijo → conectar hijo con abuelo
       - Dos hijos → reemplazar con sucesor y eliminar sucesor
```

## Complejidad

<div align=center>

|Operación|BST balanceado|BST degenerado|
|-|-|-|
|Buscar nodo|O(log n)|O(n)|
|Encontrar sucesor|O(log n)|O(n)|
|Reconexión|O(1)|O(1)|
|**Total**|**O(log n)**|**O(n)**|

</div>

La complejidad está dominada por la búsqueda del nodo y, en caso 3, la búsqueda del sucesor.

## Implementación

<div align=center>

|Iterativa|Recursiva|
|-|-|
|Requiere mantener referencias explícitas a nodos padre.|Más elegante, la recursión maneja las referencias implícitamente.|
|Más verbosa y propensa a errores de punteros.|Concisa pero consume stack.|
|Sin riesgo de stack overflow.|Puede causar overflow en árboles muy profundos.|
|[ejemplo008](/src/arboles/ejemplo008/) - Implementación iterativa completa|Código deprecated (se verá en EDA2 con recursividad)|

</div>

## Casos especiales

### Eliminar la raíz

Si el nodo a eliminar es la raíz, el proceso es el mismo, pero se debe actualizar la referencia `root` del árbol.

### Árbol vacío tras eliminación

Si eliminamos el último nodo, `root` debe ser `null`.

### Duplicados

Si el BST permite duplicados, la estrategia de eliminación debe definir:

- ¿Eliminar solo la primera ocurrencia?
- ¿Eliminar todas las ocurrencias?
- ¿Mantener contador en cada nodo?

## Aplicaciones prácticas

La eliminación es fundamental en:

|Bases de datos|Cachés y memorias|Sistemas de archivos|Aplicaciones dinámicas
|-|-|-|-
|Eliminar registros obsoletos|Política de desalojo (eviction)|Eliminar archivos y directorios|Remover elementos de diccionarios
|Mantener índices actualizados|Liberar recursos no utilizados|Mantener índices B-Tree consistentes|Actualizar datos en tiempo real
|Operaciones DELETE en SQL|LRU (Least Recently Used) con árboles|Gestión de espacio libre|Gestión de sesiones expiradas

## Desafíos de la eliminación iterativa

La implementación iterativa presenta desafíos específicos:

1. **Mantener referencia al padre:** Necesario para reconectar
2. **Múltiples casos de reconexión:** ¿Hijo izquierdo o derecho del padre?
3. **Caso del sucesor:** Encontrar el sucesor y su padre iterativamente
4. **Manejo de la raíz:** Caso especial cuando se elimina la raíz

Estos desafíos hacen que el código iterativo sea significativamente más largo que el recursivo, pero el ejercicio de implementarlo fortalece la comprensión profunda de BST.

## Relación con otras operaciones

- **Búsqueda:** Base para encontrar el nodo a eliminar
- **Inserción:** Inversa conceptual - agregar vs. remover
- **Recorrido:** El sucesor inorden se encuentra usando el concepto de inorden
- **Balanceo:** En árboles AVL/Rojo-Negro, la eliminación requiere rebalanceo adicional

> ***2Think:*** ¿Por qué el sucesor inorden de un nodo con dos hijos nunca puede tener dos hijos? (Pista: considerar la definición de "mínimo del subárbol derecho")

**Nota:** Para una implementación completa con los tres casos, consulte [ejemplo008](/src/arboles/ejemplo008/) y la [serie de ejemplos progresivos](/src/arboles/).
