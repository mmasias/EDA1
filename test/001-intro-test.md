# Test: Introducción y Fundamentos

**Tema:** Primitivas, Referencias, Estructuras de Datos y Operaciones Básicas
**Número de preguntas:** 10
**Tiempo estimado:** 15-20 minutos

---

## Pregunta 1
**¿Cuál es la diferencia fundamental entre una variable de tipo primitivo y una variable de tipo referencia (objeto)?**

A) Las primitivas son más rápidas, las referencias son más lentas
B) Las primitivas almacenan el valor directamente, las referencias almacenan una dirección de memoria
C) Las primitivas son inmutables, las referencias son mutables
D) Las primitivas solo pueden ser números, las referencias pueden ser texto

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Las variables primitivas almacenan **directamente el valor** en la dirección de memoria asignada, mientras que las variables de tipo referencia (objetos, arrays, String) almacenan una **dirección de memoria** que apunta al objeto real.

```java
int precio = 568;          // Almacena directamente 568
String texto = "Hola";     // Almacena dirección → 0x7C000000 → "Hola"
```

| Variable | Dirección/Ref | Valor |
|----------|---------------|-------|
| precio | 0x7C000000 | 568 |
| texto | 0x7C000900 | 0x7C000000 → "Hola" |

</details>

---

## Pregunta 2
**¿Cuál es la principal diferencia entre String y StringBuilder en Java?**

A) String es para texto corto, StringBuilder para texto largo
B) String es inmutable, StringBuilder es mutable
C) String funciona solo con letras, StringBuilder con cualquier carácter
D) String es más rápido que StringBuilder siempre

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia fundamental es la **mutabilidad**:

- **String:** Inmutable - cada operación crea un nuevo objeto
- **StringBuilder:** Mutable - las operaciones modifican el objeto existente

```java
// String - cada concatenación crea un nuevo objeto
String s = "Hola";
s = s + " Mundo";  // Se crea un nuevo String, el original "Hola" queda en memoria

// StringBuilder - modifica el mismo objeto
StringBuilder sb = new StringBuilder("Hola");
sb.append(" Mundo");  // Modifica el objeto existente
```

**Implicación práctica:** En bucles con muchas concatenaciones, StringBuilder es más eficiente porque no crea múltiples objetos intermedios.

</details>

---

## Pregunta 3
**¿Qué sucede cuando ejecutamos el siguiente código?**

```java
String s = "Hola";
s.toUpperCase();
System.out.println(s);
```

A) Imprime "HOLA" porque toUpperCase() modifica el String
B) Imprime "Hola" porque String es inmutable y no se guardó el resultado
C) Da error de compilación
D) Imprime "hola" en minúsculas

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** String es **inmutable**, por lo que `toUpperCase()` NO modifica el objeto original, sino que **retorna un nuevo String**. Como no guardamos ese resultado, se pierde.

```java
// ❌ Incorrecto - el resultado se pierde
String s = "Hola";
s.toUpperCase();
System.out.println(s);  // Imprime "Hola"

// ✅ Correcto - guardamos el resultado
String s = "Hola";
s = s.toUpperCase();
System.out.println(s);  // Imprime "HOLA"
```

</details>

---

## Pregunta 4
**¿Qué imprime el siguiente código y por qué?**

```java
Integer a = 10;
Integer b = 10;
System.out.println(a == b);

Integer c = 1000;
Integer d = 1000;
System.out.println(c == d);
```

A) true, true - porque los valores son iguales
B) false, false - porque son objetos diferentes
C) true, false - por el pool de Integer de Java (-128 a 127)
D) false, true - por optimización del compilador

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** Java mantiene un **pool (caché) de objetos Integer** para valores entre **-128 y 127** por optimización. Para valores en este rango, se reutiliza el mismo objeto; fuera de este rango, se crean nuevos objetos.

```java
Integer a = 10;    // Usa objeto del pool
Integer b = 10;    // Usa el MISMO objeto del pool
a == b            // true - misma referencia

Integer c = 1000;  // Crea nuevo objeto
Integer d = 1000;  // Crea OTRO nuevo objeto
c == d            // false - referencias diferentes
```

**Lección:** Para comparar valores de objetos, usar `.equals()`, no `==`.

</details>

---

## Pregunta 5
**¿Cuáles son las operaciones básicas CRUD sobre estructuras de datos?**

A) Copy, Read, Update, Delete
B) Create, Remove, Update, Display
C) Create, Read, Update, Delete
D) Copy, Retrieve, Upload, Delete

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** CRUD son las siglas de las operaciones fundamentales que se realizan sobre estructuras de datos:

- **C**reate (Crear/Insertar): Añadir nuevos elementos
- **R**ead (Leer/Consultar): Acceder a elementos existentes
- **U**pdate (Actualizar): Modificar elementos existentes
- **D**elete (Eliminar): Remover elementos

Estas operaciones son universales y aplican a listas, pilas, colas, árboles, bases de datos, etc.

</details>

---

## Pregunta 6
**En el contexto de concatenación de cadenas en un bucle, ¿cuándo deberíamos usar StringBuilder en lugar de String?**

A) Siempre, StringBuilder es mejor en todos los casos
B) Cuando concatenamos muchas veces dentro de un bucle
C) Solo cuando el texto tiene más de 100 caracteres
D) Nunca, String es suficiente para todo

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** StringBuilder es preferible cuando realizamos **concatenaciones repetitivas** (especialmente en bucles), porque:

```java
// ❌ Con String - crea 1000 objetos intermedios
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado += i;  // Cada += crea un nuevo String
}

// ✅ Con StringBuilder - modifica el mismo objeto
StringBuilder resultado = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    resultado.append(i);  // Modifica el objeto existente
}
```

Para concatenaciones simples (`"Hola" + " " + "Mundo"`), String es perfectamente válido y más legible.

</details>

---

## Pregunta 7
**¿Qué diferencia hay entre estos dos casos de asignación de String?**

```java
String a = "Hola";
String b = "Hola";

String c = new String("Hola");
String d = new String("Hola");
```

A) No hay diferencia, todos apuntan al mismo objeto
B) a y b apuntan al pool de Strings, c y d son objetos nuevos
C) a y b son más rápidos, c y d usan más memoria
D) B y C son correctas

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: D**

**Explicación:** Java mantiene un **String pool** para literales:

```java
String a = "Hola";          // Usa el pool
String b = "Hola";          // Reutiliza del pool
a == b                      // true - misma referencia

String c = new String("Hola");  // Crea nuevo objeto explícitamente
String d = new String("Hola");  // Crea otro nuevo objeto
c == d                          // false - objetos diferentes
```

| Variable | Dirección/Ref | Apunta a |
|----------|---------------|----------|
| | 0x7C000000 | "Hola" (pool) |
| a | 0x7C000900 | 0x7C000000 |
| b | 0x7C009999 | 0x7C000000 |
| | 0x7C008888 | "Hola" (heap) |
| c | 0x7C066666 | 0x7C008888 |
| | 0x7C007777 | "Hola" (heap) |
| d | 0x7C055555 | 0x7C007777 |

**Buena práctica:** Usar literales (`"Hola"`) en lugar de `new String("Hola")`.

</details>

---

## Pregunta 8
**¿Qué son las estructuras de datos?**

A) Solo arrays y matrices
B) Formas de organizar y almacenar datos para acceso y modificación eficientes
C) Únicamente listas, pilas y colas
D) Clases especiales del lenguaje Java

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Una **estructura de datos** es una forma particular de organizar y almacenar datos en una computadora para que puedan ser accedidos y modificados de manera eficiente.

**Propósitos:**
- **Organizar datos** según necesidades específicas
- **Eficiencia** en operaciones de búsqueda, inserción y eliminación
- **Flexibilidad** para adaptarse a diferentes escenarios
- **Abstracción** de los detalles de implementación

**Ejemplos:** Arrays, Listas, Pilas, Colas, Árboles, Grafos, Mapas, Conjuntos, etc.

Las estructuras de datos no son exclusivas de Java; son conceptos universales en programación.

</details>

---

## Pregunta 9
**Cuando pasamos un objeto como parámetro a un método en Java, ¿qué se pasa realmente?**

A) Una copia del objeto completo
B) La referencia (dirección de memoria) al objeto
C) Solo los atributos primitivos del objeto
D) Depende del tamaño del objeto

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** En Java, cuando pasamos un objeto a un método, se pasa **la referencia** (dirección de memoria), no una copia del objeto.

```java
public class Ejemplo {
    static class Persona {
        String nombre;
        Persona(String nombre) { this.nombre = nombre; }
    }

    static void cambiarNombre(Persona p) {
        p.nombre = "Nuevo";  // Modifica el objeto original
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Original");
        cambiarNombre(persona);
        System.out.println(persona.nombre);  // Imprime "Nuevo"
    }
}
```

**Importante:** Aunque se pasa la referencia, Java es **"pass-by-value"** de la referencia (se pasa una copia de la dirección, no se puede cambiar a qué objeto apunta la referencia original desde el método).

</details>

---

## Pregunta 10
**¿Por qué son importantes las estructuras de datos en programación?**

A) Solo para aprobar exámenes de algoritmos
B) Porque influyen significativamente en la eficiencia y funcionalidad del programa
C) Para hacer el código más largo y complejo
D) Solo son útiles en aplicaciones muy grandes

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Las estructuras de datos son fundamentales porque:

1. **Eficiencia:** La elección correcta puede hacer la diferencia entre un programa rápido y uno lento
2. **Organización:** Permiten estructurar información de forma lógica y accesible
3. **Escalabilidad:** Facilitan el manejo de grandes volúmenes de datos
4. **Funcionalidad:** Algunas operaciones solo son posibles con ciertas estructuras
5. **Mantenibilidad:** Código mejor organizado es más fácil de entender y mantener

**Ejemplo real:** Un sistema de navegación GPS necesita grafos para calcular rutas óptimas; sin la estructura adecuada, sería imposible encontrar el camino más corto entre dos puntos eficientemente.

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de fundamentos
- **7-9 respuestas correctas:** Buen entendimiento, revisar conceptos específicos
- **5-6 respuestas correctas:** Comprensión básica, se recomienda repasar
- **Menos de 5 correctas:** Es necesario revisar el tema completo

## Temas Clave Evaluados

1. ✓ Primitivos vs referencias
2. ✓ String vs StringBuilder (inmutabilidad)
3. ✓ Inmutabilidad de String
4. ✓ Integer pool en Java (-128 a 127)
5. ✓ Operaciones CRUD
6. ✓ Cuándo usar StringBuilder
7. ✓ String pool vs new String()
8. ✓ Concepto de estructuras de datos
9. ✓ Paso de parámetros (referencias)
10. ✓ Importancia de las estructuras de datos
