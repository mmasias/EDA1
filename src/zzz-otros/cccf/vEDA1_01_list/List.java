package vEDA1_01_list;

class List {
    private Node head;
    private Node tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(Customer customer) {
        Node newNode = new Node(customer);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size = size + 1;
    }

    public void addLast(Customer customer) {
        Node newNode = new Node(customer);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size = size + 1;
    }

    public Customer removeFirst() {
        if (head == null) {
            return null;
        }
        Customer data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size = size - 1;
        return data;
    }

    public Customer removeLast() {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            Customer data = head.data;
            head = null;
            tail = null;
            size = size - 1;
            return data;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        Customer data = tail.data;
        tail = current;
        tail.next = null;
        size = size - 1;
        return data;
    }

    public Customer get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i = i + 1) {
            current = current.next;
        }
        return current.data;
    }

    public boolean remove(Customer customer) {
        if (head == null) {
            return false;
        }
        if (head.data == customer) {
            removeFirst();
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == customer) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                size = size - 1;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
