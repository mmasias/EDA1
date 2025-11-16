package ejemplo006;

import java.util.Scanner;

public class TreeSample {
    public static void main(String[] args) {
        Tree tree = new Tree();

        fillTree(tree);

        System.out.println("Recorrido Preorden:");
        tree.printPreorder();

        System.out.println("Recorrido Inorden:");
        tree.printInorder();

        System.out.println("Recorrido Postorden:");
        tree.printPostorder();
    }

    private static void fillTree(Tree tree) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            value = scanner.nextInt();
            if (value != -1) {
                tree.insert(value);
            }
        } while (value != -1);
        scanner.close();
    }
}
