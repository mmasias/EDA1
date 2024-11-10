# Tipos

## Binarios

|Simple|Completo|Perfecto|Sesgado|
|-|-|-|-
|![](/images/modelosUML/arboles/tipos/binarioSimple.svg)|![](/images/modelosUML/arboles/tipos/binarioCompleto.svg)|![](/images/modelosUML/arboles/tipos/binarioPerfecto.svg)|![](/images/modelosUML/arboles/tipos/binarioSesgado.svg)|
|[plantUML](/modelosUML/arboles/tipos/binarioSimple.puml)|[plantUML](/modelosUML/arboles/tipos/binarioCompleto.puml)|[plantUML](/modelosUML/arboles/tipos/binarioPerfecto.puml)|[plantUML](/modelosUML/arboles/tipos/binarioSesgado.puml)|
|Solo garantiza máximo dos hijos por nodo|Todos los niveles llenos excepto posiblemente el último|Todos los nodos internos tienen exactamente dos hijos|Cada nodo padre tiene exactamente un hijo (excepto el último)
|Puede tener "huecos" en cualquier nivel|Los nodos se llenan de izquierda a derecha|Todas las hojas están exactamente al mismo nivel|Todos los nodos se extienden en una sola dirección (izquierda o derecha)
|Los nodos pueden tener 0, 1 o 2 hijos|Estructura más regular y predecible|El número de nodos en cada nivel es exactamente 2^k, donde k es el nivel (empezando desde 0)|La altura del árbol es igual al número de nodos menos uno
|No requiere ningún tipo de balance|Más eficiente en términos de almacenamiento|Tiene exactamente 2^(h+1) - 1 nodos en total, donde h es la altura del árbol|Es la forma menos eficiente de un árbol binario, ya que se comporta esencialmente como una lista enlazada
|||Es totalmente simétrico en su estructura|En esencia, es una "degeneración" de un árbol binario

## De búsqueda

|BST|AVL|Rojo-Negro|
|-|-|-
|![](/images/modelosUML/arboles/tipos/bst.svg)|![](/images/modelosUML/arboles/tipos/avl.svg)|![](/images/modelosUML/arboles/tipos/rojoNegro.svg)
|[plantUML](/modelosUML/arboles/tipos/bst.puml)|[plantUML](/modelosUML/arboles/tipos/avl.puml)|[plantUML](/modelosUML/arboles/tipos/rojoNegro.puml)
|Para cada nodo N:|Es un BST (mantiene todas las propiedades de ordenación de un BST)|Es un BST (mantiene las propiedades de ordenación)
|- Todos los valores en el subárbol izquierdo son menores que N|Para cada nodo, las alturas de los subárboles izquierdo y derecho difieren en máximo 1 (Factor de Balance o BF)|Cada nodo es rojo o negro
|- Todos los valores en el subárbol derecho son mayores que N|El Factor de Balance se calcula como: altura(subarbol_derecho) - altura(subarbol_izquierdo)|La raíz es siempre negra
|Esta propiedad se mantiene recursivamente para cada subárbol|Se auto-balancea mediante rotaciones cuando se inserta o elimina un nodo|Los hijos de un nodo rojo son negros (no pueden haber dos rojos seguidos)
|Los valores deben ser comparables entre sí|Es más estrictamente balanceado que un árbol Rojo-Negro|Para cada nodo, todos los caminos hasta las hojas tienen el mismo número de nodos negros
|Este ejemplo usa números para ver claramente la propiedad de ordenación|Cada nodo mantiene su Factor de Balance (mostrado como BF en el diagrama)|Las hojas NULL se consideran negras
|||El balance se mantiene usando el color y rotaciones
|||Suele usarse más en la práctica (por ejemplo, en varios mapas/sets de C++)

## Multivía

### B-Tree (de orden 3)

|![](/images/modelosUML/arboles/tipos/b-tree.svg)
|-
|[plantUML](/modelosUML/arboles/tipos/b-tree.puml)

