package Laboratory02.Problem23;

public class Prog3 {
    public static void main(String[] args) {
        float x = 1.27F;
        float y = 3.881F;
        float z = 9.6F;

        float sum = x + y + z;

        int floatAsInt = (int) sum;

        int roundingSum = Math.round(sum);

        System.out.println("sum of the floats as an integer, obtained by casting: " + floatAsInt);
        System.out.println("sum of the floats as an integer,  obtained by rounding: " + roundingSum);
    }
}
