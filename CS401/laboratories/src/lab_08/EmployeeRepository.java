package lab_08;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    // database connection info
    private static final String URL = "jdbc:postgresql://localhost:5432/cs401";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // helper method to get connection
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver not found", e);
        }
    }

    // CREATE operation
    public void create(Employee employee) {
        String sql = "INSERT INTO Employee (id, name, salary, address_id, department_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setInt(3, employee.getSalary());
            pstmt.setInt(4, employee.getAddressId());
            pstmt.setInt(5, employee.getDeptId());

            int rows = pstmt.executeUpdate();
            System.out.println("Employee added! Rows: " + rows);
            System.out.println(employee);

        } catch (SQLException e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }
    }

    // READ all
    public List<Employee> findAll() {
        List<Employee> empList = new ArrayList<>();
        String sql = "SELECT id, name, salary, address_id, department_id FROM Employee ORDER BY id";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- All Employees ---");

            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary"),
                        rs.getInt("address_id"),
                        rs.getInt("department_id")
                );
                empList.add(e);
                System.out.println(e);
            }

            System.out.println("Total: " + empList.size() + " employees\n");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return empList;
    }

    // READ by id
    public Employee findById(int empId) {
        String sql = "SELECT id, name, salary, address_id, department_id FROM Employee WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, empId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Employee e = new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("salary"),
                            rs.getInt("address_id"),
                            rs.getInt("department_id")
                    );
                    System.out.println("Found employee: " + e);
                    return e;
                } else {
                    System.out.println("No employee with ID " + empId);
                    return null;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    // UPDATE operation
    public void update(Employee employee) {
        String sql = "UPDATE Employee SET name = ?, salary = ?, address_id = ?, department_id = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getSalary());
            pstmt.setInt(3, employee.getAddressId());
            pstmt.setInt(4, employee.getDeptId());
            pstmt.setInt(5, employee.getId());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Updated successfully!");
                System.out.println(employee);
            } else {
                System.out.println("Employee not found");
            }

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    // DELETE operation
    public void delete(int empId) {
        String sql = "DELETE FROM Employee WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, empId);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Deleted employee ID: " + empId);
            } else {
                System.out.println("Employee not found");
            }

        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }

    // main method - testing CRUD operations

}