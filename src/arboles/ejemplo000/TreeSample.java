package ejemplo000;

import java.util.Scanner;

public class TreeSample {
    public static void main(String[] args) {
        Tree tree = new Tree();

        fillTree(tree);

        System.out.println("Árbol listo. Usa el depurador para inspeccionar la estructura.");
    }

    private static void fillTree(Tree tree) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            value = scanner.nextInt();
            tree.insert(value);
        } while (value != -1);
        scanner.close();
    }
}
