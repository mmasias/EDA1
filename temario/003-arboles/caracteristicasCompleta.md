# Árboles > Características (*avanzadas*)

Una vez comprendidos los conceptos básicos de los árboles, es importante profundizar en sus características y propiedades para entender mejor su comportamiento y aplicaciones.

Aquí se expanden las características fundamentales vistas en la introducción a árboles, proporcionando una visión exhaustiva de las propiedades matemáticas y estructurales que pueden analizarse en un árbol. 

Estos conceptos son especialmente relevantes para:

- Análisis de eficiencia de algoritmos
- Diseño de estructuras de datos avanzadas
- Optimización de operaciones sobre árboles
- Comprensión de variantes específicas (árboles AVL, árboles B, etc.)
- Resolución de problemas complejos que involucran árboles

<div align=center>

![](/imagenes/modelosUML/arboles.svg)

</div>

||||
|-|-|-|
|Nodo raíz|El nodo superior en un árbol, sin padres.|'a' es el nodo raíz|
|Nodos hijos|Nodos que descienden directamente de otros nodos.|'b' y 'c' son hijos de 'a'<br>'d' es hijo de 'b'<br>'e','f','g' son hijos de 'c'|
|Nodo padre|Nodo que tiene hijos directos.|'a' es padre de 'b' y 'c'<br>'b' es padre de 'd'<br>'c' es padre de 'e','f','g'|
|Hermanos (siblings)|Nodos que comparten el mismo padre.|'b' y 'c' son hermanos<br>'e','f','g' son hermanos|
|Hojas|Nodos sin hijos, también llamados nodos terminales.|'d','e','f','g' son hojas|
|Nodos internos|Nodos que tienen al menos un hijo (no son hojas).|'a','b','c' son nodos internos|
|Ancestros|Todos los nodos en el camino desde la raíz hasta el padre de un nodo.|Para 'f': sus ancestros son 'a' y 'c'<br>Para 'd': sus ancestros son 'a' y 'b'|
|Descendientes|Todos los nodos que pueden ser alcanzados desde un nodo siguiendo sus hijos.|Para 'a': todos los demás nodos<br>Para 'c': 'e','f','g'|
|Subárboles|Árboles formados por un nodo y todos sus descendientes.|Subárbol de 'c': {c,e,f,g}<br>Subárbol de 'b': {b,d}|
|Camino (path)|Secuencia de nodos conectados desde un nodo hasta otro.|De 'a' a 'f': a→c→f<br>De 'a' a 'd': a→b→d|
|Longitud del camino|Número de aristas en un camino.|Camino a→c→f tiene longitud 2<br>Camino a→b→d tiene longitud 2|
|Profundidad de un nodo|Longitud del camino único desde la raíz hasta el nodo.|'d' tiene profundidad 2<br>'f' tiene profundidad 2|
|Altura de un nodo|Longitud del camino más largo desde el nodo hasta una hoja.|'a' tiene altura 2<br>'c' tiene altura 1<br>'d','e','f','g' tienen altura 0|
|Altura del árbol|Altura del nodo raíz (o profundidad máxima).|La altura del árbol es 2|
|Nivel|Conjunto de nodos que están a la misma profundidad.|Nivel 0: {a}<br>Nivel 1: {b,c}<br>Nivel 2: {d,e,f,g}|
|Grado|Número máximo de hijos que puede tener un nodo.|'a' tiene grado 2<br>'c' tiene grado 3<br>'b' tiene grado 1|
|Peso|Número de hojas o nodos terminales del árbol.|El árbol tiene peso 4 (d,e,f,g)|
|Bosque|Conjunto de árboles disjuntos.|
|Árbol vacío|Árbol que no contiene nodos (ni siquiera raíz).|
|Factor de balanceo|Diferencia entre la altura del subárbol derecho y el izquierdo de un nodo.|'a': altura(c) - altura(b) = 1 - 1 = 0 (balanceado)<br>'c': altura(e) - altura(g) = 0 - 0 = 0 (balanceado)|
|Árbol completo|Árbol donde todos los niveles, excepto posiblemente el último, están llenos, y los nodos del último nivel están lo más a la izquierda posible.|Este árbol no es completo (le faltaría un hijo a 'b')|
|Árbol lleno|Árbol donde todos los nodos internos tienen el máximo número de hijos posible.|Este árbol no es lleno porque 'b' solo tiene un hijo|
|Número máximo de nodos|En un nivel k: 2^k para árboles binarios, M^k para árboles M-arios|Nivel 0: máx 1 nodo (cumple)<br>Nivel 1: máx 2 nodos (cumple)<br>Nivel 2: máx 4 nodos (cumple)|
|Número máximo de nodos total|Para un árbol de altura h: 2^(h+1) - 1 para binarios, (M^(h+1) - 1)/(M-1) para M-arios|Para altura 2: máximo 7 nodos en binario (este árbol tiene 7)|
|Densidad del árbol|Proporción entre el número actual de nodos y el máximo posible para esa altura.|7 nodos actuales / 7 nodos posibles = 100%|
|Árbol degenerado|Árbol donde cada nodo interno tiene exactamente un hijo.|El subárbol de 'b' es degenerado|
|Árbol balanceado|Árbol donde la diferencia de altura entre los subárboles de cualquier nodo no supera 1.|Este árbol está balanceado en todos sus nodos|
|Profundidad mínima|La longitud del camino más corto desde la raíz a una hoja.|En este árbol es 2 (tanto a→b→d como a→c→e)|
|Profundidad promedio|Media de las profundidades de todas las hojas.|En este árbol: (2+2+2+2)/4 = 2|
|Anchura del árbol|Número máximo de nodos en cualquier nivel.|La anchura es 4 (nivel 2 con d,e,f,g)|
|Diámetro del árbol|La longitud del camino más largo entre dos nodos cualesquiera.|El diámetro es 4 (d→b→a→c→g)|
|Nodos hermanos izquierdo/derecho|En un árbol ordenado, los hermanos a la izquierda/derecha de un nodo.|'b' es hermano izquierdo de 'c'<br>'f' es hermano derecho de 'e'|
|Subárbol izquierdo/derecho|En un árbol ordenado, el subárbol formado por un hijo izquierdo/derecho y todos sus descendientes.|Subárbol izq. de 'a': {b,d}<br>Subárbol der. de 'a': {c,e,f,g}|
|Ancestro común más cercano|El ancestro compartido más próximo entre dos nodos.|Entre 'd' y 'e': es 'a'<br>Entre 'e' y 'g': es 'c'|
|Distancia entre nodos|Número de aristas en el camino más corto entre dos nodos.|Distancia 'd' a 'f': 4 aristas|
|Factor de ramificación|Promedio de hijos por nodo interno.|En este árbol: (2+1+3)/3 = 2|
|Nodos frontera|Conjunto de todas las hojas del árbol.|{d,e,f,g}|
|Nodos internos|Conjunto de nodos que no son hojas.|{a,b,c}|
|Aridad de un nodo|Número actual de hijos de un nodo (a diferencia del grado que es el máximo posible).|'a': aridad 2<br>'c': aridad 3<br>'b': aridad 1|
|Camino crítico|Camino desde la raíz a una hoja que determina la altura del árbol.|En este caso cualquier camino: a→b→d, a→c→e, etc. (todos tienen la misma longitud)|
|Nivel de saturación|Porcentaje de nodos presentes en un nivel respecto al máximo posible.|Nivel 1: 2/2 = 100%<br>Nivel 2: 4/4 = 100%|
|Profundidad media ponderada|Media de las profundidades de todos los nodos, ponderada por el número de nodos en cada nivel.|((1×1) + (2×2) + (4×3))/7 ≈ 2.43|
|Árbol isomorfo|Dos árboles son isomorfos si tienen la misma estructura aunque los nodos tengan distintos valores.|Este árbol es isomorfo a cualquier árbol con la misma estructura de 2 hijos para 'a', donde el izquierdo tiene 1 hijo y el derecho tiene 3|
|Simetría del árbol|Un árbol es simétrico si sus subárboles izquierdo y derecho son imágenes espejo.|Este árbol no es simétrico|
|Complejidad estructural|Medida de cuántas configuraciones diferentes puede tener un árbol con n nodos.|Para los 7 nodos de este árbol, hay múltiples configuraciones posibles|
|Peso de un subárbol|Número de nodos en un subárbol.|Subárbol de 'c': peso 4 (c,e,f,g)<br>Subárbol de 'b': peso 2 (b,d)|
|Balance relativo|Ratio entre el número de nodos en subárboles hermanos.|Entre subárboles de 'a': 2/4 = 0.5|
|Profundidad interna|Suma de las profundidades de todos los nodos internos.|a(0) + b(1) + c(1) = 2|
|Profundidad externa|Suma de las profundidades de todas las hojas.|d(2) + e(2) + f(2) + g(2) = 8|
|Centroide|Nodo que minimiza la suma de las distancias a todos los otros nodos.|En este árbol sería 'a'|
|Radio del árbol|Mínima distancia máxima desde cualquier nodo a todos los demás.|En este caso es 2|
|Vector de niveles|Secuencia que representa el número de nodos en cada nivel.|[1,2,4]|
|Densidad por niveles|Porcentaje de nodos presentes en cada nivel respecto al máximo posible para ese nivel.|*No se aplica*|
|Grado de dispersión|Medida de cuán uniformemente están distribuidos los nodos entre los niveles.|*No se aplica*|
|Índice de Horton-Strahler|Medida de la complejidad de ramificación donde: hojas = 1; nodos internos = máx(índices_hijos) + 1 si el máximo se repite, o máx(índices_hijos) si no.|Hojas (d,e,f,g) = 1<br>Nodo b = 1 (un hijo con índice 1)<br>Nodo c = 2 (tres hijos con índice 1)<br>Nodo a = 2 (max entre hijo 1 y 2)|
