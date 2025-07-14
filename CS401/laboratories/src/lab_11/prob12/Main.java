package lab_11.prob12;

public class Main {
    public static void main(String[] args) {
        MySingletonLazy singleton1 = MySingletonLazy.getInstance();
        MySingletonLazy singleton2 = MySingletonLazy.getInstance();

        singleton1.showMessage();

        System.out.println(singleton1 == singleton2);
    }
}