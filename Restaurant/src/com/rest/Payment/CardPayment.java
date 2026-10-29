package com.rest.Payment;

public class CardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.printf("Card payment of Rs. %.2f processed successfully.%n", amount);
    }

    @Override
    public String getMethodName() {
        return "Card";
    }
}
