package com.rest.Payment;

public class UPIPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.printf("UPI payment of Rs. %.2f processed successfully.%n", amount);
    }

    @Override
    public String getMethodName() {
        return "UPI";
    }
}
