# Árboles > inserciones

La inserción en un árbol es una operación clave que permite construir el árbol agregando nuevos vértices de manera ordenada y estructurada.

## Acerca de las responsabilidades en la inserción

Es fundamental entender la distribución de responsabilidades entre la clase que gestiona el árbol y los nodos individuales, especialmente en el proceso de inserción.

### Clase gestora del árbol

[La clase que maneja el árbol](/src/arboles/ejemplo000/Tree.java) se encarga de las siguientes tareas:

1. **Inserción de nuevos vértices:** Inicia y gestiona el proceso de inserción de nuevos vértices en el árbol.
2. **Mantenimiento del punto de entrada:** Conserva la referencia a la raíz del árbol.
3. **Gestión de la lógica de inserción:** Maneja la lógica para decidir la posición del nuevo vértice según la política elegida.

### Nodos

[Los nodos](/src/arboles/ejemplo000/Node.java), en cambio, tienen un papel más limitado:

1. **Almacenamiento de datos:** Cada nodo almacena su propio valor y los enlaces a sus nodos hijos.
2. **No participan en la lógica de inserción:** Los nodos no deciden dónde se insertan nuevos vértices, siendo simplemente contenedores de datos.

Esta clara división de responsabilidades asegura un diseño modular y fácil de mantener, esencial para el manejo eficiente de árboles binarios.

## Políticas de inserción

Sin una política clara de inserción, el árbol puede crecer de forma descontrolada o ineficiente. La política determina **dónde** se coloca cada nuevo elemento y afecta directamente a:

- **Forma del árbol:** ¿Crece en profundidad o en anchura?
- **Balanceo:** ¿Se mantiene equilibrado o se sesga hacia un lado?
- **Eficiencia de búsqueda:** ¿Cómo afecta la estructura al tiempo de búsqueda?

### Políticas comunes

#### Inserción por profundidad (DFS)

Cuando un nodo se llena, se le crea un hijo y se continúa insertando en profundidad. Esto genera árboles que crecen "hacia abajo" muy rápido.

**Características:**

- Árbol profundo y estrecho
- Desbalanceado
- Búsqueda puede ser ineficiente (similar a lista enlazada en el peor caso)

**Ver:** [ejemplo000](/src/arboles/ejemplo000/) - Inserción DFS con 3 hijos

#### Inserción por niveles (BFS)

Se llenan todos los nodos de un nivel antes de pasar al siguiente nivel. Esto genera árboles más balanceados.

**Características:**

- Árbol ancho y balanceado
- Todos los niveles completos excepto posiblemente el último
- Búsqueda más eficiente en promedio

**Ver:** [ejemplo003](/src/arboles/ejemplo003/) - Inserción BFS con 3 hijos, [ejemplo004](/src/arboles/ejemplo004/) - Inserción BFS binaria

#### Inserción con criterio de ordenación (BST)

Se usa un criterio de comparación: menores a la izquierda, mayores a la derecha. Esto mantiene el árbol ordenado.

**Características:**

- Árbol ordenado (permite búsqueda eficiente)
- Puede desbalancearse si se insertan valores ordenados
- O(log n) búsqueda en árbol balanceado, O(n) en árbol degenerado

**Ver:** [ejemplo005](/src/arboles/ejemplo005/) - BST básico

## Inserción en árboles binarios de búsqueda (BST)

El proceso de inserción en un árbol binario comienza comparando el valor del vértice a insertar con el valor de la raíz del árbol. Esta operación se realiza de manera recursiva hasta encontrar una posición vacía adecuada para el nuevo vértice.

### Reglas de inserción

1. **Si el árbol está vacío:** El nuevo vértice se convierte en la raíz del árbol.
2. **Si el árbol no está vacío:** El valor del nuevo vértice se compara con el vértice actual, decidiendo si moverse al subárbol izquierdo o derecho.
3. **Repetir el proceso:** Se continúa hasta encontrar un lugar vacío para la inserción del nuevo vértice.

## Ejemplo

Consideremos la inserción de los vértices [5, 3, 7, 2, 4, 6, 8] en un árbol binario inicialmente vacío, siguiendo las reglas de inserción detalladas anteriormente.

<div align=center>

|Operación||Resultado|
|-|-|:-:|
Insertar 5|Se convierte en la raíz del árbol.|![](/imagenes/modelosUML/ejemploInsercion001.svg)
Insertar 3|Menor que 5, va al subárbol izquierdo de 5.|![](/imagenes/modelosUML/ejemploInsercion002.svg)
Insertar 7|Mayor que 5, va al subárbol derecho de 5.|![](/imagenes/modelosUML/ejemploInsercion003.svg)
Insertar 2|Menor que 5, se mueve a la izquierda. Menor que 3, se inserta a la izquierda de 3.|![](/imagenes/modelosUML/ejemploInsercion004.svg)
Insertar 4||![](/imagenes/modelosUML/ejemploInsercion005.svg)
Insertar 6||![](/imagenes/modelosUML/ejemploInsercion006.svg)
Insertar 8||![](/imagenes/modelosUML/ejemploInsercion007.svg)

</div>

### Código

<div align=center>

|Nodo|Árbol binario|Ejemplo|
|-|-|-|
|[Node.java](/src/arboles/ejemplo005/Node.java)|[Tree.java](/src/arboles/ejemplo005/Tree.java)|[TreeSample.java](/src/arboles/ejemplo005/TreeSample.java)|

</div>

**Nota:** Para una progresión completa desde árboles básicos hasta BST, consulta la [serie de ejemplos progresivos](/src/arboles/).
