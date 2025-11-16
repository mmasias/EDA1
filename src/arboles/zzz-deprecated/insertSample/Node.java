package insertSample;

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

    public void attachLeftChild(Node child) {
        this.left = child;
    }

    public void attachRightChild(Node child) {
        this.right = child;
    }

    public boolean hasLeftChild() {
        return this.left != null;
    }

    public boolean hasRightChild() {
        return this.right != null;
    }
}