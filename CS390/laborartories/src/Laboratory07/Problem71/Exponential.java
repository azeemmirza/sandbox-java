package Laboratory07.Problem71;

public class Exponential {

    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            throw new IllegalArgumentException("Exponent must be a non-negative integer.");
        } else {
            return x * power(x, n - 1);
        }
    }

    public static void main(String[] args) {
        Exponential exp = new Exponential();
        double x = 2;
        int n = 10;
        double result = exp.power(x, n);
        System.out.println(x + " raised to the power of " + n + " is: " + result);
    }
}
