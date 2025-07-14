package lab_11.prob11b;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final Function<List<Employee>, String> FILTER_EMPLOYEES =
            list -> list.stream()
                    .filter(e -> e.getSalary() > 100000)
                    .filter(e -> e.getLastName().compareTo("M") > 0)
                    .map(e -> e.getFirstName() + " " + e.getLastName())
                    .sorted()
                    .collect(Collectors.joining(", "));
}
