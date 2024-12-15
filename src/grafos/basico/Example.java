package grafos.basico;

public class Example {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 3);

        System.out.println("Conexiones del grafo:");
        graph.printNeighbors(1);
        graph.printNeighbors(2);
        graph.printNeighbors(3);
        graph.printNeighbors(4);        
    }  
}
