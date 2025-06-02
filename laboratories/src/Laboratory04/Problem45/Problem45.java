package Laboratory04.Problem45;

import Laboratory04.Problem4244.ClosedCurve.Polygon;
import Laboratory04.Problem4244.ClosedCurve.Rectangle;
import Laboratory04.Problem4244.ClosedCurve.Square;
import Laboratory04.Problem4244.ClosedCurve.Triangle;

public class Problem45 {
    public static void main(String[] args) {
        Polygon[] shapes = {
                new Square(3),
                new Triangle(4, 5, 6),
                new Rectangle(3, 4),
        };

        for (Polygon p : shapes) {
            System.out.println("For this " + p.getClass().getSimpleName());
            System.out.println(" Perimeter = " + p.computePerimeter());
        }
    }
}
