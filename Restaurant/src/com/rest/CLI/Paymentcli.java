package com.rest.CLI;

import com.rest.Payment.CardPayment;
import com.rest.Payment.CashPayment;
import com.rest.Payment.PaymentMethod;
import com.rest.Payment.UPIPayment;
import com.rest.models.Payment;
import com.rest.services.Paymentservice;

import java.util.Scanner;

public class Paymentcli {

    private final Paymentservice paymentService;
    private final Scanner scanner = new Scanner(System.in);

    public Paymentcli(Paymentservice paymentService) {
        this.paymentService = paymentService;
    }

    public void start() {
        System.out.println("\n=== PAYMENT ===");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. UPI");
        System.out.print("Choose payment method: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Invalid payment method.");
            return;
        }

        PaymentMethod method;
        switch (choice) {
            case 1:
                method = new CashPayment();
                break;
            case 2:
                method = new CardPayment();
                break;
            case 3:
                method = new UPIPayment();
                break;
            default:
                System.out.println("Invalid payment method.");
                return;
        }

        System.out.print("Enter payment amount: Rs. ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Enter a valid amount.");
            return;
        }

        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Payment amount must be greater than zero.");
            return;
        }

        Payment payment = paymentService.processPayment(method, amount);
        System.out.println("Payment recorded. ID: " + payment.getId()
                + ", Status: " + payment.getStatus());
    }
}
