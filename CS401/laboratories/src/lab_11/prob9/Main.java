package lab_11.prob9;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        printSquares(10); // output 1, 4, 9, 16
    }

    static void printSquares(int num) {
        IntStream.iterate(1, i -> i + 1)
                .limit(num)
                .forEach(i -> System.out.print((i * i) + " "));
    }

}
