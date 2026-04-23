public class Employee {

    private int id;
    private String name;
    private String position;
    private double salary;

    // Constructor
    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Setter for Name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for Position
    public String getPosition() {
        return position;
    }

    // Setter for Position
    public void setPosition(String position) {
        this.position = position;
    }

    // Getter for Salary
    public double getSalary() {
        return salary;
    }

    // Setter for Salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display employee details
    @Override
    public String toString() {
        return "Employee ID: " + id +
                ", Name: " + name +
                ", Position: " + position +
                ", Salary: " + salary;
    }
}