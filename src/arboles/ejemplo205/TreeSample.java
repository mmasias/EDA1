package ejemplo205;

import java.util.Scanner;

public class TreeSample {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Serialización de BST");
        System.out.print("¿Cuántos nodos quieres en el árbol inicial? ");
        int size = scanner.nextInt();

        System.out.println("Generando árbol (1 a " + size + ")...");

        for (int i = 1; i <= size; i++) {
            tree.insert(i);
        }

        boolean trabajando = true;

        do {
            System.out.println("Estado actual del árbol:");
            tree.printTree();

            System.out.println("--- Menú ---");
            System.out.println("1. Rotar a la Izquierda (Left Rotation)");
            System.out.println("2. Rotar a la Derecha (Right Rotation)");
            System.out.println("3. Reiniciar árbol (1 a " + size + ")");
            System.out.println("4. Serializar árbol");
            System.out.println("5. Deserializar árbol");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 0) {
                trabajando = false;
            } else if (option == 1) {
                System.out.print("Nodo sobre el cual rotar (clave): ");
                int key = scanner.nextInt();
                tree.rotateLeft(key);
            } else if (option == 2) {
                System.out.print("Nodo sobre el cual rotar (clave): ");
                int key = scanner.nextInt();
                tree.rotateRight(key);
            } else if (option == 3) {
                tree = new Tree();
                for (int i = 1; i <= size; i++) {
                    tree.insert(i);
                }
                System.out.println("Árbol reiniciado.");
            } else if (option == 4) {
                String serialized = tree.serialize();
                System.out.println("Árbol serializado:");
                System.out.println(serialized);
            } else if (option == 5) {
                System.out.print("Introduce el árbol serializado: ");
                String data = scanner.nextLine();
                tree = new Tree();
                tree.deserialize(data);
                System.out.println("Árbol deserializado.");
            } else {
                System.out.println("Opción inválida");
            }
        } while (trabajando);

        scanner.close();
        System.out.println("Programa terminado");
    }
}
