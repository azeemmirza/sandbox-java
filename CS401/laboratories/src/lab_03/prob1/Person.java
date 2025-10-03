package lab_03.prob1;

public class Person {
	private final String name;

	Person(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object aPerson) {
		if (aPerson == null) return false;
		if (!(aPerson instanceof Person)) return false;
		Person p = (Person) aPerson;
		return this.name.equals(p.name);
	}
}
