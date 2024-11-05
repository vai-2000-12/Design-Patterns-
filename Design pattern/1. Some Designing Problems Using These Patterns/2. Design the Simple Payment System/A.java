/*
 Problem: Design a Simple Payment System
You need to design a payment processing system that can support multiple payment methods, such as Credit Card, PayPal, and Bank Transfer. The system should be easily extendable so that if you need to add new payment methods in the future, you won’t have to modify existing code.

Requirements:
1. The system should support different types of payment methods (Credit Card, PayPal, Bank Transfer).
2. Each payment method should have a pay method that processes a payment.
3. It should be easy to add new payment methods in the future without changing the core payment processing logic.

*/
// Step 1: Define the PaymentMethod interface
 interface PaymentMethod {
    void pay(double amount);
}

// Step 2: Create concrete implementations for each payment method
class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

 class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class BankTransferPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing bank transfer payment of $" + amount);
    }
}

// Step 3: Define the PaymentProcessor class that uses the strategy
 class PaymentProcessor {
    private PaymentMethod paymentMethod;

    // Constructor to set the payment method strategy
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Method to set a different payment method at runtime
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Method to process the payment using the selected strategy
    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}

// Step 4: Testing the Payment System with different strategies
public class A {
    public static void main(String[] args) {
        // Using CreditCardPayment strategy
        PaymentProcessor processor = new PaymentProcessor(new CreditCardPayment());
        processor.processPayment(100.00);

        // Switch to PayPalPayment strategy
        processor.setPaymentMethod(new PayPalPayment());
        processor.processPayment(200.00);

        // Switch to BankTransferPayment strategy
        processor.setPaymentMethod(new BankTransferPayment());
        processor.processPayment(300.00);
    }
}
// Used The STRATERGY PATTERN....
// We can also Use the FACTORY PATTERN 