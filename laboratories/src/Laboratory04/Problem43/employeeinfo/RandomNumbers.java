package Laboratory04.Problem43.employeeinfo;

import java.util.Random;

public class RandomNumbers {
    static Random random;

    private RandomNumbers() {
        random = new Random();
    }

    public static int getRandomInt() {
        if (random == null) new RandomNumbers();
        return random.nextInt();
    }

    public static int getRandomInt(int lower, int upper) {
        if(lower > upper) return 0;
        if(lower == upper) return lower;
        int difference = upper - lower;
        int start = getRandomInt();

        start = Math.abs(start) % (difference+1);

        start += lower;
        return start;
    }
}