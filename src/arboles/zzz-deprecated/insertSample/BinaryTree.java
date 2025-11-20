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

        Node[] stack = new Node[100];
        int top = -1;
        Node current = node;

        while (current != null || top >= 0) {
            while (current != null) {
                stack[++top] = current;
                current = current.getLeft();
            }

            current = stack[top--];
            System.out.print(current.getKey() + " ");
            current = current.getRight();
        }
    }

    void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node current = root;
            boolean inserted = false;

            while (!inserted) {
                if (key < current.getKey()) {
                    if (current.hasLeftChild()) {
                        current = current.getLeft();
                    } else {
                        current.attachLeftChild(new Node(key));
                        inserted = true;
                    }
                } else if (key > current.getKey()) {
                    if (current.hasRightChild()) {
                        current = current.getRight();
                    } else {
                        current.attachRightChild(new Node(key));
                        inserted = true;
                    }
                } else {
                    inserted = true;
                }
            }
        }
    }
}