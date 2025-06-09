package Laboratory07.Problem73;

import java.util.LinkedList;
import java.util.List;

public class Problem73 {
    public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2){
        //if one of the input lists is empty, get the remaining list
        if(list1 == null || list1.isEmpty())
            return new LinkedList<>(list2);

        if(list2 == null || list2.isEmpty())
            return new LinkedList<>(list1);


        LinkedList<Integer> list3 = new LinkedList<>();
        //list1 = [2, 5, 8, 11] - 2
        int first1 = list1.getFirst();
        //list2 = [1,3,6] - 1
        int first2 = list2.getFirst();

        if(first1 < first2){
            list1.removeFirst();
            list3.add(first1);
        }
        else if(first2 < first1){
            list2.removeFirst();
            list3.add(first2);
        }

        list3.addAll(merge(list1,list2));
        return list3;

    }

    public static void main(String[] args){
        //input arrays - two sorted arrays
        LinkedList<Integer> list1 = new LinkedList<>(List.of(2, 5, 8, 11));
        LinkedList<Integer> list2 = new LinkedList<>(List.of(1, 3, 6));

        System.out.println(merge(list1,list2));
    }

}

