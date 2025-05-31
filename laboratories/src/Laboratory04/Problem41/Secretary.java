package Laboratory04.Problem41;

public class Secretary extends DeptEmployee {

    private double overtimeHours;

    public Secretary(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
    }
    @Override
    public double computeSalary() {
        return  (super.computeSalary() + ( 12 * overtimeHours));
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }
    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
}
