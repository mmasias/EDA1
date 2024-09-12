package insertSample;

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    void insert(int key) {
        root = recursiveInsert(root, key);
    }

    Node recursiveInsert(Node node, int key) {

        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.key) {
            node.left = recursiveInsert(node.left, key);
        } else if (key > node.key) {
            node.right = recursiveInsert(node.right, key);
        }
        return node;
    }
}