package lab_06;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {

        // fetching all students
        StudentRepository<Student> repo = new StudentRepository<>();
        repo.printUsers();

        // inserting a new student
        Student student = new Student();

        student.setFirstName("John");
        student.setLastName("Goldman");
        student.setEmail("john.goldman@example.com");
        student.setMajor("Physics");

        int newStudent = repo.insert(student);
        System.out.println("New student ID: " + newStudent);

        // fetching all students again to see the new record
        repo.printUsers();
    }

}
