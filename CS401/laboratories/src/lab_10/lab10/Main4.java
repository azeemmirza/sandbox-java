package lab_10.lab10;

import java.util.List;

public class Main4 {
    public static void main(String[] args) {

    }

    int countWords(List<String> words, char c, char d, int len) {
        var wordCount = words.stream()
                .filter(w -> w.length() == len)
                .filter(w -> w.indexOf(c) != -1)
                .filter(w -> w.indexOf(d) == -1)
                .count();
        return (int) wordCount;
    }

}
