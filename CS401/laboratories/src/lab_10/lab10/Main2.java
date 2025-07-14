package lab_10.lab10;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

    }

    static class Employee {
        private String name;
        private int salary;
    }

    //A.txt
    class EmployeeNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            int nameCmp = e1.name.compareTo(e2.name);
            if (nameCmp != 0) return nameCmp;
            return Integer.compare(e1.salary, e2.salary);
        }
    }
    static enum SortMethod {BYNAME, BYSALARY};

    //B
    public void sort(List<Employee> emps, final SortMethod method) {
        class EmployeeComparator implements Comparator<Employee> {

            //@Override
            public int compare(Employee e1, Employee e2) {
                if (method == SortMethod.BYNAME) {
                    int nameCmp = e1.name.compareTo(e2.name);
                    if (nameCmp != 0) return nameCmp;
                    return Integer.compare(e1.salary, e2.salary); // secondary check
                } else {
                    int salaryCmp = Integer.compare(e1.salary, e2.salary);
                    if (salaryCmp != 0) return salaryCmp;
                    return e1.name.compareTo(e2.name); // secondary check
                }
            }
        }
    }
    //C
    public void sort2(List<Employee> emps, SortMethod method) {
        if (method == SortMethod.BYNAME) {
            // Compare by name, then salary
            Collections.sort(emps, (e1, e2) -> {
                int nameCmp = e1.name.compareTo(e2.name);
                if (nameCmp != 0) return nameCmp;
                return Integer.compare(e1.salary, e2.salary);
            });
        } else {
            // Compare by salary, then name
            emps.sort((e1, e2) -> {
                int salaryCmp = Integer.compare(e1.salary, e2.salary);
                if (salaryCmp != 0) return salaryCmp;
                return e1.name.compareTo(e2.name);
            });
        }
    }

}

