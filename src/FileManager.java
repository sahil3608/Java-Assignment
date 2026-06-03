// Import file classes.
import java.io.*;

// Import LocalDate.
import java.time.LocalDate;

// Import ArrayList.
import java.util.ArrayList;

// FileManager handles saving and loading files.
public class FileManager {

    // File paths.
    public static final String MEMBER_FILE =
            "C:/Users/DELL/Downloads/GymProManager/data/members.txt";

    public static final String PREMIUM_MEMBER_FILE =
            "C:/Users/DELL/Downloads/GymProManager/data/PremiumMembers.txt";

    public static final String TRAINER_FILE =
            "C:/Users/DELL/Downloads/GymProManager/data/trainers.txt";

    public static final String PAYMENT_FILE =
            "C:/Users/DELL/Downloads/GymProManager/data/payments.txt";

    public static final String ATTENDANCE_FILE =
            "C:/Users/DELL/Downloads/GymProManager/data/attendance.txt";

    public static final String REPORT_FILE =
            "C:/Users/DELL/Downloads/GymProManager/data/reports.txt";

    public static final String RECEIPT_FILE =
            "C:/Users/DELL/Downloads/GymProManager/data/receipts.txt";

    // Saves data into file.
    public static void saveLine(String filePath, String data) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(data + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }
    }

    // Rewrites file.
    public static void rewriteFile(String filePath, ArrayList<String> lines) {
        try {
            FileWriter writer = new FileWriter(filePath, false);

            for (String line : lines) {
                writer.write(line + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("File rewrite error: " + e.getMessage());
        }
    }

    // Extracts value from professional text format.
    private static String getValue(String line) {
        if (line.contains(":")) {
            return line.substring(line.indexOf(":") + 1).trim();
        }
        return "";
    }

    // Loads members from members.txt.
    public static ArrayList<Member> loadMembers() {
        ArrayList<Member> members = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(MEMBER_FILE));
            String line;

            int id = 0;
            String name = "";
            int age = 0;
            String phone = "";
            String type = "";
            double weight = 0;
            double height = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Member ID")) {
                    id = Integer.parseInt(getValue(line));
                } else if (line.startsWith("Name")) {
                    name = getValue(line);
                } else if (line.startsWith("Age")) {
                    age = Integer.parseInt(getValue(line));
                } else if (line.startsWith("Phone")) {
                    phone = getValue(line);
                } else if (line.startsWith("Membership Type")) {
                    type = getValue(line);
                } else if (line.startsWith("Weight")) {
                    weight = Double.parseDouble(getValue(line).replace("kg", "").trim());
                } else if (line.startsWith("Height")) {
                    height = Double.parseDouble(getValue(line).replace("m", "").trim());
                } else if (line.startsWith("===") && id != 0) {
                    members.add(new Member(id, name, age, phone, type, weight, height));
                    id = 0;
                }
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("No previous member data found.");
        }

        return members;
    }

    // Loads trainers from trainers.txt.
    public static ArrayList<Trainer> loadTrainers() {
        ArrayList<Trainer> trainers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(TRAINER_FILE));
            String line;

            int id = 0;
            String name = "";
            int age = 0;
            String phone = "";
            String specialization = "";
            double salary = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Trainer ID")) {
                    id = Integer.parseInt(getValue(line));
                } else if (line.startsWith("Name")) {
                    name = getValue(line);
                } else if (line.startsWith("Age")) {
                    age = Integer.parseInt(getValue(line));
                } else if (line.startsWith("Phone")) {
                    phone = getValue(line);
                } else if (line.startsWith("Specialization")) {
                    specialization = getValue(line);
                } else if (line.startsWith("Salary")) {
                    salary = Double.parseDouble(getValue(line).replace("Rs", "").trim());
                } else if (line.startsWith("===") && id != 0) {
                    trainers.add(new Trainer(id, name, age, phone, specialization, salary));
                    id = 0;
                }
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("No previous trainer data found.");
        }

        return trainers;
    }

    // Loads payments from payments.txt.
    public static ArrayList<Payment> loadPayments() {
        ArrayList<Payment> payments = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(PAYMENT_FILE));
            String line;

            int paymentId = 0;
            int memberId = 0;
            double amount = 0;
            String method = "";
            LocalDate paymentDate = LocalDate.now();
            LocalDate expiryDate = LocalDate.now();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Payment ID")) {
                    paymentId = Integer.parseInt(getValue(line));
                } else if (line.startsWith("Member ID")) {
                    memberId = Integer.parseInt(getValue(line));
                } else if (line.startsWith("Amount Paid")) {
                    amount = Double.parseDouble(getValue(line).replace("Rs", "").trim());
                } else if (line.startsWith("Payment Method")) {
                    method = getValue(line);
                } else if (line.startsWith("Payment Date")) {
                    paymentDate = LocalDate.parse(getValue(line));
                } else if (line.startsWith("Expiry Date")) {
                    expiryDate = LocalDate.parse(getValue(line));
                } else if (line.startsWith("===") && paymentId != 0) {
                    payments.add(new Payment(paymentId, memberId, amount, method, paymentDate, expiryDate));
                    paymentId = 0;
                }
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("No previous payment data found.");
        }

        return payments;
    }

    // Loads attendance from attendance.txt.
    public static ArrayList<Attendance> loadAttendance() {
        ArrayList<Attendance> attendanceList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(ATTENDANCE_FILE));
            String line;

            int attendanceId = 0;
            int memberId = 0;
            LocalDate date = LocalDate.now();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Attendance ID")) {
                    attendanceId = Integer.parseInt(getValue(line));
                } else if (line.startsWith("Member ID")) {
                    memberId = Integer.parseInt(getValue(line));
                } else if (line.startsWith("Date")) {
                    date = LocalDate.parse(getValue(line));
                } else if (line.startsWith("===") && attendanceId != 0) {
                    attendanceList.add(new Attendance(attendanceId, memberId, date));
                    attendanceId = 0;
                }
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("No previous attendance data found.");
        }

        return attendanceList;
    }
}