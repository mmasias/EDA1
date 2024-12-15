# Grafos

## ¿Por qué?

En las estructuras de datos que hemos visto hasta ahora (listas y árboles), las relaciones entre elementos seguían patrones específicos y restrictivos: en las listas cada elemento se conecta solo con el siguiente, y en los árboles cada nodo tiene un padre y posibles hijos.

En el mundo real se dan muchas situaciones en las que necesitaremos modelar relaciones más flexibles entre elementos.

## ¿Qué?

|||
|-|-|
|![](/images/temario/004-grafos/grafoBasico.svg)|Un grafo es una estructura de datos que consiste en un conjunto de nodos (también llamados vértices) y un conjunto de conexiones entre estos nodos (llamadas aristas o arcos).

A diferencia de los árboles:

- Un nodo puede conectarse con cualquier otro nodo
- No hay concepto de "raíz"
- Pueden existir ciclos (un camino que empieza y termina en el mismo nodo)
- Un nodo puede tener cualquier número de conexiones

## ¿Para qué?

Los grafos son ideales para representar:

- Redes sociales (personas y sus amistades)
- Mapas (ciudades y carreteras)
- Internet (dispositivos y sus conexiones)
- Dependencias en software (qué módulos necesitan otros módulos)
- Cualquier sistema donde los elementos puedan relacionarse de forma arbitraria

## ¿Cómo?

<div align=center>

|Lista|Árbol|Grafo|
|-|-|-|
|Un nodo necesitaba:|El nodo evolucionó para tener:|El nodo necesita "expandirse" para:
|- Un dato|- Un dato|- Mantener el dato (esto no cambia)
|- Una referencia al siguiente nodo (y quizás al anterior en listas doblemente enlazadas)|- Referencias a sus hijos (típicamente izquierdo y derecho en árboles binarios)|- Poder conectarse con un número variable de otros nodos, sin restricciones de jerarquía
||- Quizás una referencia al padre|- No hay conceptos de "siguiente", "hijo" o "padre" - todos son simplemente "vecinos"
|||- Las conexiones son más libres y podrían ser muchas

</div>

### Versión básica

En su forma más básica un nodo de grafo necesita:

<div align=center>

|¿Qué?|¿Cómo?|
|-|-|
|Almacenar un valor.|En nuestro caso, un número.|
|Saber con qué otros nodos está conectado|En nuestro caso, un array de referencias a otros nodos.|

---

|[vPrimitiva](/src/grafos/primitivo/)|[vBásica](/src/grafos/basico/)|
|-|-|

</div>

Esta implementación básica nos permite:

1. Crear nodos individuales
2. Establecer conexiones entre nodos
3. Consultar las conexiones de un nodo

La simplicidad de esta implementación nos permitirá ir añadiendo funcionalidades según necesitemos:

- Dirección en las conexiones (grafos dirigidos)
- Pesos en las conexiones (grafos ponderados)
- Métodos de recorrido
- Algoritmos de búsqueda

### Caminos entre dos nodos

Implementada la versión básica, le agregaremos la capacidad de verificar si existe un camino entre dos nodos.

<div align=center>

|![](/images/temario/004-grafos/grafos.svg)
|:-:
|[vBasico02](/src/grafos/basico02/)

</div>

### A partir de aquí

[🚬](🚬grafos.md)