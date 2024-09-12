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
        int value;
        do {
            value = new Scanner(System.in).nextInt();
            tree.insert(value);
        } while (value != -1);
    }
}
