package lab_11_1.prob3;

import java.util.stream.Stream;

public class PrimeStream {

    private int counter = 0;

    PrimeStream() {
        this.counter = 0;
    }

    public int next() {
        this.counter++;

        return this.counter;
    }

    /**
     * checks if number is prime.
     * @param num - integer number
     * @return - return true or false.
     */
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void printFirstNPrimes(int n) {
        Stream.iterate(0, i -> i + 1)
                .filter(this::isPrime)
                .limit(n)
                .forEach(i -> System.out.print(i + " "));
    }



    @Override
    public String toString() {
        return String.valueOf(this.counter);
    }
}
