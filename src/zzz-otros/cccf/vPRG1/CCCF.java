package vPRG1;

import java.util.Scanner;

class CCCF {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final double OPENING_TIME = 9.0;
        final double CLOSING_TIME = 21.0;
        final double MINUTE = 1.0 / 60.0;
        double currentTime = OPENING_TIME;
        boolean isWorking = true;

        int line = 0;
        final double PROBABILITY_ARRIVAL = 0.4;

        final int NUM_CASH_REGISTERS = 4;
        int[] cashRegisters = new int[NUM_CASH_REGISTERS];
        final int ITEM_MINIMUM = 5;
        final int ITEM_MAXIMUM = 15;

        do {
            currentTime = currentTime + MINUTE;
            isWorking = currentTime < CLOSING_TIME;

            line = line + (Math.random() < PROBABILITY_ARRIVAL ? 1 : 0);

            for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
                if (line > 0 && cashRegisters[i] <= 0) {
                    line = line - 1;
                    cashRegisters[i] = createItems(ITEM_MAXIMUM, ITEM_MINIMUM);
                }
            }

            for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
                if (cashRegisters[i] > 0) {
                    cashRegisters[i] = cashRegisters[i] - 1;
                }
            }

            showHeader(currentTime, line);
            for (int i = 0; i < NUM_CASH_REGISTERS; i = i + 1) {
                describeCustomerService(cashRegisters[i], i + 1);
            }

            String userInput = scanner.nextLine();

        } while (isWorking);

        scanner.close();
    }

    private static int createItems(int maxItems, int minItems) {
        return (int) (Math.random() * (maxItems - minItems)) + minItems;
    }

    private static void describeCustomerService(int customerService, int customerServiceNumber) {
        final String ITEM = "[:]";
        System.out.println("Caja[" + customerServiceNumber + "] " + ITEM.repeat(customerService));
    }

    private static void showHeader(double currentTime, int line) {
        final int DECIMAL_PLACES = 100;
        final String CLIENT = "_O_.";
        System.out.println("=".repeat(40));
        System.out.println("[" + (double) Math.round(currentTime * DECIMAL_PLACES) / DECIMAL_PLACES + "]");
        System.out.println("FILA: " + CLIENT.repeat(line) + " ");
        System.out.println("     " + "=".repeat(35));
    }
}
