package Laboratory03.Problem34;

public class Triangle{
    private double base;
    private double height;

    public Triangle(double base, double height) {
       this.base = base;
       this.height = height;
    }

    public double computeArea() {
        return (0.5 * base * height);
    }

    @Override
    public String toString() {
        return "Area of a Triangle = " + computeArea();
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}