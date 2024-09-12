package listas.genericaInterfaz;

class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public int count() {
        if (getNext() == null) {
            return 1;
        } else {
            return 1 + getNext().count();
        }
    }
}