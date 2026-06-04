# 🏋️ GymPro Manager

## 👨‍🎓 Student Details

| Name | Student ID |
|---|---|
| Kessoonath Surakshit | 2504_28537 |
| Sungkur Lagnesh | 2504_01292 |

---

## 📌 Project Description

**GymPro Manager** is a Java console-based gym management system developed using **Object-Oriented Programming (OOP)** concepts.

The system allows the admin to manage gym operations such as members, trainers, attendance, BMI calculation, payments, receipts, and reports.  
All records write/read using **text files**.

---

## ⚙️ Features

- Add, view, update, and delete members
- Manage premium members
- Add and view trainers
- Record member attendance
- Calculate BMI and BMI category
- Process membership payments
- Generate receipts
- Generate monthly reports
- Store data using text files
- Input validation and error handling

---

## 💻 Technologies Used

- Java
- Object-Oriented Programming
- Java Collections Framework
- File Handling
- VS Code / IntelliJ IDEA

---

| Concept | Implementation in GymPro Manager |
|----------|----------------------------------|
| Inheritance | Member and Trainer inherit common attributes and methods from Person. PremiumMember extends Member. |
| Polymorphism | Different member types can be treated as objects of the same parent class while performing specialized behaviors. |
| Encapsulation | Class data is protected using private attributes with getters and setters to control access and modification. |
| Abstraction | Complex operations such as BMI calculation, validation, payment processing, and file handling are separated into dedicated classes. |
| File Handling | Data is stored and retrieved from text files such as members.txt, trainers.txt, payments.txt, and attendance.txt. |
| Composition | GymService uses objects such as Member, Trainer, Payment, and FileManager to perform system operations. |
| Collections Framework | ArrayList is used to store and manage members, trainers, attendance records, and payments dynamically. |
| Utility Classes | BMIUtil and ValidationUtil provide reusable methods that support multiple parts of the system. |

## 📁 Project Structure

```text
Java-Assignment/
│
├── src/
│   ├── Main.java
│   ├── GymService.java
│   ├── Person.java
│   ├── Member.java
│   ├── PremiumMember.java
│   ├── Trainer.java
│   ├── Attendance.java
│   ├── Payment.java
│   ├── MembershipPlan.java
│   ├── FileManager.java
│   ├── ReportGenerator.java
│   ├── BMIUtil.java
│   └── ValidationUtil.java
│
├── data/
│   ├── members.txt
│   ├── PremiumMembers.txt
│   ├── trainers.txt
│   ├── attendance.txt
│   ├── payments.txt
│   ├── receipts.txt
│   └── reports.txt
│
├── code_and_terminal_output.txt
└── README.md

📦 Class Description
Main.java

The entry point of the program. It displays the main menu and calls methods from GymService.

GymService.java

Contains the main business logic of the system, including member management, trainer management, attendance, payments, and reports.

Person.java

A parent class that stores common details such as ID, name, age, and phone number.

Member.java

Represents a normal gym member. It inherits from Person and stores membership type, weight, height, and BMI details.

PremiumMember.java

Represents a premium member with extra benefits and discounts.

Trainer.java

Represents gym trainers and stores specialization and salary details.

Attendance.java

Stores and manages member attendance records.

MembershipPlan.java

Calculates membership fees, discounts, and final payable amount.

Payment.java

Stores payment details such as payment ID, amount, method, and date.

FileManager.java

Handles reading and writing data to text files.

ReportGenerator.java

Generates reports such as income reports and BMI reports.

BMIUtil.java

Calculates BMI and determines the BMI category.

ValidationUtil.java

Validates user input such as age, phone number, empty fields, and positive numbers.


