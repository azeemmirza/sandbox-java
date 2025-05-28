package Laboratory02.Problem28;

public class Problem28 {

    public static int min(int[] arrayOfInts) {
        // Initialize the minimum to the first element
        int minValue = arrayOfInts[0];

        // Iterate through the array to find the minimum value
        for (int i = 1; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] < minValue) {
                minValue = arrayOfInts[i];
            }
        }

        // Return the minimum value found
        return minValue;
    }
}
