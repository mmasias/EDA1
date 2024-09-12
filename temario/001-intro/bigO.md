# Notación Big O

## ¿Por qué?

La eficiencia de los algoritmos es fundamental en la informática. A medida que los conjuntos de datos crecen, la diferencia en el rendimiento entre un algoritmo eficiente y uno ineficiente puede ser abismal. La notación Big O nos proporciona una herramienta estandarizada para describir y comparar la eficiencia de los algoritmos en términos de tiempo y espacio.

## ¿Qué?

La notación Big O, denotada como ***(O(f(n))***, es una notación matemática que describe el límite superior del tiempo de ejecución (o espacio) de un algoritmo en función del tamaño de la entrada. Es una representación simplificada que se centra en el comportamiento de crecimiento más significativo a medida que n (el tamaño de la entrada) se acerca al infinito.

## ¿Para qué?

Para entender cómo crece el tiempo de ejecución o el uso de memoria de un algoritmo a medida que aumenta el tamaño de la entrada.
Para facilitar la comparación entre diferentes algoritmos para determinar cuál es más eficiente.
Para tener criterios que permitan diseñar algoritmos más eficientes al identificar y evitar los cuellos de botella en el rendimiento.

## ¿Cómo?

La notación Big O se expresa en términos de funciones que representan cómo crece el tiempo o el espacio con respecto al tamaño de la entrada. Algunos ejemplos comunes incluyen:

|||||
|-|-|-|-|
O(1)|Complejidad constante|El algoritmo se ejecuta en un tiempo constante, independientemente del tamaño de la entrada|Acceder a un elemento de un array por índice.
O(log n)|Complejidad logarítmica|El tiempo de ejecución crece logarítmicamente con el tamaño de la entrada.|Búsqueda binaria en un array ordenado.
O(n)|Complejidad lineal|El tiempo de ejecución crece linealmente con el tamaño de la entrada.|Buscar un elemento en un array no ordenado.
O(n log n)||A menudo se ve en algoritmos de ordenación eficientes como el mergesort o el heapsort.
O(n^2), O(n^3), ...|Complejidades polinómicas|Se ven en algoritmos con bucles anidados. Ejemplo: algoritmos de ordenación como el bubble sort (para (O(n^2)).
O(2^n)|Complejidad exponencial|El tiempo de ejecución dobla con cada adición a la entrada.|Algoritmos de fuerza bruta para el problema del viajante.
