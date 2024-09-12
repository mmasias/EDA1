# Lista básica

<div align=center>

||
|-|
![](/imagenes/modelosUML/listaBasica.svg)

</div>

## Nodo: [clase Node](/src/listas/basica/Node.java)

Un nodo sabe quién es y el nodo que le sigue.

<div align=center>

||||
|-|-|-|
|Constructor|`public Node(String value) {}`
|Obtener dato|`public String getvalue() {}`
|Definir dato|`public void setValue(String newValue) {}`
|Devolver el siguiente|`public Node getNext() {}`
|Definir el siguiente|`public void setNext(Node next) {}`

</div>

## Lista: [clase List](/src/listas/basica/List.java)

Una lista implementa métodos para gestionar los nodos (CRUD).

<div align=center>

||||
|-|-|-|
|Constructor|∄ como tal.
|Número de nodos|`public int size() {}`
|Ver si está vacía|`public boolean isEmpty() {}`
|Insertar elemento|`public void insert(String value) {}`
|Eliminar elemento|`public void delete() {}`
|Listar los elementos|`public String[] listAll() {}`

</div>

## Implementación: [clase Ejemplo](/src/listas/basica/Ejemplo.java)

```
┏[manuel]--[main ≡]
┖[~/misRepos/23-24-eda1]java listas.generica.Ejemplo 
LA LISTA------------------
Juanito
Pepito
Anita
Luisito
-------------------------
PRIMERO:Juanito
ULTIMO :Luisito
LA LISTA------------------
5
6
7
8
-------------------------
PRIMERO:5
ULTIMO :8
┏[manuel]--[main ≡]
┖[~/misRepos/23-24-eda1]
```

### Reflexiones alrededor de la implementación en Python

Respetando el modelo anteriormente planteado

<div align=center>

|Elemento|vFormal|vMugre|
|-|-|-|
Nodo|[Código](/src/listas/basica/vPython/Node_formal.py)|[Código](/src/listas/basica/vPython/Node_mugre.py)
Lista|[Código](/src/listas/basica/vPython/List_formal.py)|[Código](/src/listas/basica/vPython/List_mugre.py)
Ejemplo|[Código](/src/listas/basica/vPython/Ejemplo_formal.py)|[Código](/src/listas/basica/vPython/Ejemplo_mugre.py)

</div>

### Reflexiones alrededor de la implementación en Javascript

Lo mismo, respetando el modelo anteriormente planteado

<div align=center>

|Elemento|vFormal|vMugre|
|-|-|-|
Nodo|[Código](/src/listas/basica/vJavascript/Node_formal.js)|[Código](/src/listas/basica/vJavascript/Node_mugre.js)
Lista|[Código](/src/listas/basica/vJavascript/List_formal.js)|[Código](/src/listas/basica/vJavascript/List_mugre.js)
Ejemplo|[Código](/src/listas/basica/vJavascript/Ejemplo_formal.js)|[Código](/src/listas/basica/vJavascript/Ejemplo_mugre.js)

</div>