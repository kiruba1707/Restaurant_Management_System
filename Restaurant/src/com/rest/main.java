
package com.rest;

import com.rest.CLI.tablecli;
import com.rest.CLI.menuitemcli;
import com.rest.CLI.ordercli;
import com.rest.CLI.Paymentcli;

import com.rest.services.tableservice;
import com.rest.services.menuitemservice;
import com.rest.services.orderservice;
import com.rest.services.Paymentservice;

import com.rest.models.order;
import com.rest.models.Payment;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        tableservice tableService = new tableservice();
        menuitemservice menuService = new menuitemservice();
        orderservice orderService = new orderservice();
        Paymentservice paymentService = new Paymentservice();

        tablecli tableCLI = new tablecli(tableService);
        menuitemcli menuCLI = new menuitemcli(menuService);
        ordercli orderCLI = new ordercli(
            orderService, menuService
        );
        Paymentcli paymentCLI = new Paymentcli(paymentService);

        int choice;

        do {
            System.out.println("\n===== RESTAURANT MANAGEMENT SYSTEM =====");
            System.out.println("1. View All Tables");
            System.out.println("2. View Menu Items");
            System.out.println("3. Place Order");
            System.out.println("4. View All Orders");
            System.out.println("5. Process Payment");
            System.out.println("6. View All Payments");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    tableCLI.start();
                    break;

                case 2:
                    menuCLI.start();
                    break;

                case 3:
                    orderCLI.start();
                    break;

                case 4:
                    List<order> orders =
                        orderService.getAllOrders();

                    System.out.println("\n===== ALL ORDERS =====");

                    if (orders.isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        for (order o : orders) {
                            System.out.println(o);
                        }
                    }
                    break;

                case 5:
                    paymentCLI.start();
                    break;

                case 6:
                    List<Payment> payments =
                        paymentService.getAllPayments();

                    System.out.println("\n===== ALL PAYMENTS =====");

                    if (payments.isEmpty()) {
                        System.out.println("No payments found.");
                    } else {
                        for (Payment payment : payments) {
                            System.out.println(
                                "ID: " + payment.getId()
                                + ", Amount: Rs. " + payment.getAmount()
                                + ", Method: " + payment.getMethod()
                                + ", Status: " + payment.getStatus()
                            );
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        scanner.close();
    }
}
