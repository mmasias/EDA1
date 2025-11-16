package insertSample;

import java.util.Scanner;

public class TreeSample {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        fillTree(tree);

        System.out.println("Recorrido inorder del árbol, luego de las inserciones:");
        tree.printInorder(tree.root);
    }

    private static void fillTree(BinaryTree tree) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            value = scanner.nextInt();
            tree.insert(value);
        } while (value != -1);
        scanner.close();
    }
}
