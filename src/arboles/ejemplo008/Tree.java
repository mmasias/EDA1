package ejemplo008;

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

    public boolean search(int key) {
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

    public boolean delete(int key) {
        if (root == null) {
            return false;
        }

        Node parent = null;
        Node current = root;
        boolean isLeftChild = false;

        while (current != null && current.getKey() != key) {
            parent = current;
            if (key < current.getKey()) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
                current = current.getRight();
                isLeftChild = false;
            }
        }

        if (current == null) {
            return false;
        }

        if (!current.hasLeftChild() && !current.hasRightChild()) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.detachLeftChild();
            } else {
                parent.detachRightChild();
            }
        } else if (current.hasLeftChild() && !current.hasRightChild()) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.detachLeftChild();
                parent.attachLeftChild(current.getLeft());
            } else {
                parent.detachRightChild();
                parent.attachRightChild(current.getLeft());
            }
        } else if (!current.hasLeftChild() && current.hasRightChild()) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.detachLeftChild();
                parent.attachLeftChild(current.getRight());
            } else {
                parent.detachRightChild();
                parent.attachRightChild(current.getRight());
            }
        } else {
            Node successorParent = current;
            Node successor = current.getRight();

            while (successor.hasLeftChild()) {
                successorParent = successor;
                successor = successor.getLeft();
            }

            current.setKey(successor.getKey());

            if (successorParent == current) {
                successorParent.detachRightChild();
                if (successor.hasRightChild()) {
                    successorParent.attachRightChild(successor.getRight());
                }
            } else {
                successorParent.detachLeftChild();
                if (successor.hasRightChild()) {
                    successorParent.attachLeftChild(successor.getRight());
                }
            }
        }

        return true;
    }

    public void printTree() {
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
