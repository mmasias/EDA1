# Árboles > búsquedas

Buscar en un árbol significa localizar un nodo que contenga un valor específico. La eficiencia de esta operación depende directamente de cómo esté organizado el árbol.

## Búsqueda según la estructura del árbol

### Búsqueda en árboles sin criterio de ordenación

En árboles donde los valores se insertan sin seguir un criterio de comparación (como [árboles de 3 hijos](/src/arboles/ejemplo000/) o [árboles binarios simples](/src/arboles/ejemplo004/)), no hay forma de saber dónde puede estar un valor.

**Estrategia:** Búsqueda exhaustiva - recorrer todos los nodos hasta encontrar el valor o agotar el árbol.

**Complejidad:**

<div align=center>

|Peor caso|Caso promedio|Mejor caso
|-|-|-|
|El valor está en el último nodo visitado o no existe|Hay que revisar aproximadamente la mitad de los nodos|El valor está en la raíz
|O(n)|O(n)|O(1)

</div>

**Implementación:** Se puede usar cualquier tipo de recorrido (preorden, postorden, por niveles) para visitar todos los nodos.

### Búsqueda en árboles binarios de búsqueda (BST)

En un [BST](/src/arboles/ejemplo005/), los valores están ordenados: menores a la izquierda, mayores a la derecha. Esto permite **descartar la mitad del árbol** en cada paso.

**Estrategia:** Comparación con criterio de ordenación

1. Comparar valor buscado con nodo actual
2. Si es igual: encontrado
3. Si es menor: buscar en subárbol izquierdo
4. Si es mayor: buscar en subárbol derecho
5. Si llegamos a null: no existe

**Complejidad:**

- **Árbol balanceado:** O(log n) - Descartamos mitad en cada paso
- **Árbol degenerado:** O(n) - Comportamiento de lista enlazada
- **Mejor caso:** O(1) - El valor está en la raíz

**Ver:** [ejemplo007](/src/arboles/ejemplo007/) - Búsqueda iterativa en BST

## Comparación de eficiencias

Para un árbol con 1,000,000 de nodos:

<div align=center>

|Tipo de árbol|Complejidad|Comparaciones (peor caso)|
|-|-|-|
|Sin ordenación|O(n)|1,000,000|
|BST balanceado|O(log n)|~20|
|BST degenerado|O(n)|1,000,000|

</div>

**Conclusión:** Un BST balanceado es ~50,000 veces más eficiente que la búsqueda exhaustiva.

## Implementaciones

La búsqueda en BST se puede implementar de dos formas:

<div align=center>

|Iterativa|Recursiva|
|-|-|
|Usa un bucle que navega por el árbol.|Definición elegante que refleja la estructura recursiva del árbol.|
|Más verbosa pero sin consumo de stack.|Concisa pero consume stack (riesgo de overflow en árboles profundos).|
|[ejemplo007](/src/arboles/ejemplo007/) - Implementación iterativa|Código deprecated, referencia educativa (se verá en EDA2)|

</div>

## Aplicaciones prácticas

La búsqueda eficiente es fundamental en:

### Diccionarios y mapas

- Búsqueda de claves en estructuras clave-valor
- Implementaciones de `Map`, `TreeMap` en librerías estándar

### Bases de datos

- Índices B-Tree para búsqueda rápida
- Consultas ordenadas y por rango

### Autocompletado

- Tries (árboles de prefijos) para sugerencias de texto
- Búsqueda de palabras en diccionarios

### Validación

- Verificar si un elemento ya existe antes de insertarlo
- Detectar duplicados

## Relación con recorridos

Buscar no es lo mismo que recorrer:

- **Recorrer:** Visitar todos los nodos en un orden específico ([ver recorridos](/temario/003-arboles/recorridos.md))
- **Buscar:** Localizar un nodo específico, idealmente sin visitar todos

En BST, la búsqueda aprovecha el ordenamiento para evitar recorrer todo el árbol.

> ***2Think:*** En un BST degenerado (lista enlazada), ¿sería más eficiente usar una lista enlazada real? ¿Qué ventajas mantiene el BST incluso degenerado?

**Nota:** Para una progresión completa desde árboles básicos hasta BST con búsqueda, consulte la [serie de ejemplos progresivos](/src/arboles/).
