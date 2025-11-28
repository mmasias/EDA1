# vEDA1_02_queue - Cola especializada (ADT)

## ¿Por qué?

La lista con API completa permite operaciones que rompen la semántica FIFO, generando errores lógicos silenciosos que el compilador no detecta.

## ¿Qué?

Esta versión restringe la API pública para garantizar comportamiento FIFO mediante un Tipo Abstracto de Datos (ADT) especializado.

## ¿Para qué?

Garantizar semántica FIFO mediante restricción de API, convertir errores lógicos en errores de compilación, y hacer explícita la intención del código.

## ¿Cómo?

### Lo que NO cambia

- **Customer.java** - idéntico
- **CashRegister.java** - idéntico
- **Node.java** - idéntico
- **Simulation.java** - idéntico
- **Implementación interna** - nodos enlazados igual que List

### Lo que cambia

#### De List a Queue

<table>

<tr><th>ANTES (vEDA1_01_list)</th><th>AHORA (vEDA1_02_queue)</th></tr>

<tr>
<td>API completa (8 métodos públicos)</td>
<td>API restringida (4 métodos públicos)</td>
</tr>

<tr>
<td valign=top>

```java
class List {
    public void addFirst(Customer)
    public void addLast(Customer)
    public Customer removeFirst()
    public Customer removeLast()
    public Customer get(int index)
    public boolean remove(Customer)
    public int size()
    public boolean isEmpty()
}
```

</td>
<td valign=top>

```java
class Queue {
    public void enqueue(Customer)
    public Customer dequeue()
    public int size()
    public boolean isEmpty()
}
```

</td>
</tr>

<tr>
<td>Declaración de estructura</td>
<td>Declaración de estructura</td>
</tr>

<tr>
<td valign=top>

```java
List queue = new List();
```

</td>
<td valign=top>

```java
Queue queue = new Queue();
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
if (Math.random() < PROBABILITY_ARRIVAL) {
    queue.addLast(new Customer());
}
```

</td>
<td valign=top>

```java
if (Math.random() < PROBABILITY_ARRIVAL) {
    queue.enqueue(new Customer());
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
if (cashRegisters[i].isFree() && !queue.isEmpty()) {
    Customer customer = queue.removeFirst();
    cashRegisters[i].serve(customer);
}
```

</td>
<td valign=top>

```java
if (cashRegisters[i].isFree() && !queue.isEmpty()) {
    Customer customer = queue.dequeue();
    cashRegisters[i].serve(customer);
}
```

</td>
</tr>

</table>

### Implementación interna (idéntica)

**Queue.java** - internamente usa los mismos nodos enlazados que List

```java
class Queue {
    private Node front;
    private Node rear;
    private int size;

    public void enqueue(Customer customer) {
        Node newNode = new Node(customer);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size = size + 1;
    }

    public Customer dequeue() {
        if (front == null) {
            return null;
        }
        Customer data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size = size - 1;
        return data;
    }
}
```

### Comparación de APIs

<div align=center>

|Operación|vEDA1_01_list|vEDA1_02_queue|
|-|-|-|
|Agregar al final|`addLast(customer)`|`enqueue(customer)`|
|Remover del inicio|`removeFirst()`|`dequeue()`|
|Verificar vacía|`isEmpty()`|`isEmpty()`|
|Obtener tamaño|`size()`|`size()`|
|Agregar al inicio|`addFirst(customer)`|No disponible|
|Remover del final|`removeLast()`|No disponible|
|Obtener por índice|`get(index)`|No disponible|
|Remover específico|`remove(customer)`|No disponible|

</div>

### Errores prevenidos

<div align=center>

|Código erróneo con List|Con Queue|
|-|-|
|`queue.removeLast()`|Error de compilación|
|`queue.addFirst(customer)`|Error de compilación|
|`queue.get(5)`|Error de compilación|
|`queue.remove(customer)`|Error de compilación|

</div>

<div align=center>

|Fortalezas|
|-|
|Garantía de comportamiento FIFO|
|API mínima: imposible usar incorrectamente|
|Errores detectados en compilación, no en ejecución|
|Intención explícita del código|
|Misma eficiencia que List (misma implementación interna)|

</div>

## Concepto clave

**Tipo Abstracto de Datos (ADT):** La misma estructura interna (nodos enlazados) puede presentar diferentes interfaces públicas según el comportamiento que se quiera garantizar. Queue y List comparten implementación pero difieren en contrato.
