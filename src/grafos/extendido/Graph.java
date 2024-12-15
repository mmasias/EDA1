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

    public String findPath(String fromStation, int fromLine, String toStation, int toLine) {
        
        Node start = findNode(fromStation, fromLine);
        Node end = findNode(toStation, toLine);
        
        Node[] stack = new Node[countOfNodes];
        int stackSize = 0;
        
        Node[] predecessor = new Node[countOfNodes];
        int[] timeToReach = new int[countOfNodes];
        boolean[] visited = new boolean[countOfNodes];
        
        stack[stackSize] = start;
        stackSize++;
        visited[findNodeIndex(start)] = true;

        boolean found = false;
        while (stackSize > 0 && !found) {
            stackSize--;
            Node current = stack[stackSize];
            
            for (int i = 0; i < current.getCountOfNeighbors() && !found; i++) {
                Node neighbor = current.getNeighbors()[i];
                int neighborIndex = findNodeIndex(neighbor);
                
                if (!visited[neighborIndex]) {
                    visited[neighborIndex] = true;
                    stack[stackSize] = neighbor;
                    stackSize++;
                    predecessor[neighborIndex] = current;
                    timeToReach[neighborIndex] = current.getTimes()[i];
                    if (neighbor == end) {
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            return "No hay ruta disponible";
        }

        Node[] path = new Node[countOfNodes];
        int[] times = new int[countOfNodes];
        int pathLength = 0;
        
        Node current = end;
        while (current != start) {
            path[pathLength] = current;
            int currentIndex = findNodeIndex(current);
            times[pathLength] = timeToReach[currentIndex];
            current = predecessor[currentIndex];
            pathLength++;
        }
        path[pathLength++] = start;

        String route = "Ruta de " + start + " a " + end + ":";
        int totalTime = 0;

        for (int i = pathLength - 1; i > 0; i--) {
            Node currentNode = path[i];
            Node nextNode = path[i-1];
            
            route = route + currentNode;
            if (currentNode.getLine() != nextNode.getLine()) {
                route = route + " → TRANSBORDO → ";
            } else {
                route = route + " → ";
            }
            totalTime = totalTime + times[i-1];
        }
        route = route + end;
        route = route + " > Tiempo total: " + totalTime + " minutos";
        
        return route;
    }

    private int findNodeIndex(Node node) {
        for (int i = 0; i < countOfNodes; i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }
}