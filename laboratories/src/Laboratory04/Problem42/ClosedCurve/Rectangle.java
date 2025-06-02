package Laboratory04.Problem42.ClosedCurve;

public class Rectangle extends ClosedCurve {
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
}
