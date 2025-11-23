package vPRG2_02_safe;

class Customer {
    private int items;

    public Customer(int items) {
        this.items = items;
    }

    public int getItems() {
        return items;
    }

    public void processItem() {
        if (items > 0) {
            items = items - 1;
        }
    }

    public boolean isFinished() {
        return items == 0;
    }
}
