# Árboles > serialización

## ¿Por qué?

Un árbol binario existe únicamente en memoria durante la ejecución de un programa. Cuando el programa termina, toda la estructura se pierde. Si queremos preservar un árbol para usarlo más tarde, enviarlo a través de una red, o simplemente hacer una copia completa del mismo, nos enfrentamos a un problema fundamental: **cómo convertir una estructura jerárquica bidimensional en una secuencia lineal de datos**.

Las estructuras de datos lineales (arrays, listas) se almacenan y transmiten fácilmente. Pero un árbol tiene una forma inherentemente no lineal: cada nodo puede tener múltiples hijos, y la relación entre ellos define la estructura. No podemos simplemente "escribir" el árbol como lo haríamos con un array.

**Ejemplo del problema:**

```
    2
   / \
  1   3
```

Si solo guardamos los valores `[2, 1, 3]`, cuando intentemos reconstruir el árbol no sabremos:
- ¿Cuál es la raíz?
- ¿Quién es hijo de quién?
- ¿Qué posición ocupa cada nodo (izquierda o derecha)?

La información estructural se ha perdido.

## ¿Qué?

La serialización es el proceso de convertir un árbol en una representación lineal (típicamente un String o un array) que capture tanto los valores de los nodos como la estructura del árbol. La deserialización es el proceso inverso: reconstruir el árbol original a partir de esa representación lineal.

**Propiedad crítica:** La serialización debe ser **completa e inequívoca**. Dados dos árboles diferentes, sus serializaciones deben ser diferentes. Dada una serialización, debe existir exactamente un árbol que la produzca.

## ¿Para qué?

La serialización de árboles tiene aplicaciones prácticas directas:

1. **Persistencia:** Guardar el árbol en un archivo o base de datos para usarlo después de cerrar el programa.
2. **Transmisión:** Enviar el árbol a través de una red (por ejemplo, en una API REST que devuelve estructuras jerárquicas en JSON).
3. **Clonación profunda:** Crear una copia exacta de un árbol sin compartir referencias.
4. **Debugging:** Visualizar y comparar estados de árboles en diferentes momentos de la ejecución.
5. **Almacenamiento en caché:** Guardar resultados computacionalmente costosos que se representan como árboles.

## ¿Cómo?

### El problema de la ambigüedad

Consideremos dos árboles diferentes:

```
Árbol A:          Árbol B:
    2                 2
   /                   \
  1                     3
   \
    3
```

Si usamos solo recorrido preorden:
- Árbol A: `[2, 1, 3]`
- Árbol B: `[2, 3]`

Pero si usamos recorrido inorden:
- Árbol A: `[1, 3, 2]`
- Árbol B: `[2, 3]`

Incluso combinando preorden e inorden hay casos donde la información no es suficiente si permitimos valores duplicados o nodos null en posiciones específicas.

### Solución: Marcadores de nodos vacíos

La estrategia más robusta es usar un recorrido (típicamente preorden) e incluir **marcadores explícitos para posiciones vacías**:

**Recorrido preorden con null markers:**

```
    2
   / \
  1   3
```

Serialización: `"2,1,null,null,3,null,null"`

Explicación del recorrido:
1. Visitar raíz: `2`
2. Ir a hijo izquierdo: `1`
3. Hijo izquierdo de 1: `null`
4. Hijo derecho de 1: `null`
5. Volver y ir a hijo derecho de raíz: `3`
6. Hijo izquierdo de 3: `null`
7. Hijo derecho de 3: `null`

**¿Por qué funciona?**

Los marcadores `null` capturan la estructura exacta del árbol. Cada nodo tiene exactamente dos hijos (que pueden ser null), y el orden preorden nos permite reconstruir la jerarquía de manera determinista.

### Algoritmo de serialización (iterativo)

1. Usar una pila para simular el recorrido preorden.
2. Para cada nodo visitado, escribir su valor.
3. Apilar hijo derecho (si existe o marcar null).
4. Apilar hijo izquierdo (si existe o marcar null).
5. Concatenar todos los valores separados por comas.

### Algoritmo de deserialización (iterativo)

1. Dividir el string por comas para obtener un array de valores.
2. Usar una cola o índice para consumir valores en orden.
3. Usar una pila para gestionar la construcción del árbol.
4. Para cada valor:
   - Si es `null`, no crear nodo
   - Si es un número, crear nodo y gestionar conexión con padre
5. Reconstruir enlaces parent-child siguiendo el orden preorden.

### Ejemplo completo

**Árbol original:**
```
      4
     / \
    2   6
   / \
  1   3
```

**Serialización preorden con null:**
`"4,2,1,null,null,3,null,null,6,null,null"`

**Proceso de deserialización:**
1. Leer `4` → crear raíz
2. Leer `2` → hijo izquierdo de 4
3. Leer `1` → hijo izquierdo de 2
4. Leer `null` → hijo izquierdo de 1 es null
5. Leer `null` → hijo derecho de 1 es null
6. Leer `3` → hijo derecho de 2
7. Leer `null` → hijo izquierdo de 3 es null
8. Leer `null` → hijo derecho de 3 es null
9. Leer `6` → hijo derecho de 4
10. Leer `null` → hijo izquierdo de 6 es null
11. Leer `null` → hijo derecho de 6 es null

**Árbol reconstruido:**
```
      4
     / \
    2   6
   / \
  1   3
```

## ¿Y ahora qué?

Una vez dominada la serialización básica con preorden, se pueden explorar:

- **Serialización compacta:** Usar recorrido por niveles (BFS) con marcadores null puede ser más eficiente para árboles balanceados.
- **Formatos estándar:** JSON, XML o Protocol Buffers para interoperabilidad entre sistemas.
- **Compresión:** Aprovechar patrones en la estructura (por ejemplo, árboles degenerados) para reducir el tamaño de la serialización.
- **Serialización incremental:** Actualizar la representación serializada cuando cambia el árbol sin regenerar todo.
- **Persistencia relacional:** En lugar de serializar a un String, almacenar el árbol en una base de datos usando una tabla de adyacencias (parent-child). Cada nodo es una fila con un campo `parent_id` que apunta a su padre. Este enfoque permite consultas flexibles (obtener solo un subárbol), actualizaciones parciales, y relacionar el árbol con otras entidades del sistema. Es especialmente útil en aplicaciones donde el árbol representa jerarquías del dominio (organización empresarial, categorías de productos, taxonomías) que deben persistir y consultarse de forma independiente.
