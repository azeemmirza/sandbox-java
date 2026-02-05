package functional_program;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Abacus", 1000);
        Employee e2 = new Employee("Bob", 1500);

        EmployeeComparator ec = new EmployeeComparator();

        System.out.println(ec.compare(e1, e2));
    }
}
