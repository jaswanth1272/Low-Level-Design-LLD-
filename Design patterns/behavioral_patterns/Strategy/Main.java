// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy 1: CreditCardPayment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card. Card Number: " + cardNumber);
    }
}

// Concrete Strategy 2: PayPalPayment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal. Email: " + email);
    }
}

// Concrete Strategy 3: CryptocurrencyPayment
class CryptocurrencyPayment implements PaymentStrategy {
    private String cryptoAddress;

    public CryptocurrencyPayment(String cryptoAddress) {
        this.cryptoAddress = cryptoAddress;
    }

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cryptocurrency. Address: " + cryptoAddress);
    }
}

// Context: PaymentService
class PaymentService {
    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Customer chooses payment methods dynamically
        PaymentService paymentService = new PaymentService(new CreditCardPayment("1234-5678-9101-1121", "John Doe"));
        paymentService.processPayment(100); // Paid using Credit Card

        // Switch to PayPal payment method
        paymentService.setPaymentStrategy(new PayPalPayment("johndoe@example.com"));
        paymentService.processPayment(200); // Paid using PayPal

        // Switch to Cryptocurrency payment method
        paymentService.setPaymentStrategy(new CryptocurrencyPayment("0xA1B2C3D4E5F67890"));
        paymentService.processPayment(500); // Paid using Cryptocurrency
    }
}
