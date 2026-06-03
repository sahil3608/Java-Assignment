// Abstract parent class for common person information.
public abstract class Person {

    // Common attributes shared by Member and Trainer.
    private int id;
    private String name;
    private int age;
    private String phone;

    // Constructor to initialize common details.
    public Person(int id, String name, int age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    // Getter methods.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    // Setter methods.
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Abstract method used for polymorphism.
    public abstract void displayInfo();
}