package grafos.primitivo;

public class Example {
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
                           
        n2.addNeighbor(n3);
        n3.addNeighbor(n2);
                           
        n3.addNeighbor(n4);
        n4.addNeighbor(n3);

        n1.addNeighbor(n3);
        n3.addNeighbor(n1);

        System.out.println("Vecinos del nodo 1:");
        printNeighbors(n1);

        System.out.println("Vecinos del nodo 2:");
        printNeighbors(n2);

        System.out.println("Vecinos del nodo 3:");
        printNeighbors(n3);

        System.out.println("Vecinos del nodo 4:");
        printNeighbors(n4);
    }

    private static void printNeighbors(Node node) {
        System.out.print("El nodo " + node.getData() + " está conectado con: ");
        for (int i = 0; i < node.getCountOfNeighbors(); i++) {
            System.out.print(node.getNeighbors()[i].getData() + " ");
        }
        System.out.println();
    }
}