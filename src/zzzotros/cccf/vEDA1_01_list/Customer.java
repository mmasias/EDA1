package zzzotros.cccf.vEDA1_01_list;

class Customer {
    private static final int ITEM_MINIMUM = 5;
    private static final int ITEM_MAXIMUM = 15;
    private int items;

    public Customer() {
        this.items = (int) (Math.random() * (ITEM_MAXIMUM - ITEM_MINIMUM)) + ITEM_MINIMUM;
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
