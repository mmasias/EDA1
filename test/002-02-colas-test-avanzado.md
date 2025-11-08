# Test Avanzado: Colas - Implementación

**Tema:** Colas (Queues) - Aspectos Técnicos
**Número de preguntas:** 10
**Tiempo estimado:** 20 minutos

---

## Pregunta 1
**¿Qué indica que `frente == null` en una cola implementada con lista enlazada?**

A) La cola tiene un elemento
B) La cola está vacía
C) La cola está llena
D) Hay un error de implementación

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** `frente == null` indica que **la cola está vacía** (no tiene elementos).

```java
public class Cola {
    private Nodo frente;
    private Nodo finalCola;

    public Cola() {
        this.frente = null;      // Cola vacía
        this.finalCola = null;
    }

    public boolean estaVacia() {
        return frente == null;   // true si vacía
    }
}
```

Es un estado válido y esperado, no un error.

</details>

---

## Pregunta 2
**Al hacer `enqueue()` en una cola vacía, ¿qué debe suceder con las referencias `frente` y `final`?**

A) Solo actualizar frente
B) Solo actualizar final
C) Ambas deben apuntar al nuevo nodo
D) Ninguna se actualiza

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Cuando la cola está vacía y añadimos el primer elemento, **ambas referencias** deben apuntar a él.

```java
public void enqueue(int valor) {
    Nodo nuevoNodo = new Nodo(valor);

    if (estaVacia()) {
        // ✓ Primera inserción - ambas al mismo nodo
        frente = nuevoNodo;
        finalCola = nuevoNodo;
    } else {
        // Inserción normal - solo mover final
        finalCola.siguiente = nuevoNodo;
        finalCola = nuevoNodo;
    }
}
```

**Ejemplo:**
```
Cola vacía:
frente = null, final = null

enqueue(10):
frente → [10] ← final
         (mismo nodo)
```

</details>

---

## Pregunta 3
**Después de ejecutar este código, ¿qué contiene la cola?**

```java
Cola cola = new Cola();
cola.enqueue(1);
cola.enqueue(2);
cola.enqueue(3);
cola.dequeue();
cola.enqueue(4);
```

A) [2, 3, 4] (2 al frente, 4 al final)
B) [4, 3, 2]
C) [1, 2, 3, 4]
D) [4, 2]

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** Seguimos las operaciones FIFO paso a paso:

```java
enqueue(1):  frente → [1] ← final
enqueue(2):  frente → [1] → [2] ← final
enqueue(3):  frente → [1] → [2] → [3] ← final
dequeue():   frente → [2] → [3] ← final  (removió 1)
enqueue(4):  frente → [2] → [3] → [4] ← final

Estado final: [2, 3, 4]
- Frente: 2
- Final: 4
```

</details>

---

## Pregunta 4
**¿Qué sucede al ejecutar `dequeue()` cuando la cola tiene UN solo elemento?**

```java
public int dequeue() {
    int valor = frente.dato;
    frente = frente.siguiente;
    return valor;
}
```

A) Error porque no actualiza final
B) La cola queda vacía correctamente
C) Se duplica el elemento
D) frente queda apuntando a un nodo inválido

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** Este código tiene un **bug**: no actualiza `final` cuando se remueve el último elemento.

```java
Estado inicial: frente → [único] ← final
                         (siguiente = null)

Después de frente = frente.siguiente:
frente = null  ✓
final → [nodo eliminado]  ❌ (referencia inválida)

// ❌ Incorrecto - no actualiza final
public int dequeue() {
    int valor = frente.dato;
    frente = frente.siguiente;
    return valor;  // Bug: final apunta a nodo eliminado
}

// ✅ Correcto - actualiza ambas referencias
public int dequeue() {
    assert !estaVacia() : "Cola vacía";
    int valor = frente.dato;
    frente = frente.siguiente;

    if (frente == null) {  // Cola quedó vacía
        finalCola = null;   // Actualizar final también
    }

    return valor;
}
```

</details>

---

## Pregunta 5
**¿Por qué una cola necesita DOS referencias (frente y final)?**

A) Para saber el tamaño
B) Para que enqueue sea eficiente sin recorrer toda la cola
C) Por convención, no es necesario
D) Para detectar errores

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La referencia al `final` permite hacer `enqueue` sin recorrer toda la cola.

**Sin referencia al final:**
```java
// ❌ Ineficiente - hay que recorrer toda la cola
public void enqueue(int valor) {
    Nodo nuevoNodo = new Nodo(valor);
    if (frente == null) {
        frente = nuevoNodo;
    } else {
        Nodo actual = frente;
        while (actual.siguiente != null) {  // Recorrer todo
            actual = actual.siguiente;
        }
        actual.siguiente = nuevoNodo;
    }
}
```

**Con referencia al final:**
```java
// ✅ Eficiente - directo al final
public void enqueue(int valor) {
    Nodo nuevoNodo = new Nodo(valor);
    if (estaVacia()) {
        frente = nuevoNodo;
        finalCola = nuevoNodo;
    } else {
        finalCola.siguiente = nuevoNodo;  // Directo
        finalCola = nuevoNodo;
    }
}
```

</details>

---

## Pregunta 6
**¿Qué imprime este código?**

```java
Cola cola = new Cola();
cola.enqueue(5);
cola.enqueue(10);
System.out.println(cola.peek());
cola.dequeue();
System.out.println(cola.peek());
```

A) 10, 5
B) 5, 10
C) 5, 5
D) 10, 10

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Seguimos el flujo FIFO paso a paso:

```java
enqueue(5):   frente → [5] ← final
enqueue(10):  frente → [5] → [10] ← final

peek():       Retorna 5 (frente, NO remueve)
              Imprime: 5
              Cola: [5] → [10]

dequeue():    Retorna 5 y remueve
              Cola: frente → [10] ← final

peek():       Retorna 10 (nuevo frente)
              Imprime: 10

Salida: 5, 10
```

**Recordar FIFO:** El primero en entrar (5) es el primero en salir.

</details>

---

## Pregunta 7
**¿Cuál es la condición correcta para verificar si una cola está vacía?**

A) `frente == null`
B) `final == null`
C) `frente == final`
D) Cualquiera de A o B es suficiente

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: D**

**Explicación:** Si la implementación es correcta, cuando la cola está vacía **ambas referencias son null**.

```java
// Ambas condiciones son equivalentes si la implementación es correcta
public boolean estaVacia() {
    return frente == null;  // Más común
}

// También válido
public boolean estaVacia() {
    return finalCola == null;
}

// Más robusto (verifica consistencia)
public boolean estaVacia() {
    assert (frente == null) == (finalCola == null)
           : "Estado inconsistente";
    return frente == null;
}
```

**Estados válidos:**
```
Cola vacía:     frente = null, final = null ✓
Cola con 1:     frente → [X] ← final ✓
Cola con 2+:    frente → [X]...[Y] ← final ✓

Estado inválido:
                frente = null, final → [X] ❌
```

</details>

---

## Pregunta 8
**Después de este código, ¿cuáles son los valores de frente y final?**

```java
Cola cola = new Cola();
cola.enqueue(1);
cola.enqueue(2);
cola.dequeue();
cola.dequeue();
// ¿Qué valores tienen frente y final?
```

A) frente = null, final = null
B) frente = 1, final = 2
C) frente = null, final → nodo 2
D) Error de ejecución

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** Después de remover todos los elementos, la cola queda vacía.

```java
enqueue(1):   frente → [1] ← final
enqueue(2):   frente → [1] → [2] ← final

dequeue():    frente → [2] ← final (removió 1)

dequeue():    Cola vacía
              frente = null
              final = null
```

**Esto requiere código correcto:**
```java
public int dequeue() {
    assert !estaVacia();
    int valor = frente.dato;
    frente = frente.siguiente;

    if (frente == null) {  // ¡Importante!
        finalCola = null;   // Actualizar final
    }

    return valor;
}
```

</details>

---

## Pregunta 9
**¿Qué problema tiene este código de enqueue?**

```java
public void enqueue(int valor) {
    Nodo nuevoNodo = new Nodo(valor);
    finalCola.siguiente = nuevoNodo;
    finalCola = nuevoNodo;
}
```

A) No hay problema
B) Falla cuando la cola está vacía (final == null)
C) No actualiza el frente
D) El orden de operaciones es incorrecto

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** El código **no maneja el caso especial** de cola vacía.

```java
// ❌ Incorrecto - no maneja cola vacía
public void enqueue(int valor) {
    Nodo nuevoNodo = new Nodo(valor);
    finalCola.siguiente = nuevoNodo;  // Error si finalCola == null
    finalCola = nuevoNodo;
}

// ✅ Correcto - maneja ambos casos
public void enqueue(int valor) {
    Nodo nuevoNodo = new Nodo(valor);

    if (estaVacia()) {
        // Caso especial: primera inserción
        frente = nuevoNodo;
        finalCola = nuevoNodo;
    } else {
        // Caso normal
        finalCola.siguiente = nuevoNodo;
        finalCola = nuevoNodo;
    }
}
```

**Problema:**
```
Cola vacía: frente = null, final = null
enqueue(5): finalCola.siguiente → NullPointerException ❌
```

</details>

---

## Pregunta 10
**¿En qué se diferencia el punto de inserción entre una pila y una cola?**

A) Pila inserta al principio, cola inserta al final
B) Pila inserta al final, cola inserta al principio
C) Ambas insertan en el mismo lugar
D) Depende de la implementación

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** La diferencia fundamental en la inserción:

**Pila (LIFO):**
```java
public void push(int valor) {
    Nodo nuevoNodo = new Nodo(valor);
    nuevoNodo.siguiente = tope;
    tope = nuevoNodo;  // Inserta al PRINCIPIO
}

Antes: tope → [10] → [5] → null
push(20):
Después: tope → [20] → [10] → [5] → null
```

**Cola (FIFO):**
```java
public void enqueue(int valor) {
    Nodo nuevoNodo = new Nodo(valor);
    if (!estaVacia()) {
        finalCola.siguiente = nuevoNodo;
        finalCola = nuevoNodo;  // Inserta al FINAL
    }
}

Antes: frente → [5] → [10] ← final
enqueue(20):
Después: frente → [5] → [10] → [20] ← final
```

**Resumen:**
- **Pila:** Inserción y extracción por el MISMO extremo (tope)
- **Cola:** Inserción por un extremo (final), extracción por el otro (frente)

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de implementación de colas
- **7-9 respuestas correctas:** Buen entendimiento técnico
- **5-6 respuestas correctas:** Comprensión básica, repasar implementación
- **Menos de 5 correctas:** Revisar código y practicar

## Temas Técnicos Evaluados

1. ✓ Estado vacío (`frente == null`)
2. ✓ Primera inserción (actualizar ambas referencias)
3. ✓ Seguimiento de operaciones enqueue/dequeue
4. ✓ Bug común: no actualizar `final` al vaciar
5. ✓ Necesidad de dos referencias
6. ✓ Secuencia FIFO con peek/dequeue
7. ✓ Condiciones para verificar cola vacía
8. ✓ Estado después de vaciar completamente
9. ✓ Error en enqueue sin validar cola vacía
10. ✓ Diferencia de inserción: pila vs cola
