import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);

        String choice;
        do {
            System.out.print("Enter notification type (SMS/EMAIL): ");
            String type = sc.nextLine();

            Notification notification = NotificationFactory.createNotification(type);

            if (notification != null) {
                notification.notifyUser();
            } else {
                System.out.println("Invalid notification type. Try again.");
            }

            System.out.print("Do you want to send another notification? (yes/no): ");
            choice = sc.nextLine().toLowerCase();

        } while (choice.equals("yes"));

        sc.close();
    }
}
