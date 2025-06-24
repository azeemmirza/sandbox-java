package Laboratory11.Problem112;

import java.util.HashMap;
import java.util.List;

public class Schur {
    public boolean checkForSum(List<Integer> list, Integer z) {
        HashMap<Integer, Integer> h = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            h.put(list.get(i), i);
        }

        for (int i = 0; i < list.size(); i++) {
            int diff = z - list.get(i);

            if (h.containsKey(diff) && h.get(diff) != i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Schur schur = new Schur();
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Integer z = 7;

        boolean result = schur.checkForSum(list, z);
        System.out.println("Is there two elements x, y in the list whose sum is " + z + "? " + result);
    }
}
