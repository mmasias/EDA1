package grafos.basico02v2;

public class NodeIndexPair {
    private Node node;
    private int index;

    public NodeIndexPair(Node node, int index) {
        this.node = node;
        this.index = index;
    }

    public Node getNode() {
        return node;
    }

    public int getIndex() {
        return index;
    }
}
