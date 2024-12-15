package grafos.extendido;

public class Graph {
    private Node[] nodes;
    private int countOfNodes;
    
    public Graph(int maxNodes) {
        nodes = new Node[maxNodes];
        countOfNodes = 0;
    }

    public void addNode(String stationName, int line) {
        if (countOfNodes < nodes.length) {
            nodes[countOfNodes] = new Node(stationName, line);
            countOfNodes++;
        }
    }

    public void addEdge(String fromStation, int fromLine, 
                       String toStation, int toLine, int time) {
        Node nodeFrom = findNode(fromStation, fromLine);
        Node nodeTo = findNode(toStation, toLine);
        
        if (nodeFrom != null && nodeTo != null) {
            nodeFrom.addNeighbor(nodeTo, time);
            nodeTo.addNeighbor(nodeFrom, time);
        }
    }

    private Node findNode(String stationName, int line) {
        for (int i = 0; i < countOfNodes; i++) {
            Node node = nodes[i];
            if (node.getStationName().equals(stationName) && 
                node.getLine() == line) {
                return node;
            }
        }
        return null;
    }

    public void printNeighbors(String stationName, int line) {
        Node node = findNode(stationName, line);
        if (node != null) {
            System.out.print(node + " está conectado con: ");
            for (int i = 0; i < node.getCountOfNeighbors(); i++) {
                Node neighbor = node.getNeighbors()[i];
                int time = node.getTimes()[i];
                System.out.print(neighbor + " (" + time + " min) ");
            }
            System.out.println();
        }
    }
}