package Laboratory02.Problem25;

import java.util.Scanner;

public class Problem25 {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Loop through the string from the last character to the first
        System.out.print("Reversed string: ");
        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.print(input.charAt(i));  // Print each character in reverse order
        }

        // Close the scanner
        scanner.close();
    }
}

