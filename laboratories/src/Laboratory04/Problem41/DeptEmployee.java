package Laboratory04.Problem41;

import java.time.LocalDate;

public class DeptEmployee {
    private String name;
    private double salary;
    private LocalDate hireDay;

   public DeptEmployee(String name, double salary, int year, int month, int day) {
       this.name = name;
       this.salary = salary;
       hireDay = LocalDate.of(year, month, day);
   }

    public double computeSalary() {
        return salary;
    }

   public String getName(){
       return name;
   }
    public LocalDate getHireDay(){
        return hireDay;
    }




}
