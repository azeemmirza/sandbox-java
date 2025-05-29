package Laboratory03.Problem34;

public class Rectangle{
    private final double base;
    private final double height;

    public Rectangle(double base, double height) {
       this.base = base;
       this.height = height;
    }

    public double computeArea() {
        return base * height;
    }

    @Override
    public String toString() {
        return "Area of a rectangle = " + computeArea();
    }
    public double getBase() {
        return base;
    }
    public double getHeight() {
        return height;
    }
}



