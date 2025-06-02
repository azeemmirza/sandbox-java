package Laboratory04.Problem42_44;

import Laboratory04.Problem42_44.ClosedCurve.*;

public class Problem44 {
    public static void main(String[] args) {

        Polygon[] objects = {
                new Square(3),
                new Triangle(4,5,6),
                new Rectangle(3, 7),
        };

        for(Polygon cc : objects) {
            String className = cc.getClass().getSimpleName();

            System.out.println("For this " + className + ": ");
            System.out.println("\tNumber of Sides = " + cc.getNumberOfSides());
            System.out.println("\tPerimeter = " + cc.computePerimeter() + "\n");
        }
    }
}
