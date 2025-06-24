package Laboratory02.Problem26;

public class Problem26 {

    public static String[] removeDups(String[] inputArray) {
        // Create a new array with a maximum size of the original array
        String[] tempArray = new String[inputArray.length];
        int uniqueCount = 0;

        // Loop through the input array
        for (int i = 0; i < inputArray.length; i++) {
            boolean isDuplicate = false;

            // Check if the element is already in the tempArray
            for (int j = 0; j < uniqueCount; j++) {
                if (inputArray[i].equals(tempArray[j])) {
                    isDuplicate = true;
                    break;
                }
            }

            // If it's not a duplicate, add it to the tempArray
            if (!isDuplicate) {
                tempArray[uniqueCount] = inputArray[i];
                uniqueCount++;
            }
        }

        // Create a final array of the exact size of unique elements
        String[] resultArray = new String[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            resultArray[i] = tempArray[i];
        }

        // Return the new array with unique elements
        return resultArray;
    }

    public static void main(String[] args) {
        // Test the removeDups method
        String[] input = {"horse", "dog", "cat", "horse", "dog"};
        String[] result = removeDups(input);

        // Print the result
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

