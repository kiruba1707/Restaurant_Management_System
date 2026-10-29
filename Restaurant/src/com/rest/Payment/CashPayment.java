package com.rest.Payment;

public class CashPayment  implements PaymentMethod {

    @Override
    public void pay(double amount) {
        // Implement cash payment logic here
        System.out.printf("Cash payment of Rs. %.2f processed successfully.%n", amount);
    }

    @Override
    public String getMethodName() {
        return "Cash";
    }
    
}
