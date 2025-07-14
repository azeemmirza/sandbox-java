package lab_13.prob5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        System.out.println(secondSmallest(list));

        List<String> names = List.of("Amine", "Bassem", "Chris", "Nina", "Kai", "Kristian");
        System.out.println(secondSmallest(names));

    }

    public static <T extends Comparable<T>> T secondSmallest(List<T> list) {
        if (list == null || list.size() < 2)
            throw new IllegalArgumentException("List must have at least 2 elements.");

        List<T> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        T smallest = sorted.getFirst();
        for (T elem : sorted) {
            if (!elem.equals(smallest)) {
                return elem;
            }
        }

        throw new NoSuchElementException("No second smallest element found.");
    }

}
