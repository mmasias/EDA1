package btree;

public class BTree {

  private final int minDegree;
  private Node root;

  public BTree(int minDegree) {
      this.minDegree = minDegree;
      this.root = new Node(true, minDegree);
  }

  public void insert(int key) {
      Node rootNode = root;
      if (rootNode.keyCount == 2 * minDegree - 1) {
          Node newRoot = new Node(false, minDegree);
          newRoot.children[0] = rootNode;
          splitChild(newRoot, 0, rootNode);
          root = newRoot;
      }
      insertNonFull(root, key);
  }

  private void splitChild(Node parent, int index, Node fullChild) {
      Node newChild = new Node(fullChild.isLeaf, minDegree);
      newChild.keyCount = minDegree - 1;

      System.arraycopy(fullChild.keys, minDegree, newChild.keys, 0, minDegree - 1);

      if (!fullChild.isLeaf) {
          System.arraycopy(fullChild.children, minDegree, newChild.children, 0, minDegree);
      }

      fullChild.keyCount = minDegree - 1;

      System.arraycopy(parent.children, index + 1, parent.children, index + 2, parent.keyCount - index);
      parent.children[index + 1] = newChild;

      System.arraycopy(parent.keys, index, parent.keys, index + 1, parent.keyCount - index);
      parent.keys[index] = fullChild.keys[minDegree - 1];
      parent.keyCount++;
  }

  private void insertNonFull(Node node, int key) {
      int i = node.keyCount - 1;

      if (node.isLeaf) {
          while (i >= 0 && key < node.keys[i]) {
              node.keys[i + 1] = node.keys[i];
              i--;
          }
          node.keys[i + 1] = key;
          node.keyCount++;
      } else {
          while (i >= 0 && key < node.keys[i]) {
              i--;
          }
          i++;

          if (node.children[i].keyCount == 2 * minDegree - 1) {
              splitChild(node, i, node.children[i]);
              if (key > node.keys[i]) {
                  i++;
              }
          }
          insertNonFull(node.children[i], key);
      }
  }

  public boolean contains(int key) {
      return search(root, key) != null;
  }

  private Node search(Node node, int key) {
      int i = 0;
      while (i < node.keyCount && key > node.keys[i]) {
          i++;
      }
      if (i < node.keyCount && key == node.keys[i]) {
          return node;
      }
      if (node.isLeaf) {
          return null;
      }
      return search(node.children[i], key);
  }

  public void show() {
      show(root);
      System.out.println();
  }

  private void show(Node node) {
      if (node == null) {
          return;
      }
      for (int i = 0; i < node.keyCount; i++) {
          if (!node.isLeaf) {
              show(node.children[i]);
          }
          System.out.print(node.keys[i] + " ");
      }
      if (!node.isLeaf) {
          show(node.children[node.keyCount]);
      }
  }

  public static void main(String[] args) {
      BTree bTree = new BTree(3);
      int[] keys = {8, 3, 10, 11, 15, 20, 17,7};
      for (int key : keys) {
          bTree.insert(key);
      }

      bTree.show();

      System.out.println("12 " + (bTree.contains(12) ? "found" : "not found"));
  }
}