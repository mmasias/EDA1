package ejemplo006;

class Tree {
    Node root;

    Tree() {
        root = null;
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

    void printPreorder() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }

        Node[] stack = new Node[100];
        int top = -1;

        top = top + 1;
        stack[top] = root;

        while (top >= 0) {
            Node current = stack[top];
            top = top - 1;

            System.out.print(current.getKey() + " ");

            if (current.hasRightChild()) {
                top = top + 1;
                stack[top] = current.getRight();
            }

            if (current.hasLeftChild()) {
                top = top + 1;
                stack[top] = current.getLeft();
            }
        }
        System.out.println();
    }

    void printInorder() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }

        Node[] stack = new Node[100];
        int top = -1;
        Node current = root;

        while (current != null || top >= 0) {
            while (current != null) {
                top = top + 1;
                stack[top] = current;
                current = current.getLeft();
            }

            current = stack[top];
            top = top - 1;
            System.out.print(current.getKey() + " ");
            current = current.getRight();
        }
        System.out.println();
    }

    void printPostorder() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }

        Node[] stack = new Node[100];
        int top = -1;
        Node current = root;
        Node lastVisited = null;

        while (top >= 0 || current != null) {
            if (current != null) {
                top = top + 1;
                stack[top] = current;
                current = current.getLeft();
            } else {
                Node peekNode = stack[top];
                if (peekNode.hasRightChild() && lastVisited != peekNode.getRight()) {
                    current = peekNode.getRight();
                } else {
                    System.out.print(peekNode.getKey() + " ");
                    lastVisited = stack[top];
                    top = top - 1;
                }
            }
        }
        System.out.println();
    }

}
