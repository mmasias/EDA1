package zzzotros.cccf.vEDA1_01_list;

class CashRegister {
    private int number;
    private Customer currentCustomer;

    public CashRegister(int number) {
        this.number = number;
        this.currentCustomer = null;
    }

    public boolean isFree() {
        return currentCustomer == null;
    }

    public void serve(Customer customer) {
        if (currentCustomer == null) {
            currentCustomer = customer;
        }
    }

    public void process() {
        if (currentCustomer != null) {
            currentCustomer.processItem();
            if (currentCustomer.isFinished()) {
                currentCustomer = null;
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public int getCurrentItems() {
        if (currentCustomer != null) {
            return currentCustomer.getItems();
        } else {
            return 0;
        }
    }
}
