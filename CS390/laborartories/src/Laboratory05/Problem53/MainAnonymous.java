package Laboratory05.Problem53;

import java.util.Comparator;

public class MainAnonymous {
    public static void main(String[] args) {
        String[] test = {"banana", "apple", "fig", "blueberry", "kiwi"};

        // Pass an anonymous Comparator to StringSort
        StringSort sorter = new StringSort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        });

        String[] result = sorter.stringSort(test);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
