package lab_03.prob3;

public class Cylinder {
    private final double height;
    private final Circle base;

    public Cylinder(double radius, double height) {
        this.base = new Circle(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double computeVolume() {
        return base.computeArea() * height;
    }

    public double getBaseRadius() {
        return base.getRadius();
    }
}
