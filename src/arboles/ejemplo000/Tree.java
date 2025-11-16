package ejemplo000;

class Tree {
    Node root;

    Tree() {
        root = null;
    }

    void insert(int key) {
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

}
