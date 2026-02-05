// QUESTION 04:

package lab_10;

import java.util.List;
import java.util.Arrays;

public class Q04WordCounter {
    public int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream()
            .filter(word -> word.length() == len)
            .filter(word -> word.indexOf(c) >= 0)
			.filter(word -> word.indexOf(d) < 0)
			.count();
	}


	public static void main(String[] args) {
	    Q04WordCounter counter = new Q04WordCounter();
		List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "application", "grape");

		int count = counter.countWords(words, 'a', 'e', 5);
		System.out.println("Count: " + count);
	}
}