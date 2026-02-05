// QUESTION 03:
package lab_10;

import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

public class Q03BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<Double, Double, List<Double>> calculator = (x, y) -> {
            List<Double> list = new ArrayList<>();
			list.add(Math.pow(x, y));
			list.add(x * y);

			return list;
		};

		List<Double> result = calculator.apply(2.0, 3.0);
		System.out.println(result);
	}
}