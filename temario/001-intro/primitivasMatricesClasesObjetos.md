# Primitivas, matrices, clases & objetos

## Tipos primitivos

Recordemos el concepto de variables [visto en Programación 1](https://github.com/mmasias/23-24-prg1/blob/main/temario/variables.md)

|Tipos primitivos|
|-|
<img src="https://raw.githubusercontent.com/mmasias/23-24-prg1/e6aa945f3bbb90999a22d0894d17f021309bb156/imagenes/modelosUML/tiposPrimitivos.svg" />

---

- Declarar una variable de tipo primitivo implica:
  1. Reservar una dirección en memoria.
  1. Reservar los bytes en función al tipo.

<div align=center>

|Variable|Dirección/Ref|Valor|
|-|-|-|
precio|0x7C000000|568
copiaPrecio|0x7C000008|568

</div>

## Datos estructurados


- Varios datos por **elemento**: *arrays* (recordar que *String* es un array de *char*), *clases*, estructuras, conjuntos.
- Aquí las variables guardan una dirección (o referencia), no un valor.

### Strings, matrices, clases & objetos...

```java
String cadenaTexto = "Una cadena";
String otraCadena = cadenaTexto;
String terceraCadena = "Una cadena";
```

<div align=center>

|Variable|Dirección/Ref|Valor|
|-|:-:|:-:|
||0x7C000000|"Una cadena"|
cadenaTexto|0x7C000900|0x7C000000
otraCadena|0x7C009999|0x7C000000
||0x7C008888|"Una cadena"|
terceraCadena|0x7C066666|0x7C008888
</div>

### Prácticum

Lo mejor es verlo y discutirlo en vivo, sobre uno o varios ejemplos.

<div align=center>

|Java|Python|JavaScript|PHP
|-|-|-|-|
|[Varias situaciones](/src/Tema001/Tema001.java)|[Ídem](/src/Tema001/Tema001.py)|[Ídem](/src/Tema001/Tema001.js)|[Ídem](/src/Tema001/Tema001.php)
[Array 2D, 🤔](/src/Tema001/Tema001Arrays2D.java)

</div>
