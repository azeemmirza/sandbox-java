package Assignment4.prob4E.launch;

import Assignment4.prob4E.*;

import java.util.ArrayList;
import java.util.List;


/**
 * This class tests the code package
 */
public class Main {
    //Uncomment when you are ready to test your code
    public static void main(String[] args) {
        Account ca1 = new CheckingAccount("231-471", 25.00, 100);
        Account ca2 = new CheckingAccount("446-973", 25.00, 200);

        Account sa1 = new SavingsAccount("44-8123", 0.03, 200);
        Account sa2 = new SavingsAccount("21-9672", 0.03, 200);
		Account sa3 = new SavingsAccount("68-0902", 0.04, 600);


        Employee e1 = new Employee("Joe");
        Employee e2 = new Employee("Ralph");
        Employee e3 = new Employee("Tom");

        e1.addAccount(ca1);
        e1.addAccount(sa1);

        e2.addAccount(ca2);
        e2.addAccount(sa2);
        e3.addAccount(sa3);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        System.out.println(Admin.computeUpdatedBalanceSum(employees));


    }

}
