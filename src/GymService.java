// Import ArrayList.
import java.util.ArrayList;

// Import Scanner.
import java.util.Scanner;

// GymService controls all main system operations.
public class GymService {

    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;
    private ArrayList<Payment> payments;
    private ArrayList<Attendance> attendanceList;

    private Scanner input;

    // Loads saved data when system starts.
    public GymService(Scanner input) {
    this.input = input;
    members = FileManager.loadMembers();
    trainers = FileManager.loadTrainers();
    payments = FileManager.loadPayments();
    attendanceList = FileManager.loadAttendance();
}

    private int generateMemberId() {
        int max = 1000;

        for (Member member : members) {
            if (member.getId() > max) {
                max = member.getId();
            }
        }

        return max + 1;
    }

    private int generateTrainerId() {
        int max = 2000;

        for (Trainer trainer : trainers) {
            if (trainer.getId() > max) {
                max = trainer.getId();
            }
        }

        return max + 1;
    }

    private int generatePaymentId() {
        int max = 3000;

        for (Payment payment : payments) {
            if (payment.getPaymentId() > max) {
                max = payment.getPaymentId();
            }
        }

        return max + 1;
    }

    private int generateAttendanceId() {
        int max = 4000;

        for (Attendance attendance : attendanceList) {
            if (attendance.getAttendanceId() > max) {
                max = attendance.getAttendanceId();
            }
        }

        return max + 1;
    }

    private int readPositiveInt(String message) {
        int value;

        while (true) {
            System.out.print(message);

            if (input.hasNextInt()) {
                value = input.nextInt();
                input.nextLine();

                if (ValidationUtil.isPositiveInt(value)) {
                    return value;
                }
            } else {
                input.nextLine();
            }

            System.out.println("Invalid input. Please enter a positive number.");
        }
    }

    private double readPositiveDouble(String message) {
        double value;

        while (true) {
            System.out.print(message);

            if (input.hasNextDouble()) {
                value = input.nextDouble();
                input.nextLine();

                if (ValidationUtil.isPositiveDouble(value)) {
                    return value;
                }
            } else {
                input.nextLine();
            }

            System.out.println("Invalid input. Please enter a positive decimal number.");
        }
    }

    private String readText(String message) {
        String value;

        while (true) {
            System.out.print(message);
            value = input.nextLine();

            if (ValidationUtil.isValidText(value)) {
                return value;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    private int readValidAge() {
        int age;

        while (true) {
            age = readPositiveInt("Enter Age: ");

            if (ValidationUtil.isValidAge(age)) {
                return age;
            }

            System.out.println("Invalid age. Age must be between 12 and 100.");
        }
    }

    private String readValidPhone() {
        String phone;

        while (true) {
            phone = readText("Enter Phone: ");

            if (ValidationUtil.isValidPhone(phone)) {
                return phone;
            }

            System.out.println("Invalid phone. Phone must contain 7 to 10 digits.");
        }
    }

    private Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }

        return null;
    }

    private void rewriteMembersFile() {
        ArrayList<String> lines = new ArrayList<>();

        for (Member member : members) {
            lines.add(member.toFileFormat());
        }

        FileManager.rewriteFile(FileManager.MEMBER_FILE, lines);
    }

    public void addMember() {
        int id = generateMemberId();

        System.out.println("Generated Member ID: " + id);

        String name = readText("Enter Name: ");
        int age = readValidAge();
        String phone = readValidPhone();
        String type = readText("Enter Membership Type: ");
        double weight = readPositiveDouble("Enter Weight in kg: ");
        double height = readPositiveDouble("Enter Height in meters: ");

        Member member = new Member(id, name, age, phone, type, weight, height);

        members.add(member);

        FileManager.saveLine(FileManager.MEMBER_FILE, member.toFileFormat());

        System.out.println("Member added successfully.");
    }

    public void addPremiumMember() {
        int id = generateMemberId();

        System.out.println("Generated Premium Member ID: " + id);

        String name = readText("Enter Name: ");
        int age = readValidAge();
        String phone = readValidPhone();
        String type = "Premium";
        double weight = readPositiveDouble("Enter Weight in kg: ");
        double height = readPositiveDouble("Enter Height in meters: ");
        String benefit = readText("Enter Premium Benefit: ");

        PremiumMember premiumMember =
                new PremiumMember(id, name, age, phone, type, weight, height, benefit, true);

        members.add(premiumMember);

        FileManager.saveLine(FileManager.PREMIUM_MEMBER_FILE, premiumMember.toFileFormat());
        FileManager.saveLine(FileManager.MEMBER_FILE, premiumMember.toFileFormat());

        System.out.println("Premium member added successfully.");
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members available.");
            return;
        }

        for (Member member : members) {
            member.displayInfo();
        }
    }

    public void searchMemberById() {
        int id = readPositiveInt("Enter Member ID to search: ");

        Member member = findMemberById(id);

        if (member == null) {
            System.out.println("Member not found.");
        } else {
            System.out.println("Member found successfully.");
            member.displayInfo();
        }
    }

    public void updateMember() {
        int id = readPositiveInt("Enter Member ID to update: ");

        Member member = findMemberById(id);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        member.setName(readText("Enter New Name: "));
        member.setAge(readValidAge());
        member.setPhone(readValidPhone());
        member.setMembershipType(readText("Enter New Membership Type: "));
        member.setWeight(readPositiveDouble("Enter New Weight: "));
        member.setHeight(readPositiveDouble("Enter New Height: "));

        rewriteMembersFile();

        System.out.println("Member updated successfully and file rewritten.");
    }

    public void deleteMember() {
        int id = readPositiveInt("Enter Member ID to delete: ");

        Member member = findMemberById(id);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        members.remove(member);
        rewriteMembersFile();

        System.out.println("Member deleted successfully and file rewritten.");
    }

    public void addTrainer() {
        int id = generateTrainerId();

        System.out.println("Generated Trainer ID: " + id);

        String name = readText("Enter Trainer Name: ");
        int age = readValidAge();
        String phone = readValidPhone();
        String specialization = readText("Enter Specialization: ");
        double salary = readPositiveDouble("Enter Salary: ");

        Trainer trainer = new Trainer(id, name, age, phone, specialization, salary);

        trainers.add(trainer);

        FileManager.saveLine(FileManager.TRAINER_FILE, trainer.toFileFormat());

        System.out.println("Trainer added successfully.");
    }

    public void viewTrainers() {
        if (trainers.isEmpty()) {
            System.out.println("No trainers available.");
            return;
        }

        for (Trainer trainer : trainers) {
            trainer.displayInfo();
        }
    }

    public void processPayment() {
        int paymentId = generatePaymentId();

        System.out.println("Generated Payment ID: " + paymentId);

        int memberId = readPositiveInt("Enter Member ID: ");
        Member member = findMemberById(memberId);

        if (member == null) {
            System.out.println("Payment failed. Member does not exist.");
            return;
        }

        int months = readPositiveInt("Enter Plan Duration in Months: ");
        double monthlyFee = readPositiveDouble("Enter Monthly Fee: ");
        String method = readText("Enter Payment Method: ");

        MembershipPlan plan = new MembershipPlan(member.getMembershipType(), months, monthlyFee);

        double finalAmount;

        if (member instanceof PremiumMember) {
            finalAmount = plan.calculatePremiumFinalAmount();
            System.out.println("Premium Discount Applied: Rs " + plan.calculatePremiumDiscount());
        } else {
            finalAmount = plan.calculateFinalAmount();
            System.out.println("Normal Discount Applied: Rs " + plan.calculateDiscount());
        }

        System.out.println("--------------------------------");
        System.out.println("Payment Calculation");
        System.out.println("Total Fee: Rs " + plan.calculateTotalFee());
        System.out.println("Final Amount: Rs " + finalAmount);

        Payment payment = new Payment(paymentId, memberId, finalAmount, method, months);

        payments.add(payment);

        FileManager.saveLine(FileManager.PAYMENT_FILE, payment.toFileFormat());

        String receipt =
                "\n=============== PAYMENT RECEIPT ===============\n" +
                        "Receipt ID      : " + paymentId + "\n" +
                        "Member ID       : " + memberId + "\n" +
                        "Member Name     : " + member.getName() + "\n" +
                        "Membership Type : " + member.getMembershipType() + "\n" +
                        "Amount Paid     : Rs " + finalAmount + "\n" +
                        "Payment Method  : " + method + "\n" +
                        "Payment Date    : " + payment.getPaymentDate() + "\n" +
                        "Expiry Date     : " + payment.getExpiryDate() + "\n" +
                        "Status          : PAID\n" +
                        "================================================";

        FileManager.saveLine(FileManager.RECEIPT_FILE, receipt);

        System.out.println("Receipt generated successfully.");
        System.out.println("Membership Expiry Date: " + payment.getExpiryDate());
        System.out.println("Payment processed successfully.");
    }

    public void recordAttendance() {
        int attendanceId = generateAttendanceId();

        System.out.println("Generated Attendance ID: " + attendanceId);

        int memberId = readPositiveInt("Enter Member ID: ");

        Member member = findMemberById(memberId);

        if (member == null) {
            System.out.println("Attendance failed. Member does not exist.");
            return;
        }

        Attendance attendance = new Attendance(attendanceId, memberId);

        attendanceList.add(attendance);

        FileManager.saveLine(FileManager.ATTENDANCE_FILE, attendance.toFileFormat());

        System.out.println("Attendance recorded successfully.");
    }

    public void viewPayments() {
        if (payments.isEmpty()) {
            System.out.println("No payments available.");
            return;
        }

        for (Payment payment : payments) {
            payment.displayPayment();
        }
    }

    public void monthlyIncomeReport() {
        int month = readPositiveInt("Enter month number, example 1 for January: ");
        int year = readPositiveInt("Enter year, example 2026: ");

        ReportGenerator.displayMonthlyIncomeReport(payments, month, year);

        double total = ReportGenerator.calculateMonthlyIncome(payments, month, year);

        String report =
                "\n============ MONTHLY INCOME REPORT ============\n" +
                        "Report Month : " + month + "\n" +
                        "Report Year  : " + year + "\n" +
                        "Total Income : Rs " + total + "\n" +
                        "Generated By : GymPro Manager\n" +
                        "================================================";

        FileManager.saveLine(FileManager.REPORT_FILE, report);
    }

    public void memberStatisticsReport() {
        ReportGenerator.displayMemberStatistics(members);
    }
}