import java.util.*;

public class BeverageSugarAnalyzer {
    public static void main(String[] args) {
        Map<String, String> beverageSugarMap = Map.ofEntries(
                Map.entry("Cold Brew Coffee", "0"),
                Map.entry("Iced Green Tea", "7"),
                Map.entry("Sparkling Water", "N/A"),
                Map.entry("Lemonade", "20"),
                Map.entry("Berry Smoothie", "N/A"),
                Map.entry("Chai Latte", "22"),
                Map.entry("Coconut Water", "15"),
                Map.entry("Apple Juice", "31"),
                Map.entry("Classic Soda", "49"),
                Map.entry("Orange Juice", "23"),
                Map.entry("Detox Green Smoothie", "16")
        );

        beverageSugarMap.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), parseSugar(entry.getValue())))
                .filter(entry -> entry.getValue() != -1)
                .filter(entry -> entry.getKey().toLowerCase().contains("juice") || entry.getKey().toLowerCase().contains("smoothie"))
                .filter(entry -> entry.getValue() < 30)
                .sorted(Comparator.comparingInt(Map.Entry<String, Integer>::getValue).thenComparing(Map.Entry::getKey))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static int parseSugar(String sugarStr) {
        try {
            return Integer.parseInt(sugarStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}