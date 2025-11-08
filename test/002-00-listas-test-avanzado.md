# Test Avanzado: Listas Enlazadas - Implementación

**Tema:** Listas Enlazadas - Aspectos Técnicos
**Número de preguntas:** 10
**Tiempo estimado:** 20 minutos

---

## Pregunta 1
**¿Qué indica que `cabeza == null` en una lista enlazada simple?**

A) La lista tiene un elemento
B) La lista está vacía
C) La lista está corrupta
D) Hay un error de implementación

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** `cabeza == null` indica que **la lista está vacía** (no tiene ningún nodo).

```java
public class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;  // Lista vacía
    }

    public boolean estaVacia() {
        return cabeza == null;  // true si vacía
    }
}
```

Es un estado válido y esperado, no un error.

</details>

---

## Pregunta 2
**En el siguiente código, ¿qué valor tiene `cabeza` después de ejecutar?**

```java
Nodo cabeza = null;
Nodo nuevo = new Nodo(5);
nuevo.siguiente = cabeza;
cabeza = nuevo;
```

A) null
B) Una referencia al nodo con valor 5
C) Un nodo sin siguiente
D) Error de compilación

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Después de ejecutar el código, `cabeza` apunta a un nodo con valor 5 cuyo siguiente es null.

```java
Paso 1: cabeza = null
Paso 2: nuevo = [5|siguiente=?]
Paso 3: nuevo.siguiente = cabeza  → nuevo = [5|siguiente=null]
Paso 4: cabeza = nuevo  → cabeza apunta a [5|siguiente=null]
```

**Resultado:** cabeza → [5] → null

</details>

---

## Pregunta 3
**¿Qué sucede si ejecutamos este código cuando la lista está vacía?**

```java
public void eliminarPrimero() {
    cabeza = cabeza.siguiente;
}
```

A) La lista se mantiene vacía
B) Se crea un nuevo nodo
C) NullPointerException
D) Retorna false

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Si `cabeza == null` (lista vacía), intentar acceder a `cabeza.siguiente` produce **NullPointerException**.

```java
// ❌ Sin validación
public void eliminarPrimero() {
    cabeza = cabeza.siguiente;  // Error si cabeza == null
}

// ✅ Con validación
public void eliminarPrimero() {
    if (cabeza != null) {
        cabeza = cabeza.siguiente;
    }
}

// ✅ Con assertion
public void eliminarPrimero() {
    assert cabeza != null : "Lista vacía";
    cabeza = cabeza.siguiente;
}
```

</details>

---

## Pregunta 4
**Después de ejecutar este código, ¿cuál es el estado de la lista?**

```java
Lista lista = new Lista();
lista.insertarAlPrincipio(3);
lista.insertarAlPrincipio(2);
lista.insertarAlPrincipio(1);
```

A) [1] → [2] → [3] → null
B) [3] → [2] → [1] → null
C) [1, 2, 3]
D) Solo tiene el nodo [1]

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** `insertarAlPrincipio` añade cada elemento al **inicio**, invirtiendo el orden de inserción.

```java
Paso 1: insertarAlPrincipio(3)
        cabeza → [3] → null

Paso 2: insertarAlPrincipio(2)
        cabeza → [2] → [3] → null

Paso 3: insertarAlPrincipio(1)
        cabeza → [1] → [2] → [3] → null
```

**Resultado final:** [1] → [2] → [3] → null

</details>

---

## Pregunta 5
**¿Qué retorna este método cuando la lista tiene 3 nodos?**

```java
public int size() {
    int count = 0;
    Nodo iterator = cabeza;
    while (iterator != null) {
        count++;
        iterator = iterator.getNext();
    }
    return count;
}
```

A) 0
B) 2
C) 3
D) Infinito (bucle infinito)

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** El método recorre todos los nodos contándolos correctamente.

```java
Lista: cabeza → [A] → [B] → [C] → null

Iteración 1: iterator = [A], count = 1
Iteración 2: iterator = [B], count = 2
Iteración 3: iterator = [C], count = 3
Iteración 4: iterator = null, sale del bucle

Retorna: 3
```

</details>

---

## Pregunta 6
**¿Cuál es el problema en este código de inserción al principio?**

```java
public void insertarAlPrincipio(int dato) {
    Nodo nuevoNodo = new Nodo(dato);
    cabeza = nuevoNodo;
    nuevoNodo.siguiente = cabeza;
}
```

A) No hay problema
B) Pierde la referencia a la lista existente
C) Crea un bucle infinito
D) No actualiza cabeza

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** El orden de operaciones está **incorrecto**. Actualiza `cabeza` ANTES de conectar el nuevo nodo, perdiendo la lista existente.

```java
// ❌ Incorrecto
public void insertarAlPrincipio(int dato) {
    Nodo nuevoNodo = new Nodo(dato);
    cabeza = nuevoNodo;              // ¡Pierde la lista antigua!
    nuevoNodo.siguiente = cabeza;    // Apunta a sí mismo
}

// ✅ Correcto
public void insertarAlPrincipio(int dato) {
    Nodo nuevoNodo = new Nodo(dato);
    nuevoNodo.siguiente = cabeza;    // Primero conecta
    cabeza = nuevoNodo;              // Luego actualiza
}
```

**Problema:** Si la lista era [A]→[B]→null, el resultado incorrecto es [nuevo]→[nuevo] (bucle) y se pierden A y B.

</details>

---

## Pregunta 7
**¿Qué condición verifica si un nodo es el último en una lista enlazada simple?**

A) `nodo == null`
B) `nodo.siguiente == null`
C) `nodo.dato == null`
D) `nodo.cabeza == null`

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Un nodo es el último cuando su referencia `siguiente` es null.

```java
public boolean esUltimo(Nodo nodo) {
    return nodo != null && nodo.siguiente == null;
}

// Ejemplo de uso
public void imprimirLista() {
    Nodo actual = cabeza;
    while (actual != null) {
        System.out.print(actual.dato);
        if (actual.siguiente == null) {  // Es el último
            System.out.println(" → null");
        } else {
            System.out.print(" → ");
        }
        actual = actual.siguiente;
    }
}
```

**Lista:** [A]→[B]→[C]→null
- A.siguiente = B (no es último)
- B.siguiente = C (no es último)
- C.siguiente = null (SÍ es último)

</details>

---

## Pregunta 8
**En una lista con UN solo nodo, ¿qué sucede al llamar `eliminarPrimero()`?**

```java
public void eliminarPrimero() {
    if (cabeza != null) {
        cabeza = cabeza.siguiente;
    }
}
```

A) Error de ejecución
B) La lista queda vacía (cabeza = null)
C) El nodo se duplica
D) No hace nada

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Al eliminar el único nodo, la lista queda vacía.

```java
Estado inicial:
cabeza → [único nodo] → null
         (siguiente = null)

Después de cabeza = cabeza.siguiente:
cabeza = null

Resultado: Lista vacía ✓
```

Es el comportamiento correcto y esperado.

</details>

---

## Pregunta 9
**¿Qué estructura se forma si accidentalmente hacemos `nodo.siguiente = nodo`?**

A) Lista vacía
B) Lista con un nodo
C) Bucle infinito (ciclo)
D) Lista doblemente enlazada

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Hacer que un nodo apunte a sí mismo crea un **ciclo infinito**.

```java
Nodo nodo = new Nodo(5);
nodo.siguiente = nodo;  // ¡Error! Apunta a sí mismo

Resultado:
   ↓──────┐
[5|●]     |
   └──────┘

// Cualquier recorrido será infinito
Nodo actual = nodo;
while (actual != null) {  // ¡Nunca será null!
    actual = actual.siguiente;  // Siempre vuelve a sí mismo
}
```

**Problema:** Métodos como `size()`, `imprimir()` entrarán en bucle infinito.

</details>

---

## Pregunta 10
**Dada esta implementación de búsqueda, ¿qué retorna si el elemento NO está en la lista?**

```java
public Nodo buscar(int valor) {
    Nodo actual = cabeza;
    while (actual != null) {
        if (actual.dato == valor) {
            return actual;
        }
        actual = actual.siguiente;
    }
    return null;
}
```

A) Lanza excepción
B) Retorna el primer nodo
C) Retorna null
D) Retorna -1

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Si el elemento no se encuentra, el bucle termina y retorna **null**.

```java
Lista: [1] → [2] → [3] → null
Buscar: 5

Iteración 1: actual = [1], 1 ≠ 5, continúa
Iteración 2: actual = [2], 2 ≠ 5, continúa
Iteración 3: actual = [3], 3 ≠ 5, continúa
Iteración 4: actual = null, sale del bucle

Retorna: null ✓
```

**Uso:**
```java
Nodo resultado = lista.buscar(5);
if (resultado == null) {
    System.out.println("No encontrado");
} else {
    System.out.println("Encontrado: " + resultado.dato);
}
```

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de implementación
- **7-9 respuestas correctas:** Buen entendimiento técnico
- **5-6 respuestas correctas:** Comprensión básica, repasar implementación
- **Menos de 5 correctas:** Revisar código y practicar

## Temas Técnicos Evaluados

1. ✓ Estado de lista vacía (`cabeza == null`)
2. ✓ Proceso de inserción paso a paso
3. ✓ Manejo de NullPointerException
4. ✓ Seguimiento de operaciones múltiples
5. ✓ Método size() - recorrido completo
6. ✓ Errores comunes en inserción
7. ✓ Identificación del último nodo
8. ✓ Eliminación del único elemento
9. ✓ Detección de ciclos/bucles
10. ✓ Método de búsqueda y valor de retorno
