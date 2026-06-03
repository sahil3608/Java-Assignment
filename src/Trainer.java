// Trainer class represents a gym trainer.
public class Trainer extends Person {

    // Trainer-specific attributes.
    private String specialization;
    private double salary;

    // Constructor.
    public Trainer(int id, String name, int age, String phone, String specialization, double salary) {
        super(id, name, age, phone);
        this.specialization = specialization;
        this.salary = salary;
    }

    // Displays trainer details.
    @Override
    public void displayInfo() {
        System.out.println("--------------------------------");
        System.out.println("Trainer ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone: " + getPhone());
        System.out.println("Specialization: " + specialization);
        System.out.println("Salary: Rs " + salary);
    }

    // Professional text format for trainers.txt.
    public String toFileFormat() {
        return "\n=========== TRAINER RECORD ===========\n" +
                "Trainer ID     : " + getId() + "\n" +
                "Name           : " + getName() + "\n" +
                "Age            : " + getAge() + "\n" +
                "Phone          : " + getPhone() + "\n" +
                "Specialization : " + specialization + "\n" +
                "Salary         : Rs " + salary + "\n" +
                "======================================";
    }
}