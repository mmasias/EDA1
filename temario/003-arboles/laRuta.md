# Ruta

## Fundamentos del árbol genérico (no ordenado)

> Entender qué es un árbol, un nodo y cómo recorrerlo sin reglas de ordenación.

1. **El "Porqué"**
    - Leer las secciones `¿Por qué?`, `¿Qué?` y `¿Para qué?` del [**README principal de árboles**](temario/003-arboles/README.md).
    - **Meta:** Comprender la utilidad y el vocabulario básico (raíz, hoja, hijo, etc.).
1. **La clave**
    - Estudiar el fichero [**`ejemplo000/Node.java`**](/src/arboles/ejemplo000/Node.java).
    - **Meta:** Entender que un nodo es un contenedor de datos con referencias a otros nodos.
1. **Construcción I - Profundidad**
    - Leer el artículo [**`inserciones.md`**](temario/003-arboles/inserciones.md) (solo la sección de "Inserción por profundidad (DFS)").
    - Analizar el fichero [**`ejemplo000/Tree.java`**](/src/arboles/ejemplo000/Tree.java) para ver cómo se usa una **pila** para implementar esta estrategia.
1. **Visualización y recorrido**
    - Analizar el método `printTree()` en [**`ejemplo001/Tree.java`**](/src/arboles/ejemplo001/Tree.java).
    - Leer el artículo [**`recorridos.md`**](temario/003-arboles/recorridos.md) (sección de "Preorden").
    - **Meta:** Conectar la idea de `printTree` con un recorrido en **preorden** y entender cómo la pila lo hace posible. Ejecutar el ejemplo para verlo funcionar.
1. **Construcción II - Anchura**
    - Volver al artículo [**`inserciones.md`**](temario/003-arboles/inserciones.md) y leer la sección "Inserción por niveles (BFS)".
    - Analizar [**`ejemplo003/Tree.java`**](/src/arboles/ejemplo003/Tree.java) y comparar su método `insert` con el de `ejemplo000`.
    - **Meta:** Entender el impacto fundamental de cambiar una **pila (DFS)** por una **cola (BFS)**.

## **Fase 2: El árbol binario**

> Especializar el conocimiento hacia los árboles con un máximo de dos hijos.

1. **Especialización**
    - Leer la sección "Árboles Binarios" en el [**README principal**](temario/003-arboles/README.md).
    - Estudiar el fichero [**`ejemplo004/Node.java`**](/src/arboles/ejemplo004/Node.java).
    - **Meta:** Comprender la transición de un array de `children` a las referencias `left` y `right`.

## **Fase 3: Dominio del árbol binario de búsqueda (BST)**

> Entender la regla de ordenación y dominar las operaciones clave de un BST.

1. **Inserción ordenada**
    - Leer la sección "Inserción con criterio de ordenación (BST)" en [**`inserciones.md`**](temario/003-arboles/inserciones.md).
    - Analizar a fondo el método `insert()` en [**`ejemplo005/Tree.java`**](/src/arboles/ejemplo005/Tree.java).
    - **Meta:** Entender cómo la comparación `key < current.getKey()` guía la inserción. Este es el concepto central del BST.

2. **Recorridos en el BST**
    - Leer el artículo completo [**`recorridos.md`**](temario/003-arboles/recorridos.md). Poner especial atención a por qué el **inorden** es especial en un BST.
    - Estudiar los tres métodos `print...` en [**`ejemplo006/Tree.java`**](/src/arboles/ejemplo006/Tree.java).
    - **Meta:** Ejecutar el ejemplo y confirmar que `printInorder()` produce la secuencia ordenada.

3. **Búsqueda eficiente**
    - Leer el artículo [**`busqueda.md`**](temario/003-arboles/busqueda.md).
    - Analizar el método `search()` en [**`ejemplo007/Tree.java`**](/src/arboles/ejemplo007/Tree.java).
    - **Meta:** Ver cómo la misma lógica de la inserción permite encontrar elementos de forma muy rápida.

4. **Eliminación**
    - Leer con mucha atención el artículo [**`eliminacion.md`**](temario/003-arboles/eliminacion.md), asimilando los **tres casos** (hoja, un hijo, dos hijos).
    - Estudiar el método `delete()` en [**`ejemplo008/Tree.java`**](/src/arboles/ejemplo008/Tree.java), identificando en el código la lógica para cada uno de los tres casos.
    - **Práctica final:** Usar el menú interactivo de [**`ejemplo008`**](/src/arboles/ejemplo008/TreeSample.java) para probar todas las operaciones. Intentar provocar y resolver cada uno de los tres casos de eliminación.
