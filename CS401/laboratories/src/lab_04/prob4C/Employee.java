package Assignment4.prob4C;

public abstract class Employee {
    protected String empId;

    public PayCheck calcCompensation(int month, int year) {
        double grossPay = calcGrossPay(month, year);
        return new PayCheck(grossPay);
    }
    public abstract void print();

    protected abstract double calcGrossPay(int month, int year);

}