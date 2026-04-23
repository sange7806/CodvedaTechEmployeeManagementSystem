import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    Employee emp = new Employee(id, name, position, salary);
                    employeeDAO.addEmployee(emp);
                    break;

                case 2:
                    System.out.println("\nEmployee List:");
                    employeeDAO.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();

                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();

                    employeeDAO.updateEmployee(updateId, newSalary);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();

                    employeeDAO.deleteEmployee(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}