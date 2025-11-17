# 🚬🌲

Supongamos un árbol conformado por [nodos](ejemplo000/Node.java) que admiten conectarse con otros tres nodos.

Hará falta un [Tree](ejemplo000/Tree.java) que gestione lo que ocurre con el árbol. Lo primero será **agregar elementos** ([ejemplo000](ejemplo000/)), pero surge la pregunta: ¿dónde los insertamos? ¿Llenamos en profundidad o por niveles? ¿Con qué criterio?

Una vez insertados, necesitaremos **visualizar** el árbol ([ejemplo001](ejemplo001/)) para entender qué estructura hemos creado.

Descubriremos que el **criterio de inserción** ([ejemplo003](ejemplo003/), [ejemplo005](ejemplo005/)) y el número de hijos ([ejemplo004](ejemplo004/)) determinan las propiedades del árbol: balanceo, ordenación, eficiencia de búsqueda.

Luego exploraremos diferentes formas de **recorrer** un árbol ([ejemplo006](ejemplo006/)), cada una con propósitos diferentes.

Veremos cómo **buscar** eficientemente ([ejemplo007](ejemplo007/)) en un BST aprovechando su ordenación.

Finalmente enfrentaremos el desafío de **eliminar** nodos ([ejemplo008](ejemplo008/)) manteniendo las propiedades del árbol.

|Ejemplo|Descripción|
|-|-|
|**[ejemplo000](ejemplo000/)**| Inserción simple por profundidad (DFS): cuando se llena un nodo, se le crea un hijo. Árbol de 3 hijos. Sin validación de centinela (-1). Solo visualización con depurador. |
|**[ejemplo001](ejemplo001/)**| Igual que ejemplo000 pero añade impresión iterativa del árbol con indentación por niveles. |
|**[ejemplo002](ejemplo002/)**| Igual que ejemplo001 pero valida el centinela: el valor -1 no se inserta en el árbol. |
|**[ejemplo003](ejemplo003/)**| Inserción por niveles (BFS): llena nivel por nivel, de izquierda a derecha. Árbol balanceado de 3 hijos. |
|**[ejemplo004](ejemplo004/)**| Árbol binario simple (2 hijos): inserción por niveles sin criterio de ordenación. Introduce conceptos de izquierda/derecha. |
|**[ejemplo005](ejemplo005/)**| Binary Search Tree (BST): inserción con criterio de comparación. Menores a la izquierda, mayores a la derecha. Duplicados ignorados. |
|**[ejemplo006](ejemplo006/)**| BST con recorridos iterativos: preorden (raíz-izq-der), inorden (izq-raíz-der), postorden (izq-der-raíz). El recorrido inorden muestra valores ordenados. |
|**[ejemplo007](ejemplo007/)**| BST con búsqueda iterativa: búsqueda eficiente O(log n) aprovechando el ordenamiento del árbol. Permite buscar valores sin recorrer todos los nodos. |
|**[ejemplo008](ejemplo008/)**| BST con eliminación iterativa: elimina nodos manejando los 3 casos (hoja, un hijo, dos hijos). Usa estrategia del sucesor inorden. Interfaz interactiva para insertar, buscar y eliminar. |

## Notas

- Progresión diseñada para aprender gradualmente: DFS → BFS → Binario → BST → Recorridos → Búsqueda → Eliminación
- Para entender cómo las **políticas de inserción** afectan la forma y eficiencia del árbol, consulta la [teoría sobre inserciones](/temario/003-arboles/inserciones.md#políticas-de-inserción)
- Para conocer las **aplicaciones prácticas** de cada tipo de recorrido, consulta la [teoría sobre recorridos](/temario/003-arboles/recorridos.md#aplicaciones-prácticas)
- Para comprender la **eficiencia de la búsqueda** en diferentes tipos de árboles, consulta la [teoría sobre búsqueda](/temario/003-arboles/busqueda.md#comparación-de-eficiencias)
- Para entender los **3 casos de eliminación** y la estrategia del sucesor inorden, consulta la [teoría sobre eliminación](/temario/003-arboles/eliminacion.md#los-tres-casos)

## Material obsoleto

La carpeta `zzz-deprecated/` contiene código antiguo que ha sido superado por los ejemplos actuales:

- `insertSample/` - Reemplazado por ejemplo006
- `recorridos/` - Versiones recursivas, reemplazadas por ejemplo006 iterativo
- `btree/` - B-Tree avanzado, fuera del alcance de esta progresión básica
