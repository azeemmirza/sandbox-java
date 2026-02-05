package lab_13.prob_04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Problem04 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
        double dbl = sum(nums);
        // nums.add(3.14);
        // we have ? and this ? is some child of number that we don't know, so the program doesn't know what type are we going to enter


        List<Object> objs = new ArrayList<>();
        objs.add(1);
        objs.add("two");
        List<? super Integer> intsB = objs;
        ints.add(3);
        //double dbl1 = sum(intsB);
        // we do not know if the actual elements inside intsB are Number or not
    }

    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) s += num.doubleValue();
        return s;
    }

    public static <T> List<List<T>> group(List<A> items ) {
        List<List<T>> list = new ArrayList<>();

        for (A item : items) {
            List<T> itemList = new ArrayList<>();

        }

    }
}
