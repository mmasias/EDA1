package zzzotros;

public class Calculator {
    public double calculateDiscount(double price, int customerLevel) {
        if (customerLevel > 5) {
            return price * 0.2;
        } else {
            return price * 0.1;
        }
    }
}