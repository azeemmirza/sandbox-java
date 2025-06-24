package Laboratory04.Problem42_44.ClosedCurve;

public class Rectangle extends ClosedCurve implements Polygon {
    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double computeArea() {
        return this.length * this.width;
    }

    @Override
    public int getNumberOfSides() {
        return 4;
    }

    @Override
    public double computePerimeter() {
        return  2 * (this.length + this.width);
    }
}
