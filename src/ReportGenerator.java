// Import ArrayList.
import java.util.ArrayList;

// Import LocalDate.
import java.time.LocalDate;

// ReportGenerator handles reports and statistics.
public class ReportGenerator {

    // Calculates monthly income.
    public static double calculateMonthlyIncome(ArrayList<Payment> payments, int month, int year) {
        double totalIncome = 0;

        for (Payment payment : payments) {
            LocalDate date = payment.getPaymentDate();

            if (date.getMonthValue() == month && date.getYear() == year) {
                totalIncome += payment.getAmount();
            }
        }

        return totalIncome;
    }

    // Counts monthly payments.
    public static int countMonthlyPayments(ArrayList<Payment> payments, int month, int year) {
        int count = 0;

        for (Payment payment : payments) {
            LocalDate date = payment.getPaymentDate();

            if (date.getMonthValue() == month && date.getYear() == year) {
                count++;
            }
        }

        return count;
    }

    // Displays monthly report.
    public static void displayMonthlyIncomeReport(ArrayList<Payment> payments, int month, int year) {
        double totalIncome = calculateMonthlyIncome(payments, month, year);
        int count = countMonthlyPayments(payments, month, year);

        System.out.println("--------------------------------");
        System.out.println("MONTHLY INCOME REPORT");
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
        System.out.println("Number of Payments: " + count);
        System.out.println("Total Income: Rs " + totalIncome);
    }

    // Displays BMI statistics.
    public static void displayMemberStatistics(ArrayList<Member> members) {
        int underweight = 0;
        int normal = 0;
        int overweight = 0;
        int obese = 0;

        for (Member member : members) {
            String status = member.getBMIStatus();

            if (status.equalsIgnoreCase("Underweight")) {
                underweight++;
            } else if (status.equalsIgnoreCase("Normal")) {
                normal++;
            } else if (status.equalsIgnoreCase("Overweight")) {
                overweight++;
            } else {
                obese++;
            }
        }

        System.out.println("--------------------------------");
        System.out.println("MEMBER BMI STATISTICS");
        System.out.println("Total Members: " + members.size());
        System.out.println("Underweight Members: " + underweight);
        System.out.println("Normal Members: " + normal);
        System.out.println("Overweight Members: " + overweight);
        System.out.println("Obese Members: " + obese);
    }
}