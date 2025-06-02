package Laboratory05.Problem51;

public class MySingleton {
    // Step 1: Eagerly create the singleton instance
    private static final MySingleton INSTANCE = new MySingleton();

    // Step 2: Private constructor to prevent instantiation
    private MySingleton() {
        // Optional: You can throw an exception if reflection is used to break singleton
        if (INSTANCE != null) {
            throw new RuntimeException("Use getInstance() method to access the singleton.");
        }
    }

    // Step 3: Public method to provide access to the singleton instance
    public static MySingleton getInstance() {
        return INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

