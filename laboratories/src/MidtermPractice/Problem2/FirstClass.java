package MidtermPractice.Problem2;

public class FirstClass implements BoardingTime {
	Status status;

	public FirstClass(Status status) {
		this.status = status;
	}

	@Override
	public double computeBoardingTime() {
		switch (status) {
			case GOLD:
				return 1;
			case SILVER:
				return 5;
			default:
				return 10;
		}
	}
}

