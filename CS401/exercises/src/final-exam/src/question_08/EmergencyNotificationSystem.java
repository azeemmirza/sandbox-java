import java.util.concurrent.*;

public class EmergencyNotificationSystem {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 20; i++) {
            final int staffId = i;
            executor.execute(() -> sendAlert("Staff-" + staffId));
        }

        executor.shutdown();
    }

    public static void sendAlert(String staff) {
        System.out.println("Alert sent to: " + staff);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
