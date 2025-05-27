
public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        byte smallNum = 127;
        byte operand = 3;

        int result = smallNum + operand;

        System.out.println(result);

        String name = "Robert";

        System.out.println(name.substring(0,3));
        System.out.println(name.substring(0, name.length()));

        System.out.println(name.indexOf('t'));
        System.out.println(name.indexOf("bert"));

        System.out.println("------------------");
        for (int i = 0; i < 3; ++i) {
            System.out.println(i);
        }

        System.out.println("------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }


    }
}