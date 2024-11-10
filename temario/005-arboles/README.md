# Árboles

## ¿Por qué?

Después de comprender estructuras de datos lineales como listas, pilas y colas, hemos de avanzar hacia estructuras más complejas como los árboles.

Los árboles permiten representar datos de manera jerárquica, lo que es crucial para muchas aplicaciones, como:

<div align=center>

|||
|-|-|
|Sistemas de archivos|Árboles DOM en desarrollo web
|Bases de datos|Árboles de decisión en IA
|Procesamiento de lenguaje natural|Estructura de JSON/XML
|Algoritmos de búsqueda y clasificación.|

</div>

## ¿Qué?

Un árbol es una estructura de datos **no lineal** que simula una jerarquía utilizando relaciones padre-hijo.

Consiste en **nodos** conectados. 

### Árboles en contraste con Listas

<div align=center>

|Lista|Árbol|
|-|-|
|En una estructura lineal (como una lista o una cola), cada elemento tiene como máximo un elemento anterior y uno siguiente.|En un árbol, un nodo puede tener múltiples "siguientes" (sus hijos).
|En una estructura lineal, hay un único camino para recorrer todos los elementos (del primero al último).|En un árbol, podemos tener múltiples caminos diferentes para llegar a distintos elementos, siguiendo diferentes ramas.|
|<div align=center>![](/images/modelosUML/listas/lista.svg)</div>|<div align=center>![](/images/modelosUML/arboles/arbol.svg)</div>|
|**A → B → C → D** (único camino posible)|Para llegar a D seguimos **A → B → D**, mientras que para E seguimos **A → C → E**.

</div>

## ¿Para qué?

|||
|-|-|
|**Representar datos jerárquicos**|Sistemas de archivos y directorios|
||Estructuras organizacionales|
||Árboles genealógicos|
||Estructuras DOM en páginas web|
||Documentos XML/JSON|
|**Facilitar búsquedas**|Árboles de búsqueda binaria (BST)|
||Árboles AVL para búsquedas balanceadas|
||Índices en bases de datos|
||Árboles B y B+ en sistemas de archivos|
|**Manejar datos ordenados**|Mantener elementos en orden específico|
||Facilitar recorridos ordenados (inorden, preorden, postorden)|
||Implementar diccionarios y mapas ordenados|
|**Optimizar operaciones**|Búsquedas más eficientes que en listas (O(log n) vs O(n))|
||Inserciones y eliminaciones ordenadas|
||Balanceo automático en estructuras avanzadas|
|**Compilación y parsing**|[Árboles de sintaxis abstracta (AST)](ejemplos/AST.md)|
||Evaluación de expresiones matemáticas|
||Parseo de lenguajes de programación|
|**Inteligencia Artificial**|Árboles de decisión en machine learning|
||Árboles de juego en IA de videojuegos|
||Árboles de búsqueda en sistemas expertos|
|**Gráficos y videojuegos**|Octrees para particionamiento espacial|
||BSP trees para renderizado 3D|
||Árboles de colisiones|
|**Sistemas operativos**|Gestión de procesos y threads|
||Sistemas de archivos|
||Gestión de memoria|
|**Redes y comunicaciones**|Tablas de enrutamiento|
||Árboles de spanning en redes|
||Protocolos de comunicación jerárquicos|

## ¿Cómo?

### Implementación básica

- En una estructura de árbol simple, cada nodo contiene datos y referencias a sus nodos hijos.
- La implementación precisa varía según el tipo de árbol.

### Características

<div align=center>

![](/imagenes/modelosUML/arboles.svg)

</div>

[vCompleta](caracteristicasCompleta.md)

||||
|-|-|-|
|Nodo raíz|El nodo superior en un árbol, sin padres.|'a' es el nodo raíz|
|Nodos hijos|Nodos que descienden directamente de otros nodos.|'b' y 'c' son hijos de 'a'|
|Nodo padre|Nodo que tiene hijos directos.|'a' es padre de 'b' y 'c'|
|Hojas|Nodos sin hijos, también llamados nodos terminales.|'d','e','f','g' son hojas|
|Nodos internos|Nodos que tienen al menos un hijo (no son hojas).|'a','b','c' son nodos internos|
|Nivel|Conjunto de nodos que están a la misma profundidad.|Nivel 0: {a}<br>Nivel 1: {b,c}<br>Nivel 2: {d,e,f,g}|
|Altura del árbol|Altura del nodo raíz (o profundidad máxima).|La altura del árbol es 2|
|Grado|Número máximo de hijos que puede tener un nodo.|'a' tiene grado 2<br>'c' tiene grado 3|
|Camino (path)|Secuencia de nodos conectados desde un nodo hasta otro.|De 'a' a 'f': a→c→f|

### Operaciones

#### Básicas

|||
|-|-|
|[Recorrido](recorridos.md)|Visitar todos los nodos en un orden específico:<br>- Preorden (raíz, izquierda, derecha)<br>- Inorden (izquierda, raíz, derecha)<br>- Postorden (izquierda, derecha, raíz)<br>- Por niveles (nivel a nivel, de izquierda a derecha)
|[Inserción](inserciones.md)|Agregar nodos respetando las propiedades del árbol:<br>- Como hoja<br>- En una posición específica<br>- Manteniendo el orden (en árboles ordenados)
|Búsqueda|Encontrar un nodo específico:<br>- Por valor<br>- Por posición<br>- Por relación (padre, hijo, hermano)
|Eliminación|Remover nodos manteniendo la estructura del árbol:<br>- Eliminación de hojas<br>- Eliminación de nodos internos (con restructuración)<br>- Eliminación preservando propiedades específicas

#### Avanzadas

|||
|-|-|
|Cálculo de altura|Determinar la altura de:<br>- Todo el árbol<br>- Un nodo específico<br>- Un subárbol
|Búsqueda de ancestro común|Encontrar el ancestro común más cercano entre dos nodos:<br>- Por recorrido hacia arriba<br>- Por marcado de caminos<br>- Por comparación de profundidades
|Balanceo|Reorganizar el árbol para mantener balance:<br>- Rotaciones simples<br>- Rotaciones dobles<br>- Rebalanceo completo
|Clonación y copia|Crear copias del árbol:<br>- Copia superficial<br>- Copia profunda<br>- Copia parcial (subárboles)
|Operaciones de análisis|Calcular propiedades del árbol:<br>- Número de nodos<br>- Profundidad máxima/mínima<br>- Factor de ramificación
|Fusión y división|Operaciones estructurales complejas:<br>- Combinar dos árboles<br>- Dividir un árbol en subárboles<br>- Injertar subárboles
|Serialización|Convertir el árbol en una forma lineal:<br>- Para almacenamiento<br>- Para transmisión<br>- Para persistencia
|Validación|Verificar propiedades del árbol:<br>- Integridad estructural<br>- Propiedades específicas (como en BST)<br>- Restricciones de balance

### Tipos de Árboles

|||
|-|-|
Binarios|Cada nodo tiene como máximo dos hijos.
Binarios de búsqueda (BST)|Un tipo de árbol binario donde cada nodo tiene un valor mayor que todos los nodos de su subárbol izquierdo y menor que los de su subárbol derecho.
AVL|Árboles binarios de búsqueda balanceados.
N-arios|Cada nodo puede tener más de dos hijos.
