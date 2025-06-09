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
}
