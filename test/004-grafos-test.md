# Test: Grafos (Graphs)

**Tema:** Estructura de Datos - Grafos y Redes
**Número de preguntas:** 10
**Tiempo estimado:** 15-20 minutos

---

## Pregunta 1
**¿Qué es un grafo?**

A) Un árbol sin restricciones de jerarquía
B) Una estructura de nodos (vértices) y conexiones (aristas) entre ellos
C) Una lista con múltiples referencias
D) Una pila bidimensional

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Un **grafo** es una estructura de datos que consiste en:
- **Vértices (nodos):** Los elementos individuales
- **Aristas (arcos):** Las conexiones entre los vértices

```
Ejemplo de grafo simple:

    A ---- B
    |      |
    |      |
    C ---- D

Vértices: {A, B, C, D}
Aristas: {A-B, A-C, B-D, C-D}
```

**Flexibilidad:** A diferencia de listas y árboles, los grafos permiten conexiones arbitrarias entre nodos sin restricciones jerárquicas.

</details>

---

## Pregunta 2
**¿Cuál es la principal diferencia entre un árbol y un grafo?**

A) Los grafos son más rápidos
B) Los grafos pueden tener ciclos y conexiones arbitrarias
C) Los árboles solo almacenan números
D) No hay diferencia

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia fundamental:

**Árbol:**
- Estructura jerárquica
- Cada nodo (excepto raíz) tiene exactamente un padre
- **NO puede tener ciclos**
- Hay un único camino entre dos nodos

**Grafo:**
- Estructura de red flexible
- Nodos pueden conectarse arbitrariamente
- **PUEDE tener ciclos**
- Puede haber múltiples caminos entre dos nodos
- NO hay concepto de "raíz"

```
Árbol (NO ciclos):    Grafo (SÍ ciclos):
    A                    A ←
   / \                  / \  ↑
  B   C                B   C |
                        \  /  |
                         D ←--
```

**Relación:** Todo árbol es un tipo especial de grafo, pero no todo grafo es un árbol.

</details>

---

## Pregunta 3
**¿Qué términos se usan para referirse a los elementos y conexiones en un grafo?**

A) Nodos y punteros
B) Elementos y enlaces
C) Vértices y aristas
D) Puntos y líneas

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** La terminología estándar en teoría de grafos es:

- **Vértices (vertices):** Los nodos o elementos del grafo
  - También llamados "nodos" informalmente

- **Aristas (edges):** Las conexiones entre vértices
  - También llamados "arcos" especialmente en grafos dirigidos

```
    A -------- B      Vértices: A, B, C, D
    |          |      Aristas: {A-B, A-C, B-D, C-D}
    |          |
    C -------- D
```

**Sinónimos comunes:**
- Vértices = nodos = puntos
- Aristas = arcos = conexiones = enlaces

</details>

---

## Pregunta 4
**¿Para qué aplicaciones son ideales los grafos?**

A) Solo para matemáticas abstractas
B) Para modelar redes, mapas, relaciones sociales y dependencias
C) Solo para almacenar números ordenados
D) Para reemplazar arrays en todos los casos

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Los grafos son ideales para modelar **relaciones complejas y redes**:

**Aplicaciones reales:**

| Aplicación | Descripción |
|------------|-------------|
| **Redes sociales** | Personas (vértices), amistades (aristas) |
| **Mapas/GPS** | Ciudades (vértices), carreteras (aristas) |
| **Internet** | Dispositivos/servidores (vértices), conexiones (aristas) |
| **Dependencias software** | Módulos (vértices), dependencias (aristas) |
| **Redes eléctricas** | Nodos de distribución, cables |
| **Páginas web** | Páginas (vértices), enlaces (aristas) |
| **Rutas aéreas** | Aeropuertos (vértices), vuelos (aristas) |

**Ejemplo red social:**
```
Ana ---- Luis
 |        |
 |        |
María -- Carlos

Ana es amiga de: Luis, María
```

</details>

---

## Pregunta 5
**¿Qué es un "ciclo" en un grafo?**

A) Una arista que conecta un nodo consigo mismo
B) Un camino que empieza y termina en el mismo vértice
C) Un grafo circular
D) Un error de implementación

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Un **ciclo** es un camino en el grafo que **comienza y termina en el mismo vértice**, pasando por al menos una arista.

```
Ejemplo de ciclo:

    A ---- B
    |      |
    |      |
    C ---- D

Ciclo: A → B → D → C → A
(empezamos en A y volvemos a A)
```

**Tipos de grafos según ciclos:**
- **Grafo acíclico:** NO tiene ciclos (ejemplo: árboles)
- **Grafo cíclico:** SÍ tiene al menos un ciclo

**DAG (Directed Acyclic Graph):** Grafo dirigido sin ciclos, muy usado en dependencias de tareas.

</details>

---

## Pregunta 6
**¿Qué diferencia a un grafo dirigido de uno no dirigido?**

A) El tamaño del grafo
B) Las aristas tienen dirección (A→B es diferente de B→A)
C) La velocidad de procesamiento
D) El número de vértices

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia está en la **direccionalidad de las aristas**:

**Grafo NO dirigido:**
- Las aristas NO tienen dirección
- Si A está conectado con B, entonces B está conectado con A
- Relación simétrica

```
A ---- B    (A-B es bidireccional)
```

**Grafo dirigido (dígrafo):**
- Las aristas SÍ tienen dirección (flechas)
- A→B no implica que B→A
- Relación asimétrica

```
A ---→ B    (puedes ir de A a B, pero NO de B a A)
```

**Ejemplos reales:**
- **No dirigido:** Red de amistades (si Ana es amiga de Luis, Luis es amigo de Ana)
- **Dirigido:** Twitter (seguir a alguien no implica que te sigan de vuelta)

</details>

---

## Pregunta 7
**¿Qué es un grafo ponderado?**

A) Un grafo muy grande
B) Un grafo donde las aristas tienen pesos o costos asociados
C) Un grafo con más vértices que aristas
D) Un grafo perfectamente balanceado

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Un **grafo ponderado** es aquel en el que cada arista tiene un **peso (valor numérico)** asociado, representando costo, distancia, tiempo, etc.

```
Grafo NO ponderado:      Grafo ponderado:
    A ---- B                 A --5-- B
    |      |                 |       |
    |      |                 3       7
    C ---- D                 C --2-- D

En el ponderado:
- Distancia A→B: 5 km
- Distancia A→C: 3 km
- Distancia B→D: 7 km
- Distancia C→D: 2 km
```

**Aplicaciones:**
- Mapas de rutas (peso = distancia o tiempo)
- Redes de comunicación (peso = ancho de banda)
- Costos de transporte (peso = precio)

**Uso:** Algoritmos como Dijkstra encuentran el camino más corto en grafos ponderados.

</details>

---

## Pregunta 8
**Según la documentación del curso, ¿qué "NO SABEN" los grafos por sí mismos?**

A) Qué vértices están directamente conectados a cada nodo
B) Si existe un camino entre dos nodos sin realizar una búsqueda
C) El peso de las conexiones (en grafos ponderados)
D) La dirección de las conexiones (en grafos dirigidos)

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Un grafo **no sabe automáticamente si existe un camino** entre dos nodos no directamente conectados; necesita **realizar una búsqueda** (BFS o DFS).

**Lo que SÍ sabe un grafo:**
- ✓ Qué vértices están **directamente** conectados (vecinos)
- ✓ Pesos de conexiones (si es ponderado)
- ✓ Dirección de conexiones (si es dirigido)

**Lo que NO sabe (sin búsqueda/algoritmo):**
- ✗ Si existe camino entre A y Z (no vecinos)
- ✗ El camino más corto entre dos nodos
- ✗ Todos los ciclos presentes

```java
// Para encontrar si hay camino de A a D:
// Necesitamos BFS o DFS

    A ---- B
    |
    |
    C ---- D

¿Hay camino A→D? Sí: A→C→D
Pero el grafo no lo sabe sin buscarlo
```

</details>

---

## Pregunta 9
**¿Qué representa cada nodo en un grafo que modela una red social?**

A) Una publicación
B) Una persona (usuario)
C) Un mensaje
D) Una foto

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** En una red social modelada como grafo:

**Vértices (nodos):** Representan **personas/usuarios**

**Aristas (conexiones):** Representan **relaciones** entre personas:
- Amistad (Facebook)
- Seguir (Twitter/Instagram)
- Conexión profesional (LinkedIn)

```
Ejemplo Facebook (no dirigido):

    Ana ---- Luis
     |        |
     |        |
   María -- Carlos

Aristas = amistades bidireccionales
```

```
Ejemplo Twitter (dirigido):

    Ana ---→ Luis
     ↑        |
     |        ↓
   María ←-- Carlos

Ana sigue a Luis, pero Luis no sigue a Ana
```

**Operaciones típicas:**
- ¿Quiénes son amigos de Ana? (vecinos directos)
- ¿Hay conexión entre Ana y Carlos? (buscar camino)
- Sugerir amigos (amigos de amigos)

</details>

---

## Pregunta 10
**¿En qué se diferencia la forma de almacenar conexiones en un grafo comparado con un árbol binario?**

A) No hay diferencia
B) El árbol usa dos referencias fijas (izquierdo/derecho), el grafo necesita lista de vecinos variable
C) El grafo es más rápido
D) El árbol usa arrays, el grafo no

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia está en **cómo se almacenan las conexiones**:

**Árbol binario (conexiones fijas):**
```java
class NodoArbol {
    int dato;
    NodoArbol izquierdo;  // Hijo 1 (fijo)
    NodoArbol derecho;    // Hijo 2 (fijo)
}
```
- Máximo 2 hijos
- Referencias fijas

**Grafo (conexiones variables):**
```java
class NodoGrafo {
    int dato;
    List<NodoGrafo> vecinos;  // Lista dinámica de conexiones
}
```
- Número variable de conexiones
- No hay concepto de "izquierdo/derecho"
- Todos son "vecinos" o "adyacentes"

**Ejemplo:**
```
Árbol:        Grafo:
    A            A conectado con: [B, C, D, E]
   / \           (puede tener muchos vecinos)
  B   C
```

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de grafos
- **7-9 respuestas correctas:** Buen entendimiento, revisar conceptos específicos
- **5-6 respuestas correctas:** Comprensión básica, se recomienda repasar
- **Menos de 5 correctas:** Es necesario revisar el tema completo

## Temas Clave Evaluados

1. ✓ Definición de grafo (vértices y aristas)
2. ✓ Diferencia entre árbol y grafo (ciclos)
3. ✓ Terminología (vértices/aristas)
4. ✓ Aplicaciones reales
5. ✓ Concepto de ciclo
6. ✓ Grafos dirigidos vs no dirigidos
7. ✓ Grafos ponderados
8. ✓ Limitaciones (conocimiento sin búsqueda)
9. ✓ Modelado de redes sociales
10. ✓ Almacenamiento de conexiones
