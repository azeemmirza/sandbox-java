package lab_13.prob_05;

import java.util.*;


public class Problem05 {
    /**
     * to fine the second smallest number list
     * @param list - array of number
     * @return - return comparable
     *
     * @param <T>
     */
    public static <T extends Comparable<T>> T secondSmallest(List<T> list) {
        if (list == null || list.size() < 2) {
            throw new Error("add atleast two elements");
        }

        T smallest = null;
        T secondSmallest = null;

        for (T item : list) {
            if (smallest == null || item.compareTo(smallest) < 0) {
                secondSmallest = smallest;
                smallest = item;
            } else if (!item.equals(smallest) &&
                    (secondSmallest == null || item.compareTo(secondSmallest) < 0)) {
                secondSmallest = item;
            }
        }

        if (secondSmallest == null) {
            throw new IllegalArgumentException("List must contain at least two distinct elements.");
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 1, 5, 1, 3);
        System.out.println("Second smallest (Integer): " + secondSmallest(nums));

        List<String> words = Arrays.asList("banana", "apple", "cherry", "apple");
        System.out.println("Second smallest (String): " + secondSmallest(words));
    }
}
