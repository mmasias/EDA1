package ejemplo005;

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
        left = child;
    }

    public void attachRightChild(Node child) {
        right = child;
    }
}
