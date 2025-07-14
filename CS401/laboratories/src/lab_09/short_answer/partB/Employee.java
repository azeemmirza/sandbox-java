package lab_09.short_answer.partB;


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

    /*public boolean equals(Employee e) {
        return e.name.equals(name) && e.salary == salary;
    }*/

    public boolean equals(Object ob) {
        if (!(ob instanceof Employee e)) return false;
        return e.name.equals(name) && e.salary == salary;
    }

    //The issue is that we were overloading the equals method by defining it with a parameter of type Employee instead of overriding the equals method from Object,
    //which requires a parameter of type Object.
    //
    //As a result, calls like e.equals(emp) or list.contains(e) end up using Object's default implementation, which compares references instead of actual field values.
    //This causes duplicate detection to fail and it returns Is answer correct? false.
}
