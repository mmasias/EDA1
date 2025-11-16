package ejemplo007;

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

    boolean search(int key) {
        if (root == null) {
            return false;
        }

        Node current = root;

        while (current != null) {
            if (key == current.getKey()) {
                return true;
            } else if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return false;
    }

    void printTree() {
        if (root == null) {
            System.out.println("Árbol vacío");
        } else {
            Node[] nodeStack = new Node[100];
            int[] levelStack = new int[100];
            int top = -1;

            top = top + 1;
            nodeStack[top] = root;
            levelStack[top] = 0;

            while (top >= 0) {
                Node current = nodeStack[top];
                int level = levelStack[top];
                top = top - 1;

                for (int i = 0; i < level; i = i + 1) {
                    System.out.print("  ");
                }
                System.out.println(current.getKey());

                if (current.hasRightChild()) {
                    top = top + 1;
                    nodeStack[top] = current.getRight();
                    levelStack[top] = level + 1;
                }

                if (current.hasLeftChild()) {
                    top = top + 1;
                    nodeStack[top] = current.getLeft();
                    levelStack[top] = level + 1;
                }
            }
        }
    }

}
