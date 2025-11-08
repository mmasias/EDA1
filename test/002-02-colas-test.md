# Test: Colas (Queues)

**Tema:** Estructura de Datos - Colas FIFO
**Número de preguntas:** 10
**Tiempo estimado:** 15-20 minutos

---

## Pregunta 1
**¿Qué principio define el comportamiento de una cola?**

A) LIFO (Last In, First Out)
B) FIFO (First In, First Out)
C) LILO (Last In, Last Out)
D) Acceso aleatorio

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Una cola sigue el principio **FIFO (First In, First Out)** - "Primero en entrar, primero en salir". El primer elemento que se añade a la cola es el primero que se puede remover.

**Analogía:** Como una fila de personas en un banco:
- La primera persona que llega es la primera que es atendida
- Las nuevas personas se forman al final de la fila
- No puedes "saltarte" personas para atender a alguien que llegó después

```java
cola.enqueue(1);   // Cola: [1]
cola.enqueue(2);   // Cola: [1, 2]
cola.enqueue(3);   // Cola: [1, 2, 3]
cola.dequeue();    // Retorna 1 (el primero), Cola: [2, 3]
cola.dequeue();    // Retorna 2, Cola: [3]
```

**Contraste con pilas:** Las pilas usan LIFO (último en entrar, primero en salir).

</details>

---

## Pregunta 2
**¿Cuáles son las tres operaciones básicas de una cola?**

A) push, pop, peek
B) insert, delete, search
C) enqueue, dequeue, peek
D) add, remove, top

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Las tres operaciones fundamentales de una cola son:

1. **enqueue(elemento):** Añadir un elemento al **final** de la cola
2. **dequeue():** Remover y retornar el elemento del **frente** de la cola
3. **peek() o front():** Ver el elemento del frente SIN removerlo

```java
Cola cola = new Cola();
cola.enqueue(10);        // Añade 10 al final
cola.enqueue(20);        // Añade 20 al final
int frente = cola.peek();      // Retorna 10, NO lo remueve
int valor = cola.dequeue();    // Retorna 10 y lo remueve
```

**Nota:** push/pop/peek son operaciones de **pilas**, no de colas.

</details>

---

## Pregunta 3
**¿Por qué una cola eficiente necesita mantener DOS referencias (frente y final)?**

A) Para saber cuántos elementos tiene
B) Para permitir enqueue en el final sin recorrer toda la cola
C) Para poder hacer búsquedas más rápidas
D) Es solo una convención, no es necesario

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Mantener referencia tanto al **frente** como al **final** permite operaciones eficientes:

```java
public class Cola {
    private Nodo frente;   // Referencia al primer elemento
    private Nodo final;    // Referencia al último elemento

    // ✅ Con referencia al final - eficiente
    public void enqueue(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (estaVacia()) {
            frente = nuevoNodo;
            final = nuevoNodo;
        } else {
            final.siguiente = nuevoNodo;  // Directo, sin recorrer
            final = nuevoNodo;
        }
    }
}
```

**Sin referencia al final:**
- Habría que recorrer TODA la cola desde el frente hasta encontrar el último nodo
- Cada enqueue sería lento

**Con referencia al final:**
- enqueue es directo e inmediato
- dequeue usa la referencia al frente

</details>

---

## Pregunta 4
**¿En cuál de estas situaciones es apropiado usar una cola?**

A) Implementar la función "deshacer" en un editor
B) Gestión de tareas de impresión en orden de llegada
C) Evaluación de expresiones matemáticas
D) Navegación "atrás" en un navegador

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Las colas son ideales para **gestión de tareas en orden de llegada** porque:
- Cada documento enviado a imprimir se encola al final
- La impresora procesa documentos en el orden que llegaron (FIFO)
- Es justo: "primero en llegar, primero en ser atendido"

**Aplicaciones comunes de colas:**
- Gestión de impresión
- Atención al cliente (sistemas de turnos)
- Procesamiento de tareas en servidores
- Búsqueda en anchura (BFS) en grafos
- Buffers de comunicación

**Opciones incorrectas (necesitan pilas LIFO):**
- A) Deshacer: última acción primero
- C) Expresiones matemáticas: evaluar de adentro hacia afuera
- D) Navegación atrás: última página visitada

</details>

---

## Pregunta 5
**¿Qué indica que `frente == null` en una cola implementada con lista enlazada?**

A) La cola tiene un elemento
B) La cola está vacía
C) La cola está llena
D) Hay un error de implementación

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** En una cola implementada con lista enlazada, `frente == null` indica que **la cola está vacía** (no tiene elementos).

```java
public class Cola {
    private Nodo frente;
    private Nodo final;

    public Cola() {
        this.frente = null;  // Cola vacía
        this.final = null;
    }

    public boolean estaVacia() {
        return frente == null;  // true si vacía
    }

    public void enqueue(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (estaVacia()) {  // Primera inserción
            frente = nuevoNodo;
            final = nuevoNodo;
        } else {
            final.siguiente = nuevoNodo;
            final = nuevoNodo;
        }
    }
}
```

Es un estado válido y normal, no un error.

</details>

---

## Pregunta 6
**Al hacer `dequeue()` en una cola con un solo elemento, ¿qué debe actualizarse?**

A) Solo la referencia `frente`
B) Solo la referencia `final`
C) Ambas referencias `frente` y `final` deben ponerse en null
D) Ninguna referencia

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Cuando removemos el **último elemento** de la cola, tanto `frente` como `final` deben ponerse en `null` para indicar que la cola está vacía.

```java
public int dequeue() {
    assert !estaVacia() : "Cola vacía";

    int valor = frente.dato;
    frente = frente.siguiente;  // Avanzar frente

    // ⚠️ IMPORTANTE: Si ahora frente es null, también final debe ser null
    if (frente == null) {
        final = null;  // Cola quedó vacía
    }

    return valor;
}
```

**Ejemplo:**
```java
Cola cola = new Cola();
cola.enqueue(10);      // frente→[10]←final
cola.dequeue();        // Ahora: frente=null, final=null ✓

// ❌ Si olvidamos actualizar final:
// frente=null pero final→[nodo eliminado] (ERROR)
```

</details>

---

## Pregunta 7
**¿Cuál es la diferencia principal entre una pila y una cola?**

A) La pila es más rápida que la cola
B) La pila usa LIFO, la cola usa FIFO
C) La pila permite más operaciones
D) No hay diferencia, son equivalentes

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia fundamental está en el **orden de procesamiento**:

**Pila (Stack) - LIFO:**
- **L**ast **I**n, **F**irst **O**ut
- El último que entra es el primero que sale
- Inserción y extracción desde el mismo extremo (tope)

**Cola (Queue) - FIFO:**
- **F**irst **I**n, **F**irst **O**ut
- El primero que entra es el primero que sale
- Inserción en un extremo (final), extracción en el otro (frente)

```java
// Pila - LIFO
pila.push(1); pila.push(2); pila.push(3);
pila.pop();  // Retorna 3 (último insertado)

// Cola - FIFO
cola.enqueue(1); cola.enqueue(2); cola.enqueue(3);
cola.dequeue();  // Retorna 1 (primero insertado)
```

**Aplicaciones diferentes:**
- Pila: deshacer, recursión, expresiones
- Cola: turnos, tareas, procesamiento en orden

</details>

---

## Pregunta 8
**¿Cuál es la diferencia entre `dequeue()` y `peek()` en una cola?**

A) dequeue() es más rápido que peek()
B) dequeue() remueve el elemento, peek() solo lo consulta
C) peek() solo funciona con colas vacías
D) No hay diferencia práctica

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia es la misma que en pilas:

- **dequeue():** Retorna el elemento del frente **Y lo remueve** (destructivo)
- **peek():** Retorna el elemento del frente **SIN removerlo** (consulta)

```java
Cola cola = new Cola();
cola.enqueue(10);
cola.enqueue(20);
cola.enqueue(30);
// Cola: [10, 20, 30] (frente→10, final→30)

// peek() - solo consulta
int valor1 = cola.peek();  // Retorna 10, cola: [10, 20, 30]
int valor2 = cola.peek();  // Retorna 10, cola: [10, 20, 30]

// dequeue() - remueve
int valor3 = cola.dequeue();  // Retorna 10, cola: [20, 30]
int valor4 = cola.dequeue();  // Retorna 20, cola: [30]
```

**peek()** es útil para verificar qué viene a continuación sin modificar la cola.

</details>

---

## Pregunta 9
**Según la documentación del curso, ¿qué "NO SABEN" hacer las colas por sí mismas?**

A) Saber cuál es el elemento al frente
B) Saber cuántos elementos contienen sin mantener un contador
C) Saber si están vacías
D) Añadir elementos al final

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Una cola básica **no sabe cuántos elementos contiene** sin:
- Recorrer todos los elementos (sin removerlos pero ineficiente), o
- Mantener un contador explícito que se actualice en cada operación

**Lo que SÍ sabe una cola:**
- ✓ Cuál es el elemento al frente (peek)
- ✓ Cuál es el siguiente elemento a procesar
- ✓ Si está vacía (frente == null)

**Lo que NO sabe:**
- ✗ Cuántos elementos tiene (sin contador)
- ✗ Qué elementos están en medio (sin desencolarlos)
- ✗ La posición de un elemento específico

```java
// Para saber el tamaño sin contador
public int tamaño() {
    int count = 0;
    Nodo actual = frente;
    while (actual != null) {  // Recorrer toda la cola
        count++;
        actual = actual.siguiente;
    }
    return count;  // Ineficiente
}
```

**Solución común:** Agregar un atributo `int size` que se actualice en enqueue/dequeue.

</details>

---

## Pregunta 10
**¿Qué retorna el siguiente código?**

```java
Cola cola = new Cola();
cola.enqueue(5);
cola.enqueue(10);
cola.enqueue(15);
cola.dequeue();
cola.enqueue(20);
System.out.println(cola.peek());
```

A) 5
B) 10
C) 15
D) 20

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Sigamos la ejecución paso a paso:

```java
Cola cola = new Cola();          // Cola: []
cola.enqueue(5);                 // Cola: [5]
cola.enqueue(10);                // Cola: [5, 10]
cola.enqueue(15);                // Cola: [5, 10, 15]
cola.dequeue();                  // Remueve 5, Cola: [10, 15]
cola.enqueue(20);                // Cola: [10, 15, 20]
System.out.println(cola.peek()); // Consulta frente → 10
```

**Visualización:**

```
Después de enqueue(5):     frente→[5]←final
Después de enqueue(10):    frente→[5]→[10]←final
Después de enqueue(15):    frente→[5]→[10]→[15]←final
Después de dequeue():      frente→[10]→[15]←final (removió 5)
Después de enqueue(20):    frente→[10]→[15]→[20]←final
peek() retorna:            10 (primer elemento, sin remover)
```

**Recordar FIFO:** El primero en entrar (ahora 10) es el que está al frente.

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de colas
- **7-9 respuestas correctas:** Buen entendimiento, revisar conceptos específicos
- **5-6 respuestas correctas:** Comprensión básica, se recomienda repasar
- **Menos de 5 correctas:** Es necesario revisar el tema completo

## Temas Clave Evaluados

1. ✓ Principio FIFO
2. ✓ Operaciones básicas (enqueue, dequeue, peek)
3. ✓ Dos referencias (frente y final)
4. ✓ Aplicaciones prácticas
5. ✓ Estado de cola vacía
6. ✓ Actualización de referencias al desencolar
7. ✓ Diferencia entre pila y cola
8. ✓ Diferencia entre dequeue y peek
9. ✓ Limitaciones de la estructura
10. ✓ Seguimiento de operaciones FIFO
