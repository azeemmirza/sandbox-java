
public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        byte smallNum = 127;
        byte operand = 3;

        int result = smallNum + operand;

        System.out.println(result);
    }
}