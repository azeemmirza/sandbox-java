package Laboratory05.Problem51;

public class Problem51 {
    public static void main(String[] args) {
        MySingleton instance1 = MySingleton.getInstance();
        MySingleton instance2 = MySingleton.getInstance();

        System.out.println("Are both instances the same? " + (instance1 == instance2));

        instance1.showMessage();
    }
}
