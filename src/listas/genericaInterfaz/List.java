package listas.genericaInterfaz;

public class List<T> implements IDataStructure<T> {
    
    Node<T> first;

    public List<T> insert(T data, int index) {
        if (first == null && (index == 0 || index == -1)) {
            first = new Node<T>(data);
        } else if (index == 0) {
            insertFirst(new Node<T>(data));
        } else if (index == -1) {
            insertLast(new Node<T>(data));
        } else if (index > 0) {
            insertAt(new Node<T>(data), index);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private void insertFirst(Node<T> node) {
        node.setNext(first);
        first = node;
    }

    private void insertLast(Node<T> node) {
        Node<T> last = first;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(node);
    }

    private void insertAt(Node<T> node, int index) {
        int i = 0;
        Node<T> current = first;
        while (i < index - 1 && current != null) {
            ++i;
            current = current.getNext();
        }
        if (current != null) {
            node.setNext(current.getNext());
            current.setNext(node);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public List<T> remove(int index) {
        if (getFirst() != null) {
            if (index == 0) {
                removeFirst();
            } else if (index == -1) {
                removeLast();
            } else {
                removeAt(index);
            }

        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private void removeFirst() {
        first = getFirst().getNext();
    }

    private void removeLast() {
        if (getFirst().getNext() != null) {
            Node<T> oneBeforeLast = getFirst();
            while (oneBeforeLast.getNext() != null && oneBeforeLast.getNext().getNext() != null) {
                oneBeforeLast = oneBeforeLast.getNext();
            }
            oneBeforeLast.setNext(null);
        } else {
            first = null;
        }
    }

    private void removeAt(int index) {
        Node<T> current = first;
        for (int i = 0; i < index - 1; ++i) {
            current = current.getNext();
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        if (current.getNext() == null) {
            throw new IndexOutOfBoundsException();
        }
        current.setNext(current.getNext().getNext());
    }

    public Node<T> getFirst() {
        return first;
    }

    public boolean isEmpty() {
        return getFirst() == null;
    }

    public int size() {
        if (first != null) {
            return first.count();
        } else {
            return 0;
        }
    }

    public Object[] listData() {
        Object[] array = new Object[size()];
        Node<T> node = first;
        for (int i = 0; i < array.length; ++i) {
            array[i] = node.getData();
            node = node.getNext();
        }
        return array;
    }
}