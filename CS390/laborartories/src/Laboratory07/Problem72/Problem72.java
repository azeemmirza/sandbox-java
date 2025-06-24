package Laboratory07.Problem72;

import java.util.Arrays;

public class Problem72 {
    public static void main(String[] args) {

        System.out.println("Problem 72: ");
        System.out.println("______________________");
        int[] input01 = { 2, 5, 4, 101, 78, 0, 2 };
        int[] result01 = MinSort.sortInteger(input01);

        System.out.println(Arrays.toString(result01));

        System.out.println("______________________");

        String input02 = "zwxuabfkafutbbbb";
        String result02 = MinSort.sortString(input02);

        System.out.println(result02);

        System.out.println('a' < 'b');

    }
}
