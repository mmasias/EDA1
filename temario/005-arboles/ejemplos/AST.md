# Árbol de sintaxis abstracta

## Ejemplo 001

```java
public class Calculator {
    public double calculateDiscount(double price, int customerLevel) {
        if (customerLevel > 5) {
            return price * 0.2;
        } else {
            return price * 0.1;
        }
    }
}

```
<div align=center>

|![](/images/modelosUML/arboles/ejemplosPower/AST/AST001.svg)
|:-:
|[Código fuente en PlantUML](/modelosUML/arboles/ejemplosPower/AST/AST001.puml)

</div>

## Ejemplo 002

```java
public class NumberGuessGame {
    public void playGame() {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;
        
        while (attempts > 0) {
            System.out.println("Introduce un número (1-100):");
            int guess = scanner.nextInt();
            
            if (guess == secretNumber) {
                System.out.println("¡Has ganado!");
                return;
            } else if (guess < secretNumber) {
                System.out.println("El número es mayor");
            } else {
                System.out.println("El número es menor");
            }
            attempts--;
        }
        System.out.println("¡Game Over! El número era " + secretNumber);
    }
}
```

<div align=center>

|![](/images/modelosUML/arboles/ejemplosPower/AST/AST002.svg)
|:-:
|[Código fuente en PlantUML](/modelosUML/arboles/ejemplosPower/AST/AST002.puml)

</div>

## Ejemplo 003

[🧍🏻🐒](https://github.com/puntoReflex/.github/blob/c782ee4398381e6795f39ac2391c3f2720d6ee73/retos%26proyectos/viajeMarco/src/vPRG1/Marco.java)

<div align=center>

|![](/images/modelosUML/arboles/ejemplosPower/AST/AST003.svg)
|:-:
|[Código fuente en PlantUML](/modelosUML/arboles/ejemplosPower/AST/AST003.puml)

</div>

## Reflexión

Las forma de construir todas estas relaciones de un árbol AST en PlantUML recuerdan a instrucciones de ensamblador por varias razones...

### Son instrucciones lineales y secuenciales

|Definición de relaciones en PlantUML|Ensamblador|
|-|-|
|`cu --> pkg`|`MOV pkg, cu`|
|`cu --> imp`|`MOV imp, cu`|
|`cu --> cd`|`MOV cd, cu`|
|`cd --> c`|`MOV c, cd`|

### Las operaciones matemáticas se descomponen en operaciones básicas

|Definición en PlantUML|Ensamblador|
|-|-|
|`add1 --> mult1`|`MUL rand1, num9, mult1  ; multiplica random * 5`|
|`mult1 --> rand1`|`ADD mult1, num10, add1  ; suma el resultado + 10`|
|`mult1 --> num9`||
|`add1 --> num10`||

### Las asignaciones y movimientos de datos

|Asignación en PlantUML|Ensamblador|
|-|-|
|`wb --> assign10`    |`MOV velRef2, R1        ; carga primer operando`|
|`assign10 --> mult4` |`MOV velChRef1, R2      ; carga segundo operando`|
|`mult4 --> velRef2`  |`MUL R1, R2             ; multiplica`|
|`mult4 --> velChRef1`|`MOV R1, assign10       ; guarda resultado`|

### Los saltos condicionales

|Condiciones en PlantUML|Ensamblador|
|-|-|
|`if1 --> cond1`|`CMP rainRef1, hardRainRef1 ; compara valores`|
|`cond1 --> lte1`|`JLE true_block             ; salta si menor o igual`|
|`lte1 --> rainRef1`|`JMP else_block             ; sino, salta al else`|
|`lte1 --> hardRainRef1`|

Incluso las estructuras de datos más complejas se pueden reducir a operaciones simples de 'conecta esto con aquello', similar a cómo todo programa, sin importar su complejidad, se reduce eventualmente a simples movimientos de datos en el procesador.

1. El AST es una representación intermedia que luego se usará para generar código
1. Las relaciones del AST muestran el flujo de datos de manera explícita
1. Cada operación compleja se descompone en operaciones más simples
1. El orden de las operaciones es crítico y debe ser preservado
1. Los accesos a memoria (variables) están explícitamente marcados

De hecho, muchos compiladores usan el AST como paso intermedio para generar código de tres direcciones o IR (Intermediate Representation), que luego se traduce casi directamente a ensamblador. Es por eso que vemos esta similitud estructural.

## ToDo

Convierta en árbol

### Uno

<details>
<summary>

```java
x = 5 + 3 * 2
```
</summary>

![](/images/modelosUML/arboles/ejemplosPower/AST/astUno.svg)

</details>

### Dos

<details>
<summary>

```java
if (x > 0) {
    return x;
} else {
    return -x;
}
```
</summary>

![](/images/modelosUML/arboles/ejemplosPower/AST/astDos.svg)

</details>


### Tres

<details>
<summary>

```java
while (i < 10) {
    sum = sum + i;
    i = i + 1;
}
```
</summary>

![](/images/modelosUML/arboles/ejemplosPower/AST/astTres.svg)

</details>