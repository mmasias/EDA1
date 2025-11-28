package zzzotros.cccf.vEDA1_02_queue;

import java.util.Scanner;

class CCCF {
    private final double OPENING_TIME = 9.0;
    private final double CLOSING_TIME = 21.0;
    private final double MINUTE = 1.0 / 60.0;
    private final double PROBABILITY_ARRIVAL = 0.4;
    private final int NUM_CASH_REGISTERS = 4;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        double currentTime = OPENING_TIME;
        boolean isWorking = true;

        Queue queue = new Queue();

        CashRegister[] cashRegisters = new CashRegister[NUM_CASH_REGISTERS];
        for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
            cashRegisters[i] = new CashRegister(i + 1);
        }

        do {
            currentTime = currentTime + MINUTE;
            isWorking = currentTime < CLOSING_TIME;

            if (Math.random() < PROBABILITY_ARRIVAL) {
                queue.enqueue(new Customer());
            }

            for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
                if (cashRegisters[i].isFree() && !queue.isEmpty()) {
                    Customer customer = queue.dequeue();
                    cashRegisters[i].serve(customer);
                }
            }

            for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
                cashRegisters[i].process();
            }

            showHeader(currentTime, queue.size());
            for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
                describeCashRegister(cashRegisters[i]);
            }

            String userInput = scanner.nextLine();

        } while (isWorking);

        scanner.close();
    }

    private void describeCashRegister(CashRegister cashRegister) {
        final String ITEM = "[:]";
        System.out.println("Caja[" + cashRegister.getNumber() + "] " + ITEM.repeat(cashRegister.getCurrentItems()));
    }

    private void showHeader(double currentTime, int size) {
        final int DECIMAL_PLACES = 100;
        final String CLIENT = "_O_.";
        System.out.println("=".repeat(40));
        System.out.println("[" + (double) Math.round(currentTime * DECIMAL_PLACES) / DECIMAL_PLACES + "]");
        System.out.println("FILA: " + CLIENT.repeat(size) + " ");
        System.out.println("     " + "=".repeat(35));
    }
}
