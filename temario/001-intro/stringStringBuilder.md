# String vs StringBuilder

## ¿Por qué?

|String|StringBuilder|
|-|-|
|**Inmutabilidad**|**Mutabilidad**|
|- Diseñado para seguridad en operaciones con cadenas|- Creado para mejorar el rendimiento en manipulaciones de cadenas|
|- Útil cuando el valor de la cadena no debe cambiar|- Útil cuando se necesitan modificaciones frecuentes de la cadena|
|**Concurrencia**|**Eficiencia**|
|- Seguro para usar en entornos multi-hilo sin sincronización adicional|- Optimizado para operaciones que modifican la cadena repetidamente|
|- Ideal para almacenar información constante como nombres o identificadores|- Ideal para construir cadenas dinámicamente en bucles o concatenaciones complejas|

## ¿Qué?

|String|StringBuilder|
|-|-|
|Clase que representa una cadena de caracteres inmutable|Clase que representa una cadena de caracteres mutable|
|**Características fundamentales**||
|- Cada operación crea un nuevo objeto String|- Las operaciones modifican el objeto existente|
|- El contenido no puede ser cambiado después de la creación|- El contenido puede ser modificado en cualquier momento|
|- Almacenado en el pool de strings para optimización de memoria|- No se almacena en el pool de strings|
|- Thread-safe por diseño|- No es thread-safe (existe StringBuffer para uso en multi-hilo)|

## ¿Para qué?

|String|StringBuilder|
|-|-|
|**Almacenamiento de datos constantes**|**Manipulación dinámica de cadenas**|
|- Guardar información que no cambia, como nombres o códigos|- Construir cadenas que cambian frecuentemente|
|**Operaciones de comparación de cadenas**|**Concatenación eficiente de múltiples cadenas**|
|- Realizar comparaciones de igualdad o ordenamiento|- Unir muchas cadenas sin crear objetos intermedios|
|**Uso en estructuras de datos como clave**|**Generación de cadenas en tiempo de ejecución**|
|- Utilizar como clave en HashMap o HashSet|- Crear cadenas basadas en entrada del usuario o cálculos|

## ¿Cómo?

<table>
  <thead>
    <tr>
      <th>Aspecto</th>
      <th>String</th>
      <th>StringBuilder</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Creación</strong></td>
<td>

```java
    String s = "Hola";
```      

</td>
<td>

```java
    StringBuilder sb = new StringBuilder("Hola");
```

</td>
    </tr>
    <tr>
      <td><strong>Concatenación</strong></td>
<td>

```java
String s = "Hola";
s = s + " Mundo";
// Crea un nuevo objeto String
```

</td>
<td>

```java
StringBuilder sb = new StringBuilder("Hola");
sb.append(" Mundo");
// Modifica el mismo objeto
```

</td>
    </tr>
    <tr>
      <td><strong>Rendimiento en bucles</strong></td>
<td>

```java
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado += i;
    // Crea 1000 objetos String
}
```

</td>
<td>

```java
StringBuilder resultado = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    resultado.append(i);
    // Modifica el mismo objeto 1000 veces
}
```
</td>
    </tr>
    <tr>
      <td><strong>Inmutabilidad</strong></td>
<td>

```java
String s = "Hola";
s.toUpperCase();
System.out.println(s); // Imprime "Hola"
```
</td>
<td>

```java
StringBuilder sb = new StringBuilder("Hola");
sb.append(" Mundo");
System.out.println(sb); // Imprime "Hola Mundo"
```

</td>
</tr>
</tbody>
</table>

**Ejemplo comparativo:**

```java
public class StringVsStringBuilder {
    public static void main(String[] args) {
        
        long inicio = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s += "a";
        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo con String: " + (fin - inicio) + "ms");
        
        inicio = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("a");
        }
        fin = System.currentTimeMillis();
        System.out.println("Tiempo con StringBuilder: " + (fin - inicio) + "ms");
    }
}
```

Este ejemplo muestra la diferencia de rendimiento al concatenar una gran cantidad de caracteres, ilustrando por qué StringBuilder es preferible en operaciones intensivas de manipulación de cadenas.