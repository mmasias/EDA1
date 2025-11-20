# Árboles - Recorridos

Recorrer un árbol significa visitar todos sus nodos en un orden específico. El objetivo es procesar cada nodo exactamente una vez siguiendo una estrategia determinada.

## Recorridos según el tipo de árbol

No todos los recorridos se aplican a todos los tipos de árboles:

### Recorridos generales (árboles n-arios)

**Preorden** y **Postorden** funcionan en árboles con cualquier número de hijos:

- **Preorden (raíz → hijos):** Visita el nodo actual, luego todos sus hijos de izquierda a derecha
- **Postorden (hijos → raíz):** Visita todos los hijos de izquierda a derecha, luego el nodo actual

**Aplicable a:** [Árboles de 3 hijos](/src/arboles/ejemplo000/), [Árboles binarios](/src/arboles/ejemplo004/), etc.

### Recorrido específico de árboles binarios

**Inorden** es un recorrido exclusivo de árboles binarios. Visita hijo izquierdo → raíz → hijo derecho.

**¿Por qué solo binarios?** El concepto de procesar la raíz "entre" sus hijos solo tiene sentido con exactamente dos hijos (un "antes" y un "después").

**Aplicable a:**
- [Árboles binarios](/src/arboles/ejemplo004/) (2 hijos)
- [BST](/src/arboles/ejemplo005/) (2 hijos)

**No aplicable a:** [Árboles de 3 hijos](/src/arboles/ejemplo000/) ni otros árboles n-arios

**Utilidad en BST:** El recorrido inorden de un árbol binario de búsqueda produce los valores **en orden ascendente** ([ver ejemplo006](/src/arboles/ejemplo006/)).

> ***2Think:*** ¿Podría generalizarse inorden a árboles con número par de hijos? Por ejemplo, con 4 hijos: ¿visitar los dos primeros, luego la raíz, luego los dos últimos? ¿Sería útil? ¿Por qué no se usa en la práctica?

## Recorridos en árboles binarios

La diferencia entre estos tres recorridos radica en **cuándo** se procesa cada nodo respecto a sus hijos.

<div align=center>

||![](/imagenes/modelosUML/arboles001.svg)||
|:-:|:-:|:-:|
**Preorden**|**Inorden**|**Postorden**
Para recorrer un árbol binario en preorden se comienza por la raíz y luego se recorre en preorden el subárbol que tiene como raíz el hijo izquierdo de la raíz del árbol original. Una vez recorrido todos los vértices del subárbol izquierdo se recorre en preorden el subárbol derecho. En otras palabras, por cada vértice se registra primero el vértice, luego el hijo izquierdo y finalmente el hijo derecho.|Para recorrer un árbol binario en inorden se comienza por recorrer en inorden el subárbol que tiene como raíz el hijo izquierdo de la raíz del árbol original. Una vez recorrido todos los vértices del subárbol izquierdo se visita la raíz y luego se recorre en inorden el subárbol derecho. En otras palabras, por cada vértice se registra primero el hijo izquierdo, luego el vértice y finalmente el hijo derecho.|Para recorrer un árbol binario en postorden se comienza por recorrer en postorden el subárbol que tiene como raíz el hijo izquierdo de la raíz del árbol original. Una vez recorrido todos los vértices del subárbol izquierdo, se recorre en postorden el subárbol derecho y finalmente se visita la raíz. En otras palabras, por cada vértice se registra primero el hijo izquierdo, luego el hijo derecho y finalmente el vértice.
V / hI / hD|hI / V / hD|hI / hD / V

</div>

## Implementaciones

Los recorridos se pueden implementar de dos formas:

<div align=center>

|Iterativa|Recursiva|
|-|-|
Usa una ***pila explícita*** para simular las llamadas recursivas.|La forma más habitual y concisa. La definición del recorrido se traduce directamente en llamadas recursivas.
Más verbosa pero sin riesgo de stack overflow y más fácil de depurar paso a paso.|Es elegante pero consume stack y puede causar desbordamiento en árboles muy profundos.
[ejemplo006](/src/arboles/ejemplo006/) - Implementaciones iterativas de los tres recorridos en BST|[Ejemplos recursivos](/src/arboles/zzz-deprecated/recorridos/) (código deprecated, solo referencia educativa. Lo volveremos a ver en EDA2 cuando estudiemos recursividad)

</div>

## Aplicaciones prácticas

Cada recorrido tiene propósitos específicos:

### Preorden (V/hI/hD)

- **Copiar un árbol:** Crear primero el padre, luego los hijos
- **Serializar:** Guardar la estructura para reconstruirla después
- **Evaluar expresiones prefijas**

### Inorden (hI/V/hD)

- **Obtener valores ordenados en BST:** El recorrido inorden de un BST produce los valores en orden ascendente
- **Validar BST:** Verificar que los valores estén en orden correcto

**Ejemplo:** BST con valores [5, 3, 7, 1, 9]
- Inorden: 1, 3, 5, 7, 9 (ordenado!)

### Postorden (hI/hD/V)

- **Eliminar un árbol:** Borrar hijos antes que el padre
- **Calcular tamaño/altura:** Necesitas info de hijos primero
- **Evaluar expresiones postfijas**

---

<div align=center>

||![](/imagenes/modelosUML/arboles001.svg)||
|:-:|:-:|:-:|
**Preorden**|**Inorden**|**Postorden**
V / hI / hD|hI / V / hD|hI / hD / V
`a, b, d, e, h, i, c, f, g, j, k`|`d, b, h, e, i, a, f, c, j, g, k`|`d, h, i, e, b, f, j, k, g, c, a`
</div>

---

<div align=center>

||![](/imagenes/modelosUML/arboles002.svg)||
|:-:|:-:|:-:|
**Preorden**|**Inorden**|**Postorden**
V / hI / hD|hI / V / hD|hI / hD / V
1 2 4 5 3|4 2 5 1 3|4 5 2 3 1
[printPreorder()](/src/arboles/ejemplo006/Tree.java#L41-L62)|[printInorder()](/src/arboles/ejemplo006/Tree.java#L64-L86)|[printPostorder()](/src/arboles/ejemplo006/Tree.java#L88-L122)

</div>

**Nota:** Para una progresión completa desde árboles básicos hasta BST con recorridos, consulte la [serie de ejemplos progresivos](/src/arboles/).
