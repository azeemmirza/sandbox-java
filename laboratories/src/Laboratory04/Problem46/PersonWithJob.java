package Laboratory04.Problem46;

import java.util.GregorianCalendar;
import java.util.Objects;

public class PersonWithJob {
    private Person person;
    private double salary;

    public PersonWithJob(String name, GregorianCalendar dob, double salary) {
        this.person = new Person(name, dob);
        this.salary = salary;
    }

    public Person getPerson() {
        return person;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PersonWithJob)) return false;
        PersonWithJob other = (PersonWithJob) obj;
        return person.equals(other.person) && Double.compare(salary, other.salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, salary);
    }
}


