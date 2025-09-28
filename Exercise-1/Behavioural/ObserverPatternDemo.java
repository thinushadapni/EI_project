import java.util.*;

interface Observer {
    void update(String stockName, double price);
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class Stock implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public Stock(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    public void update(String stockName, double price) {
        System.out.println(name + " notified. " + stockName + " price changed to " + price);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stock name: ");
        String stockName = sc.nextLine();
        System.out.print("Enter initial stock price: ");
        double price = sc.nextDouble();
        sc.nextLine(); 

        Stock stock = new Stock(stockName, price);

        System.out.print("Enter number of investors: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name of investor " + i + ": ");
            String investorName = sc.nextLine();
            stock.registerObserver(new Investor(investorName));
        }

        String choice;
        do {
            System.out.print("Enter new stock price: ");
            double newPrice = sc.nextDouble();
            stock.setPrice(newPrice);

            System.out.print("Update price again? (yes/no): ");
            choice = sc.next().toLowerCase();
        } while (choice.equals("yes"));

        sc.close();
    }
}
