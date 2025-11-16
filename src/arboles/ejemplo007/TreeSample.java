package ejemplo007;

import java.util.Scanner;

public class TreeSample {
    public static void main(String[] args) {
        Tree tree = new Tree();

        fillTree(tree);

        System.out.println("Estructura del árbol:");
        tree.printTree();

        searchLoop(tree);
    }

    private static void fillTree(Tree tree) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese valores para el árbol (-1 para terminar):");
        int value;
        do {
            value = scanner.nextInt();
            if (value != -1) {
                tree.insert(value);
            }
        } while (value != -1);
        scanner.close();
    }

    private static void searchLoop(Tree tree) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese valores a buscar (0 para terminar):");
        int value;
        do {
            value = scanner.nextInt();
            if (value != 0) {
                if (tree.search(value)) {
                    System.out.println(value + " encontrado en el árbol");
                } else {
                    System.out.println(value + " NO encontrado en el árbol");
                }
            }
        } while (value != 0);
        scanner.close();
    }
}
