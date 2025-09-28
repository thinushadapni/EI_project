import java.util.Scanner;

// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method first.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

// Demo
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        String choice;
        do {
            System.out.print("Enter amount to pay: ");
            int amount = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Select Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.print("Choice: ");
            int option = sc.nextInt();
            sc.nextLine(); 

            switch (option) {
                case 1:
                    cart.setPaymentStrategy(new CreditCardPayment());
                    break;
                case 2:
                    cart.setPaymentStrategy(new PayPalPayment());
                    break;
                default:
                    System.out.println("Invalid option. Defaulting to Credit Card.");
                    cart.setPaymentStrategy(new CreditCardPayment());
            }

            cart.checkout(amount);

            System.out.print("Do you want to make another payment? (yes/no): ");
            choice = sc.nextLine().toLowerCase();

        } while (choice.equals("yes"));

        sc.close();
    }
}
