package lab_08;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== LAB 08: employee Repository ===");
        EmployeeRepository repo = new EmployeeRepository();

        // step 1: create new employee
        System.out.println("step 1: Creating new employee");
        Employee newEmp = new Employee(116, "Johny Chuck Walker", 175000, 1, 1);
        repo.create(newEmp);

        // step 2: show all employees
        System.out.println("\nstep 2: all employees");
        repo.findAll();

        // step 3: find specific employee
        System.out.println("step 3: finding employee 116");
        Employee emp = repo.findById(116);

        // step 4: update employee
        System.out.println("\nstep 4: updating employee");
        if (emp != null) {
            emp.setName("Chuck Norris");
            emp.setSalary(185000);
            emp.setDeptId(2);
            repo.update(emp);
        }

        // verify update
        System.out.println("\nverifying update:");
        repo.findById(116);

        // step 5: delete employee
        System.out.println("\nstep 5: Deleting employee 116");
        repo.delete(116);

        // step 6: confirm deletion
        System.out.println("\nstep 6: Checking all employees");
        repo.findAll();

        System.out.println("=== complete ===");
    }
}
