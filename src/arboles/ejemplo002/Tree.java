package ejemplo002;

class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node[] stack = new Node[100];
            int top = -1;
            top = top + 1;
            stack[top] = root;
            boolean inserted = false;

            while (!inserted && top >= 0) {
                Node current = stack[top];
                top = top - 1;

                if (current.hasSpace()) {
                    current.addChild(new Node(key));
                    inserted = true;
                } else {
                    int childCount = current.getChildCount();
                    for (int i = childCount - 1; i >= 0; i = i - 1) {
                        Node child = current.getChild(i);
                        if (child != null) {
                            top = top + 1;
                            stack[top] = child;
                        }
                    }
                }
            }
        }
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

                int childCount = current.getChildCount();
                for (int i = childCount - 1; i >= 0; i = i - 1) {
                    Node child = current.getChild(i);
                    if (child != null) {
                        top = top + 1;
                        nodeStack[top] = child;
                        levelStack[top] = level + 1;
                    }
                }
            }
        }
    }

}
