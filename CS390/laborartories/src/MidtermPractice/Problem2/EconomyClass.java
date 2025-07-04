package MidtermPractice.Problem2;

public class EconomyClass implements BoardingTime {
	private double capacity;

	public EconomyClass(double capacity) {
		this.capacity = capacity;
	}

	@Override
	public double computeBoardingTime() {
		return capacity / 10 + Math.sqrt(capacity);
	}
}

