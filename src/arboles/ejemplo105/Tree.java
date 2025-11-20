package ejemplo105;

class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void insert(int key) {
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

    public void printTree() {
        if (root != null) {
            System.out.println(root.getKey());

            Node[] stack = new Node[100];
            String[] prefixStack = new String[100];
            boolean[] isLastStack = new boolean[100];
            boolean[] isLeftStack = new boolean[100];
            int top = -1;

            if (root.hasLeftChild()) {
                top = top + 1;
                stack[top] = root.getLeft();
                prefixStack[top] = "";
                isLastStack[top] = true;
                isLeftStack[top] = true;
            }

            if (root.hasRightChild()) {
                top = top + 1;
                stack[top] = root.getRight();
                prefixStack[top] = "";
                isLastStack[top] = !root.hasLeftChild();
                isLeftStack[top] = false;
            }

            while (top >= 0) {
                Node node = stack[top];
                String prefix = prefixStack[top];
                boolean isLast = isLastStack[top];
                boolean isLeft = isLeftStack[top];
                top = top - 1;

                String connector = isLast ? "└─" : "├─";
                String extension = isLast ? "  " : "│ ";
                String side = isLeft ? "L: " : "R: ";

                System.out.println(prefix + connector + side + node.getKey());

                String newPrefix = prefix + extension;

                if (node.hasLeftChild()) {
                    top = top + 1;
                    stack[top] = node.getLeft();
                    prefixStack[top] = newPrefix;
                    isLastStack[top] = true;
                    isLeftStack[top] = true;
                }

                if (node.hasRightChild()) {
                    top = top + 1;
                    stack[top] = node.getRight();
                    prefixStack[top] = newPrefix;
                    isLastStack[top] = !node.hasLeftChild();
                    isLeftStack[top] = false;
                }
            }
        } else {
            System.out.println("Árbol vacío");
        }

    }

    public void rotateRight(int key) {
        if (root != null) {

            Node parent = null;
            Node current = root;

            while (current != null && current.getKey() != key) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }

            if (current == null || !current.hasLeftChild()) {
                return;
            }

            Node newRoot = current.getLeft();
            Node grandChild = newRoot.getRight();

            current.detachLeftChild();
            if (grandChild != null) {
                current.attachLeftChild(grandChild);
            }

            if (newRoot.hasRightChild()) {
                newRoot.detachRightChild();
            }
            newRoot.attachRightChild(current);

            if (parent == null) {
                root = newRoot;
            } else {
                if (parent.getLeft() == current) {
                    parent.detachLeftChild();
                    parent.attachLeftChild(newRoot);
                } else {
                    parent.detachRightChild();
                    parent.attachRightChild(newRoot);
                }
            }
        }
    }

    public void rotateLeft(int key) {
        if (root != null) {
            Node parent = null;
            Node current = root;

            while (current != null && current.getKey() != key) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }

            if (current == null || !current.hasRightChild()) {
                return;
            }

            Node newRoot = current.getRight();
            Node grandChild = newRoot.getLeft();

            current.detachRightChild();
            if (grandChild != null) {
                current.attachRightChild(grandChild);
            }

            if (newRoot.hasLeftChild()) {
                newRoot.detachLeftChild();
            }
            newRoot.attachLeftChild(current);

            if (parent == null) {
                root = newRoot;
            } else {
                if (parent.getLeft() == current) {
                    parent.detachLeftChild();
                    parent.attachLeftChild(newRoot);
                } else {
                    parent.detachRightChild();
                    parent.attachRightChild(newRoot);
                }
            }
        }
    }

}
