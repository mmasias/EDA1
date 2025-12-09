# Reivindicando a mamá

> *El patrón de diseño que llamamos coloquialmente "modo mamá" representa un dilema arquitectónico fundamental: ¿deben los objetos autogestionarse mediante delegación (muchas veces recursiva), o debe un coordinador externo controlar las operaciones?*

||*En listas*|*En árboles*|*En grafos*|
|-|-|-|-|
|La respuesta, lejos de ser dogmática, depende de las restricciones inherentes a cada estructura de datos.|El "modo mamá" es una tentación peligrosa que degrada el diseño.|Sin recursividad, comienza a mostrar su utilidad.|Se revela como la única arquitectura viable.|

## ¿Qué es el "modo mamá"?

Es el patrón donde un objeto contenedor (la "mamá") mantiene control explícito sobre las operaciones de sus elementos, típicamente mediante:

- Bucles iterativos que recorren la estructura
- Getters que exponen la estructura interna de los nodos
- Lógica de negocio centralizada en el coordinador

**MODO MAMÁ**: Monitor controla todo

```java
public int contar() {
    int contador = 0;
    Nodo actual = primero;
    while (actual != null) {
        contador++;
        actual = actual.getSiguiente();  // ← Getter expuesto
    }
    return contador;
}
```

## Comparación con delegación *recursiva*

|Modo mamá (iterativo)|Delegación recursiva|
|-|-|
|El contenedor mantiene control explícito mediante bucles|Cada nodo se autogestiona y delega en el siguiente|
|Requiere exponer estructura interna (getters)|Encapsulación completa de la estructura|
|Control centralizado en un coordinador|Responsabilidad distribuida entre objetos|
|Eficiente, sin límite de profundidad de pila|Elegante, pero vulnerable a stack overflow|
|Objetos "tontos" que solo almacenan datos|Objetos "inteligentes" con comportamiento|

**DELEGACIÓN RECURSIVA**: Cada nodo se autogestiona

```java
public int contar() {
    if (siguiente == null) {
         return 1;
    } else {
        return 1 + siguiente.contar();  // ← No requiere getter
    }
}
```

## La pendiente resbaladiza

El "modo mamá" es peligroso porque abre una tentación arquitectónica:

### Fase 1 - Getter "inocente"

```java
public Nodo getSiguiente() {
    return siguiente;
}
```

Justificación: *"Solo para iterar eficientemente"*.

### Fase 2 - Cascada de getters

```java
public String getNombre() { 
    return nombre; 
    }
public int getEdad() { 
    return edad; 
    }
public boolean getHambriento() { 
    return hambriento; 
    }
```

Justificación: *"Monitor necesita esta información para decidir"*.

### Fase 3 - Objetos anémicos

Consecuencia: Monitor ahora ejecuta TODA la lógica de negocio.

```java
public void alimentarHambrientos() {
    Nodo actual = primero;
    while (actual != null) {
        if (actual.getHambriento() && actual.getEdad() < EDAD_MINIMA) {
            cocina.prepararMerienda(actual.getPreferenciaAlimentaria());
            actual.setHambriento(false);  // ← Encapsulación rota!!!
        }
        actual = actual.getSiguiente();
    }
}
```

> **Resultado final**: Los nodos se han degradado a estructuras pasivas que solo almacenan datos. Toda la responsabilidad reside en un controlador omnipotente.

## La escala de inevitabilidad

### Listas: el modo mamá es una concesión

En listas, la delegación recursiva es viable y preferible.

Cada nodo puede autogestionarse:

```java
public int contar() {
    return (siguiente == null) ? 1 : 1 + siguiente.contar();
}
```

El "modo mamá" aquí es una **degradación**: el nodo PODRÍA autogestionarse, pero le quitamos la responsabilidad por conveniencia (evitar *stack overflow* en listas muy largas).

### Árboles: la grieta aparece

Sin recursividad, ciertas operaciones en árboles empiezan a requerir coordinación externa.

Recorrido por niveles REQUIERE coordinador con cola:

```java
public void recorrerPorNiveles() {
    Cola cola = new Cola();
    cola.encolar(raiz);

    while (!cola.estaVacia()) {
        Nodo actual = cola.desencolar();
        System.out.println(actual.getDato());

        if (actual.getIzquierdo() != null) {
            cola.encolar(actual.getIzquierdo());
        }
        if (actual.getDerecho() != null) {
            cola.encolar(actual.getDerecho());
        }
    }
}
```

El nodo individual no puede ejecutar recorrido por niveles porque carece del contexto global necesario (la cola). La "mamá" se vuelve necesaria.

### Grafos: el modo mamá es inevitable

En grafos, la delegación recursiva pura es inviable: los ciclos obligan a coordinación externa.

DFS requiere estado global de visitados:

```java
public boolean hasPath(int from, int to) {
    boolean[] visited = new boolean[size];  // ← Estado global
    Stack stack = new Stack();              // ← Control externo

    stack.push(from);

    while (!stack.isEmpty()) {
        int current = stack.pop();

        if (current == to){
             return true;
        }

        if (!visited[current]) {
            visited[current] = true;
            // Agregar vecinos no visitados...
        }
    }
    return false;
}
```

Aquí el "modo mamá" NO es degradación: es **necesidad arquitectónica**. El nodo NO PUEDE autogestionarse porque:

- Los ciclos requieren memoria global de visitados
- El algoritmo necesita estrategia de recorrido (pila, cola)
- La decisión de "encontrado" requiere visión global

## Distinción crítica

|Contexto|Naturaleza del modo mamá|Legitimidad|
|-|-|-|
|Listas|Degradación por conveniencia|Antipatrón (existe alternativa mejor)|
|Árboles sin recursividad|Necesidad parcial|Justificado para ciertas operaciones|
|Grafos|Necesidad arquitectónica|Patrón legítimo (no hay alternativa viable)|

## Implicaciones

||||
|-|-|-|
*Pero dijimos que el modo mama era malo...*|Era malo allí donde había alternativa mejor. Aquí no la hay.|Las decisiones de diseño responden a restricciones del dominio, no a dogmas universales.|

Los algoritmos fundamentales de grafos (Dijkstra, Floyd-Warshall, Prim, Kruskal, BFS, DFS) son **todos** coordinadores externos. No es por accidente: es la naturaleza del problema.

## Implicaciones II

El "modo mamá" evoluciona en nuestra comprensión:

1. **En listas**: Reconocemos su peligro arquitectónico
2. **En árboles**: Aceptamos su utilidad condicional
3. **En grafos**: Abrazamos su inevitabilidad

No es cuestión de si el patrón es "bueno" o "malo". Es cuestión de **cuándo las restricciones del problema lo hacen necesario**.

La madurez como programador no consiste en seguir dogmas ("siempre encapsula", "nunca expongas estructura interna"), sino en **reconocer cuándo las restricciones del dominio justifican romper las reglas**.

> Mamá no siempre tiene razón. Pero a veces, especialmente en grafos, **no hay nadie más capaz de hacer el trabajo**.
