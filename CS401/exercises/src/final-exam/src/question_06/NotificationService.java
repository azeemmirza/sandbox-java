public enum NotificationService {
    INSTANCE;

    public void sendAlert(String message) {
        System.out.println("ALERT: " + message);
    }
}
