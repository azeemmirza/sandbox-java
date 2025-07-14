package lab_11.prob10;

import java.util.*;
import java.util.stream.*;

public class Or {

    public static void main(String[] args) {
        List<Simple> list = Arrays.asList(
                new Simple(false),
                new Simple(false),
                new Simple(true)
        );

        Or orChecker = new Or();
        System.out.println("Part a result: " + orChecker.someSimpleIsTrue(list));

        // Part b
        Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
        String result = stringStream.collect(Collectors.joining(", "));
        System.out.println("Part b result: " + result);

        // Part c
        Stream<Integer> myIntStream = Stream.of(3, 7, 2, 10, 5);
        IntSummaryStatistics stats = myIntStream.mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Part c result: Min = " + stats.getMin() + ", Max = " + stats.getMax());
    }

    // Part a
    public boolean someSimpleIsTrue(List<Simple> list) {
        return list.stream()
                .map(s -> s.flag)
                .reduce(false, (a, b) -> a || b);
    }
}
