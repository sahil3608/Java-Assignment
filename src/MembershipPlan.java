// MembershipPlan handles membership payment calculations.
public class MembershipPlan {

    // Plan details.
    private String planName;
    private int durationMonths;
    private double monthlyFee;

    // Constructor.
    public MembershipPlan(String planName, int durationMonths, double monthlyFee) {
        this.planName = planName;
        this.durationMonths = durationMonths;
        this.monthlyFee = monthlyFee;
    }

    // Calculates total fee before discount.
    public double calculateTotalFee() {
        return monthlyFee * durationMonths;
    }

    // Calculates normal discount.
    public double calculateDiscount() {
        if (durationMonths >= 12) {
            return calculateTotalFee() * 0.20;
        } else if (durationMonths >= 6) {
            return calculateTotalFee() * 0.10;
        } else {
            return 0;
        }
    }

    // Calculates premium discount.
    public double calculatePremiumDiscount() {
        return calculateTotalFee() * 0.25;
    }

    // Calculates normal final amount.
    public double calculateFinalAmount() {
        return calculateTotalFee() - calculateDiscount();
    }

    // Calculates premium final amount.
    public double calculatePremiumFinalAmount() {
        return calculateTotalFee() - calculatePremiumDiscount();
    }
}