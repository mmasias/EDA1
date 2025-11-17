package ejemplo006;

class Node {
    private int key;
    private Node left;
    private Node right;

    public Node(int item) {
        key = item;
        left = null;
        right = null;
    }

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public boolean hasRightChild() {
        return right != null;
    }

    public void attachLeftChild(Node child) {
        assert child != null : "El hijo izquierdo no puede ser null";
        assert left == null : "Ya existe un hijo izquierdo";
        left = child;
    }

    public void attachRightChild(Node child) {
        assert child != null : "El hijo derecho no puede ser null";
        assert right == null : "Ya existe un hijo derecho";
        right = child;
    }
}
