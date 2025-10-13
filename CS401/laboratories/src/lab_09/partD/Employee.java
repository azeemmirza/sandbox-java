package lab_09.partD;

import java.util.Objects;

public class Employee {
    private String name;
    private int salary;
    private boolean visited = false;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setVisited(boolean b) {
        visited = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + salary + ")";
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == null) return false;
        if (!(ob instanceof Employee emp)) return false;
        return emp.name.equals(name) && emp.salary == salary; /*&& emp.visited == visited*/

        //equals() and hashCode() include the visited field, which changes at runtime.
        //This makes identical employees look different, breaking duplicate detection. visited should be excluded.
    }

    @Override
    public int hashCode() {
       /* int result = 17;
        int salaryHash = Double.hashCode(salary);
        result += 31 * result + name.hashCode();
        result += 31 * result + salaryHash;
        result += 31 * result + (visited ? 1 : 0);
        //result += 31 * result + (visited ? 71 : 43);
        return result;*/
        return Objects.hash(name, salary); //this is sample and clean

    }
}
