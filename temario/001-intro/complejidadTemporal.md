# Complejidad temporal

## ¿Por qué?

La eficiencia es crucial en la programación. No basta con que un programa funcione; también es importante que funcione rápidamente y no consuma más recursos de los necesarios.

La complejidad temporal y espacial nos proporciona una herramienta para evaluar y comparar la eficiencia de las operaciones y algoritmos.

## ¿Qué?

|Complejidad temporal|Complejidad Espacial|
|-|-|
Se refiere al tiempo que tarda un algoritmo en completarse en función del tamaño de la entrada.|Se refiere a la cantidad de memoria que un algoritmo utiliza en función del tamaño de la entrada.
Es una medida de la rapidez con la que se ejecuta un algoritmo.|Es una medida de cuánto espacio en memoria consume un algoritmo.

## ¿Para qué?

- **Optimización**: Al entender la complejidad, podemos elegir o diseñar algoritmos que sean más eficientes para un problema específico.
- **Comparación**: Nos permite comparar diferentes algoritmos o estructuras de datos y elegir el más adecuado para una tarea particular.
- **Previsión**: Ayuda a prever cómo se comportará un algoritmo o estructura de datos a medida que el tamaño de los datos aumenta.

## ¿Cómo?

La complejidad se suele expresar utilizando la notación [Big O (O grande)](bigO.md). 

Por ejemplo:

||||
|-|-|-|
O(1)|Complejidad constante|No importa cuán grande sea la entrada, la operación siempre tomará un tiempo constante.
O(n)|Complejidad lineal|El tiempo que tarda la operación crece linealmente con el tamaño de la entrada.
O(log n)|Complejidad logarítmica|Se ve comúnmente en algoritmos que dividen a la entrada por la mitad en cada paso, como la búsqueda binaria.
O(n^2)|Complejidad cuadrática|Típica de algoritmos con bucles anidados.