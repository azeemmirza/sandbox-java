package Laboratory04.Problem45.ClosedCurve;

public interface Polygon {
    // Abstract method
    double[] getArrayOfSides();

    // Static utility method
    static double sum(double[] arr) {
        double total = 0;
        for (double d : arr) {
            total += d;
        }
        return total;
    }

    // Default method for perimeter
    default double computePerimeter() {
        return Polygon.sum(getArrayOfSides());
    }

    public int getNumberOfSides();
}
