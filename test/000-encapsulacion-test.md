# Test: Encapsulamiento y Diseño

**Tema:** Encapsulamiento, Visibilidad y Buenas Prácticas
**Número de preguntas:** 10
**Tiempo estimado:** 20 minutos

---

## Pregunta 1
**El código cliente puede verificar el estado de una cola con `if (cola.frente == null)`. ¿Qué indica esto?**

A) La cola está bien diseñada
B) Es una forma eficiente de verificar si está vacía
C) Hay un error de encapsulamiento - `frente` debería ser privado
D) Es la forma correcta en Java

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Si desde **fuera** de la clase puedo acceder a `frente`, hay un **error grave de encapsulamiento**. Los atributos internos deben ser `private`.

```java
// ❌ MAL - Encapsulamiento roto
public class Cola {
    public Nodo frente;  // ¡Error! No debería ser público
}

// Desde código cliente:
if (cola.frente == null) { }  // Si esto compila, hay error de diseño

// ✅ BIEN - Encapsulamiento correcto
public class Cola {
    private Nodo frente;  // PRIVADO

    public boolean estaVacia() {
        return frente == null;  // Solo interno
    }
}

// Desde código cliente:
if (cola.estaVacia()) { }  // ✓ Usa interfaz pública
```

**Principio:** Los detalles de implementación deben estar ocultos.

</details>

---

## Pregunta 2
**¿Cuál de estos diseños de Pila respeta el encapsulamiento?**

```java
// Diseño A
public class Pila {
    private Nodo tope;
    public boolean estaVacia() { return tope == null; }
}

// Diseño B
public class Pila {
    public Nodo tope;
    public boolean estaVacia() { return tope == null; }
}

// Diseño C
public class Pila {
    private Nodo tope;
    public Nodo getTope() { return tope; }
}
```

A) Solo A
B) Solo B
C) A y C
D) Todos

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** Solo el diseño A respeta correctamente el encapsulamiento.

**Diseño A - ✅ CORRECTO:**
```java
public class Pila {
    private Nodo tope;  // ✓ Privado
    public boolean estaVacia() { return tope == null; }  // ✓ Interfaz controlada
}
```
- `tope` es privado
- Provee método público para funcionalidad necesaria
- No expone detalles internos

**Diseño B - ❌ INCORRECTO:**
```java
public class Pila {
    public Nodo tope;  // ✗ Público - rompe encapsulamiento
}
```
- Permite acceso directo: `pila.tope.dato = 999;` (¡desastre!)
- Cualquiera puede modificar estructura interna

**Diseño C - ❌ INCORRECTO:**
```java
public class Pila {
    private Nodo tope;
    public Nodo getTope() { return tope; }  // ✗ Expone nodo interno
}
```
- Aunque `tope` es privado, `getTope()` lo expone
- Permite: `pila.getTope().siguiente = null;` (romper la estructura)
- **Getter de referencia = romper encapsulamiento**

**Regla:** No exponer referencias a objetos mutables internos.

</details>

---

## Pregunta 3
**Desde código cliente, ¿cuál es la forma CORRECTA de verificar si una lista está vacía?**

A) `if (lista.cabeza == null)`
B) `if (lista.size() == 0)`
C) `if (lista.estaVacia())`
D) B y C son correctas

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: D**

**Explicación:** Desde **perspectiva externa** (código cliente), solo podemos usar métodos públicos.

```java
public class Lista {
    private Nodo cabeza;  // PRIVADO - no accesible desde fuera

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int size() {
        // implementación...
        return count;
    }
}

// Código cliente (FUERA de la clase):

// ❌ Opción A - ERROR de compilación
if (lista.cabeza == null) { }  // cabeza es privada, no compila

// ✅ Opción B - CORRECTO
if (lista.size() == 0) { }  // Usa método público

// ✅ Opción C - CORRECTO (más expresivo)
if (lista.estaVacia()) { }  // Usa método público, más claro

// ✅ Opción D - CORRECTO
// Ambas B y C son válidas desde perspectiva externa
```

**Nota:** Opción A solo sería válida **dentro** de la clase Lista, nunca desde fuera.

</details>

---

## Pregunta 4
**¿Desde qué perspectiva tiene sentido la expresión `tope == -1`?**

A) Solo desde dentro de la clase Pila (implementación con array)
B) Desde código cliente que usa la pila
C) Desde cualquier lugar
D) Nunca tiene sentido

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** `tope == -1` es un **detalle de implementación** solo visible/relevante dentro de la clase.

```java
public class Pila {
    private int[] arregloPila;
    private int tope;  // PRIVADO

    public Pila(int tamaño) {
        arregloPila = new int[tamaño];
        tope = -1;  // ← Detalle interno: -1 indica vacío
    }

    public boolean estaVacia() {
        return tope == -1;  // ✓ Dentro de clase: tiene sentido
    }

    public void push(int valor) {
        if (tope < arregloPila.length - 1) {
            arregloPila[++tope] = valor;  // ✓ Uso interno
        }
    }
}

// Código cliente (FUERA):
Pila pila = new Pila(10);

// ❌ Esto NO tiene sentido desde fuera:
if (pila.tope == -1) { }  // Error: tope es privado

// ✅ Desde fuera solo:
if (pila.estaVacia()) { }  // Interfaz pública
```

**Perspectivas:**
- **Interna (implementador):** `tope == -1` tiene sentido completo
- **Externa (código cliente):** No existe `tope`, solo métodos públicos

</details>

---

## Pregunta 5
**¿Qué problema tiene este método público?**

```java
public class Lista {
    private Nodo cabeza;

    public Nodo getCabeza() {
        return cabeza;
    }
}
```

A) No hay problema
B) Expone la referencia interna, rompiendo encapsulamiento
C) Debería retornar el dato, no el nodo
D) B y C son correctas

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: D**

**Explicación:** Este método tiene **dos problemas graves**:

**Problema 1: Expone referencia interna**
```java
Lista lista = new Lista();
lista.insertarAlPrincipio(10);
lista.insertarAlPrincipio(20);

Nodo nodo = lista.getCabeza();  // Obtiene referencia interna
nodo.siguiente = null;  // ¡Destruye la lista desde fuera!

// La lista quedó corrupta: solo tiene primer elemento
```

**Problema 2: Expone tipo interno (Nodo)**
```java
// Cliente necesita conocer la clase Nodo
Nodo n = lista.getCabeza();
int valor = n.dato;  // Cliente depende de implementación

// Si cambio implementación, clientes se rompen
```

**Diseño correcto - Opciones:**

```java
// ✅ Opción 1: Retornar copia del dato con validación
public int obtenerPrimero() {
    assert cabeza != null : "Lista vacía";
    return cabeza.dato;  // Retorna valor, no referencia
}

// ✅ Opción 2: No exponer nada
// Si no hay necesidad de acceder al primero desde fuera,
// no proveer método

// ❌ Nunca hacer:
public Nodo getCabeza() {
    return cabeza;  // Expone implementación
}
```

**Principio:** No retornar referencias a objetos mutables internos.

</details>

---

## Pregunta 6
**¿Cuál sería una interfaz pública CORRECTA para una Cola?**

```java
// Opción A
public interface ColaPublica {
    void enqueue(int valor);
    int dequeue();
    boolean estaVacia();
}

// Opción B
public interface ColaPublica {
    Nodo getFrente();
    Nodo getFinal();
    void setFrente(Nodo n);
}

// Opción C
public interface ColaPublica {
    void enqueue(int valor);
    int peek();
    Nodo frente;  // atributo público
}
```

A) Solo A
B) Solo B
C) A y C
D) Todas

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** Solo la opción A expone **comportamiento**, no implementación.

**Opción A - ✅ CORRECTA:**
```java
public interface ColaPublica {
    void enqueue(int valor);  // ✓ Operación
    int dequeue();            // ✓ Operación
    boolean estaVacia();      // ✓ Consulta de estado
}
```
- Expone QUÉ hace, no CÓMO lo hace
- Implementación interna puede cambiar sin afectar clientes
- Podría usar lista, array, o lo que sea internamente

**Opción B - ❌ INCORRECTA:**
```java
public interface ColaPublica {
    Nodo getFrente();     // ✗ Expone tipo interno
    Nodo getFinal();      // ✗ Expone tipo interno
    void setFrente(Nodo n); // ✗ Permite modificar internos
}
```
- Expone completamente la implementación
- Cliente puede destruir la estructura
- Si cambio implementación, clientes se rompen

**Opción C - ❌ INCORRECTA:**
```java
public interface ColaPublica {
    void enqueue(int valor);
    int peek();
    Nodo frente;  // ✗ ¡Interfaces no tienen atributos públicos!
}
```
- Interfaces en Java no pueden tener atributos de instancia
- Error de sintaxis

**Principio:** Interfaz pública = operaciones abstractas, no detalles de implementación.

</details>

---

## Pregunta 7
**Este código compila y ejecuta. ¿Qué indica sobre el diseño?**

```java
Pila pila = new Pila();
pila.push(10);
pila.tope.dato = 999;  // ← Esta línea compila
```

A) El diseño es correcto
B) Hay error de encapsulamiento: `tope` es público
C) Es la forma correcta de modificar elementos
D) Java permite esto siempre

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Si `pila.tope.dato = 999` **compila**, significa que `tope` es accesible públicamente.

```java
// Para que compile, la clase debe ser:
public class Pila {
    public Nodo tope;  // ¡PÚBLICO! Error grave

    public void push(int valor) {
        // implementación...
    }
}

// Desde cliente:
Pila pila = new Pila();
pila.push(10);
pila.tope.dato = 999;  // ← Compila porque tope es público

// Problemas que causa:
pila.tope = null;  // ¡Destruyo toda la pila!
pila.tope = new Nodo(100);  // ¡Cambio arbitrariamente el tope!
pila.tope.siguiente = pila.tope;  // ¡Creo ciclo infinito!
```

**Diseño correcto:**
```java
public class Pila {
    private Nodo tope;  // PRIVADO

    public void push(int valor) {
        // Solo yo controlo cómo se modifica tope
    }
}

// Desde cliente:
Pila pila = new Pila();
pila.push(10);
pila.tope.dato = 999;  // ← ERROR de compilación (como debe ser)
```

**Indicador de mal diseño:** Si desde fuera puedo romper la estructura interna, el encapsulamiento está roto.

</details>

---

## Pregunta 8
**¿Cuál afirmación es CORRECTA sobre el siguiente código?**

```java
public class Lista {
    private Nodo cabeza;

    private void validarNoVacia() {
        assert cabeza != null : "Lista vacía";
    }
}
```

A) `validarNoVacia()` debería ser público para que clientes lo usen
B) Está bien que sea privado - es un método auxiliar interno
C) Debería verificar `cabeza != null` en lugar de `== null`
D) Los métodos privados no pueden usar asserts

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Los métodos auxiliares/de validación **deben ser privados** si son detalles de implementación.

```java
public class Lista {
    private Nodo cabeza;

    // ✓ Método auxiliar privado con assertion
    private void validarNoVacia() {
        assert cabeza != null : "Lista vacía";
    }

    // ✓ Métodos públicos lo usan internamente
    public int obtenerPrimero() {
        validarNoVacia();  // Uso interno - lanza AssertionError si vacía
        return cabeza.dato;
    }

    public void eliminarPrimero() {
        validarNoVacia();  // Uso interno - lanza AssertionError si vacía
        cabeza = cabeza.siguiente;
    }
}

// Desde código cliente:
Lista lista = new Lista();
lista.validarNoVacia();  // ← ERROR: método privado, no accesible
lista.obtenerPrimero();  // ✓ Método público, falla con assertion si vacía
```

**Por qué opción A es incorrecta:**
```java
// ❌ Si fuera público:
public void validarNoVacia() { }

// Código cliente podría:
lista.validarNoVacia();  // ¿Para qué? No aporta valor
// Y además expone cómo se valida internamente
```

**Regla:** Métodos que son detalles de implementación (helpers, validaciones internas) deben ser privados.

</details>

---

## Pregunta 9
**¿Desde qué contexto es válido/tiene sentido acceder directamente a `cabeza.siguiente`?**

A) Desde código cliente que usa la lista
B) Desde métodos públicos de otras clases
C) Solo desde dentro de la clase Lista
D) Desde cualquier lugar si es necesario

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** `cabeza.siguiente` es un **detalle interno** solo accesible/con sentido dentro de la clase.

```java
public class Lista {
    private Nodo cabeza;

    // ✓ CONTEXTO VÁLIDO: Dentro de la clase
    public void eliminarPrimero() {
        assert cabeza != null : "Lista vacía";
        cabeza = cabeza.siguiente;  // ✓ Acceso interno válido
    }

    // ✓ CONTEXTO VÁLIDO: Dentro de la clase
    public int size() {
        int count = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            count++;
            actual = actual.siguiente;  // ✓ Acceso interno válido
        }
        return count;
    }
}

// ❌ CONTEXTO INVÁLIDO: Fuera de la clase
public class ClienteMain {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertarAlPrincipio(10);

        // ❌ Esto NO debería ser posible:
        lista.cabeza.siguiente = null;  // Error de compilación

        // ✓ Solo interfaz pública:
        lista.eliminarPrimero();  // Correcto
    }
}
```

**Perspectivas:**
- **Interna:** Puedo manipular `cabeza`, `siguiente`, estructura completa
- **Externa:** Solo veo operaciones abstractas: insertar, eliminar, buscar

**Analogía:** Como el motor de un coche
- Mecánico (interno): accede a pistones, válvulas, etc.
- Conductor (externo): solo usa pedales y volante

</details>

---

## Pregunta 10
**¿Cuál diseño permite cambiar de lista enlazada a array sin afectar código cliente?**

```java
// Diseño A
public class Lista {
    private Nodo cabeza;
    public void insertar(int dato) { }
    public int obtener(int pos) { }
    public int size() { }
}

// Diseño B
public class Lista {
    public Nodo cabeza;
    public void insertarNodo(Nodo n) { }
    public Nodo getNodo(int pos) { }
}
```

A) Solo A permite el cambio
B) Solo B permite el cambio
C) Ambos permiten el cambio
D) Ninguno permite el cambio

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: A**

**Explicación:** Solo el diseño A **oculta la implementación**, permitiendo cambiarla sin afectar clientes.

**Diseño A - ✅ Permite cambio:**
```java
// Versión 1: Con lista enlazada
public class Lista {
    private Nodo cabeza;  // Implementación oculta

    public void insertar(int dato) {
        // Implementación con nodos
    }

    public int obtener(int pos) {
        // Recorre nodos
        return dato;
    }
}

// Versión 2: Cambio a array - Cliente NO se entera
public class Lista {
    private int[] elementos;  // ¡Cambié implementación!
    private int size;

    public void insertar(int dato) {
        // Ahora usa array
    }

    public int obtener(int pos) {
        // Acceso directo a array
        return elementos[pos];
    }
}

// Código cliente - SIN CAMBIOS:
Lista lista = new Lista();
lista.insertar(10);
lista.insertar(20);
int valor = lista.obtener(0);  // ✓ Funciona igual
```

**Diseño B - ❌ NO permite cambio:**
```java
// Versión 1: Con nodos
public class Lista {
    public Nodo cabeza;  // ¡Expuesto!

    public void insertarNodo(Nodo n) { }  // Requiere Nodo
    public Nodo getNodo(int pos) { }      // Retorna Nodo
}

// Cliente depende de Nodos:
Lista lista = new Lista();
Nodo n = new Nodo(10);
lista.insertarNodo(n);
Nodo resultado = lista.getNodo(0);

// ¡No puedo cambiar a array! Cliente espera Nodos
```

**Principio fundamental:**
> "Programar contra interfaces, no contra implementaciones"

Cuando ocultas la implementación, puedes cambiarla libremente.

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de encapsulamiento
- **7-9 respuestas correctas:** Buen entendimiento de diseño
- **5-6 respuestas correctas:** Comprensión básica, repasar principios
- **Menos de 5 correctas:** Revisar conceptos de POO y encapsulamiento

## Conceptos Clave Evaluados

1. ✓ Detección de errores de encapsulamiento
2. ✓ Atributos privados vs públicos
3. ✓ Uso correcto de interfaz pública
4. ✓ Perspectiva interna vs externa
5. ✓ Problemas de exponer referencias
6. ✓ Diseño de interfaces públicas
7. ✓ Validación de compilación vs diseño
8. ✓ Métodos auxiliares privados
9. ✓ Contextos válidos de acceso
10. ✓ Independencia de implementación

## Principios de Diseño

- **Encapsulamiento:** Ocultar detalles de implementación
- **Información Hiding:** Exponer solo lo necesario
- **Abstracción:** Interfaz pública vs implementación privada
- **Mantenibilidad:** Poder cambiar implementación sin afectar clientes
