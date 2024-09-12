# Árboles > inserciones

La inserción en un árbol es una operación clave que permite construir el árbol agregando nuevos vértices de manera ordenada y estructurada.

## Acerca de las responsabilidades en la inserción

Es fundamental entender la distribución de responsabilidades entre la clase que gestiona el árbol y los nodos individuales, especialmente en el proceso de inserción.

### Clase gestora del árbol

[La clase que maneja el árbol binario](/src/arboles/insertSample/BinaryTree.java) se encarga de las siguientes tareas:

1. **Inserción de nuevos vértices:** Inicia y gestiona el proceso de inserción de nuevos vértices en el árbol.
2. **Mantenimiento del punto de entrada:** Conserva la referencia a la raíz del árbol.
3. **Gestión de la recursividad:** Maneja la lógica recursiva para decidir la posición del nuevo vértice.

### Nodos

[Los nodos](/src/arboles/insertSample/Node.java), en cambio, tienen un papel más limitado:

1. **Almacenamiento de datos:** Cada nodo almacena su propio valor y los enlaces a sus nodos hijos.
2. **No participan en la lógica de inserción:** Los nodos no deciden dónde se insertan nuevos vértices, siendo simplemente contenedores de datos.

Esta clara división de responsabilidades asegura un diseño modular y fácil de mantener, esencial para el manejo eficiente de árboles binarios.

## Inserción en Árboles Binarios

El proceso de inserción en un árbol binario comienza comparando el valor del vértice a insertar con el valor de la raíz del árbol. Esta operación se realiza de manera recursiva hasta encontrar una posición vacía adecuada para el nuevo vértice.

### Reglas de Inserción

1. **Si el Árbol Está Vacío:** El nuevo vértice se convierte en la raíz del árbol.
2. **Si el Árbol No Está Vacío:** El valor del nuevo vértice se compara con el vértice actual, decidiendo si moverse al subárbol izquierdo o derecho.
3. **Repetir el Proceso:** Se continúa hasta encontrar un lugar vacío para la inserción del nuevo vértice.

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
|[Node.java](/src/arboles/insertSample/Node.java)|[BinaryTree.java](/src/arboles/insertSample/BinaryTree.java)|[TreeSample.java](/src/arboles/insertSample/TreeSample.java)|

</div>