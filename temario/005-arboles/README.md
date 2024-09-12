# Árboles

## ¿Por qué?

Después de comprender estructuras de datos lineales como listas, pilas y colas, hemos de avanzar hacia estructuras más complejas como los árboles.

Los árboles permiten representar datos de manera jerárquica, lo que es crucial para muchas aplicaciones, como:

- Sistemas de archivos
- Bases de datos
- Procesamiento de lenguaje natural
- Algoritmos de búsqueda y clasificación.

## ¿Qué?

Un árbol es una estructura de datos **no lineal** que simula una jerarquía utilizando relaciones padre-hijo.

Consiste en **nodos** conectados. Las características clave de un árbol incluyen:

|||
|-|-|
Nodo raíz|El nodo superior en un árbol, sin padres.
Nodos hijos|Nodos que descienden de otros nodos.
Hojas|Nodos sin hijos.
Subárboles|Árboles formados por un nodo y sus descendientes.
Profundidad y Altura|Niveles en el árbol.

Los árboles se diferencian de las estructuras lineales en que los datos no se organizan de manera secuencial, sino en forma de ramas que se dividen de nodos anteriores.

## ¿Para qué?

|||
|-|-|
Representar datos jerárquicos|Como en sistemas de gestión de archivos y directorios.
Facilitar búsquedas|Árboles de búsqueda binaria y árboles AVL mejoran la eficiencia de las búsquedas.
Manejar datos ordenados|Los árboles mantienen sus elementos en un orden específico.
Optimizar operaciones de listas|En lugar de recorrer toda una lista, los árboles pueden permitir un acceso más directo a los elementos.
Apoyar algoritmos más avanzados|Como aquellos utilizados en la compresión de datos, enrutamiento de redes y más.

## ¿Cómo?

### Implementación Básica

- En una estructura de árbol simple, cada nodo contiene datos y referencias a sus nodos hijos.
- La implementación precisa varía según el tipo de árbol.

### Características

|||
|-|-|
Raíz|Desde el nodo raíz se puede llegar a cualquier nodo del árbol progresando por las ramas y atravesando diferentes nodos. Esto irá conformando un **camino**.
Padre-Hijo|La relación entre dos nodos separados de forma inmediata por una rama se denomina padre-hijo.
||En un árbol un padre puede tener varios hijos pero un hijo sólo puede tener un padre.
Grado|Número de subárboles del nodo.
Hoja|Se establece que un nodo es hoja si no tiene descendientes.
Peso|Número de hojas o nodos terminales de un árbol.
Nivel de nodo|Número de nodos que le anteceden en el árbol.
||Ej.: el nivel de nodo raíz es 1.
Profundidad|El mayor de los niveles de todos los nodos del árbol.
Orden|Número máximo de hijos que puede tener un nodo.


<div align=center>

||
|-|
![](/imagenes/modelosUML/arboles.svg)



Raiz|Hijos de **a**|Padre de d|Grado|Nivel
|:-:|:-:|:-:|:-:|:-:|
**a**|**b** y **c**|**b**|**a** = 2|**a** = 1
||||**b** = 1|**b** = 2
||||**c** = 3|**d** = 3
||||**e** = 0

</div>

### Operaciones Básicas

|||
|-|-|
[Recorrido](recorridos.md)|Visitar todos los nodos en un orden específico (preorden, inorden, postorden).
[Inserción](inserciones.md)|Agregar nodos respetando las propiedades del árbol.
Búsqueda|Encontrar un nodo específico.
Eliminación|Remover nodos manteniendo la estructura del árbol.

### Tipos de Árboles

|||
|-|-|
Binarios|Cada nodo tiene como máximo dos hijos.
Binarios de búsqueda (BST)|Un tipo de árbol binario donde cada nodo tiene un valor mayor que todos los nodos de su subárbol izquierdo y menor que los de su subárbol derecho.
AVL|Árboles binarios de búsqueda balanceados.
N-arios|Cada nodo puede tener más de dos hijos.

