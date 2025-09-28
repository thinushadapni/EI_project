import java.util.Scanner;

class ConfigurationManager {
    private static ConfigurationManager instance;
    private String config;

    private ConfigurationManager() {
        config = "Default Configuration";
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}

// Demo
public class SingletonPatternDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConfigurationManager cm1 = ConfigurationManager.getInstance();

        System.out.print("Enter configuration setting: ");
        String userConfig = sc.nextLine();
        cm1.setConfig(userConfig);

        ConfigurationManager cm2 = ConfigurationManager.getInstance();
        System.out.println("Config from second reference: " + cm2.getConfig());

        sc.close();
    }
}
