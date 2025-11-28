package zzzotros.cccf.vEDA1_02_queue;

class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(Customer customer) {
        Node newNode = new Node(customer);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size = size + 1;
    }

    public Customer dequeue() {
        if (front == null) {
            return null;
        }
        Customer data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size = size - 1;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
