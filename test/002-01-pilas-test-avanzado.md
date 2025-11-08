# Test Avanzado: Pilas - Implementación

**Tema:** Pilas (Stacks) - Aspectos Técnicos
**Número de preguntas:** 10
**Tiempo estimado:** 20 minutos

---

## Pregunta 1
**¿Qué indica que `tope == null` en una pila implementada con lista enlazada?**

A) La pila tiene un elemento
B) La pila está vacía
C) La pila está llena
D) Hay un error de implementación

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** `tope == null` indica que **la pila está vacía** (no tiene elementos).

```java
public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;  // Pila vacía
    }

    public boolean estaVacia() {
        return tope == null;  // true si vacía
    }
}
```

Es un estado válido y esperado, no un error.

</details>

---

## Pregunta 2
**En una pila implementada con array, ¿qué indica que `tope == -1`?**

A) La pila tiene un elemento
B) La pila está vacía
C) La pila está llena
D) Error de índice

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Por convención, `tope = -1` indica que **la pila está vacía** en implementaciones con array.

```java
public class Pila {
    private int maxTamaño;
    private int[] arregloPila;
    private int tope;

    public Pila(int tamaño) {
        maxTamaño = tamaño;
        arregloPila = new int[maxTamaño];
        tope = -1;  // Pila vacía
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public void push(int valor) {
        arregloPila[++tope] = valor;  // Primero incrementa, luego asigna
    }
}
```

**Razón:** Los índices de array empiezan en 0, así que -1 indica "ningún elemento".

</details>

---

## Pregunta 3
**Después de ejecutar este código, ¿qué contiene la pila?**

```java
Pila pila = new Pila();
pila.push(1);
pila.push(2);
pila.push(3);
pila.pop();
pila.push(4);
```

A) [1, 2, 4] (4 en el tope)
B) [1, 2, 3, 4]
C) [4, 2, 1]
D) [1, 4]

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** Seguimos las operaciones LIFO paso a paso:

```java
push(1):  [1] ← tope
push(2):  [1, 2] ← tope
push(3):  [1, 2, 3] ← tope
pop():    [1, 2] ← tope (removió 3)
push(4):  [1, 2, 4] ← tope

Estado final: [1, 2, 4] con 4 en el tope
```

</details>

---

## Pregunta 4
**¿Qué sucede al ejecutar `pop()` en este código?**

```java
public int pop() {
    int valor = tope.dato;
    tope = tope.siguiente;
    return valor;
}
// Llamada: pila.pop() cuando tope == null
```

A) Retorna 0
B) Retorna null
C) NullPointerException
D) La pila se reinicia

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Intentar acceder a `tope.dato` cuando `tope == null` causa **NullPointerException**.

```java
// ❌ Sin validación
public int pop() {
    int valor = tope.dato;  // Error si tope == null
    tope = tope.siguiente;
    return valor;
}

// ✅ Con validación
public int pop() {
    if (estaVacia()) {
        throw new IllegalStateException("Pila vacía");
    }
    int valor = tope.dato;
    tope = tope.siguiente;
    return valor;
}

// ✅ Con assertion
public int pop() {
    assert !estaVacia() : "No se puede desapilar de una pila vacía";
    int valor = tope.dato;
    tope = tope.siguiente;
    return valor;
}
```

</details>

---

## Pregunta 5
**En una pila con array de tamaño 5, ¿cuándo está llena?**

A) Cuando tope == 5
B) Cuando tope == 4
C) Cuando tope == maxTamaño
D) Cuando tope == 0

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La pila está llena cuando `tope == maxTamaño - 1` (en este caso, 4).

```java
public class Pila {
    private int maxTamaño = 5;
    private int[] arregloPila = new int[5];
    private int tope = -1;

    public boolean estaLlena() {
        return tope == maxTamaño - 1;  // tope == 4
    }
}

// Índices válidos: 0, 1, 2, 3, 4
// Si tope = 4, todos los espacios están ocupados
```

**Ejemplo:**
```
Índice:  0   1   2   3   4
Valor: [10][20][30][40][50]
                         ↑
                       tope = 4 (llena)
```

</details>

---

## Pregunta 6
**¿Cuál es la diferencia entre estos dos métodos?**

```java
// Método A
public int peek() {
    return tope.dato;
}

// Método B
public int pop() {
    int valor = tope.dato;
    tope = tope.siguiente;
    return valor;
}
```

A) No hay diferencia
B) peek() solo consulta, pop() remueve el elemento
C) peek() es más rápido
D) pop() retorna null

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** `peek()` **solo consulta** sin modificar, `pop()` **consulta Y remueve**.

```java
Pila inicial: [10, 20, 30] (30 en tope)

// peek() - NO modifica
int valor1 = pila.peek();  // Retorna 30
int valor2 = pila.peek();  // Retorna 30
// Pila: [10, 20, 30] (sin cambios)

// pop() - SÍ modifica
int valor3 = pila.pop();   // Retorna 30
int valor4 = pila.pop();   // Retorna 20
// Pila: [10] (removió 30 y 20)
```

**peek():** Operación de consulta no destructiva
**pop():** Operación de extracción destructiva

</details>

---

## Pregunta 7
**¿Qué imprime este código?**

```java
Pila pila = new Pila();
pila.push(5);
pila.push(10);
System.out.println(pila.peek());
pila.pop();
System.out.println(pila.peek());
```

A) 5, 5
B) 10, 5
C) 10, 10
D) 5, 10

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Seguimos el flujo paso a paso:

```java
push(5):    [5] ← tope
push(10):   [5, 10] ← tope

peek():     Retorna 10 (NO remueve)
            Imprime: 10
            Pila: [5, 10] ← tope

pop():      Retorna 10 y remueve
            Pila: [5] ← tope

peek():     Retorna 5
            Imprime: 5

Salida: 10, 5
```

</details>

---

## Pregunta 8
**En este código de push con array, ¿cuál es el orden correcto de operaciones?**

```java
public void push(int valor) {
    // ¿Qué va primero?
    // Opción 1: arregloPila[++tope] = valor;
    // Opción 2: arregloPila[tope++] = valor;
}
```

A) Opción 1 (++tope) - incrementa antes de usar
B) Opción 2 (tope++) - usa antes de incrementar
C) Ambas son equivalentes
D) Ninguna es correcta

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** Debe usar **pre-incremento** `++tope` para incrementar ANTES de asignar.

```java
// ✅ Correcto - pre-incremento
public void push(int valor) {
    arregloPila[++tope] = valor;
    // Primero: tope = tope + 1
    // Luego: arregloPila[tope] = valor
}

// ❌ Incorrecto - post-incremento
public void push(int valor) {
    arregloPila[tope++] = valor;
    // Primero: arregloPila[tope] = valor
    // Luego: tope = tope + 1
}
```

**Ejemplo con tope inicial = -1:**

**Pre-incremento (correcto):**
```
tope = -1
push(10): ++tope → tope=0, arregloPila[0] = 10 ✓
push(20): ++tope → tope=1, arregloPila[1] = 20 ✓
```

**Post-incremento (incorrecto):**
```
tope = -1
push(10): arregloPila[-1] = 10 ❌ (índice inválido!)
```

</details>

---

## Pregunta 9
**¿Qué retorna `peek()` después de este código?**

```java
Pila pila = new Pila();
pila.push(1);
pila.push(2);
pila.pop();
pila.pop();
int resultado = pila.peek();
```

A) 1
B) 2
C) 0
D) Error/Excepción

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: D**

**Explicación:** La pila queda vacía, y `peek()` en pila vacía causa error.

```java
push(1):  [1] ← tope
push(2):  [1, 2] ← tope
pop():    [1] ← tope (removió 2)
pop():    [] (pila vacía, tope = null)

peek():   Intenta acceder a tope.dato cuando tope == null
          → NullPointerException ❌
```

**Código correcto:**
```java
if (!pila.estaVacia()) {
    int resultado = pila.peek();
}
```

</details>

---

## Pregunta 10
**En una pila implementada con lista enlazada, ¿dónde se inserta el nuevo nodo al hacer push()?**

A) Al final de la lista
B) Al principio de la lista (nuevo tope)
C) En el medio de la lista
D) En una posición aleatoria

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** En una pila con lista enlazada, el nuevo elemento se inserta **al principio** (como nuevo tope).

```java
public void push(int valor) {
    Nodo nuevoNodo = new Nodo(valor);
    nuevoNodo.siguiente = tope;  // Apunta al antiguo tope
    tope = nuevoNodo;            // Se convierte en el nuevo tope
}
```

**Ejemplo visual:**

```
Estado inicial:
tope → [10] → [5] → null

push(20):
Paso 1: nuevoNodo = [20|?]
Paso 2: nuevoNodo.siguiente = tope
        nuevoNodo = [20|●] → [10] → [5] → null
Paso 3: tope = nuevoNodo
        tope → [20] → [10] → [5] → null
```

**Razón:** Insertar al principio de una lista es O(1), mientras que al final requeriría recorrer toda la lista.

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de implementación de pilas
- **7-9 respuestas correctas:** Buen entendimiento técnico
- **5-6 respuestas correctas:** Comprensión básica, repasar implementación
- **Menos de 5 correctas:** Revisar código y practicar

## Temas Técnicos Evaluados

1. ✓ Estado vacío con lista enlazada (`tope == null`)
2. ✓ Estado vacío con array (`tope == -1`)
3. ✓ Seguimiento de operaciones push/pop
4. ✓ Manejo de NullPointerException en pop
5. ✓ Estado lleno en array (`tope == maxTamaño - 1`)
6. ✓ Diferencia peek vs pop
7. ✓ Secuencia de operaciones peek/pop
8. ✓ Pre-incremento vs post-incremento
9. ✓ Error al peek en pila vacía
10. ✓ Posición de inserción en lista enlazada
