package Laboratory03.Problem34;

public class Rectangle{
    private double base;
    private double height;

    public Rectangle(double base, double height) {
       this.base = base;
       this.height = height;
    }

    public double getBase() {
        return base;
    }
    public double getHeight() {
        return height;
    }
    public double getArea() {
        return base * height;
    }
}



