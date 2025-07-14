package lab_09.short_answer.partB;

import lab_09.short_answer.partB.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInfo {
	
	
	/**
	 * Removes all duplicate Employee instances from input list (only a copy is modified)
	 * An Employee instance is considered to be a duplicate of another Employee
	 * instance if the two instances have the same name and salary.
	 */
	public static List<lab_09.short_answer.partB.Employee> removeDuplicates(List<lab_09.short_answer.partB.Employee> employees) {
		List<lab_09.short_answer.partB.Employee> noDupsList = new ArrayList<>();
		noDupsList.add(employees.getFirst());
		for(int i = 1; i < employees.size(); ++i) {
			if(!inList(employees.get(i), noDupsList)) {
				noDupsList.add(employees.get(i));
			}
		}
		return noDupsList;
	}
	
	/** Returns true if e is in the list emps, false otherwise */
	private static boolean inList(lab_09.short_answer.partB.Employee e, List<lab_09.short_answer.partB.Employee> emps) {
		for(lab_09.short_answer.partB.Employee emp : emps) {
			if(e.equals(emp)) return true;
		}
		return false;
	}
	
	/**
	 * Tests to see if solution is correct
	 * What's wrong here?
	 */
	public static void main(String[] args) {	
		List<lab_09.short_answer.partB.Employee> list = new ArrayList<lab_09.short_answer.partB.Employee>() {
			{
				add(new lab_09.short_answer.partB.Employee("Richard", 55000));
				add(new lab_09.short_answer.partB.Employee("Richard", 55000));
				add(new lab_09.short_answer.partB.Employee("John", 30000));
				add(new lab_09.short_answer.partB.Employee("Steve", 30000));
				add(new lab_09.short_answer.partB.Employee("Zeke", 50000));
				add(new lab_09.short_answer.partB.Employee("Reggie", 50000));
				add(new lab_09.short_answer.partB.Employee("Steve", 30000));
				add(new lab_09.short_answer.partB.Employee("John", 70000));
				add(new lab_09.short_answer.partB.Employee("Harold", 55000));
				add(new lab_09.short_answer.partB.Employee("Richard", 55000));
				add(new lab_09.short_answer.partB.Employee("Richard", 55000));
				add(new lab_09.short_answer.partB.Employee("Richard", 60000));
				add(new lab_09.short_answer.partB.Employee("Dennis", 80000));
				add(new lab_09.short_answer.partB.Employee("Adam", 80000));
				add(new lab_09.short_answer.partB.Employee("John", 70000));
				add(new lab_09.short_answer.partB.Employee("Charles", 25000));
				add(new lab_09.short_answer.partB.Employee("Bill", 60000));
				add(new lab_09.short_answer.partB.Employee("Bob", 60000));
				add(new lab_09.short_answer.partB.Employee("Bill", 70000));
				add(new lab_09.short_answer.partB.Employee("Bob", 60000));
			}
		};
		
		//List with duplicates removed - correctly computed
		List<lab_09.short_answer.partB.Employee> dupsRemoved = new ArrayList<lab_09.short_answer.partB.Employee>() {
			{
				add(new lab_09.short_answer.partB.Employee("Richard", 55000));
				add(new lab_09.short_answer.partB.Employee("John", 30000));
				add(new lab_09.short_answer.partB.Employee("Steve", 30000));
				add(new lab_09.short_answer.partB.Employee("Zeke", 50000));
				add(new lab_09.short_answer.partB.Employee("Reggie", 50000));
				add(new lab_09.short_answer.partB.Employee("John", 70000));
				add(new lab_09.short_answer.partB.Employee("Harold", 55000));
				add(new lab_09.short_answer.partB.Employee("Richard", 60000));
				add(new lab_09.short_answer.partB.Employee("Dennis", 80000));
				add(new lab_09.short_answer.partB.Employee("Adam", 80000));
				add(new lab_09.short_answer.partB.Employee("Charles", 25000));
				add(new lab_09.short_answer.partB.Employee("Bill", 60000));
				add(new lab_09.short_answer.partB.Employee("Bill", 70000));
				add(new lab_09.short_answer.partB.Employee("Bob", 60000));
			}
		};

		List<lab_09.short_answer.partB.Employee> answer = removeDuplicates(list);
		System.out.println("Is answer correct? " + listsAreEqual(answer, dupsRemoved));
	}
	
	/**
	 * Returns true if the two lists have the same size and contain exactly the same
	 * elements (this is just set equality)
	 */
	public static boolean listsAreEqual(List<lab_09.short_answer.partB.Employee> l1, List<lab_09.short_answer.partB.Employee> l2) {
		if(l1.size() != l2.size()) return false;
		for(Employee e : l1) {
			if(!l2.contains(e)) return false;
		}
		return true;
	}

	 
}
