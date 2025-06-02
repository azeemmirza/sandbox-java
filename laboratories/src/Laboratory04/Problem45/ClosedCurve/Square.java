package Laboratory04.Problem45.ClosedCurve;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}

	@Override
	public int getNumberOfSides() {
		return 4;
	}

	@Override
	public double[] getArrayOfSides() {
		return new double[]{ side, side, side, side };
	}
}
