# EDA1

## [Temario](/temario/README.md)

- [x] [Estructuras de datos & conceptos fundamentales](temario/001-intro/primitivasMatricesClasesObjetos.md)
- [x] Secuencias
  - [x] [Listas](temario/002-00-listas/README.md)
  - [x] [Pilas](temario/002-01-pilas/README.md)
  - [x] [Colas](temario/002-02-colas/README.md)
- [x] [Árboles](temario/003-arboles/README.md)
- [ ] [Grafos](temario/004-grafos/README.md)
- [ ] [Ficheros](temario/005-ficheros/README.md)

## Jerarquía de estructuras de datos

Esta jerarquía muestra cómo las estructuras de datos más simples pueden verse como restricciones de estructuras más generales.

<table>
<tr>
<td><b>Grafo</b>: La estructura más general (Vértices y Aristas).</td>
<td rowspan="4">

![](/images/modelosUML/jerarquiaEstructuras.svg)
</td>
</tr>
<tr>
<td><b>Árbol</b>: Un grafo con restricciones (debe ser conexo y no tener ciclos).</td>
</tr>
<tr>
<td><b>Lista</b>: Un árbol degenerado donde cada nodo tiene como máximo 1 hijo (lineal).</td>
</tr>
<tr>
<td><b>Pila / Cola</b>: Listas con restricciones en el acceso a los datos (LIFO / FIFO).</td>
</tr>
</table>

## Lecturas complementarias

- Acerca de... : qué son, qué no son, qué saben, qué no saben...
  - [las listas](/temario/999-otrosTemas/acercaDeListas.md) / [las pilas](/temario/999-otrosTemas/acercaDePilas.md) / [las colas](/temario/999-otrosTemas/acercaDeColas.md)
  - [los árboles](/temario/999-otrosTemas/acercaDeArboles.md)
  - [los grafos](/temario/999-otrosTemas/acercaDeGrafos.md)
- [Breve intro a la recursividad](/temario/999-otrosTemas/recursividad.md)
- [Programación genérica](/temario/999-otrosTemas/programacionGenerica.md)
- [Pruebas & manejo de errores](/temario/999-otrosTemas/pruebas.md)
- Git et al...
