package lab_10.lab10;

import java.util.Comparator;
import java.util.function.Supplier;

public class Main1 {
    static int s = 3;
    static int t = 4;
    static boolean ignoreCase = true;

    public static void main(String[] args) {
        // Lambda i: Runnable
        // Parameters: none
        // Free variables: s, t
        Runnable r = () -> {
            int[][] products = new int[s][t];
            for (int i = 0; i < s; i++) {
                for (int j = i + 1; j < t; j++) {
                    products[i][j] = i * j;
                }
            }
        };

        // Lambda ii: Comparator<String>
        // Parameters: s, t (strings)
        // Free variable: ignoreCase
        Comparator<String> comp = (s, t) -> {
            if (ignoreCase) {
                return s.compareToIgnoreCase(t);
            } else {
                return s.compareTo(t);
            }
        };

        // i. Method reference as lambda expression
        Supplier<Double> lambda = () -> Math.random();

        // ii. Use the lambda to print a random number
        System.out.println("Lambda output: " + lambda.get());

        // iii. Equivalent inner class
        class RandomSupplier implements Supplier<Double> {
            @Override
            public Double get() {
                return Math.random();
            }
        }

        Supplier<Double> innerClass = new RandomSupplier();
        System.out.println("Inner class output: " + innerClass.get());
    }

}
