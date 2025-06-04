package lesson7.exercise_2;

public class Fib {
	
	public int fib(int n) {
		if (n <= 1) {
			return 1;
		}

		return this.fib(n - 2) + this.fib(n - 1) ;
	}
	
	public static void main(String[] args) {
		Fib f = new Fib();
		System.out.println(f.fib(10));
	}
}


