package Assignment4.prob4E;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private List<Account> accounts = new ArrayList<>();

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addAccount(Account acct) {
		accounts.add(acct);
	}

	public double computeUpdatedBalanceSum() {
		double sum = 0;
		for (Account acct : accounts) {
			sum += acct.computeUpdatedBalance();
		}
		return sum;
	}


}
