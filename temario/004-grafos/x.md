
|Paso|Acción|Nodo actual|Vecinos disponibles|Stack|Stack pointer|Visitados|
|:-:|-|:-:|:-:|-|:-:|:-:|
|0|Inicialización|-|-|[]|0|[F,F,F,F,F]|
|1|Añadir nodo inicial|1|2,4|[1]|1|[F,F,F,F,F]|
|2|Procesar nodo 1|1|2,4|[2,4]|2|[T,F,F,F,F]|
|3|Procesar nodo 4|4|5|[2,5]|2|[T,F,F,T,F]|
|4|Procesar nodo 5|5|META|[2]|1|[T,F,F,T,T]|

1. Situarse en el nodo actual
2. Identificamos los vecinos disponibles y no visitados.
3. Actualizamos el stack basado en esos vecinos
4. Actualizamos el contador del stack
5. Marcamos el nodo como visitado

El proceso termina cuando alcanzamos el nodo objetivo.

|Paso|Acción|Nodo actual|Vecinos disponibles|Stack|Stack pointer|Visitados|
|:-:|-|:-:|:-:|-|:-:|:-:|
|0|Inicialización|-|-|[]|0|[F,F,F,F,F,F,F,F,F,F,F,F]|
|1|Añadir nodo inicial|0|7,A|[0]|1|[F,F,F,F,F,F,F,F,F,F,F,F]|
|2|Procesar nodo 0|0|7,A|[7,A]|2|[T,F,F,F,F,F,F,F,F,F,F,F]|
|3|Procesar nodo A|A|B,8|[7,B,8]|3|[T,F,F,F,F,F,F,F,F,F,T,F]|
|4|Procesar nodo 8|8|9,5|[7,B,9,5]|4|[T,F,F,F,F,F,F,F,T,F,T,F]|
|5|Procesar nodo 5|5|2|[7,B,9,2]|4|[T,F,F,F,F,T,F,F,T,F,T,F]|
|6|Procesar nodo 2|2|3,1|[7,B,9,3,1]|5|[T,F,T,F,F,T,F,F,T,F,T,F]|
|7|Procesar nodo 3|3|6|[7,B,9,1,6]|5|[T,F,T,T,F,T,F,F,T,F,T,F]|
|8|Procesar nodo 6|6|META|[7,B,9,1]|4|[T,F,T,T,F,T,T,F,T,F,T,F]|
