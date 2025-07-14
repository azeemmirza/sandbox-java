package lab_11.prob3;

import java.util.stream.Stream;

public class Prime {

    // Part A.txt: primes stream (not reusable)
    private final Stream<Integer> primes = Stream.iterate(2, Prime::nextPrime);

    // Part B: reusable stream via a supplier method
    private Stream<Integer> getPrimesStream() {
        return Stream.iterate(2, Prime::nextPrime);
    }

    public void printFirstNPrimes(long n) {
        getPrimesStream()
                .limit(n)
                .forEach(System.out::println);
    }

    // Finds next prime number after given number
    private static int nextPrime(int current) {
        int next = current + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    // Checks if number is prime
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Prime ps = new Prime();
        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);
    }
}
