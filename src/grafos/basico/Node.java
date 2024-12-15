package grafos.basico;

public class Node {
    private int data;
    private Node[] neighbors;
    private int countOfNeighbors;

    public Node(int data) {
        final int MAX_NEIGHBORS = 10;
        this.data = data;
        this.neighbors = new Node[MAX_NEIGHBORS];
        this.countOfNeighbors = 0;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void addNeighbor(Node neighbor) {
        if (countOfNeighbors < neighbors.length) {
            neighbors[countOfNeighbors] = neighbor;
            countOfNeighbors++;
        }
    }

    public Node[] getNeighbors() {
        return neighbors;
    }

    public int getCountOfNeighbors() {
        return countOfNeighbors;
    }
}