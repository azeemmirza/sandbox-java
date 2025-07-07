package Assignment4.prob4C;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final int month = 6;
        final int year = 2025;

         Commissioned c1 = new Commissioned("1", 3000, 0.5);
        Commissioned c2 = new Commissioned("2", 4000, 0.4);

        // Sample orders for previous month (May 2025)
        c1.addOrder(new Order(101, LocalDate.of(2025, 5, 10), 2000));
        c1.addOrder(new Order(102, LocalDate.of(2025, 5, 20), 1500));
        c2.addOrder(new Order(201, LocalDate.of(2025, 5, 5), 4000));

        Employee[] employees = {
                new Salaried("3", 3000),
                new Salaried("4", 4000),
                new Hourly("5", 45.1, 40),
                new Hourly("6", 55.20, 40),
                c1,
                c2,
        };


        for (Employee e : employees) {
            PayCheck p = e.calcCompensation(month, year);
            System.out.println("Employee ID: " + e.empId);
            p.print();
            System.out.println("------------");
        }
    }
}
