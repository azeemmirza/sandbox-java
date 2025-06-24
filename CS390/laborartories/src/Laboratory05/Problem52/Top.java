package Laboratory05.Problem52;

public class Top {
	int t = 1;
	Middle mid;
	Middle.Bottom midbot;

	public Top() {
		mid = new Middle();
		midbot = mid.new Bottom();
	}

	// Returns the value in the instance variable of Bottom
	int readBottom() {
		return midbot.b;
	}

	class Middle {
		int m = 2;

		int addTopAndBottom() {
			return t + midbot.b;
		}

		class Bottom {
			int b = 3;

			int multiplyAllThree() {
				return t * m * b;
			}
		}
	}

	public static void main(String[] args) {
		Top top = new Top();
		System.out.println(top.readBottom());
		System.out.println(top.mid.addTopAndBottom());
		System.out.println(top.midbot.multiplyAllThree());
	}
}
