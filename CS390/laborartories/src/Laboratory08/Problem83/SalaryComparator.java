package Laboratory08.Problem83;

import java.util.Comparator;
import java.util.Date;

public class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2){
        String name1 = e1.getName();
        String name2 = e2.getName();
        Date hireDate1 = e1.getHireDate();
        Date hireDate2 = e2.getHireDate();
        int salary1 = e1.getSalary();
        int salary2 = e2.getSalary();
        //as the salary is the prmitive data type, not able to use compareTo method
        if(Double.compare(salary1,salary2) != 0 )
            return Double.compare(salary1, salary2);

        if( hireDate1.compareTo(hireDate2) != 0)
            return hireDate1.compareTo(hireDate2);

        if( name1.compareTo(name2) != 0 )
            return name1.compareTo(name2);

        return 0;

    }
}
