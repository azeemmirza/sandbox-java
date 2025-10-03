package lab_03.prob3;

public class Problem33 {
      public static void main(String[] args) {
        // Create a Circle
        Circle circle = new Circle(5.0);
        System.out.println("Circle radius: " + circle.getRadius());
        System.out.println("Circle area: " + circle.computeArea());

        // Create a Cylinder using the Circle's radius
        Cylinder cylinder = new Cylinder(5.0, 10.0);
        System.out.println("Cylinder base radius: " + cylinder.getBaseRadius());
        System.out.println("Cylinder height: " + cylinder.getHeight());
        System.out.println("Cylinder volume: " + cylinder.computeVolume());
    }
}
