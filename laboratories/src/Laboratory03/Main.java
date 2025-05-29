package Laboratory03;

import Laboratory03.Problem32.employeeinfo.Employee;

public class Main {
    public static void main(String[] args) {
        // Create an Employee object
        Employee emp = new Employee("Helena Pedro", 2025, 5, 28);

        // Create accounts for the employee
        emp.createNewChecking(1000.00);
        emp.createNewSavings(5000.00);
        emp.createNewRetirement(15000.00);

        // Print formatted account information
        System.out.println(emp.getFormattedAcctInfo());

        // Deposit into checking account
        emp.deposit("checking", 200.00);

        // Print updated account information
        System.out.println(emp.getFormattedAcctInfo());
    }
}
