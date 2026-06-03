// Import date class.
import java.time.LocalDate;

// Payment class stores payment transaction details.
public class Payment {

    private int paymentId;
    private int memberId;
    private double amount;
    private String paymentMethod;
    private LocalDate paymentDate;
    private LocalDate expiryDate;

    // Constructor for loading old records.
    public Payment(int paymentId, int memberId, double amount, String paymentMethod, LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.memberId = memberId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.expiryDate = paymentDate;
    }

    // Constructor for loading records with expiry date.
    public Payment(int paymentId, int memberId, double amount, String paymentMethod,
                   LocalDate paymentDate, LocalDate expiryDate) {
        this.paymentId = paymentId;
        this.memberId = memberId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.expiryDate = expiryDate;
    }

    // Constructor for new payment.
    public Payment(int paymentId, int memberId, double amount, String paymentMethod, int durationMonths) {
        this.paymentId = paymentId;
        this.memberId = memberId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = LocalDate.now();
        this.expiryDate = paymentDate.plusMonths(durationMonths);
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Displays payment in console.
    public void displayPayment() {
        System.out.println("--------------------------------");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Member ID: " + memberId);
        System.out.println("Amount Paid: Rs " + amount);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Expiry Date: " + expiryDate);
    }

    // Professional text format for payments.txt.
    public String toFileFormat() {
        return "\n=========== PAYMENT RECORD ===========\n" +
                "Payment ID     : " + paymentId + "\n" +
                "Member ID      : " + memberId + "\n" +
                "Amount Paid    : Rs " + amount + "\n" +
                "Payment Method : " + paymentMethod + "\n" +
                "Payment Date   : " + paymentDate + "\n" +
                "Expiry Date    : " + expiryDate + "\n" +
                "======================================";
    }
}