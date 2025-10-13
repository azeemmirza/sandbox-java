package lab_06;

import java.sql.*;

public class StudentRepository<T> {
    /**
     * Print all student records from the database
     */
    public void printUsers() {
        String sql = "SELECT id, first_name, last_name, email, major FROM students";

        try (
                Connection conn = Postgres.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            System.out.println("id | first_name | last_name | email | major");
            System.out.println("-------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String major = rs.getString("major");
                System.out.println(id + " | " + firstName + " | " + lastName + " | " + email + " | " + major);
            }

        } catch (SQLException e) {
            System.out.println("Database error occurred!");
            e.printStackTrace();
        }
    }

    /**
     * Insert a new student record into the database
     * @param student - Student object containing student details
     *
     * @return int - the generated student ID or -1 if insertion failed
     */
    public int insert(Student student) {

        String sql = "INSERT INTO students (first_name, last_name, email, major) VALUES (?,?,?,?)";

        try (Connection conn = Postgres.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getMajor());

            // Execute insert
            int affectedRows = pstmt.executeUpdate();

            // Optionally, get the generated student ID
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("Database error occurred!");
            e.printStackTrace();
        }

        return -1;
    }
}
