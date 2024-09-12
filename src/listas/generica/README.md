# Lista genérica

<div align=center>

||
|-|
![](/imagenes/modelosUML/listaGenerica.svg)

</div>

## Nodo: [clase GenericNode](/src/listas/generica/GenericNode.java)

Un nodo sabe quién es y el nodo que le sigue.

||||
|-|-|-|
|Constructor|`public GenericNode(String value) {}`
|Obtener dato|`public String getvalue() {}`
|Definir dato|`public void setValue(String newValue) {}`
|Devolver el siguiente|`public Node getNext() {}`
|Definir el siguiente|`public void setNext(Node next) {}`

## Lista: [clase List](/src/listas/generica/GenericList.java)

Una lista implementa métodos para gestionar los nodos (CRUD).

||||
|-|-|-|
|Constructor|∄ como tal.
|Número de nodos|`public int size() {}`
|Ver si está vacía|`public boolean isEmpty() {}`
|Insertar elemento|`public void insert(String value) {}`
|Eliminar elemento|`public void delete() {}`
|Listar los elementos|`public String[] listAll() {}`

## Implementación: [clase Ejemplo](/src/listas/generica/Ejemplo.java)

**NOTA:** Falla con la versión 11 del jdk