package grafos.basico02original;

public class Example {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        
        configura(graph);

        System.out.println("Subgrafo 1 - Ciclo con atajo:");
        for (int i = 1; i <= 5; i++) {
            graph.printNeighbors(i);
        }

        System.out.println("Subgrafo 2 - Triángulo:");
        for (int i = 10; i <= 12; i++) {
            graph.printNeighbors(i);
        }

        System.out.println("Subgrafo 3 - Forma de Y:");
        for (int i = 20; i <= 23; i++) {
            graph.printNeighbors(i);
        }

        System.out.println("Pruebas de caminos:");
        System.out.println("¿Hay camino de 1 a 4? " + graph.hasPath(1, 4));
        System.out.println("¿Hay camino de 10 a 12? " + graph.hasPath(10, 12));
        System.out.println("¿Hay camino de 20 a 23? " + graph.hasPath(20, 23));
        System.out.println("¿Hay camino de 5 a 10? " + graph.hasPath(5, 10));
        System.out.println("¿Hay camino de 12 a 20? " + graph.hasPath(12, 20));
        System.out.println("¿Hay camino de 4 a 22? " + graph.hasPath(4, 22));
    }

    static void configura(Graph graph){
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        graph.addEdge(2, 4);

        graph.addNode(10);
        graph.addNode(11);
        graph.addNode(12);
        graph.addEdge(10, 11);
        graph.addEdge(11, 12);
        graph.addEdge(10, 12);

        graph.addNode(20);
        graph.addNode(21);
        graph.addNode(22);
        graph.addNode(23);
        graph.addEdge(20, 21);
        graph.addEdge(21, 22);
        graph.addEdge(21, 23);        
    }
}
