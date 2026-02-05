import java.util.function.*;
import java.util.*;

public class PropertyManagementLambdas {

    public static void main(String[] args) {
        // A. Address Standardization
        Function<String, String> standardizeAddress = address -> address.toUpperCase();

        // B. Rent Calculation
        BiFunction<Double, Double, Double> calculateTotalRent = (baseRent, fees) -> baseRent + fees;

        // C. Property Sorting
        Comparator<Property> sortByBedroomsDescending = (p1, p2) -> Integer.compare(p2.getBedrooms(), p1.getBedrooms());

        // D. Owner Display Name
        BiFunction<String, String, String> displayOwnerName = (first, last) -> first + " " + last;

        // E. Maintenance Request ID Generation
        BiFunction<String, Integer, String> generateRequestId = (propertyId, requestNo) -> propertyId + "-" + requestNo;
    }

    static class Property {
        private int bedrooms;
        public Property(int bedrooms) {
            this.bedrooms = bedrooms;
        }
        public int getBedrooms() {
            return bedrooms;
        }
    }
}
