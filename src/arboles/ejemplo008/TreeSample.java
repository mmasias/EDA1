package ejemplo008;

import java.util.Scanner;

public class TreeSample {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BST con Inserción, Búsqueda y Eliminación ===\n");

        fillTree(tree, scanner);

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar árbol");
            System.out.println("2. Buscar valor");
            System.out.println("3. Eliminar valor");
            System.out.println("4. Insertar valor");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int option = scanner.nextInt();

            if (option == 0) {
                break;
            } else if (option == 1) {
                System.out.println("\nEstructura del árbol:");
                tree.printTree();
            } else if (option == 2) {
                System.out.print("Valor a buscar: ");
                int value = scanner.nextInt();
                if (tree.search(value)) {
                    System.out.println(value + " encontrado en el árbol");
                } else {
                    System.out.println(value + " NO encontrado en el árbol");
                }
            } else if (option == 3) {
                System.out.print("Valor a eliminar: ");
                int value = scanner.nextInt();
                if (tree.delete(value)) {
                    System.out.println(value + " eliminado exitosamente");
                } else {
                    System.out.println(value + " NO encontrado, no se pudo eliminar");
                }
            } else if (option == 4) {
                System.out.print("Valor a insertar: ");
                int value = scanner.nextInt();
                tree.insert(value);
                System.out.println(value + " insertado");
            } else {
                System.out.println("Opción inválida");
            }
        }

        scanner.close();
        System.out.println("\nPrograma terminado");
    }

    private static void fillTree(Tree tree, Scanner scanner) {
        System.out.println("Ingrese valores iniciales para el árbol (-1 para terminar):");
        int value;
        do {
            value = scanner.nextInt();
            if (value != -1) {
                tree.insert(value);
            }
        } while (value != -1);

        System.out.println("\nÁrbol inicial:");
        tree.printTree();
    }
}
