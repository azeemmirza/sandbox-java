package Laboratory02.Problem27;

import java.util.Random;

public class AdditionProblems {
    public static void main(String[] args) {
        // Create a Random object for generating random numbers
        Random random = new Random();

        // Loop to generate 8 addition problems
        for (int i = 0; i < 8; i++) {
            // Generate two random numbers between 1 and 99
            int num1 = random.nextInt(99) + 1;
            int num2 = random.nextInt(99) + 1;

            // Print the first line with the numbers
            System.out.printf("%2d %3d ", num1, num2);

            // Print the second line with the addition signs
            System.out.print("+ ");
            System.out.printf("%2d %3d ", num1, num2);

            // Print the sum below the lines
            System.out.print("_____ ");
            System.out.println();
        }
    }
}
