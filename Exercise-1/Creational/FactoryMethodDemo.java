// Factory Method Pattern Example

interface Notification {
    void notifyUser();
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS Notification");
    }
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email Notification");
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        return null;
    }
}

// Demo
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.createNotification("SMS");
        notification1.notifyUser();

        Notification notification2 = NotificationFactory.createNotification("EMAIL");
        notification2.notifyUser();
    }
}
