# Árboles

## ¿Por qué?

Después de comprender estructuras de datos lineales como listas, pilas y colas, hemos de avanzar hacia estructuras más complejas como los árboles.

Los árboles permiten representar datos de manera jerárquica, lo que es crucial para muchas aplicaciones, como:

<div align=center>

|||
|-|-|
|Sistemas de archivos|Árboles DOM en desarrollo web|
|Bases de datos|Árboles de decisión en IA|
|Procesamiento de lenguaje natural|Estructura de JSON/XML|
|Algoritmos de búsqueda y clasificación.||

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

|Operación|Descripción|
|-|-|
|[Recorrido](recorridos.md)|Visitar todos los nodos en un orden específico|
||Preorden (raíz, izquierda, derecha)|
||Inorden (izquierda, raíz, derecha)|
||Postorden (izquierda, derecha, raíz)|
||Por niveles (nivel a nivel, de izquierda a derecha)|
|[Inserción](inserciones.md)|Agregar nodos respetando las propiedades del árbol|
||Como hoja|
||En una posición específica|
||Manteniendo el orden (en árboles ordenados)|
|Búsqueda|Encontrar un nodo específico|
||Por valor|
||Por posición|
||Por relación (padre, hijo, hermano)|
|Eliminación|Remover nodos manteniendo la estructura del árbol|
||Eliminación de hojas|
||Eliminación de nodos internos (con restructuración)|
||Eliminación preservando propiedades específicas|

#### Avanzadas

|Operación|Descripción|
|-|-|
|Cálculo de altura|Determinar la altura de:|
||Todo el árbol|
||Un nodo específico|
||Un subárbol|
|Búsqueda de ancestro común|Encontrar el ancestro común más cercano entre dos nodos:|
||Por recorrido hacia arriba|
||Por marcado de caminos|
||Por comparación de profundidades|
|Balanceo|Reorganizar el árbol para mantener balance:|
||Rotaciones simples|
||Rotaciones dobles|
||Rebalanceo completo|
|Clonación y copia|Crear copias del árbol:|
||Copia superficial|
||Copia profunda|
||Copia parcial (subárboles)|
|Operaciones de análisis|Calcular propiedades del árbol:|
||Número de nodos|
||Profundidad máxima/mínima|
||Factor de ramificación|
|Fusión y división|Operaciones estructurales complejas:|
||Combinar dos árboles|
||Dividir un árbol en subárboles|
||Injertar subárboles|
|Serialización|Convertir el árbol en una forma lineal:|
||Para almacenamiento|
||Para transmisión|
||Para persistencia|
|Validación|Verificar propiedades del árbol:|
||Integridad estructural|
||Propiedades específicas (como en BST)|
||Restricciones de balance|

### Tipos de Árboles

[Tipos](tipos.md)

|||
|-|-|
|**Árboles Binarios**||
|Árbol Binario Simple|Cada nodo tiene máximo dos hijos
||Sin restricciones de ordenación
||Útil para representar estructuras jerárquicas simples|
|Árbol Binario Completo|Todos los niveles están llenos excepto posiblemente el último
||Nodos del último nivel están lo más a la izquierda posible
||Ideal para arrays y heaps|
|Árbol Binario Perfecto|Todos los niveles están completamente llenos
||Número de nodos = 2^h+1 - 1 (h = altura)
||Forma perfectamente simétrica|
|Árbol Binario Sesgado|Todos los nodos tienen solo hijo izquierdo o derecho
||Degenera efectivamente en una lista
||Caso peor para muchas operaciones|
|**Árboles de Búsqueda**||
|BST (Binary Search Tree)|Hijo izquierdo < Padre < Hijo derecho
||Búsqueda, inserción y eliminación O(h)
||Base para estructuras más complejas|
|AVL|BST auto-balanceado
||Factor de balance entre -1 y 1
||Garantiza operaciones en O(log n)|
|Rojo-Negro|BST auto-balanceado con coloración
||Garantiza máximo 2 veces más alto que el mínimo
||Usado en muchas librerías estándar (map, set)|
|Árbol Splay|BST que mueve nodos accedidos a la raíz
||Auto-optimizante para accesos frecuentes
||Bueno para cachés y búsquedas localizadas|
|**Árboles Multivia**||
|B-Tree|Generalización de BST para almacenamiento secundario
||Nodos pueden tener múltiples claves y hijos
||Optimizado para sistemas de archivos y bases de datos|
|B+ Tree|Variante de B-Tree con todas las claves en hojas
||Hojas enlazadas para recorrido secuencial
||Estándar en sistemas de bases de datos|
|B* Tree|B-Tree con mayor factor de ocupación
||Redistribución de claves entre hermanos
||Mejor utilización del espacio|
|**Árboles Especializados**||
|Trie (Árbol de prefijos)|Optimizado para strings y búsquedas de prefijos
||Cada nodo representa un carácter
||Usado en autocompletado y diccionarios|
|Árbol de Segmentos|Divide intervalos en segmentos
||Permite consultas y actualizaciones de rangos
||Común en problemas de geometría computacional|
|Quad-Tree|Cada nodo tiene 4 hijos
||División espacial en 2D
||Usado en gráficos por computadora|
|Octree|Cada nodo tiene 8 hijos
||División espacial en 3D
||Usado en videojuegos y gráficos 3D|
|**Árboles para Datos Específicos**||
|Árbol de Expresión|Representa expresiones matemáticas
||Hojas son operandos, nodos internos son operadores
||Usado en compiladores|
|Árbol de Huffman|Árbol de codificación para compresión
||Construido basado en frecuencias
||Óptimo para codificación de prefijos|
|Árbol de Fenwick (BIT)|Estructura para sumas acumulativas
||Operaciones eficientes de actualización y consulta
||Usado en problemas de rango dinámico|
