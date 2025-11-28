package zzzotros.cccf.vPRG2_02_safe;

import java.util.Scanner;

class CCCF {
    private final double OPENING_TIME = 9.0;
    private final double CLOSING_TIME = 21.0;
    private final double MINUTE = 1.0 / 60.0;
    private final int MAX_QUEUE = 100;
    private final double PROBABILITY_ARRIVAL = 0.4;
    private final int NUM_CASH_REGISTERS = 4;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        double currentTime = OPENING_TIME;
        boolean isWorking = true;

        Customer[] queue = new Customer[MAX_QUEUE];
        int front = 0;
        int rear = 0;
        int size = 0;

        CashRegister[] cashRegisters = new CashRegister[NUM_CASH_REGISTERS];
        for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
            cashRegisters[i] = new CashRegister(i + 1);
        }

        do {
            currentTime = currentTime + MINUTE;
            isWorking = currentTime < CLOSING_TIME;

            if (Math.random() < PROBABILITY_ARRIVAL && size < MAX_QUEUE) {
                queue[rear] = new Customer();
                rear = (rear + 1) % MAX_QUEUE;
                size = size + 1;
            }

            for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
                if (cashRegisters[i].isFree() && size > 0) {
                    Customer customer = queue[front];
                    front = (front + 1) % MAX_QUEUE;
                    size = size - 1;
                    cashRegisters[i].serve(customer);
                }
            }

            for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
                cashRegisters[i].process();
            }

            showHeader(currentTime, size);
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
