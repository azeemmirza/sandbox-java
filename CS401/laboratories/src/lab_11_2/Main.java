package lab_11_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Address add1 = new Address("500 E Broadway Ave", "Fairfield", "IA", 52556);
        Address add2 = new Address("103 W Adams Ave", "Fairfield", "IA", 52556);

        Section cs545_1 = new Section(900, "CS545");
        Section cs545_2 = new Section(901, "CS545");
        Section cs401 = new Section(902, "CS401");
        Section cs221 = new Section(903, "CS221");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(111, "Yasmeen", new ArrayList<>(Arrays.asList(3.9, 4.0, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs545_1, cs401))),
                new Student(112, "Mira", new ArrayList<>(Arrays.asList(4.0, 4.0, 3.9)), add1,
                        new ArrayList<>(Arrays.asList(cs545_2, cs401, cs221))),
                new Student(113, "Zaina", new ArrayList<>(Arrays.asList(3.6, 3.3, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs221, cs401))),
                new Student(114, "Khaled", new ArrayList<>(Arrays.asList(3.0, 2.8, 3.1)), add2)
        ));

        // Find all the students that are taking a given course
        students.stream()
                .filter(s -> s.sections.contains(cs545_1))
                .forEach(System.out::println);


        // Get the address of any student that is taking a given course (e.g., "CS401")
        students.stream()
                .filter(s -> s.sections.stream().anyMatch(sec -> sec.getCourseCode().equals("CS401")))
                .map(s -> s.address)
                .findAny()
                .ifPresent(System.out::println);


        // Calculate the GPA for a given student
        students.stream()
                .filter(s -> s.getName().equals("Khaled"))
                .map(s -> s.grades.stream().mapToDouble(d -> d).average().orElse(0.0))
                .forEach(gpa -> System.out.println("Khaled's GPA: " + gpa));



        // Find the student with the highest GPA
        students.stream()
                .max((s1, s2) -> Double.compare(
                        s1.grades.stream().mapToDouble(d -> d).average().orElse(0.0),
                        s2.grades.stream().mapToDouble(d -> d).average().orElse(0.0)
                ))
                .ifPresent(System.out::println);



        // Get a list of all unique courses taken by students
        students.stream()
                .flatMap(s -> s.sections.stream())
                .distinct()
                .forEach(System.out::println);



        // Find all students who live in a given city (e.g., "Fairfield") sorted in alphabetical order
        students.stream()
                .filter(s -> s.address.getCity().equalsIgnoreCase("Fairfield"))
                .sorted((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()))
                .forEach(System.out::println);



        // Count the number of students enrolled in a specific course (e.g., "CS401")
        long count = students.stream()
                .filter(s -> s.sections.stream().anyMatch(sec -> sec.getCourseCode().equals("CS401")))
                .count();
        System.out.println("Number of students in CS401: " + count);



        // Get a list of students in a specific section
        students.stream()
                .filter(s -> s.sections.contains(cs545_1))
                .forEach(System.out::println);


        //  Get the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)
        students.stream()
                .filter(s -> s.sections.size() > 2)
                .map(Student::getName)
                .forEach(System.out::println);


        // Get a list of unique course names taken by students who live in a given city (e.g., "Fairfield")
        students.stream()
                .filter(s -> s.sections.size() > 2)
                .map(Student::getName)
                .forEach(System.out::println);



        // Get a list of distinct addresses of students who are taking a specific course (e.g., "CS401")
        students.stream()
                .filter(s -> s.
                        sections
                        .stream()
                        .anyMatch(sec -> sec.getCourseCode().equals("CS401")))
                .map(s -> s.address)
                .distinct()
                .forEach(System.out::println);


        // Get a mapping of students' names to the list of courses they are taking
        students.stream()
                .forEach(s -> {
                    List<String> courseNames = s.sections.stream()
                            .map(Section::getCourseCode)
                            .toList();
                    System.out.println(s.getName() + " -> " + courseNames);
                });
    }
}
