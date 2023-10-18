package task_2_19_1;

public class Main2 {
    public static void main(String[] args) {
        ConfigSingleton config = ConfigSingleton.getInstance();
        System.out.println("ConfigSingleton hash code: " + config.hashCode());
        System.out.println("Host: " + config.getProperty("host"));
        System.out.println("Port: " + config.getProperty("port"));
    }
}

