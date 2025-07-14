package lab_13.prob1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //a.  First fragment:
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        Number dd = ints.get(1);
//        List<Number> nums = ints; // Integer extends Number, but List<Integer> is not a subtype of List<Number>.
//        nums.add(3.14);


        //b. Second fragment:
        List<Integer> intsB = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = intsB;
        //nums.add(3.14); // (?) can be any type extend number like integer or double... so we dont know which one, means the compiler won't accept it

    }
}
