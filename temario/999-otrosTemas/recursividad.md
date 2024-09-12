# Breves conceptos de recursividad

## Listas

![](/imagenes/recursividadNodos.png)

```java
public static <T> int count(Node<T> first){
    if(first == null) return 0;
    return 1 + count(first.getNext());
}
```

## Árboles

![](/imagenes/recursividadArboles.png)

```java
public static <T> int count(TreeNode<T> root){
    if(root == null) return 0;
    int childrenNodeCount = 1;
    for(TreeNode<T> child: root.getChildren()){
        childrenNodeCount += count(child);
    }
    return childrenNodeCount;
}
```
