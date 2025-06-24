package Laboratory02.Problem24;

public class Problem24 {

    public static void main(String[] args) {
        // Access the records from Data class (simulated in this example)
        String myString = Data.records;

        // Split the records by the colon ":" delimiter to get each record
        String[] records = myString.split(":");

        // Loop through each record to extract and print the productId
        for (String record : records) {
            // Split each record by the comma "," delimiter
            String[] columns = record.split(",");

            // The productId is always the first column in each record
            String productId = columns[0];

            // Print the productId to the console
            System.out.println(productId);
        }
    }
}

// Simulating the Data class (in real use, this class would be provided)
class Data {
    // Simulated records string
    public static final String records = "134A,Product1,100.00:213A,Product2,150.00:911C,Product3,200.00:012E,Product4,250.00:662Z,Product5,300.00";
}