package Laboratory07.Problem74;

import java.util.Arrays;

public class Problem74 {
    public static int[] reverseArray(int[] arr){

        return reverseHelper(arr, 0, arr.length-1);
    }

    public static int[] reverseHelper(int[] arr, int start, int end){
        //base condition, to break recurrsive
        if (start > end)
            return arr;

        //swap
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        return reverseHelper(arr, ++start, --end);
    }
    public static void main(String[] args){
        int[] arr = new int[]{1, 3, 5, 7, 9, 13};
        System.out.println(Arrays.toString(reverseArray(arr)));
    }
}

