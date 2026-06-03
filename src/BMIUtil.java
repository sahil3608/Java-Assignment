// Utility class for BMI calculation.
public class BMIUtil {

    // Calculates BMI using weight and height.
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Returns BMI health category.
    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}