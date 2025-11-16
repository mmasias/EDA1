package ejemplo003;

class Node {
    private static final int MAX_CHILDREN = 3;
    private int key;
    private Node[] children;
    private int childCount;

    public Node(int item) {
        key = item;
        children = new Node[MAX_CHILDREN];
        childCount = 0;
    }

    public int getKey() {
        return key;
    }

    public Node getChild(int index) {
        if (index >= 0 && index < childCount) {
            return children[index];
        }
        return null;
    }

    public int getChildCount() {
        return childCount;
    }

    public boolean hasSpace() {
        return childCount < MAX_CHILDREN;
    }

    public void addChild(Node child) {
        if (hasSpace()) {
            children[childCount] = child;
            childCount++;
        }
    }
}
