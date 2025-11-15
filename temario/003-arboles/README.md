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

Representar datos jerárquicos|Facilitar búsquedas|Manejar datos ordenados
|-|-|-|
*Modelar estructuras con **relaciones padre-hijo***|*Optimizar la **búsqueda de elementos***|*Mantener elementos **en orden específico***
|- Sistemas de archivos y directorios|- Árboles de búsqueda binaria (BST)|- Mantener elementos en orden específico
|- Estructuras organizacionales|- Árboles AVL para búsquedas balanceadas|- Facilitar recorridos ordenados (inorden, preorden, postorden)
|- Árboles genealógicos|- Índices en bases de datos|- Implementar diccionarios y mapas ordenados
|- Estructuras DOM en páginas web|- Árboles B y B+ en sistemas de archivos|
|- Documentos XML/JSON|
|||
**Optimizar operaciones**|**Compilación y parsing**|**Inteligencia Artificial**
*Mejorar la **eficiencia** de operaciones*|*Analizar y **procesar lenguajes***|*Tomar **decisiones** y resolver problemas*
|- Búsquedas más eficientes que en listas (O(log n) vs O(n))|- [Árboles de sintaxis abstracta (AST)](ejemplos/AST.md)|- Árboles de decisión en machine learning
|- Inserciones y eliminaciones ordenadas|- Evaluación de expresiones matemáticas|- Árboles de juego en IA de videojuegos
|- Balanceo automático en estructuras avanzadas|- Parseo de lenguajes de programación|- Árboles de búsqueda en sistemas expertos
|||
**Gráficos y videojuegos**|**Sistemas operativos**|**Redes y comunicaciones**
*Optimizar **renderizado** y detección de colisiones*|*Gestionar **recursos del sistema***|*Organizar **topologías** y protocolos de red*
|- Octrees para particionamiento espacial|- Gestión de procesos y threads|- Tablas de enrutamiento
|- BSP trees para renderizado 3D|- Sistemas de archivos|- Árboles de spanning en redes
|- Árboles de colisiones|- Gestión de memoria|- Protocolos de comunicación jerárquicos

## ¿Cómo?

### Implementación básica

- En una estructura de árbol simple, cada nodo contiene datos y referencias a sus nodos hijos.
- La implementación precisa varía según el tipo de árbol.

### Características

<div align=center>

![](/imagenes/modelosUML/arboles.svg)

</div>

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

> [Características (versión completa)](caracteristicasCompleta.md)

### Operaciones

#### Básicas

[Inserción](inserciones.md)|[Recorrido](recorridos.md)|Búsqueda|Eliminación|
|-|-|-|-|
*Agregar nodos **respetando las propiedades del árbol***|*Visitar todos los nodos **en un orden específico***|*Encontrar un nodo específico*|*Remover nodos **manteniendo la estructura del árbol***|
|- Como hoja|- Preorden (raíz, izquierda, derecha)|- Por valor|- Eliminación de hojas|
|- En una posición específica|- Inorden (izquierda, raíz, derecha)|Por posición|- Eliminación de nodos internos (con restructuración)|
|- Manteniendo el orden (en árboles ordenados)|- Postorden (izquierda, derecha, raíz)|- Por relación (padre, hijo, hermano)|- Eliminación preservando propiedades específicas|
||- Por niveles (nivel a nivel, de izquierda a derecha)|

#### Avanzadas

Cálculo de altura|Búsqueda de ancestro común|Balanceo|Clonación y copia
|-|-|-|-|
*Determinar la altura de **diferentes partes del árbol***|*Encontrar el ancestro común **más cercano entre dos nodos***|*Reorganizar el árbol para **mantener balance***|*Crear copias **del árbol o subárboles***
|- Todo el árbol|- Por recorrido hacia arriba|- Rotaciones simples|- Copia superficial
|- Un nodo específico|- Por marcado de caminos|- Rotaciones dobles|- Copia profunda
|- Un subárbol|- Por comparación de profundidades|- Rebalanceo completo|- Copia parcial (subárboles)
|||||
**Operaciones de análisis**|**Fusión y división**|**Serialización**|**Validación**
*Calcular **propiedades del árbol***|*Operaciones **estructurales complejas***|*Convertir el árbol en **una forma lineal***|*Verificar **propiedades del árbol***
|- Número de nodos|- Combinar dos árboles|- Para almacenamiento|- Integridad estructural
|- Profundidad máxima/mínima|- Dividir un árbol en subárboles|- Para transmisión|- Propiedades específicas (como en BST)
|- Factor de ramificación|- Injertar subárboles|- Para persistencia|- Restricciones de balance

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
