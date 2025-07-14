package lab_11.prob12;

import java.util.Optional;

public class MySingletonLazy {
    private static MySingletonLazy instance = null;

    private MySingletonLazy() {
    }

    public static MySingletonLazy getInstance() {
        return Optional.ofNullable(instance).orElseGet(MySingletonLazy::new);
    }

    public void showMessage() {
        System.out.println("Singleton instance is working.");
    }
}
