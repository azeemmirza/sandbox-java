package Laboratory05.Problem53;

public class MainLambda {
    public static void main(String[] args) {
        String[] test = {"banana", "apple", "fig", "blueberry", "kiwi"};

        // Pass a lambda expression comparator
        StringSort sorter = new StringSort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        String[] result = sorter.stringSort(test);

        for (String s : result) {
            System.out.println(s);
        }
    }
}

