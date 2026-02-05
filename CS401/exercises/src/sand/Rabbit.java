package sand;

interface A {
    default void display() {
        System.out.println("Display from Interface A");
    }
}

interface B {
    default void display() {
        System.out.println("Display from Interface B");
    }
}

class C implements A, B {

    @Override
    public void display() {
    }
}

public class Rabbit {
    public static void main(String[] args) {
        C obj = new C();
        obj.display(); // Output: Display from Class C
    }
}
