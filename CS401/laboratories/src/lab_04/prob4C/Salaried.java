package Assignment4.prob4C;

public class Salaried extends Employee {
    private double salary;

    public Salaried(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    @Override
    protected double calcGrossPay(int month, int year) {
        return salary;
    }

    @Override
    public void print() {

    }
}