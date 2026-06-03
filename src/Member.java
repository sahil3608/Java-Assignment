// Member class represents a normal gym member.
public class Member extends Person {

    // Member-specific attributes.
    private String membershipType;
    private double weight;
    private double height;

    // Constructor.
    public Member(int id, String name, int age, String phone, String membershipType, double weight, double height) {
        super(id, name, age, phone);
        this.membershipType = membershipType;
        this.weight = weight;
        this.height = height;
    }

    // Getter methods.
    public String getMembershipType() {
        return membershipType;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    // Setter methods.
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Calculates BMI.
    public double calculateBMI() {
        return BMIUtil.calculateBMI(weight, height);
    }

    // Gets BMI status.
    public String getBMIStatus() {
        return BMIUtil.getBMIStatus(calculateBMI());
    }

    // Displays member details.
    @Override
    public void displayInfo() {
        System.out.println("--------------------------------");
        System.out.println("Member ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone: " + getPhone());
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
        System.out.printf("BMI: %.2f\n", calculateBMI());
        System.out.println("BMI Status: " + getBMIStatus());
    }

    // Professional text format for members.txt.
    public String toFileFormat() {
        return "\n=========== MEMBER RECORD ===========\n" +
                "Member ID       : " + getId() + "\n" +
                "Name            : " + getName() + "\n" +
                "Age             : " + getAge() + "\n" +
                "Phone           : " + getPhone() + "\n" +
                "Membership Type : " + membershipType + "\n" +
                "Weight          : " + weight + " kg\n" +
                "Height          : " + height + " m\n" +
                "BMI             : " + String.format("%.2f", calculateBMI()) + "\n" +
                "BMI Status      : " + getBMIStatus() + "\n" +
                "=====================================";
    }
}