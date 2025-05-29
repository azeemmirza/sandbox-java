package Laboratory03.Problem34;

public class Circle {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double computeArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Area of a circle = " + computeArea();
    }

    public double getRadius() {
        return radius;
    }
}