# Pruebas y manejo de errores

## [¿Por qué?](https://www.youtube.com/watch?v=981Pl9-pCLQ)

En la programación, prever y manejar adecuadamente los errores es fundamental para asegurar la robustez y fiabilidad de un software. Los errores no manejados pueden causar comportamientos inesperados, fallas en la aplicación e incluso la terminación abrupta del programa.

Sin embargo, no todos los errores son iguales ni deben manejarse de la misma manera. Distinguir entre errores de programación y situaciones impredecibles es crucial:

- **Errores de programación**: Violaciones de las reglas que el programador debe cumplir (precondiciones, invariantes, postcondiciones)
- **Situaciones impredecibles**: Condiciones externas que el programa debe manejar aunque estén fuera de su control

Esta distinción determina la responsabilidad: ¿es el código que usa una estructura quien debe garantizar las condiciones correctas, o es la estructura quien debe protegerse de cualquier uso incorrecto?

## ¿Qué?

|Aspecto|Assert (Error interno)|Try-Catch (Error externo)|
|-|-|-|
|**Naturaleza**|Error de programación|Error de ejecución por circunstancias externas
|**Detección**|Durante desarrollo/pruebas (con assertions habilitadas)|Durante la ejecución en cualquier momento
|**Recuperación**|No requiere recuperación en producción (no debería ocurrir)|Requiere plan de recuperación (valor por defecto, notificar usuario, etc.)
|**Responsabilidad**|Del código cliente (quien usa la estructura)|De la implementación (quien provee la funcionalidad)
|**Cuándo ocurre**|Cuando se violan precondiciones conocidas|Cuando factores externos causan problemas

En Java, hay dos mecanismos principales:

|||
|-|-|
|[assert](https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html)|Utilizado principalmente durante el desarrollo y la fase de pruebas. Las aserciones son afirmaciones que el programa verifica en tiempo de ejecución. Si la condición de una aserción es falsa, el sistema arroja un error de AssertionError, indicando que algo en el código no está funcionando como se esperaba.
|try-catch-finally|Mecanismo para capturar y manejar [excepciones](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html), que son problemas que ocurren durante la ejecución del programa. Los bloques try-catch permiten definir un segmento de código para 'intentar' (try) ejecutar y capturar excepciones específicas que puedan surgir, manejándolas adecuadamente en el bloque 'catch'.

## ¿Para qué?

|||
|-|-|
|**Assert**|Se utiliza para validar suposiciones hechas por el programador durante el desarrollo. Es una herramienta de depuración que ayuda a identificar y corregir errores de lógica interna. Las aserciones documentan y verifican el "contrato" que el código cliente debe cumplir.
|**Try-Catch**|Es fundamental para la gestión de errores en tiempo de ejecución. Se utiliza para manejar excepciones de manera que el programa pueda continuar o cerrarse de manera controlada. Permite a los desarrolladores escribir código que es resistente a fallos y capaz de manejar situaciones imprevistas, como entradas de usuario incorrectas, fallas en la conexión a bases de datos, o errores al leer/escribir archivos.

## ¿Cuándo usar cada uno?

### En estructuras de datos (Listas, Pilas, Colas)

Cuando implementamos estructuras de datos básicas, **el código cliente es responsable de verificar las precondiciones**:

```java
// USO CORRECTO: el cliente verifica antes de operar
Pila pila = new Pila();
// ...
if (!pila.estaVacia()) {
    int valor = pila.pop();  // Seguro, la precondición se cumple
}
```

**¿Por qué assertions y no try-catch?**

- El cliente puede y debe verificar `estaVacia()` antes de llamar a `pop()`
- Es un error de lógica de programación llamar a `pop()` en una pila vacía
- No es una situación impredecible, sino una violación de las reglas de uso

Ver implementaciones en:

- [Acerca de las listas](acercaDeListas.md)
- [Acerca de las pilas](acercaDePilas.md)
- [Acerca de las colas](acercaDeColas.md)

### En operaciones con recursos externos

Cuando trabajamos con archivos, red, bases de datos, **la implementación debe manejar situaciones impredecibles**:

```java
// Situación impredecible: el archivo puede no existir
try {
    File file = new File("archivo.txt");
    FileReader fr = new FileReader(file);
    // Leer archivo
} catch (FileNotFoundException e) {
    System.out.println("Archivo no encontrado: " + e.getMessage());
    // Plan de recuperación: usar valores por defecto, notificar, etc.
}
```

**¿Por qué try-catch y no assertions?**

- El cliente no puede garantizar que el archivo exista
- Es una situación externa e impredecible
- Requiere un plan de recuperación o alternativa

## ¿Cómo?

### Assert

Debe ser utilizado para verificar precondiciones, invariantes y postcondiciones que el programador controla. Las aserciones se activan con la JVM usando la opción `-ea` (enable assertions).

```java
public void procesarElemento(int posicion, int[] array) {
    assert array != null : "El array no puede ser null";
    assert posicion >= 0 : "La posición debe ser no negativa";
    assert posicion < array.length : "La posición está fuera de rango";
    
    // Procesar elemento en array[posicion]
}
```

**Características importantes**

- Solo activo durante desarrollo (con `-ea`)
- No debe usarse para validar entrada de usuario
- Documenta suposiciones del programador
- No afecta el rendimiento en producción (desactivadas por defecto)

### Try-Catch

Se debe emplear en segmentos de código donde se anticipan posibles situaciones externas impredecibles. El bloque 'try' encierra el código que puede generar la excepción, mientras que el bloque 'catch' define cómo manejarla.

```java
try {
    String contenido = leerArchivo("datos.txt");
    int numero = Integer.parseInt(contenido);
    // Procesar número
} catch (FileNotFoundException e) {
    System.out.println("Archivo no encontrado, usando valor por defecto");
    // Usar valor por defecto
} catch (NumberFormatException e) {
    System.out.println("Formato de número inválido");
    // Manejar formato incorrecto
}
```

**Características importantes**

- Siempre activo en tiempo de ejecución
- Debe usarse para situaciones que el programador no puede prevenir
- Permite definir plan de recuperación
- Tiene costo de rendimiento cuando ocurre la excepción

## Principio fundamental

<div align=center>

![](/images/modelosUML/errores.svg)

</div>

**Si el código cliente puede y debe verificar una condición antes de llamar a un método, usa `assert` dentro del método para documentar y verificar esa precondición.**

**Si una condición depende de factores externos que el cliente no puede controlar, usa `try-catch` para manejar la situación.**

Esta distinción mantiene la responsabilidad clara: el cliente es responsable de usar correctamente las estructuras de datos, mientras que las implementaciones son responsables de manejar situaciones impredecibles del mundo real.