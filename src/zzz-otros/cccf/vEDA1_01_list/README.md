# vEDA1_01_list - Lista dinámica

## ¿Por qué?

Los arrays de tamaño fijo imponen límites artificiales y requieren gestión manual de índices circulares, aumentando la complejidad del código y desperdiciando memoria.

## ¿Qué?

Esta versión demuestra cómo transformar una solución basada en arrays a una basada en estructuras dinámicas mediante nodos enlazados.

## ¿Para qué?

Eliminar límites artificiales de capacidad, simplificar el código eliminando aritmética circular, y gestionar memoria de forma proporcional al uso real.

## ¿Cómo?

### Lo que NO cambia

- **Customer.java** - idéntico
- **CashRegister.java** - idéntico
- **Simulation.java** - idéntico
- **Lógica de simulación** - tiempo, probabilidades, procesamiento permanecen igual

### Lo que cambia

#### Archivo CCCF.java

<table>

<tr><th>ANTES (vPRG2_02_safe)</th><th>AHORA (vEDA1_01_list)</th></tr>

<tr>
<td>Límite artificial de capacidad</td>
<td>Sin límite - crecimiento dinámico</td>
</tr>

<tr>
<td valign=top>

```java
private final int MAX_QUEUE = 100;
```

</td>
<td valign=top>

```java

```

</td>
</tr>

<tr>
<td>Declaración de estructura de datos</td>
<td>Declaración de estructura de datos</td>
</tr>

<tr>
<td valign=top>

```java
Customer[] queue = new Customer[MAX_QUEUE];
int front = 0;
int rear = 0;
int size = 0;
```

</td>
<td valign=top>

```java
List queue = new List();
```

</td>
</tr>

<tr>
<td>Agregar elemento a la cola</td>
<td>Agregar elemento a la cola</td>
</tr>

<tr>
<td valign=top>

```java
if (Math.random() < PROBABILITY_ARRIVAL && size < MAX_QUEUE) {
    queue[rear] = new Customer();
    rear = (rear + 1) % MAX_QUEUE;
    size = size + 1;
}
```

</td>
<td valign=top>

```java
if (Math.random() < PROBABILITY_ARRIVAL) {
    queue.addLast(new Customer());
}
```

</td>
</tr>

<tr>
<td>Remover elemento de la cola</td>
<td>Remover elemento de la cola</td>
</tr>

<tr>
<td valign=top>

```java
if (cashRegisters[i].isFree() && size > 0) {
    Customer customer = queue[front];
    front = (front + 1) % MAX_QUEUE;
    size = size - 1;
    cashRegisters[i].serve(customer);
}
```

</td>
<td valign=top>

```java
if (cashRegisters[i].isFree() && !queue.isEmpty()) {
    Customer customer = queue.removeFirst();
    cashRegisters[i].serve(customer);
}
```

</td>
</tr>

</table>

#### Lo que se agrega

**Node.java** - nueva clase

```java
class Node {
    Customer data;
    Node next;
}
```

**List.java** - nueva clase con API completa

- `addFirst(Customer)` - agregar al inicio
- `addLast(Customer)` - agregar al final
- `removeFirst()` - remover del inicio
- `removeLast()` - remover del final
- `get(int index)` - obtener por posición
- `remove(Customer)` - remover específico
- `size()` - tamaño actual
- `isEmpty()` - verificar si está vacía

### Comparación directa

<div align=center>

|vPRG2_02_safe|vEDA1_01_list|
|-|-|
|`Customer[] queue = new Customer[100]`|`List queue = new List()`|
|`int front = 0, rear = 0, size = 0`|_(gestionado internamente)_|
|`size < MAX_QUEUE`|_(no necesario)_|
|`rear = (rear + 1) % MAX_QUEUE`|_(no necesario)_|
|`queue[rear] = customer`|`queue.addLast(customer)`|
|`customer = queue[front]`|`customer = queue.removeFirst()`|
|Rechaza clientes al llegar a 100|Sin límite artificial|

</div>

<div align=center>

|Fortalezas|Amenazas|
|-|-|
|Código más simple (sin gestión de índices circulares)|API demasiado rica: 8 métodos públicos
|Sin límite artificial (crece dinámicamente)|Nada garantiza semántica FIFO correcta
|Memoria proporcional al uso real|Podríamos llamar `removeLast()` por error
|API expresiva (`addLast`, `removeFirst` vs índices)|Responsabilidad del programador usar correctamente

</div>




