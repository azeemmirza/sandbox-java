package Laboratory13.Problem132;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Problem132 extends JFrame {
    // UI components
    private JTextField idField = new JTextField(10);
    private JTextField nameField = new JTextField(10);
    private JTextField streetField = new JTextField(10);
    private JTextField cityField = new JTextField(10);
    private JTextField stateField = new JTextField(10);
    private JTextField zipField = new JTextField(10);
    private JLabel statusLabel = new JLabel(" ");

    // DB credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/YOUR_DATABASE";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public Problem132() {
        setLayout(new GridLayout(8, 2));
        add(new JLabel("ID:")); add(idField);
        add(new JLabel("Name:")); add(nameField);
        add(new JLabel("Street:")); add(streetField);
        add(new JLabel("City:")); add(cityField);
        add(new JLabel("State:")); add(stateField);
        add(new JLabel("ZIP:")); add(zipField);
        
        JButton searchBtn = new JButton("Search");
        JButton saveBtn = new JButton("Save");
        JButton clearBtn = new JButton("Clear");

        add(searchBtn); add(saveBtn);
        add(clearBtn); add(statusLabel);

        searchBtn.addActionListener(e -> search());
        saveBtn.addActionListener(e -> save());
        clearBtn.addActionListener(e -> clear());

        setTitle("Lab 13-2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void search() {
        String id = idField.getText().trim();
        if (id.isEmpty()) {
            statusLabel.setText("Please enter an ID.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT p.name, a.street, a.city, a.state, a.zip " +
                           "FROM PERSON p JOIN ADDRESS a ON p.addrId = a.id WHERE p.id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nameField.setText(rs.getString("name"));
                streetField.setText(rs.getString("street"));
                cityField.setText(rs.getString("city"));
                stateField.setText(rs.getString("state"));
                zipField.setText(rs.getString("zip"));
                statusLabel.setText("Record found.");
            } else {
                statusLabel.setText("No records found");
            }

        } catch (Exception ex) {
            statusLabel.setText("Error: " + ex.getMessage());
        }
    }

    private void save() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String street = streetField.getText().trim();
        String city = cityField.getText().trim();
        String state = stateField.getText().trim();
        String zip = zipField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || street.isEmpty() || city.isEmpty() || state.isEmpty() || zip.isEmpty()) {
            statusLabel.setText("All fields must be nonempty");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            conn.setAutoCommit(false); // atomic insert

            String addrSql = "INSERT INTO ADDRESS (street, city, state, zip) VALUES (?, ?, ?, ?)";
            PreparedStatement addrStmt = conn.prepareStatement(addrSql, Statement.RETURN_GENERATED_KEYS);
            addrStmt.setString(1, street);
            addrStmt.setString(2, city);
            addrStmt.setString(3, state);
            addrStmt.setString(4, zip);
            addrStmt.executeUpdate();

            ResultSet keys = addrStmt.getGeneratedKeys();
            if (keys.next()) {
                int addrId = keys.getInt(1);

                String personSql = "INSERT INTO PERSON (id, name, addrId) VALUES (?, ?, ?)";
                PreparedStatement personStmt = conn.prepareStatement(personSql);
                personStmt.setInt(1, Integer.parseInt(id));
                personStmt.setString(2, name);
                personStmt.setInt(3, addrId);
                personStmt.executeUpdate();

                conn.commit();
                statusLabel.setText("Record saved");
            } else {
                conn.rollback();
                statusLabel.setText("Address insert failed");
            }

        } catch (Exception ex) {
            statusLabel.setText("Error: " + ex.getMessage());
        }
    }

    private void clear() {
        idField.setText("");
        nameField.setText("");
        streetField.setText("");
        cityField.setText("");
        stateField.setText("");
        zipField.setText("");
        statusLabel.setText(" ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Problem132::new);
    }
}