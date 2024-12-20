# Acerca de los grafos
|||
|-|-|
|Comprender la naturaleza flexible y las propiedades de los grafos es fundamental para modelar relaciones complejas entre elementos, donde las conexiones pueden ser bidireccionales y no necesariamente jerárquicas.|A diferencia de los árboles, los grafos permiten ciclos y conexiones arbitrarias entre nodos, lo que los hace ideales para representar redes, mapas y cualquier sistema de relaciones complejas.|
---
|Qué son|Qué no son|Qué saben|Qué no saben|
|-|-|-|-|
|Una estructura de datos que consiste en un conjunto de vértices (nodos) y aristas que los conectan.|No son estructuras necesariamente jerárquicas como los árboles.|Saben qué vértices están directamente conectados a cada nodo.|No saben automáticamente si existe un camino entre dos nodos sin realizar una búsqueda.|
|Una forma de representar relaciones binarias entre elementos de un conjunto.|No son estructuras que requieren una raíz o un punto de inicio definido.|Saben el peso o costo de las conexiones (en grafos ponderados).|No conocen todos los ciclos presentes sin realizar un análisis específico.|
|Una estructura matemática para modelar conexiones y relaciones entre objetos.|No son estructuras que limitan las conexiones entre nodos.|Saben la dirección de las conexiones (en grafos dirigidos).|No saben el camino más corto entre nodos sin ejecutar un algoritmo específico.|

## Ejemplo de *correcta* implementación

```java

// 2DO!!!

```

## Implicaciones y consideraciones

- Acceso a elementos: El acceso a vértices adyacentes es directo mediante la lista de adyacencia.
- Eficiencia de operaciones
  - Verificar adyacencia: O(1) con matriz de adyacencia, O(n) con lista
  - Agregar/eliminar vértice: O(1) con lista, O(n²) con matriz para redimensionar
  - Agregar/eliminar arista: O(1)
- Flexibilidad: Máxima capacidad para modelar relaciones complejas y redes
- Uso de memoria: O(V + E) con lista de adyacencia, O(V²) con matriz de adyacencia

## Variaciones y extensiones

- Grafos dirigidos: Las aristas tienen dirección
- Grafos ponderados: Las aristas tienen pesos o costos
- Grafos bipartitos: Los vértices se pueden dividir en dos conjuntos independientes
- Grafos planares: Se pueden dibujar en un plano sin que las aristas se crucen
- Grafos completos: Cada vértice está conectado con todos los demás
- Grafos acíclicos dirigidos (DAG): Grafos dirigidos sin ciclos