package Assignment4.prob4C;

public class Hourly extends Employee {
    private double hourlyWage;
    private double hoursPerWeek;

    public Hourly(String empId, double hourlyWage, double hoursPerWeek) {
        this.empId = empId;
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    protected double calcGrossPay(int month, int year) {
        return hourlyWage * hoursPerWeek * 4;
    }

    @Override
    public void print() {

    }
}