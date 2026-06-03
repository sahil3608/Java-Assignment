// Import Scanner.
import java.util.Scanner;

// Main class starts the program.
public class Main {

    // Main method.
    public static void main(String[] args) {

       Scanner input = new Scanner(System.in);
GymService gymService = new GymService(input);
        int choice = 0;

        do {
            System.out.println("\n========== GymPro Manager ==========");
            System.out.println("1. Add Member");
            System.out.println("2. Add Premium Member");
            System.out.println("3. View Members");
            System.out.println("4. Update Member");
            System.out.println("5. Delete Member");
            System.out.println("6. Add Trainer");
            System.out.println("7. View Trainers");
            System.out.println("8. Process Payment");
            System.out.println("9. Record Attendance");
            System.out.println("10. View Payments");
            System.out.println("11. Monthly Income Report");
            System.out.println("12. Member BMI Statistics");
            System.out.println("13. Validation Rules");
            System.out.println("14. Search Member by ID");
            System.out.println("15. Exit");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                input.nextLine();
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    gymService.addMember();
                    break;
                case 2:
                    gymService.addPremiumMember();
                    break;
                case 3:
                    gymService.viewMembers();
                    break;
                case 4:
                    gymService.updateMember();
                    break;
                case 5:
                    gymService.deleteMember();
                    break;
                case 6:
                    gymService.addTrainer();
                    break;
                case 7:
                    gymService.viewTrainers();
                    break;
                case 8:
                    gymService.processPayment();
                    break;
                case 9:
                    gymService.recordAttendance();
                    break;
                case 10:
                    gymService.viewPayments();
                    break;
                case 11:
                    gymService.monthlyIncomeReport();
                    break;
                case 12:
                    gymService.memberStatisticsReport();
                    break;
                case 13:
                    ValidationUtil.displayValidationRules();
                    break;
                case 14:
                    gymService.searchMemberById();
                    break;
                case 15:
                    System.out.println("Thank you for using GymPro Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 1 and 15.");
            }

        } while (choice != 15);

        input.close();
    }
}