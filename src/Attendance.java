// Import date class.
import java.time.LocalDate;

// Attendance class stores attendance records.
public class Attendance {

    private int attendanceId;
    private int memberId;
    private LocalDate date;

    // Constructor for loading saved attendance.
    public Attendance(int attendanceId, int memberId, LocalDate date) {
        this.attendanceId = attendanceId;
        this.memberId = memberId;
        this.date = date;
    }

    // Constructor for new attendance.
    public Attendance(int attendanceId, int memberId) {
        this(attendanceId, memberId, LocalDate.now());
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    // Displays attendance.
    public void displayAttendance() {
        System.out.println("--------------------------------");
        System.out.println("Attendance ID: " + attendanceId);
        System.out.println("Member ID: " + memberId);
        System.out.println("Attendance Date: " + date);
    }

    // Professional text format for attendance.txt.
    public String toFileFormat() {
        return "\n========== ATTENDANCE RECORD ==========\n" +
                "Attendance ID : " + attendanceId + "\n" +
                "Member ID     : " + memberId + "\n" +
                "Date          : " + date + "\n" +
                "=======================================";
    }
}