package lab_13.prob_01;

import java.util.*;

public class Problem01 {
    public static void main(String[] args) {
        // Consider the following code fragments. For each, if there is a compiler error, identify where it occurs.
        // a. First fragment:

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);

        // List<Number> nums = ints; <--- COMPILER ERROR HERE.
        // nums.add(3.14);

        // b. Second fragment:
        List<Integer> ints02 = new ArrayList<>();
        ints02.add(1);
        ints02.add(2);

        List<? extends Number> nums = ints;
       //  nums.add(3.14); <--- COMPILER ERROR HERE
    }
}
