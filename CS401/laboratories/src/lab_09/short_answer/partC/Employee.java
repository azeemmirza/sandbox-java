package lab_09.short_answer.partC;

import java.util.Objects;

public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
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
        return emp.name.equals(name) && emp.salary == salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    //HashMap uses both equals() and hashCode() to check for duplicates as I know from FPP.
    //SO without a proper hashCode(), even equal Employee objects go into different buckets and are treated as different.
    //That’s why the code fails to remove duplicates.


}
