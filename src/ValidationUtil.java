 // Utility class for input validation.
public class ValidationUtil {

    // Checks that text is not empty.
    public static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }

    // Checks positive integer.
    public static boolean isPositiveInt(int number) {
        return number > 0;
    }

    // Checks positive decimal number.
    public static boolean isPositiveDouble(double number) {
        return number > 0;
    }

    // Checks valid age range.
    public static boolean isValidAge(int age) {
        return age >= 12 && age <= 100;
    }

    // Checks phone number contains 7 to 10 digits.
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{7,10}");
    }

    // Displays validation rules.
    public static void displayValidationRules() {
        System.out.println("--------------------------------");
        System.out.println("Validation Rules");
        System.out.println("Name cannot be empty.");
        System.out.println("Age must be between 12 and 100.");
        System.out.println("Phone must contain 7 to 10 digits.");
        System.out.println("Numbers must be positive.");
    }
}