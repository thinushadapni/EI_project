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
        Stock appleStock = new Stock("Apple", 150);
        Investor john = new Investor("John");
        Investor emma = new Investor("Emma");

        appleStock.registerObserver(john);
        appleStock.registerObserver(emma);

        appleStock.setPrice(155);
        appleStock.setPrice(160);
    }
}
