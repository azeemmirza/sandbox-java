package Laboratory04.Problem41;

import java.util.Scanner;

public class Program41 {
    public static void main(String[] args) {
        Profesor p1 = new Profesor("Peter", 10000,1995, 9,21);
        Profesor p2 = new Profesor("Orchirbat", 10200,2015, 6,1);
        Profesor p3 = new Profesor("Azeem", 1000,2023, 2,7);

        Secretary s1 = new Secretary("Helena", 10000,2024,3,4);
        Secretary s2 = new Secretary("Nandar", 12000,2024,4,5);

        p1.setnumberOfPublications(10);
        p2.setnumberOfPublications(10);
        p3.setnumberOfPublications(10);

        s1.setOvertimeHours(200);
        s2.setOvertimeHours(200);

        DeptEmployee[] department = new DeptEmployee[5];
        department[0] = p1;
        department[1] = p2;
        department[2] = p3;
        department[3] = s1;
        department[4] = s2;


        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to see the sum of all salaries in the department?");

        String input = sc.nextLine();
        double totalSalary = 0;

        if(input.equalsIgnoreCase("Y")){

            for(DeptEmployee e : department){
                totalSalary += e.computeSalary();
            }

            System.out.println("Total Salary: " + totalSalary);
        }
        else if (!input.equalsIgnoreCase("n")){
            System.out.println("Invalid input ");
        }




    }
}
