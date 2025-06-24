package Laboratory11.Problem111;

import java.util.HashMap;

public class Employee {
	private String firstName;
	private String lastName;
	private HashMap salaryRecord;
	
	public Employee(){
		salaryRecord = new HashMap<String,Double>();
	}

	public void addEntry(String date, double salary) {
		salaryRecord.put(date, salary);
	}

	public void printPaymentAmount(String date) {
		if(!salaryRecord.containsKey(date))
			System.out.println(getFirstName() +" did not receive a paycheck on  "+ date);
		else
			System.out.println(getFirstName() + " "+ getLastName()+" was paid " + salaryRecord.get(date) +" on " + date);

	}

	public void printAveragePaycheck(){
		double average = 0.0;
		for(Object key: salaryRecord.keySet()){
			average += (double) salaryRecord.get(key);
		}
		average = average/salaryRecord.size();
		System.out.println("Average paycheck for "+ getFirstName()+" " + getLastName() + " was " + average);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setFirstName("Jim");
		e.setLastName("Jones");
		for(int i = 1; i <= 12; ++i) {
			e.addEntry(i+"/15/2011", 3070+5*i);
		}
		e.printPaymentAmount("3/15/2011");
		e.printPaymentAmount("5/15/2010");
		e.printAveragePaycheck();
	}
}
