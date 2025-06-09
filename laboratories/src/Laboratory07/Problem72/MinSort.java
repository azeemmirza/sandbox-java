package Laboratory07.Problem72;

// aka SelectionSort
public class MinSort {
    public static int[] sortInteger(int[] input) {
        int length = input.length;

        for (int i = 0; i < length; i++) {
          int minIndex = i;

          for (int j = minIndex + 1; j < length; j++) {
              if (input[i] > input[j]) {
                  int temp = input[i];

                  input[i] = input[j];
                  input[j] = temp;

                  minIndex = j;
              }
          }
        }

        return input;
    }

    public static String sortString(String input) {
        char[] inputArr = input.toCharArray();
        int length = inputArr.length;

        for (int i = 0; i < length; i++) {
            int minIndex = i;

            for (int j = minIndex; j < length; j++) {
                if (inputArr[i] > inputArr[j]) {
                    char temp = inputArr[i];

                    inputArr[i] = inputArr[j];
                    inputArr[j] = temp;

                    minIndex = j;
                }
            }
        }

        return new String(inputArr);
    }
public class MinSort {
    public static String sort(String s){
        StringBuilder sb = new StringBuilder(s);
        int minChar = 27;
        int minpos = 0; // consider the char count will have total 26 (1 to 26)
        //s = abcge
        if( s == null || s == "") return "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - 'a' < minChar) {
                minChar = s.charAt(i) - 'a';
                minpos = i;
            }

        }
        // System.out.println("minps "+minpos);
        sb.deleteCharAt(minpos);
        return s.charAt(minpos) + sort(sb.toString());
    }
    public static void main(String[] args){
        MinSort ms = new MinSort();
        String result = ms.sort("zwxuabfkafutbbbb");
        System.out.println(result);
    }


}
