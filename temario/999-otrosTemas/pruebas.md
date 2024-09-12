# Pruebas

## [¿Por qué?](https://www.youtube.com/watch?v=981Pl9-pCLQ)

En la programación, prever y manejar adecuadamente los errores es fundamental para asegurar la robustez y fiabilidad de un software. Los errores no manejados pueden causar comportamientos inesperados, fallas en la aplicación e incluso la terminación abrupta del programa. Por lo tanto, comprender y aplicar correctamente las técnicas de gestión de errores es crucial tanto para los desarrolladores novatos como para los experimentados.

La gestión de errores permite a los desarrolladores controlar el flujo del programa y tomar medidas correctivas cuando ocurren situaciones inesperadas. Esto es especialmente importante en aplicaciones que interactúan con recursos externos como bases de datos, archivos o redes, donde las posibilidades de encontrar condiciones inesperadas son altas.

## ¿Qué?

En Java, hay varias maneras de manejar errores, pero dos de las más comunes son assert y los bloques try-catch-finally.

|||
|-|-|
|[assert](https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html)|Utilizado principalmente durante el desarrollo y la fase de pruebas. Las aserciones son afirmaciones que el programa verifica en tiempo de ejecución. Si la condición de una aserción es falsa, el sistema arroja un error de AssertionError, indicando que algo en el código no está funcionando como se esperaba.
|try-catch-finally|Es un mecanismo para capturar y manejar [excepciones](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html), que son problemas que ocurren durante la ejecución del programa. Los bloques try-catch permiten definir un segmento de código para 'intentar' (try) ejecutar y capturar excepciones específicas que puedan surgir, manejándolas adecuadamente en el bloque 'catch'.

## ¿Para qué?

|||
|-|-|
Assert|Se utiliza para validar suposiciones hechas por el programador durante el desarrollo. Es una herramienta de depuración que ayuda a identificar y corregir errores de lógica interna. Sin embargo, las aserciones no deben usarse para reemplazar el manejo de errores en situaciones que puedan surgir en un entorno de producción.
Try-Catch|Es fundamental para la gestión de errores en tiempo de ejecución. Se utiliza para manejar excepciones de manera que el programa pueda continuar o cerrarse de manera controlada. Permite a los desarrolladores escribir código que es resistente a fallos y capaz de manejar situaciones imprevistas, como entradas de usuario incorrectas, fallas en la conexión a bases de datos, o errores al leer/escribir archivos.

## ¿Cómo?

### Assert

Debe ser utilizado en situaciones donde el desarrollador está seguro de que algo debe ser cierto. Por ejemplo, para verificar que un valor no sea nulo después de una operación que, según la lógica del programa, no debería producir nulos. Las aserciones se activan con la JVM usando la opción -ea (enable assertions).

```java
public void calcular(int numero) {
    assert numero > 0 : "El número debe ser positivo";
    // Resto del código
}
```

### Try-Catch

Se debe emplear en segmentos de código donde se anticipan posibles excepciones, como entrada/salida de datos, parsing de números, conexiones a bases de datos, entre otros. El bloque 'try' encierra el código que puede generar la excepción, mientras que el bloque 'catch' define cómo manejarla.

```java

try {
    File file = new File("archivo.txt");
    FileReader fr = new FileReader(file);
    // Resto del código que permite leer archivo
} catch (FileNotFoundException e) {
    System.out.println("Archivo no encontrado: " + e.getMessage());
}
```
