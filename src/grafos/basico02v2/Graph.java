package grafos.basico02v2;

public class Graph {
    private Node[] nodes;
    private int countOfNodes;
    
    public Graph(int maxNodes) {

        if (maxNodes < 1) {
            throw new IllegalArgumentException("El número máximo de nodos debe ser al menos 1");
        }

        nodes = new Node[maxNodes];
        countOfNodes = 0;
    }

    private Node createNode(int data) {
        countOfNodes++;
        return new Node(data);
    }

    public void addNode(int data) {
        if (findNode(data) != null) {
            System.out.println("El nodo " + data + " ya existe en el grafo");
            return;
        }
        if (countOfNodes >= nodes.length) {
            System.out.println("El grafo está lleno");
            return;
        }
        nodes[countOfNodes] = createNode(data);
    }

    
    private NodeIndexPair findNodeIndexPair(int data) {
        for (int i = 0; i < countOfNodes; i++) {
            if (nodes[i].getData() == data) {
                return new NodeIndexPair(nodes[i], i);
            }
        }
        return null;
    }
    
    public Node findNode(int data) {
        NodeIndexPair pair = findNodeIndexPair(data);
        return pair == null ? null : pair.getNode();
    }

    public int findNodeIndex(int data) {
        NodeIndexPair pair = findNodeIndexPair(data);
        return pair == null ? -1 : pair.getIndex();
    }
    
    public void printNeighbors(int nodeData) {
        Node node = findNode(nodeData);
        if (node == null) {
            System.out.println("No se encontró el nodo " + nodeData);
            return;
        }

        System.out.print("El nodo " + nodeData + " está conectado con: ");
        Node[] neighbors = node.getNeighbors();
        for (int i = 0; i < node.getCountOfNeighbors(); i++) {
            System.out.print(neighbors[i].getData() + " ");
        }
        System.out.println();
    }    

    public boolean hasPath(int from, int to) {

        NodeIndexPair fromNode = findNodeIndexPair(from);
        NodeIndexPair toNode = findNodeIndexPair(to);

        if (fromNode == null || toNode == null) {
            System.out.println("No se encontró el nodo origen o destino");
            return false;
        }
    
        boolean[] visited = new boolean[countOfNodes];
        NodeIndexPair[] stack = new NodeIndexPair[countOfNodes];
        int stackPointer = -1;
    
        stack[++stackPointer] = fromNode;
    
        while (stackPointer >= 0) {
            NodeIndexPair currentNodeIndex = stack[stackPointer--];

            Node currentNode = currentNodeIndex.getNode();
            if (currentNode == toNode.getNode()) return true;
            
            int currentIndex = currentNodeIndex.getIndex();

            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;
            
            Node[] neighbors = currentNode.getNeighbors();
            for (int i = 0; i < currentNode.getCountOfNeighbors(); i++) {
                int neighborIndex = findNodeIndex(neighbors[i].getData());
                if (!visited[neighborIndex]) {
                    stack[++stackPointer] = new NodeIndexPair(neighbors[i], neighborIndex);
                }
            }
        }
    
        return false;
    }

    public void addEdge(int from, int to) {
        Node nodeFrom = findNode(from);
        Node nodeTo = findNode(to);
        
        if (nodeFrom == null || nodeTo == null) {
            System.out.println("No se encontró el nodo origen o destino");
            return;
        }

        nodeFrom.addNeighbor(nodeTo);
        nodeTo.addNeighbor(nodeFrom);
    }
    

}
