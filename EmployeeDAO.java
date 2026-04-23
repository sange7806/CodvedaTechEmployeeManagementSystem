import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    // Add Employee
    public void addEmployee(Employee emp) {

        String query = "INSERT INTO employees (id, name, position, salary) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getPosition());
            stmt.setDouble(4, emp.getSalary());

            stmt.executeUpdate();
            System.out.println("Employee added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding employee.");
            e.printStackTrace();
        }
    }

    // View All Employees
    public void viewEmployees() {

        String query = "SELECT * FROM employees";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");

                System.out.println(
                        "ID: " + id +
                                ", Name: " + name +
                                ", Position: " + position +
                                ", Salary: " + salary
                );
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving employees.");
            e.printStackTrace();
        }
    }

    // Update Employee Salary
    public void updateEmployee(int id, double newSalary) {

        String query = "UPDATE employees SET salary = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, newSalary);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee salary updated successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating employee.");
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        String query = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting employee.");
            e.printStackTrace();
        }
    }
}