# 🚬🌲

Supongamos un árbol conformado por [nodos](ejemplo000/Node.java) que admiten conectarse con otros tres nodos.

Hará falta un [Tree](ejemplo000/Tree.java) que gestione lo que ocurre con el árbol. Lo primero será **agregar elementos** ([ejemplo000](ejemplo000/)), pero surge la pregunta: ¿dónde los insertamos? ¿Llenamos en profundidad o por niveles? ¿Con qué criterio?

Una vez insertados, necesitaremos **visualizar** el árbol ([ejemplo001](ejemplo001/)) para entender qué estructura hemos creado.

Descubriremos que el **criterio de inserción** ([ejemplo003](ejemplo003/), [ejemplo005](ejemplo005/)) y el número de hijos ([ejemplo004](ejemplo004/)) determinan las propiedades del árbol: balanceo, ordenación, eficiencia de búsqueda.

Finalmente veremos que hay múltiples formas de **recorrer** un árbol ([ejemplo006](ejemplo006/)), cada una con propósitos diferentes.

|Ejemplo|Descripción|
|-|-|
|**[ejemplo000](ejemplo000/)**| Inserción simple por profundidad (DFS): cuando se llena un nodo, se le crea un hijo. Árbol de 3 hijos. Sin validación de centinela (-1). Solo visualización con depurador. |
|**[ejemplo001](ejemplo001/)**| Igual que ejemplo000 pero añade impresión iterativa del árbol con indentación por niveles. |
|**[ejemplo002](ejemplo002/)**| Igual que ejemplo001 pero valida el centinela: el valor -1 no se inserta en el árbol. |
|**[ejemplo003](ejemplo003/)**| Inserción por niveles (BFS): llena nivel por nivel, de izquierda a derecha. Árbol balanceado de 3 hijos. |
|**[ejemplo004](ejemplo004/)**| Árbol binario simple (2 hijos): inserción por niveles sin criterio de ordenación. Introduce conceptos de izquierda/derecha. |
|**[ejemplo005](ejemplo005/)**| Binary Search Tree (BST): inserción con criterio de comparación. Menores a la izquierda, mayores a la derecha. Duplicados ignorados. |
|**[ejemplo006](ejemplo006/)**| BST con recorridos iterativos: preorden (raíz-izq-der), inorden (izq-raíz-der), postorden (izq-der-raíz). El recorrido inorden muestra valores ordenados. |

## Notas

- Progresión diseñada para aprender gradualmente: DFS → BFS → Binario → BST → Recorridos
- Para entender cómo las **políticas de inserción** afectan la forma y eficiencia del árbol, consulta la [teoría sobre inserciones](/temario/003-arboles/inserciones.md#políticas-de-inserción)
- Para conocer las **aplicaciones prácticas** de cada tipo de recorrido, consulta la [teoría sobre recorridos](/temario/003-arboles/recorridos.md#aplicaciones-prácticas)

## Material obsoleto

La carpeta `zzz-deprecated/` contiene código antiguo que ha sido superado por los ejemplos actuales:

- `insertSample/` - Reemplazado por ejemplo006
- `recorridos/` - Versiones recursivas, reemplazadas por ejemplo006 iterativo
- `btree/` - B-Tree avanzado, fuera del alcance de esta progresión básica
