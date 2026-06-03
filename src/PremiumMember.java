// PremiumMember is a specialized child class of Member.
public class PremiumMember extends Member {

    // Extra premium member attributes.
    private String premiumBenefit;
    private boolean personalTrainerIncluded;

    // Constructor.
    public PremiumMember(int id, String name, int age, String phone, String membershipType,
                         double weight, double height, String premiumBenefit,
                         boolean personalTrainerIncluded) {

        super(id, name, age, phone, membershipType, weight, height);
        this.premiumBenefit = premiumBenefit;
        this.personalTrainerIncluded = personalTrainerIncluded;
    }

    // Displays premium member details.
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Premium Benefit: " + premiumBenefit);
        System.out.println("Personal Trainer Included: " + personalTrainerIncluded);
    }

    // Professional text format for PremiumMembers.txt.
    @Override
    public String toFileFormat() {
        return "\n======= PREMIUM MEMBER RECORD =======\n" +
                "Member ID                 : " + getId() + "\n" +
                "Name                      : " + getName() + "\n" +
                "Age                       : " + getAge() + "\n" +
                "Phone                     : " + getPhone() + "\n" +
                "Membership Type           : " + getMembershipType() + "\n" +
                "Weight                    : " + getWeight() + " kg\n" +
                "Height                    : " + getHeight() + " m\n" +
                "BMI                       : " + String.format("%.2f", calculateBMI()) + "\n" +
                "BMI Status                : " + getBMIStatus() + "\n" +
                "Premium Benefit           : " + premiumBenefit + "\n" +
                "Personal Trainer Included : " + personalTrainerIncluded + "\n" +
                "=====================================";
    }
}