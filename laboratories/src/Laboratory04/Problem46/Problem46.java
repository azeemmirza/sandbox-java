package Laboratory04.Problem46;

import java.util.GregorianCalendar;

public class Problem46 {
    public static void main(String[] args) {
        GregorianCalendar dob = new GregorianCalendar(1990, 1, 1);

        Person p = new Person("Alice", dob);
        PersonWithJob pwj = new PersonWithJob("Alice", dob, 100000);

        System.out.println("case1 equals? " + p.equals(pwj)); // true
        System.out.println("case1 equals? " + pwj.equals(p)); // true
    }
}
