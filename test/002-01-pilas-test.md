# Test: Pilas (Stacks)

**Tema:** Estructura de Datos - Pilas LIFO
**Número de preguntas:** 10
**Tiempo estimado:** 15-20 minutos

---

## Pregunta 1
**¿Qué principio define el comportamiento de una pila?**

A) FIFO (First In, First Out)
B) LIFO (Last In, First Out)
C) LILO (Last In, Last Out)
D) Acceso aleatorio a cualquier elemento

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Una pila sigue el principio **LIFO (Last In, First Out)** - "Último en entrar, primero en salir". El último elemento que se añade a la pila es el primero que se puede remover.

**Analogía:** Como una pila de platos:
- Cuando lavas platos, los apilas uno sobre otro
- Cuando necesitas un plato, tomas el de arriba (el último que pusiste)
- No puedes tomar el plato del fondo sin sacar todos los de encima primero

```java
pila.push(1);  // Pila: [1]
pila.push(2);  // Pila: [1, 2]
pila.push(3);  // Pila: [1, 2, 3]
pila.pop();    // Retorna 3, Pila: [1, 2]
pila.pop();    // Retorna 2, Pila: [1]
```

</details>

---

## Pregunta 2
**¿Cuáles son las tres operaciones básicas de una pila?**

A) insert, delete, search
B) add, remove, get
C) push, pop, peek
D) enqueue, dequeue, front

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Las tres operaciones fundamentales de una pila son:

1. **push(elemento):** Añadir un elemento al tope de la pila
2. **pop():** Remover y retornar el elemento del tope
3. **peek() o top():** Ver el elemento del tope SIN removerlo

```java
Pila pila = new Pila();
pila.push(10);      // Añade 10 al tope
pila.push(20);      // Añade 20 al tope
int tope = pila.peek();   // Retorna 20, NO lo remueve
int valor = pila.pop();   // Retorna 20 y lo remueve
```

**Nota:** enqueue/dequeue/front son operaciones de **colas**, no de pilas.

</details>

---

## Pregunta 3
**Según la documentación del curso, ¿qué "NO SABEN" hacer las pilas por sí mismas?**

A) Saber cuál es el elemento en el tope
B) Saber cuántos elementos contienen sin realizar operaciones destructivas
C) Saber si están vacías
D) Añadir elementos al tope

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Una pila básica **no sabe cuántos elementos contiene** sin tener que desapilar todos los elementos (operación destructiva). Para conocer el tamaño, necesitaría:
- Desapilar todos los elementos contándolos (destruye la pila), o
- Mantener un contador explícito (mejora de implementación)

**Lo que SÍ sabe una pila:**
- ✓ Cuál es el elemento en el tope (peek)
- ✓ Si está vacía (tope == null)
- ✓ Cómo añadir/remover del tope

**Lo que NO sabe:**
- ✗ Cuántos elementos tiene (sin contador)
- ✗ Qué elementos hay debajo del tope (sin desapilar)
- ✗ El contenido completo (sin modificar su estado)

</details>

---

## Pregunta 4
**¿En cuál de estas situaciones es apropiado usar una pila?**

A) Procesar tareas en orden de llegada
B) Implementar la función "deshacer" en un editor de texto
C) Gestionar una fila de impresión
D) Almacenar datos para búsqueda rápida

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Las pilas son ideales para la función **"deshacer"** porque:
- Cada acción se apila (push) cuando se realiza
- Al presionar "deshacer", se recupera la última acción (pop)
- LIFO garantiza que deshacemos en orden inverso al que hicimos

**Aplicaciones comunes de pilas:**
- Función deshacer/rehacer
- Gestión de llamadas a funciones (call stack)
- Evaluación de expresiones matemáticas
- Verificación de paréntesis balanceados
- Navegación "atrás" en navegadores

**Opciones incorrectas:**
- A y C necesitan **colas** (FIFO - procesar en orden de llegada)
- D necesita estructuras con acceso directo como árboles o mapas

</details>

---

## Pregunta 5
**¿Qué indica que `tope == null` en una pila implementada con lista enlazada?**

A) La pila tiene un elemento
B) La pila está vacía
C) La pila está corrupta
D) Hay un error de memoria

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** En una pila implementada con lista enlazada, `tope == null` indica que **la pila está vacía** (no tiene elementos).

```java
public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;  // Pila vacía inicialmente
    }

    public boolean estaVacia() {
        return tope == null;  // true si vacía
    }

    public void push(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;  // Ahora tope != null
    }
}
```

Es un estado válido y normal, no un error.

</details>

---

## Pregunta 6
**¿Qué sucede si intentamos hacer `pop()` en una pila vacía sin validación?**

A) Retorna 0 automáticamente
B) La pila se reinicia
C) Se produce un error de NullPointerException
D) Retorna el último elemento eliminado

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Intentar `pop()` en una pila vacía sin validación causa **NullPointerException** porque intentamos acceder a `tope.dato` cuando `tope == null`.

```java
// ❌ SIN validación - PELIGROSO
public int pop() {
    int valor = tope.dato;      // Error si tope == null
    tope = tope.siguiente;
    return valor;
}

// ✅ CON validación - CORRECTO
public int pop() {
    if (estaVacia()) {
        throw new IllegalStateException("Pila vacía");
    }
    int valor = tope.dato;
    tope = tope.siguiente;
    return valor;
}

// ✅ Con assertion como en el curso
public int pop() {
    assert !estaVacia() : "No se puede desapilar de una pila vacía";
    int valor = tope.dato;
    tope = tope.siguiente;
    return valor;
}
```

Por eso es fundamental **validar antes de operar** con pilas vacías.

</details>

---

## Pregunta 7
**En una pila implementada con array, ¿cómo se verifica si está llena?**

A) Cuando tope == 0
B) Cuando tope == maxTamaño
C) Cuando tope == maxTamaño - 1
D) Las pilas nunca se llenan

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** En una pila con array, se considera llena cuando `tope == maxTamaño - 1` porque:
- Los arrays en Java usan índices de 0 a (tamaño - 1)
- Si `maxTamaño = 5`, los índices válidos son 0, 1, 2, 3, 4
- Cuando `tope = 4` (maxTamaño - 1), la pila está llena

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

    public boolean estaLlena() {
        return tope == maxTamaño - 1;  // Correcto
    }

    public void push(int valor) {
        if (!estaLlena()) {
            arregloPila[++tope] = valor;
        }
    }
}
```

</details>

---

## Pregunta 8
**¿Cuál es la diferencia clave entre `pop()` y `peek()`?**

A) pop() es más rápido que peek()
B) pop() remueve el elemento, peek() solo lo consulta
C) peek() solo funciona con pilas vacías
D) No hay diferencia, son sinónimos

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia fundamental es:

- **pop():** Retorna el elemento del tope **Y lo remueve** de la pila (destructivo)
- **peek():** Retorna el elemento del tope **SIN removerlo** (consulta no destructiva)

```java
Pila pila = new Pila();
pila.push(10);
pila.push(20);
pila.push(30);

// peek() - solo consulta
int valor1 = pila.peek();  // Retorna 30, pila sigue: [10, 20, 30]
int valor2 = pila.peek();  // Retorna 30, pila sigue: [10, 20, 30]

// pop() - remueve
int valor3 = pila.pop();   // Retorna 30, pila ahora: [10, 20]
int valor4 = pila.pop();   // Retorna 20, pila ahora: [10]
```

**peek()** es útil cuando necesitas ver qué hay en el tope sin modificar la estructura.

</details>

---

## Pregunta 9
**¿Cuál es la ventaja de implementar una pila con lista enlazada en lugar de array?**

A) Acceso más rápido a elementos
B) Tamaño dinámico, crece según necesidad
C) Usa menos memoria
D) Permite acceso aleatorio

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La principal ventaja de la implementación con **lista enlazada** es el **tamaño dinámico**:

**Pila con Array:**
- ✓ Implementación más simple
- ✗ Tamaño fijo (puede llenarse)
- ✗ Desperdicia memoria si no se llena

**Pila con Lista Enlazada:**
- ✓ Tamaño dinámico (crece según necesidad)
- ✓ No se puede "llenar" (hasta agotar memoria del sistema)
- ✗ Usa más memoria por elemento (necesita referencias)
- ✗ Implementación ligeramente más compleja

```java
// Array - tamaño fijo
Pila pilaArray = new Pila(100);  // Máximo 100 elementos

// Lista enlazada - crece dinámicamente
Pila pilaLista = new Pila();     // Sin límite (salvo memoria)
```

</details>

---

## Pregunta 10
**¿Qué retorna el siguiente código?**

```java
Pila pila = new Pila();
pila.push(5);
pila.push(10);
pila.push(15);
pila.pop();
pila.push(20);
System.out.println(pila.peek());
```

A) 5
B) 10
C) 15
D) 20

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: D**

**Explicación:** Sigamos la ejecución paso a paso:

```java
Pila pila = new Pila();          // Pila: []
pila.push(5);                    // Pila: [5]
pila.push(10);                   // Pila: [5, 10]
pila.push(15);                   // Pila: [5, 10, 15]
pila.pop();                      // Remueve 15, Pila: [5, 10]
pila.push(20);                   // Pila: [5, 10, 20]
System.out.println(pila.peek()); // Consulta tope → 20
```

**Visualización:**

```
Después de push(5):     [5] ← tope
Después de push(10):    [5, 10] ← tope
Después de push(15):    [5, 10, 15] ← tope
Después de pop():       [5, 10] ← tope (removió 15)
Después de push(20):    [5, 10, 20] ← tope
peek() retorna:         20 (sin remover)
```

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de pilas
- **7-9 respuestas correctas:** Buen entendimiento, revisar conceptos específicos
- **5-6 respuestas correctas:** Comprensión básica, se recomienda repasar
- **Menos de 5 correctas:** Es necesario revisar el tema completo

## Temas Clave Evaluados

1. ✓ Principio LIFO
2. ✓ Operaciones básicas (push, pop, peek)
3. ✓ Limitaciones de la estructura
4. ✓ Aplicaciones prácticas
5. ✓ Estado de pila vacía
6. ✓ Manejo de errores (underflow)
7. ✓ Implementación con array (estado llena)
8. ✓ Diferencia entre pop y peek
9. ✓ Array vs lista enlazada
10. ✓ Seguimiento de operaciones
