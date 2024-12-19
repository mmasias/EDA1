package grafos.basico02original;

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

        Node startNode = findNode(from);
    
        boolean[] visited = new boolean[countOfNodes];
        Node[] stack = new Node[countOfNodes];
        int stackPointer = 0;
    
        stack[stackPointer] = startNode;
        stackPointer++;
    
        while (stackPointer > 0) {
            stackPointer--;
            Node current = stack[stackPointer];
            int currentIndex = findNodeIndex(current.getData());
    
            if (!visited[currentIndex]) {
                visited[currentIndex] = true;
        
                if (current.getData() == to) {
                    return true;
                }
        
                for (int i = 0; i < current.getCountOfNeighbors(); i++) {
                    Node neighbor = current.getNeighbors()[i];
                    int neighborIndex = findNodeIndex(neighbor.getData());
                    if (!visited[neighborIndex]) {
                        stack[stackPointer] = neighbor;
                        stackPointer++;
                    }
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
