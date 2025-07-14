package lab_09.short_answer.partD;

import lab_09.short_answer.partD.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeInfo {

    /**
     * Removes all duplicate Employee instances from input list (only a copy is modified)
     * An Employee instance is considered to be a duplicate of another Employee
     * instance if the two instances have the same name and salary.
     */
    public static List<lab_09.short_answer.partD.Employee> removeDuplicates(List<lab_09.short_answer.partD.Employee> employees) {
        HashMap<lab_09.short_answer.partD.Employee, lab_09.short_answer.partD.Employee> tracker = new HashMap<>();
        List<lab_09.short_answer.partD.Employee> noDupsList = new ArrayList<>();
        for (lab_09.short_answer.partD.Employee e : employees) {
            if (!tracker.containsKey(e)) {
                tracker.put(e, e);
                noDupsList.add(e);
            } else {
                tracker.get(e).setVisited(true);
            }
        }
        return noDupsList;
    }


    /**
     * Tests to see if solution is correct
     * What's wrong here?
     */
    public static void main(String[] args) {
        List<lab_09.short_answer.partD.Employee> list = new ArrayList<>() {
            {
                add(new lab_09.short_answer.partD.Employee("Richard", 55000));
                add(new lab_09.short_answer.partD.Employee("Richard", 55000));
                add(new lab_09.short_answer.partD.Employee("John", 30000));
                add(new lab_09.short_answer.partD.Employee("Steve", 30000));
                add(new lab_09.short_answer.partD.Employee("Zeke", 50000));
                add(new lab_09.short_answer.partD.Employee("Reggie", 50000));
                add(new lab_09.short_answer.partD.Employee("Steve", 30000));
                add(new lab_09.short_answer.partD.Employee("John", 70000));
                add(new lab_09.short_answer.partD.Employee("Harold", 55000));
                add(new lab_09.short_answer.partD.Employee("Richard", 55000));
                add(new lab_09.short_answer.partD.Employee("Richard", 55000));
                add(new lab_09.short_answer.partD.Employee("Richard", 60000));
                add(new lab_09.short_answer.partD.Employee("Dennis", 80000));
                add(new lab_09.short_answer.partD.Employee("Adam", 80000));
                add(new lab_09.short_answer.partD.Employee("John", 70000));
                add(new lab_09.short_answer.partD.Employee("Charles", 25000));
                add(new lab_09.short_answer.partD.Employee("Bill", 60000));
                add(new lab_09.short_answer.partD.Employee("Bob", 60000));
                add(new lab_09.short_answer.partD.Employee("Bill", 70000));
                add(new lab_09.short_answer.partD.Employee("Bob", 60000));
            }
        };

        //List with duplicates removed - correctly computed
        List<lab_09.short_answer.partD.Employee> dupsRemoved = new ArrayList<>() {
            {
                add(new lab_09.short_answer.partD.Employee("Richard", 55000));
                add(new lab_09.short_answer.partD.Employee("John", 30000));
                add(new lab_09.short_answer.partD.Employee("Steve", 30000));
                add(new lab_09.short_answer.partD.Employee("Zeke", 50000));
                add(new lab_09.short_answer.partD.Employee("Reggie", 50000));
                add(new lab_09.short_answer.partD.Employee("John", 70000));
                add(new lab_09.short_answer.partD.Employee("Harold", 55000));
                add(new lab_09.short_answer.partD.Employee("Richard", 60000));
                add(new lab_09.short_answer.partD.Employee("Dennis", 80000));
                add(new lab_09.short_answer.partD.Employee("Adam", 80000));
                add(new lab_09.short_answer.partD.Employee("Charles", 25000));
                add(new lab_09.short_answer.partD.Employee("Bill", 60000));
                add(new lab_09.short_answer.partD.Employee("Bill", 70000));
                add(new lab_09.short_answer.partD.Employee("Bob", 60000));
            }
        };
        List<lab_09.short_answer.partD.Employee> answer = removeDuplicates(list);
        System.out.println("Is answer correct? " + listsAreEqual(answer, dupsRemoved));
    }

    /**
     * Returns true if the two lists have the same size and contain exactly the same
     * elements (this is really just set equality)
     */
    public static boolean listsAreEqual(List<lab_09.short_answer.partD.Employee> l1, List<lab_09.short_answer.partD.Employee> l2) {
        if (l1.size() != l2.size()) return false;
        for (Employee e : l1) {
            if (!l2.contains(e)) return false;
        }
        return true;
    }


}
