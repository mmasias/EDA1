package grafos.extendido;

public class MetroExample {
    public static void main(String[] args) {
        Graph metro = new Graph(20);

        metro.addNode("Opera", 1);
        metro.addNode("Callao", 1);
        metro.addNode("Sol", 1);
        metro.addNode("Tribunal", 1);
        metro.addNode("Bilbao", 1);

        metro.addEdge("Opera", 1, "Callao", 1, 4);
        metro.addEdge("Callao", 1, "Sol", 1, 2);
        metro.addEdge("Sol", 1, "Tribunal", 1, 2);
        metro.addEdge("Tribunal", 1, "Bilbao", 1, 3);

        metro.addNode("Noviciado", 2);
        metro.addNode("Tribunal", 2);
        metro.addNode("Quevedo", 2);
        metro.addNode("Canal", 2);

        metro.addEdge("Noviciado", 2, "Tribunal", 2, 5);
        metro.addEdge("Tribunal", 2, "Quevedo", 2, 5);
        metro.addEdge("Quevedo", 2, "Canal", 2, 4);

        metro.addNode("Sol", 3);
        metro.addNode("Moncloa", 3);
        metro.addNode("Ventura", 3);
        metro.addNode("PlazaEspaña", 3);

        metro.addEdge("Moncloa", 3, "Ventura", 3, 5);
        metro.addEdge("Ventura", 3, "Sol", 3, 4);
        metro.addEdge("Sol", 3, "PlazaEspaña", 3, 3);

        metro.addEdge("Sol", 1, "Sol", 3, 4);
        metro.addEdge("Tribunal", 1, "Tribunal", 2, 3);

        System.out.println("Conexiones Línea 1:");
        metro.printNeighbors("Opera", 1);
        metro.printNeighbors("Callao", 1);
        metro.printNeighbors("Sol", 1);
        metro.printNeighbors("Tribunal", 1);
        metro.printNeighbors("Bilbao", 1);

        System.out.println("Conexiones Línea 2:");
        metro.printNeighbors("Noviciado", 2);
        metro.printNeighbors("Tribunal", 2);
        metro.printNeighbors("Quevedo", 2);
        metro.printNeighbors("Canal", 2);

        System.out.println("Conexiones Línea 3:");
        metro.printNeighbors("Moncloa", 3);
        metro.printNeighbors("Ventura", 3);
        metro.printNeighbors("Sol", 3);
        metro.printNeighbors("PlazaEspaña", 3);
    }
}