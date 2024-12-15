package grafos.extendido;

public class Node {
    private String stationName;
    private int line;
    private Node[] neighbors;
    private int[] times;
    private int countOfNeighbors;

    public Node(String stationName, int line) {
        final int MAX_NEIGHBORS = 10;
        this.stationName = stationName;
        this.line = line;
        this.neighbors = new Node[MAX_NEIGHBORS];
        this.times = new int[MAX_NEIGHBORS];
        this.countOfNeighbors = 0;
    }

    public String getStationName() {
        return stationName;
    }

    public int getLine() {
        return line;
    }

    public void addNeighbor(Node neighbor, int time) {
        if (countOfNeighbors < neighbors.length) {
            neighbors[countOfNeighbors] = neighbor;
            times[countOfNeighbors] = time;
            countOfNeighbors++;
        }
    }

    public Node[] getNeighbors() {
        return neighbors;
    }

    public int[] getTimes() {
        return times;
    }

    public int getCountOfNeighbors() {
        return countOfNeighbors;
    }

    public int getTimeToNeighbor(Node neighbor) {
        for (int i = 0; i < countOfNeighbors; i++) {
            if (neighbors[i] == neighbor) {
                return times[i];
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return stationName + " L" + line;
    }
}