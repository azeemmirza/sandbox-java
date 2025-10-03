package lab_03.prob1;

public class PersonWithJob extends Person {
	
	private final double salary;
	
	public double getSalary() {
		return salary;
	}

	PersonWithJob(String n, double s) {
		super(n);
		salary = s;
	}
	
	@Override
	public boolean equals(Object aPersonWithJob) {
		if(aPersonWithJob == null) {
			return false;
		}

		if(!(aPersonWithJob instanceof PersonWithJob)) {
			return false;
		}

		PersonWithJob person = (PersonWithJob)aPersonWithJob;

		boolean isEqual = this.getName().equals(person.getName()) &&
				this.getSalary() == person.getSalary();

		return isEqual;
	}
	
	public static void main(String[] args) {
		Person p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}
}
