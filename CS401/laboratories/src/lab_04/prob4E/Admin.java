package Assignment4.prob4E;

import java.util.List;

public class Admin {
	public static double computeUpdatedBalanceSum(List<Employee> list) {
		double total = 0;
		for (Employee emp : list) {
			total += emp.computeUpdatedBalanceSum();
		}
		return total;
	}
}
