GYMPRO MANAGER

Student Name: Kessoonath Surakshit & Sungkur Lagnesh
Student ID: 2504_28537 & 2504_01292

Description:
GymPro Manager is a Java console-based gym management system developed
using Object-Oriented Programming concepts. The system manages members, trainers, attendance,
BMI calculations, and payments using text file storage.


Features:
- Member Management
- Trainer Management
- Attendance Recording
- Payment Processing
- BMI Calculation
- Monthly Income Reports
- File Handling
- CRUD Operations
- Validation and Error Handling

Technologies Used:
- Java
- Java Collections
- Java File Handling
- VS Code

Project Structure:
src/
data/

Developer:
Kessoonath and Sungkur



1.Person.java
We created this file because it is the parent class. Members.java and Trainer.java inherits from this class.
It stores common attributes such as id, name, age and phone number. This class demonstrates abstraction and inheritance.

2. BMIUtil.java
This utility class handles BMI calculations and BMI status determination. It contains reusable static methods.
Member.java uses this class to calculate BMI values.

3. ValidationUtil.java
This class handles all input validation such as empty text validation, age validation, phone validation and positive number validation.
GymService.java uses this class to prevent invalid user input.

4. Member.java
This class represents a normal gym member. It inherits from person.java and contains member-specific attributes such as membership type,
weight and height. It performs BMI calculations and demonstrates inheritance and polymorphism.

5. PremiumMember.java
This class extends Member.java. It represents premium members who receive additional benefits such as higher discounts and personal
trainer access. This class demonstrates multilevel inheritance.

6. Trainer.java
This class represents gym trainers. It inherits from Person.java and stores specialization and salary information.

7. MembershipPlan.java
This class handles all membership payment calculations. It calculates total fees, discount, premium discounts and final payment
amounts.

8. Payment.java
This class stores payment information such as Payment ID, Payment amount, payment method and payment date.

9. Attendance.java
This class records member attendance information and attendance dates.

10. FileManager.java
This class handles all file operations including saving, rewriting and loading data from text files.

11. ReportGenerator.java
This class generates reports such as monthly income reports and BMI statistics reports.

12. GymService.java
This is the main business logic class. It controls member management, trainer management, attendance recording, payment processing
and report generation.

13. Main.java
This is the starting point of the application where it displays the menu  and calls methods from GymService.java.
