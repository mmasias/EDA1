package ejemplo004;

class Tree {
    Node root;

    Tree() {
        root = null;
    }

    void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node[] queue = new Node[100];
            int front = 0;
            int rear = 0;
            queue[rear] = root;
            rear = rear + 1;
            boolean inserted = false;

            while (!inserted && front < rear) {
                Node current = queue[front];
                front = front + 1;

                if (!current.hasLeftChild()) {
                    current.attachLeftChild(new Node(key));
                    inserted = true;
                } else if (!current.hasRightChild()) {
                    current.attachRightChild(new Node(key));
                    inserted = true;
                } else {
                    queue[rear] = current.getLeft();
                    rear = rear + 1;
                    queue[rear] = current.getRight();
                    rear = rear + 1;
                }
            }
        }
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
