package lab_05.prob3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<ClosedCurve> shapes = new ArrayList<>();

        shapes.add(new Rectangle(5, 4));         // Area: 20
        shapes.add(new Triangle(3, 6));          // Area: 9
        shapes.add(new Circle(2));               // Area: ~12.57

        double totalArea = 0.0;

        for (ClosedCurve shape : shapes) {
            totalArea += shape.computeArea();
        }

        System.out.printf("Sum of Areas = %.2f\n", totalArea); // Expected ~41.57
    }
}