# pyCCCF evolutivo

> *Basado en el [pyCCCF](https://github.com/puntoReflex/pyCCCF)*

## ¿Por qué?

Hemos visto ya tres asignaturas dedicadas al desarrollo: Programación I (programación imperativa y estructurada), Programación II (programación orientada a objetos), Estructura de datos y algoritmos I (estructuras de datos). Esto nos ha proporcionado herramientas para abordar la disciplina de programación.

## ¿Qué?

Explorar diversas versiones (y diferentes formas de resolver) un mismo problema.

## ¿Para qué?

Mostrar la progresión natural desde código estructurado hasta estructuras de datos dinámicas, evidenciando las limitaciones de cada aproximación y cómo la siguiente las resuelve.

## ¿Cómo?

### Versiones

#### [vPRG1](vPRG1)

Procedural puro

<div align=center>

|Características|Limitaciones|
|-|-|
|Array de primitivos `int[] cashRegisters`|Cola solo como contador `int` (sin info del cliente)|
|Todo en `main()` con lógica procedural|Sin encapsulación de responsabilidades|
|Bucles para evitar repetición extrema||

</div>

#### [vPRG2_01_unsafe](vPRG2_01_unsafe)

Arrays de objetos sin protección

<div align=center>

|Características|Limitaciones|
|-|-|
|Clases: `Customer`, `CashRegister`, `CCCF`, `Simulation`|Sin validación de capacidad: revienta con `ArrayIndexOutOfBoundsException`|
|Arrays de objetos: `Customer[]`, `CashRegister[]`|Índices sin aritmética circular: `rear = rear + 1`|
|Encapsulación de responsabilidades|Propósito: experimentar el crash antes de aprender protecciones|

</div>

**Implementación crítica:** esta aproximación revienta cuando rear >= 100.

```java
if (Math.random() < PROBABILITY_ARRIVAL) {
    queue[rear] = new Customer(items);
    rear = rear + 1;
    size = size + 1;
}
```

```console
[13.15]
FILA: _O_._O_._O_._O_._O_._O_. 
     ===================================
Caja[1] [:][:][:][:][:][:]
Caja[2] 
Caja[3] [:][:][:][:][:][:][:][:]
Caja[4] 

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 100 out of bounds for length 100
    at vPRG2_01_unsafe.CCCF.run(CCCF.java:36)
    at vPRG2_01_unsafe.Simulation.main(Simulation.java:6)
```

#### [vPRG2_02_safe](vPRG2_02_safe)

Arrays de objetos con protección

<div align=center>

|Características|Limitaciones|
|-|-|
|Validación de capacidad: `size < MAX_QUEUE`|Capacidad fija: `MAX_QUEUE = 100`|
|Aritmética circular: `(rear + 1) % MAX_QUEUE`|Rechaza clientes cuando la cola está llena|
|Reutilización de posiciones liberadas|Desperdicio de memoria si nunca se llena|
|Simula "punteros" con índices `front` y `rear`|Complejidad adicional por gestión circular|

</div>

**Implementación crítica:** implementación circular. El operador `%` garantiza la vuelta a 0

```java
if (Math.random() < PROBABILITY_ARRIVAL && size < MAX_QUEUE) {
    queue[rear] = new Customer(items);
    rear = (rear + 1) % MAX_QUEUE;
    size = size + 1;
}
```

**Observación técnica:**

Los índices `front` y `rear` simulan el comportamiento de punteros. Esta simulación prepara conceptualmente para trabajar con referencias dinámicas.

