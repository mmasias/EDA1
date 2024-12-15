package grafos.basico02;

public class Graph {
    private Node[] nodes;
    private int countOfNodes;
    
    public Graph(int maxNodes) {
        nodes = new Node[maxNodes];
        countOfNodes = 0;
    }

    public void addNode(int data) {
        if (countOfNodes < nodes.length) {
            nodes[countOfNodes] = new Node(data);
            countOfNodes++;
        }
    }

    public void addEdge(int from, int to) {
        Node nodeFrom = findNode(from);
        Node nodeTo = findNode(to);
        
        if (nodeFrom != null && nodeTo != null) {
            nodeFrom.addNeighbor(nodeTo);
            nodeTo.addNeighbor(nodeFrom);
        }
    }

    private Node findNode(int data) {
        for (int i = 0; i < countOfNodes; i++) {
            if (nodes[i].getData() == data) {
                return nodes[i];
            }
        }
        return null;
    }

    public void printNeighbors(int nodeData) {
        Node node = findNode(nodeData);
        if (node != null) {
            System.out.print("El nodo " + nodeData + " está conectado con: ");
            for (int i = 0; i < node.getCountOfNeighbors(); i++) {
                System.out.print(node.getNeighbors()[i].getData() + " ");
            }
            System.out.println();
        }
    }    
    public boolean hasPath(int from, int to) {
        boolean[] visited = new boolean[countOfNodes];
        Node startNode = findNode(from);
        return startNode != null && hasPathDFS(startNode, to, visited);
    }

    private boolean hasPathDFS(Node current, int target, boolean[] visited) {
        if (current.getData() == target) {
            return true;
        }

        int currentIndex = findNodeIndex(current.getData());
        visited[currentIndex] = true;

        for (int i = 0; i < current.getCountOfNeighbors(); i++) {
            Node neighbor = current.getNeighbors()[i];
            int neighborIndex = findNodeIndex(neighbor.getData());
            if (!visited[neighborIndex]) {
                if (hasPathDFS(neighbor, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }    
    private int findNodeIndex(int data) {
        for (int i = 0; i < countOfNodes; i++) {
            if (nodes[i].getData() == data) {
                return i;
            }
        }
        return -1;
    }    
}
