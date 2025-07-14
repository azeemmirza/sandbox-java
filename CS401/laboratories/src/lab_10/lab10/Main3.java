package lab_10.lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Main3 {
    public static void main(String[] args) {
/*
        (x,y) -> {
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x,y));
            list.add((double) (x * y));
            return list;
        };
*/


//Yes the lambda function can be replaced with a Bifunction <double, double , list<double>>

        BiFunction<Double, Double, List<Double>> func = (x, y) -> {

            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x, y));
            list.add(x * y);
            return list;

        };

        List<Double> result = func.apply(1.1, 2.2);

        System.out.println(result);


    }
}
