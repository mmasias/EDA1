# Test: Árboles

**Tema:** Estructura de Datos - Árboles Jerárquicos
**Número de preguntas:** 10
**Tiempo estimado:** 15-20 minutos

---

## Pregunta 1
**¿Qué característica fundamental distingue a un árbol de una estructura lineal como una lista?**

A) Los árboles son más rápidos
B) En un árbol, un nodo puede tener múltiples hijos (ramificación)
C) Los árboles usan menos memoria
D) Los árboles solo almacenan números

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia fundamental es la **ramificación**:

**Listas (lineales):**
- Cada elemento tiene como máximo un siguiente
- Un único camino para recorrer todos los elementos
- Estructura: A → B → C → D

**Árboles (no lineales):**
- Un nodo puede tener **múltiples hijos**
- Múltiples caminos diferentes para llegar a distintos elementos
- Estructura jerárquica con ramificaciones

```
Lista:     A → B → C → D

Árbol:         A
              / \
             B   C
            /   / \
           D   E   F
```

Para llegar a D seguimos **A → B → D**, para E seguimos **A → C → E**.

</details>

---

## Pregunta 2
**¿Cuál es el nodo que no tiene padre en un árbol?**

A) Nodo hoja
B) Nodo raíz
C) Nodo interno
D) Nodo terminal

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** El **nodo raíz** es el nodo superior del árbol y es el único que **no tiene padre**.

**Terminología de árboles:**

```
         A  ← Raíz (sin padre)
        / \
       B   C  ← Nodos internos (tienen padre e hijos)
      /   / \
     D   E   F  ← Hojas (tienen padre, NO tienen hijos)
```

- **Raíz:** Nodo inicial sin padre
- **Nodos internos:** Tienen padre y al menos un hijo
- **Hojas (terminales):** Tienen padre pero no tienen hijos

</details>

---

## Pregunta 3
**¿Qué son los nodos "hoja" en un árbol?**

A) Los nodos que están en el nivel 0
B) Los nodos que no tienen hijos
C) Los nodos que tienen exactamente dos hijos
D) Los nodos que son raíz del árbol

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Los **nodos hoja** (o terminales) son aquellos que **no tienen hijos**. Están en los extremos de las ramas del árbol.

```
         A
        / \
       B   C
      /   / \
     D   E   F   ← D, E, F son hojas (sin hijos)
```

**Características:**
- No tienen referencias a otros nodos como hijos
- Representan los puntos finales del árbol
- En código: `nodo.izquierdo == null && nodo.derecho == null`

**No confundir:**
- Nivel 0 = raíz (puede tener hijos)
- Nodos con 2 hijos = nodos internos completos

</details>

---

## Pregunta 4
**En un árbol binario, ¿cuántos hijos puede tener como MÁXIMO cada nodo?**

A) 1
B) 2
C) Depende del nivel
D) Ilimitados

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Un **árbol binario** es aquel donde cada nodo tiene **máximo 2 hijos**: izquierdo y derecho.

```java
class Nodo {
    int dato;
    Nodo izquierdo;   // Primer hijo (máximo)
    Nodo derecho;     // Segundo hijo (máximo)
}
```

**Posibilidades en árbol binario:**
- 0 hijos (nodo hoja)
- 1 hijo (solo izquierdo O solo derecho)
- 2 hijos (izquierdo Y derecho)

**Contraste:**
- Árbol binario: máximo 2 hijos
- Árbol general: puede tener cualquier número de hijos
- Árbol B, Quad-Tree, Octree: otros números específicos

</details>

---

## Pregunta 5
**¿Qué es la "altura" de un árbol?**

A) El número total de nodos
B) La profundidad máxima desde la raíz hasta la hoja más lejana
C) El número de nodos en el primer nivel
D) El ancho máximo del árbol

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La **altura** de un árbol es la **profundidad máxima**: el número de niveles desde la raíz hasta la hoja más lejana.

```
         A         ← Nivel 0
        / \
       B   C       ← Nivel 1
      /   / \
     D   E   F     ← Nivel 2
```

**Altura = 2** (niveles: 0, 1, 2)

**Cálculo:**
- Se cuenta desde 0 (raíz = nivel 0)
- O desde 1 (raíz = nivel 1)
- Depende de la convención usada

**Ejemplos:**
- Árbol con solo raíz: altura = 0
- Árbol con raíz y un hijo: altura = 1
- Árbol vacío: altura = -1 (por convención)

</details>

---

## Pregunta 6
**¿En qué consiste el recorrido "inorden" (in-order) en un árbol binario?**

A) Raíz → Izquierdo → Derecho
B) Izquierdo → Raíz → Derecho
C) Izquierdo → Derecho → Raíz
D) Por niveles de arriba a abajo

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** El recorrido **inorden** sigue el orden: **Izquierdo → Raíz → Derecho**

```
      4
     / \
    2   6
   / \ / \
  1  3 5  7
```

**Recorridos principales:**

| Tipo | Orden | Resultado |
|------|-------|-----------|
| **Inorden** | Izq → Raíz → Der | 1, 2, 3, 4, 5, 6, 7 |
| Preorden | Raíz → Izq → Der | 4, 2, 1, 3, 6, 5, 7 |
| Postorden | Izq → Der → Raíz | 1, 3, 2, 5, 7, 6, 4 |

**Utilidad del inorden:**
- En un BST (árbol binario de búsqueda), el recorrido inorden produce los elementos **en orden ascendente**

</details>

---

## Pregunta 7
**¿Qué es un BST (Binary Search Tree)?**

A) Un árbol donde todos los nodos tienen exactamente 2 hijos
B) Un árbol binario donde hijo izquierdo < padre < hijo derecho
C) Un árbol que solo puede tener números
D) Un árbol perfectamente balanceado

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Un **BST (Binary Search Tree)** es un árbol binario que cumple la propiedad de ordenación:

**Propiedad BST:** Para cada nodo:
- Todos los valores del subárbol **izquierdo** son **menores** que el nodo
- Todos los valores del subárbol **derecho** son **mayores** que el nodo

```
      50
     /  \
   30    70      ← 30 < 50 < 70
   / \   / \
  20 40 60 80    ← 20,40 < 50  y  60,80 > 50
```

**Ventaja:**
- Facilita búsquedas: en cada paso descartamos la mitad del subárbol
- Similar a búsqueda binaria en arrays

**No confundir:**
- BST ≠ árbol binario completo (no requiere que todos tengan 2 hijos)
- BST ≠ árbol balanceado (puede desbalancearse)

</details>

---

## Pregunta 8
**¿Para qué se utilizan principalmente los árboles en programación?**

A) Solo para almacenar números ordenados
B) Para representar jerarquías y facilitar búsquedas eficientes
C) Para reemplazar arrays en todos los casos
D) Solo para algoritmos académicos

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Los árboles son fundamentales para **representar jerarquías y búsquedas eficientes**.

**Aplicaciones reales:**

| Área | Uso |
|------|-----|
| **Sistemas de archivos** | Directorios y subdirectorios |
| **Web** | DOM (estructura de páginas HTML) |
| **Bases de datos** | Índices y B-Trees |
| **IA** | Árboles de decisión, árboles de juego |
| **Compiladores** | Árboles de sintaxis (AST) |
| **Gráficos** | Octrees (3D), Quad-trees (2D) |
| **Datos estructurados** | JSON, XML |
| **Algoritmos** | Expresiones matemáticas |

**Ejemplo sistema de archivos:**
```
C:
├── Users
│   ├── Manuel
│   └── Admin
└── Program Files
    └── Java
```

</details>

---

## Pregunta 9
**Según la documentación del curso, ¿qué "NO SABEN" los árboles por sí mismos?**

A) Quién es su nodo raíz
B) El número total de nodos en todas sus ramas (sin recorrido)
C) Cómo acceder a los hijos directos de cada nodo
D) Identificar si un nodo es hoja o interno

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Un árbol **no sabe cuántos nodos tiene en total** sin hacer un recorrido completo de todas sus ramas.

**Lo que SÍ sabe un árbol:**
- ✓ Quién es su nodo raíz (referencia directa)
- ✓ Cómo acceder a hijos directos de cada nodo
- ✓ Si un nodo es hoja (sin hijos) o interno

**Lo que NO sabe (sin recorrido):**
- ✗ Número total de nodos
- ✗ Todos sus nodos hoja
- ✗ Su profundidad/altura total

```java
// Para contar nodos, hay que recorrer TODO el árbol
public int contarNodos(Nodo raiz) {
    if (raiz == null) return 0;
    return 1 + contarNodos(raiz.izquierdo) + contarNodos(raiz.derecho);
}
```

**Solución:** Mantener un contador que se actualice en cada inserción/eliminación.

</details>

---

## Pregunta 10
**¿Qué diferencia fundamental hay entre un árbol y un grafo?**

A) Los árboles son más rápidos
B) Los árboles no pueden tener ciclos, los grafos sí
C) Los grafos solo tienen números
D) No hay diferencia

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia fundamental es que los **árboles NO pueden tener ciclos**, mientras que los grafos sí.

**Árbol:**
- Estructura jerárquica
- Cada nodo (excepto raíz) tiene **exactamente un padre**
- No hay ciclos (no puedes volver al mismo nodo siguiendo referencias)
- Existe un único camino entre dos nodos cualesquiera

```
    A
   / \
  B   C     ← Árbol válido
 /
D
```

**Grafo:**
- Estructura de red
- Un nodo puede tener múltiples conexiones
- **Puede tener ciclos**
- Puede haber múltiples caminos entre dos nodos

```
A ← B
↓   ↑
C → D     ← Grafo con ciclo: A→C→D→B→A
```

**Relación:** Todo árbol es un grafo (especial), pero no todo grafo es un árbol.

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de árboles
- **7-9 respuestas correctas:** Buen entendimiento, revisar conceptos específicos
- **5-6 respuestas correctas:** Comprensión básica, se recomienda repasar
- **Menos de 5 correctas:** Es necesario revisar el tema completo

## Temas Clave Evaluados

1. ✓ Estructura no lineal vs lineal
2. ✓ Nodo raíz (sin padre)
3. ✓ Nodos hoja (sin hijos)
4. ✓ Árboles binarios (máximo 2 hijos)
5. ✓ Altura del árbol
6. ✓ Recorridos (inorden)
7. ✓ BST (Binary Search Tree)
8. ✓ Aplicaciones prácticas
9. ✓ Limitaciones (conocimiento sin recorrido)
10. ✓ Árboles vs grafos (ciclos)
