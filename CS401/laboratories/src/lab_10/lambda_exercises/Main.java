package lab_10.lambda_exercises;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        new Main().evaluator();
    }

    void evaluator() {


        /// A.txt. (Employee e) -> e.getName()
        /// B. (Employee e,String s) -> e.setName(s)
        /// C. (String s1,String s2) -> s1.compareTo(s2)
        /// D. (Integer x,Integer y) -> Math.pow(x,y)
        /// E.txt. (Apple a) -> a.getWeight()
        /// F. (String x) -> Integer.parseInt(x);
        /// G. EmployeeNameComparator comp = new EmployeeNameComparator();
        /// (Employee e1, Employee e2) -> comp.compare(e1,e2)



        // Function<Employee, String> getName1 = Employee::getName;
        Function<Employee, String> getName1 = (Employee e) -> e.getName();
        Function<Employee, String> getName2 = Employee::getName;

        //BiConsumer<Employee, String> setName1 = Employee::setName;
        BiConsumer<Employee, String> setName1 = (e, s) -> e.setName(s);
        BiConsumer<Employee, String> setName2 = Employee::setName;

        //BiFunction<String, String, Integer> compareStr1 = String::compareTo;
        BiFunction<String, String, Integer> compareStr1 = (s1, s2) -> s1.compareTo(s2);
        BiFunction<String, String, Integer> compareStr2 = String::compareTo;

        //BiFunction<Integer, Integer, Double> pow1 = Math::pow;
        BiFunction<Integer, Integer, Double> pow1 = (x, y) -> Math.pow(x, y);
        BiFunction<Integer, Integer, Double> pow2 = Math::pow;

        //Function<Apple, Double> getWeight1 = Apple::getWeight;
        Function<Apple, Double> getWeight1 = (Apple a) -> a.getWeight();
        Function<Apple, Double> getWeight2 = Apple::getWeight;

        //Function<String, Integer> parseInt1 = Integer::parseInt;
        Function<String, Integer> parseInt1 = (x) -> Integer.parseInt(x);
        Function<String, Integer> parseInt2 = Integer::parseInt;

        EmployeeNameComparator comp = new EmployeeNameComparator();
        BiFunction<Employee, Employee, Integer> compareEmp1 = comp::compare;
        BiFunction<Employee, Employee, Integer> compareEmp2 = comp::compare;

        // Example output
        Employee emp = new Employee("John");
        setName2.accept(emp, "Mike");
        System.out.println(getName2.apply(emp)); // Mike

        System.out.println(parseInt2.apply("123")); // 123
        System.out.println(pow2.apply(2, 3)); // 8.0
        System.out.println(getWeight2.apply(new Apple(1.5))); // 1.5
    }

    static class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Apple {
        private double weight;

        public Apple(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }
    }

    static class EmployeeNameComparator {
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    }
}
