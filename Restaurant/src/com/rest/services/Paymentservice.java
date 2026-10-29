package com.rest.services;


import com.rest.models.Payment;
import com.rest.Payment.PaymentMethod;
import com.rest.repository.Paymentrepository;
import java.util.List;

public class Paymentservice {

    private final Paymentrepository repository;
    private int nextPaymentId=1;

    public Paymentservice() {
        repository = new Paymentrepository();
    }
    public Payment processPayment(PaymentMethod method,double amount) {

        method.pay(amount);
        Payment payment = new Payment(nextPaymentId++, amount, method.getMethodName(), "SUCCESS");
        repository.save(payment);
        return payment;
    }

    public List<Payment> getAllPayments(){
        return repository.findAll();

    }

    public Payment getPaymentById(int id){
        Payment payment=repository.findById(id);
        return payment;
    }
    
}
