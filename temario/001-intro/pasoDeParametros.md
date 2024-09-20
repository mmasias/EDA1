# Paso de parámetros

## ¿Por qué?

|Evolución|Desafíos y necesidades emergentes|Paradigmas de programación|Búsqueda del equilibrio|
|-|-|-|-|
|**Primeros días**, lenguajes como Fortran (1957) usaban principalmente paso por referencia|**Manejo de memoria**: Creciente complejidad de los programas|**Programación orientada a objetos (OOP)**:|**Eficiencia vs. Seguridad**:|
|- Eficiente para grandes conjuntos de datos|- Necesidad de optimizar el uso de la memoria|- Concepto de objetos como entidades complejas|- Paso por referencia: Eficiente pero potencialmente peligroso|
|- Problemas de efectos secundarios no deseados|- Paso por referencia como solución para grandes estructuras de datos|- Necesidad de manipular objetos eficientemente (referencia) y proteger datos (valor)|- Paso por valor: Seguro pero potencialmente ineficiente|
|**Años 60-70**: Surgimiento de lenguajes como Algol y Pascal|**Programación modular**: Aumento de la complejidad del software|**Programación funcional**:|**Soluciones híbridas**:|
|- Introducción del paso por valor como estándar|- Necesidad de proteger datos en diferentes módulos|- Énfasis en inmutabilidad|- Desarrollo de conceptos como punteros constantes, referencias, etc.|
|- Mejor control sobre los datos, pero ineficiente para estructuras grandes|- Paso por valor como mecanismo de encapsulación|- Preferencia por paso por valor para evitar efectos secundarios|- Lenguajes modernos ofreciendo ambas opciones (C++, Java, Python)|

## ¿Qué?

El paso de parámetros es un mecanismo en programación que permite transferir información a una función o procedimiento cuando es invocado.

|Valor|Referencia|
|-|-|
|El paso por valor es un método de paso de parámetros donde se transmite una copia del valor del argumento a la función.|El paso por referencia es un método de paso de parámetros donde se transmite la dirección de memoria del argumento a la función.|
|**Características fundamentales**||
|- Crea una copia independiente del dato original|- No crea una copia del dato, sino que trabaja con el original|
|- El parámetro en la función es una variable local nueva|- El parámetro en la función es un alias para el argumento original|
|- Cambios en el parámetro no afectan al argumento original|- Cambios en el parámetro afectan directamente al argumento original|
|- Garantiza la inmutabilidad del argumento original dentro de la función|- Permite modificar el valor del argumento original desde dentro de la función|
|**Propiedades**||
|Hace una copia de datos|No hace una copia de datos|
|Impide modificar el original|Permite modificar el original|
|Alto uso de memoria|Menor uso de memoria|
|Mayor protección de los datos|Datos más expuestos|

## ¿Para qué?

- **Adaptabilidad del software**: Permite que los programas se adapten a diferentes entradas y situaciones.
- **Reutilización de código**: Facilita la creación de funciones genéricas que pueden usarse en múltiples contextos.
- **Gestión eficiente de recursos**: Proporciona mecanismos para optimizar el uso de memoria y tiempo de ejecución.
- **Mejora de la calidad del software**: Contribuye a la creación de código más robusto, mantenible y fácil de entender.
- **Soporte para diferentes paradigmas de programación**: Facilita la implementación de conceptos en programación funcional, orientada a objetos y otros paradigmas.

|Propósito general|Paso por valor|Paso por referencia|
|-|-|-|
|**Flexibilidad en el diseño de software**|**Encapsulación y protección de datos**|**Eficiencia en el manejo de datos**|
|- Permite crear funciones y métodos versátiles|- Asegura que los datos originales no sean modificados accidentalmente|- Permite trabajar con grandes estructuras de datos sin copiarlas|
|- Facilita la reutilización de código|- Promueve la creación de funciones puras y predecibles|- Reduce el uso de memoria en operaciones con datos complejos|
|**Modularidad del código**|**Simplicidad y claridad del código**|**Capacidad de modificación directa**|
|- Permite dividir problemas complejos en partes manejables|- Hace que el flujo de datos sea más fácil de seguir y entender|- Permite que las funciones modifiquen directamente los datos originales cuando es necesario|
|- Mejora la organización y mantenimiento del software|- Reduce la complejidad al limitar el alcance de los cambios|- Facilita la implementación de algoritmos que requieren modificaciones in-situ|
|**Abstracción de la implementación**|**Seguridad en operaciones críticas**|**Rendimiento en operaciones complejas**|
|- Oculta los detalles internos de las funciones|- Previene modificaciones no intencionales en datos sensibles|- Mejora la velocidad de ejecución en operaciones con estructuras de datos grandes|
|- Permite cambiar la implementación sin afectar al código que la usa|- Ayuda a mantener la integridad de los datos en sistemas críticos|- Optimiza el uso de recursos en aplicaciones de alto rendimiento|
|**Comunicación entre componentes del programa**|**Facilita el razonamiento sobre el código**|**Permite compartir estado entre funciones**|
|- Permite el intercambio de información entre diferentes partes del programa|- Hace que el comportamiento de las funciones sea más predecible|- Facilita la implementación de algoritmos que requieren acceso compartido a datos|
|- Facilita la integración de diferentes módulos o librerías|- Simplifica el proceso de debugging y testing|- Permite una comunicación más directa entre diferentes partes del programa|

## ¿Cómo?
Entendido. Vamos a enfocar la sección "¿Cómo?" específicamente en Java, ya que es el lenguaje que quieres utilizar para explicar estos conceptos. Aquí tienes una versión revisada:

# Paso de parámetros en Java

## ¿Cómo?

<table>
  <thead>
    <tr>
      <th>Aspecto</th>
      <th>Paso por valor</th>
      <th>Paso por referencia (simulado)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Comportamiento en Java</strong></td>
      <td>Todos los parámetros en Java se pasan por valor</td>
      <td>Java simula paso por referencia con objetos</td>
    </tr>
    <tr>
      <td><strong>Tipos primitivos</strong></td>
      <td>

```java
void incrementar(int x) {
    x++;
    // x local se incrementa, el original no cambia
}

int a = 5;
incrementar(a);
// a sigue siendo 5

```

</td>
<td>No aplicable para tipos primitivos en Java</td>
</tr>
<tr>
<td><strong>Objetos</strong></td>
<td>

```java
void modificar(StringBuilder sb) {
        sb = new StringBuilder("Nuevo");
        // La referencia local cambia, la original no
    }
    StringBuilder str = new StringBuilder("Original");
    modificar(str);
    // str sigue siendo "Original"
```

</td>
<td>

```java

void modificar(StringBuilder sb) {
    sb.append(" Modificado");
    // El objeto original se modifica
}

StringBuilder str = new StringBuilder("Original");
modificar(str);
// str ahora es "Original Modificado"

```
</td>
</tr>
    <tr>
      <td><strong>Arrays</strong></td>
      <td>Los arrays se pasan por valor, pero el valor es una referencia al array</td>
      <td>

```java
void modificarArray(int[] arr) {
    arr[0] = 100;
    // El array original se modifica
}

int[] numeros = {1, 2, 3};
modificarArray(numeros);
// numeros[0] ahora es 100

```
</td>
</tr>
<tr>
<td><strong>Objetos inmutables</strong></td>
<td>

```java
void modificar(String s) {
    s = s + " Mundo";
    // Crea un nuevo objeto String, el original no cambia
}

String str = "Hola";
modificar(str);
// str sigue siendo "Hola"
```
</td>
<td>No aplicable para objetos inmutables como String</td>
</tr>
</tbody>
</table>

**Consideraciones adicionales en Java:**

1. **Paso de objetos grandes:**
   ```java
   public void procesarObjeto(GranObjeto obj) {
       // obj es una referencia, no hay copia del objeto grande
       obj.hacerAlgo();
   }
   ```

2. **Uso de la palabra clave `final` para parámetros:**
   ```java
   public void metodoSeguro(final int x, final StringBuilder sb) {
       x = 10; // Error de compilación
       sb.append("Texto"); // Permitido, el objeto puede modificarse
       sb = new StringBuilder(); // Error de compilación
   }
   ```

3. **Simulación de paso por referencia para tipos primitivos:**
   ```java
   public class Contenedor<T> {
       public T valor;
       public Contenedor(T valor) { this.valor = valor; }
   }

   public void incrementar(Contenedor<Integer> c) {
       c.valor++;
   }

   Contenedor<Integer> cont = new Contenedor<>(5);
   incrementar(cont);
   // cont.valor ahora es 6
   ```

4. **Paso de métodos como parámetros (usando interfaces funcionales):**
   ```java
   interface Operacion {
       int aplicar(int x);
   }

   public void procesarArray(int[] arr, Operacion op) {
       for (int i = 0; i < arr.length; i++) {
           arr[i] = op.aplicar(arr[i]);
       }
   }

   int[] numeros = {1, 2, 3, 4, 5};
   procesarArray(numeros, x -> x * 2);
   // numeros ahora es {2, 4, 6, 8, 10}
   ```

5. **Manejo de excepciones en métodos:**
   ```java
   public void metodoConExcepcion(String input) throws IllegalArgumentException {
       if (input == null || input.isEmpty()) {
           throw new IllegalArgumentException("Input no puede ser nulo o vacío");
       }
       // Procesar input
   }
   ```
