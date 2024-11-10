package btree;

class Node {
    int[] keys;
    Node[] children;
    int keyCount;
    boolean isLeaf;
    private final int minDegree;

    Node(boolean isLeaf, int minDegree) {
        this.isLeaf = isLeaf;
        this.minDegree = minDegree;
        this.keys = new int[2 * minDegree - 1];
        this.children = new Node[2 * minDegree];
        this.keyCount = 0;
    }

    int findKeyIndex(int key) {
        int index = 0;
        while (index < keyCount && keys[index] < key) {
            index++;
        }
        return index;
    }
}