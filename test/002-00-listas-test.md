# Test: Listas Enlazadas

**Tema:** Listas Enlazadas Simples
**Número de preguntas:** 10
**Tiempo estimado:** 15-20 minutos

---

## Pregunta 1
**¿Cuál es la característica fundamental que define a una lista enlazada simple?**

A) Almacena todos los elementos en posiciones contiguas de memoria
B) Mantiene referencias directas a todos sus elementos
C) Solo mantiene una referencia al primer nodo (cabeza), y cada nodo apunta al siguiente
D) Requiere un tamaño fijo predefinido al momento de su creación

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Una lista enlazada simple solo mantiene una referencia al primer nodo (cabeza/head), y cada nodo contiene una referencia al siguiente nodo. No almacena elementos en memoria contigua (esa es característica de los arrays), no mantiene referencias directas a todos los elementos, y no requiere tamaño fijo (es dinámica).

</details>

---

## Pregunta 2
**Para insertar un elemento al principio de una lista enlazada, ¿cuál es el orden correcto de operaciones?**

A) Crear nuevo nodo, actualizar cabeza, hacer que el nuevo nodo apunte a la antigua cabeza
B) Actualizar cabeza, crear nuevo nodo, hacer que el nuevo nodo apunte a la antigua cabeza
C) Crear nuevo nodo, hacer que el nuevo nodo apunte a la antigua cabeza, actualizar cabeza
D) Hacer que el nuevo nodo apunte a la antigua cabeza, actualizar cabeza, crear nuevo nodo

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** El orden correcto es crucial para no perder la referencia a los nodos existentes:
1. **Primero** crear el nuevo nodo con los datos
2. **Luego** hacer que el nuevo nodo apunte a la antigua cabeza (preservando la lista existente)
3. **Finalmente** actualizar cabeza para que apunte al nuevo nodo

Si actualizamos cabeza antes de conectar el nuevo nodo, perdemos la referencia a la lista existente.

```java
public void insertarAlPrincipio(int dato) {
    Nodo nuevoNodo = new Nodo(dato);      // 1. Crear
    nuevoNodo.siguiente = cabeza;          // 2. Conectar
    cabeza = nuevoNodo;                    // 3. Actualizar
}
```

</details>

---

## Pregunta 3
**Según la documentación del curso, ¿qué "NO SABE" hacer una lista enlazada simple por sí misma?**

A) Acceder al primer elemento de la secuencia
B) Conocer directamente cuántos elementos contiene (sin recorrerla)
C) Añadir un nuevo elemento al principio
D) Verificar si está vacía

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Una lista enlazada simple básica no mantiene un contador de elementos. Para saber cuántos elementos tiene, debe recorrer toda la lista (O(n)). Sin embargo, SÍ sabe: acceder al primer elemento (tiene la referencia cabeza), añadir al principio (O(1)), y verificar si está vacía (comprobando si cabeza == null). Algunas implementaciones añaden un atributo contador explícito, pero no es inherente a la estructura.

</details>

---

## Pregunta 4
**¿Cómo se identifica el último nodo en una lista enlazada simple?**

A) Es el nodo cuyo valor es null
B) Es el nodo cuya referencia `siguiente` es null
C) Es el nodo que apunta a la cabeza (formando un círculo)
D) Hay un atributo en la lista que lo marca como último

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** En una lista enlazada simple, el último nodo se identifica porque su referencia `siguiente` (o `next`) es `null`. Esto indica el final de la secuencia. El nodo en sí contiene datos válidos (no es null), pero no tiene siguiente nodo al cual apuntar.

```java
public void recorrerHastaElFinal() {
    Nodo actual = cabeza;
    while (actual.siguiente != null) {  // Mientras NO sea el último
        actual = actual.siguiente;
    }
    // Aquí 'actual' es el último nodo
}
```

Nota: Si el último nodo apuntara a la cabeza, sería una **lista circular**, no una lista simple estándar.

</details>

---

## Pregunta 5
**¿Cuál es la diferencia principal entre una lista enlazada simple y una lista doblemente enlazada?**

A) La simple solo permite insertar elementos, la doble permite eliminar
B) En la doble, cada nodo tiene referencias tanto al siguiente como al anterior
C) La simple almacena primitivas, la doble almacena objetos
D) La doble es más rápida en todas las operaciones

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** En una **lista doblemente enlazada**, cada nodo contiene:
- Los datos
- Referencia al nodo siguiente
- Referencia al nodo anterior

Esto permite recorrer la lista en ambas direcciones.

```java
// Lista simple
class NodoSimple {
    int dato;
    NodoSimple siguiente;  // Solo hacia adelante
}

// Lista doble
class NodoDoble {
    int dato;
    NodoDoble siguiente;  // Hacia adelante
    NodoDoble anterior;   // Hacia atrás
}
```

Las opciones incorrectas: ambas permiten insertar y eliminar, ambas pueden almacenar cualquier tipo de dato, y la "velocidad" depende de la operación específica (no siempre la doble es más rápida).

</details>

---

## Pregunta 6
**¿Cuál es la principal ventaja de una lista enlazada sobre un array?**

A) Acceso más rápido a elementos por índice
B) Menor uso de memoria total
C) Tamaño dinámico sin necesidad de redimensionar/copiar todos los elementos
D) Búsqueda más rápida de elementos específicos

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Las listas enlazadas permiten crecimiento dinámico sin necesidad de redimensionar o copiar elementos (como ocurre con arrays dinámicos cuando se llena la capacidad). Solo se crea un nuevo nodo y se ajustan referencias.

**Ventajas de arrays sobre listas:**
- A) Arrays tienen acceso directo por índice
- B) Arrays usan menos memoria (listas necesitan espacio para referencias)
- D) En arrays se puede buscar más directamente

**Ventaja de listas sobre arrays:**
- Inserción/eliminación flexible sin reorganizar elementos
- Crecimiento sin copiar toda la estructura

</details>

---

## Pregunta 7
**En el contexto de listas enlazadas, ¿qué indica que `cabeza == null`?**

A) La lista está corrupta
B) La lista está vacía
C) La lista tiene exactamente un elemento
D) Hay un error de referencia null

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Cuando `cabeza == null`, la lista está vacía (no tiene ningún nodo). Es la forma correcta y estándar de representar una lista sin elementos. No indica error ni corrupción, es un estado válido. Cuando hay un elemento, cabeza apuntaría a ese nodo (no sería null).

```java
public boolean estaVacia() {
    return cabeza == null;
}
```

</details>

---

## Pregunta 8
**¿Qué estructura(s) se pueden implementar usando listas enlazadas?**

A) Solo pilas (stacks)
B) Solo colas (queues)
C) Tanto pilas como colas
D) Ninguna, se requieren arrays

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Las listas enlazadas son ideales para implementar tanto pilas como colas:

- **Pila (Stack):** Usa el principio LIFO (Last In, First Out)
  - push: insertar al principio de la lista
  - pop: eliminar del principio de la lista

- **Cola (Queue):** Usa el principio FIFO (First In, First Out)
  - enqueue: insertar al final de la lista
  - dequeue: eliminar del principio de la lista

La documentación del curso menciona explícitamente: "Implementación de otras estructuras de datos como pilas, colas y grafos" como una aplicación de las listas enlazadas.

</details>

---

## Pregunta 9
**¿Qué sucede si intentamos eliminar el primer elemento de una lista vacía sin validación previa?**

A) La lista automáticamente se mantiene vacía sin problemas
B) Se crea un nuevo nodo vacío
C) Se produce un error de NullPointerException al intentar acceder a cabeza.siguiente
D) El método devuelve false indicando que falló

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Si intentamos eliminar el primer elemento cuando `cabeza == null` (lista vacía), y hacemos `cabeza = cabeza.siguiente` sin validación, obtendremos un **NullPointerException** porque intentamos acceder a un atributo (`siguiente`) de un objeto null.

Por eso es fundamental validar:

```java
// ❌ SIN validación - PELIGROSO
public void eliminarPrimero() {
    cabeza = cabeza.siguiente;  // Error si cabeza == null
}

// ✅ CON validación - CORRECTO
public void eliminarPrimero() {
    if (cabeza != null) {
        cabeza = cabeza.siguiente;
    }
}

// ✅ Con assertion como en el curso
public void eliminarPrimero() {
    assert !estaVacia() : "No se puede eliminar de una lista vacía";
    cabeza = cabeza.siguiente;
}
```

</details>

---

## Pregunta 10
**En una lista enlazada, cada nodo contiene:**

A) Solo los datos que almacena
B) Los datos y el tamaño total de la lista
C) Los datos y una referencia al siguiente nodo
D) Los datos y referencias a todos los demás nodos

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** En una lista enlazada simple, cada nodo contiene exactamente dos elementos: 1) los datos que almacena, y 2) una referencia (puntero) al siguiente nodo en la secuencia. No almacena el tamaño de la lista (eso lo puede tener el objeto Lista), ni referencias a todos los nodos (eso sería ineficiente y no es la naturaleza de una lista enlazada).

```java
class Nodo {
    int dato;           // 1. Los datos
    Nodo siguiente;     // 2. Referencia al siguiente nodo
}
```

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de listas enlazadas
- **7-9 respuestas correctas:** Buen entendimiento, revisar conceptos específicos
- **5-6 respuestas correctas:** Comprensión básica, se recomienda repasar
- **Menos de 5 correctas:** Es necesario revisar el tema completo

## Temas Clave Evaluados

1. ✓ Definición y características fundamentales
2. ✓ Proceso de inserción de elementos
3. ✓ Estructura interna (nodos y referencias)
4. ✓ Identificación del último nodo
5. ✓ Tipos de listas (simple vs doble)
6. ✓ Comparación con arrays
7. ✓ Estado de lista vacía y validaciones
8. ✓ Implementación de otras estructuras (pilas, colas)
9. ✓ Manejo de errores y casos especiales
10. ✓ Limitaciones y capacidades de la estructura

